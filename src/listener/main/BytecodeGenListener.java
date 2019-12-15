package listener.main;

import java.util.Hashtable;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.MiniCBaseListener;
import generated.MiniCParser;
import generated.MiniCParser.ExprContext;
import generated.MiniCParser.Fun_declContext;
import generated.MiniCParser.Local_declContext;
import generated.MiniCParser.ParamsContext;
import generated.MiniCParser.ProgramContext;
import generated.MiniCParser.StmtContext;
import generated.MiniCParser.Struct_funContext;
import generated.MiniCParser.Struct_stmtContext;
import generated.MiniCParser.Struct_typeContext;
import generated.MiniCParser.Type_specContext;
import generated.MiniCParser.Var_declContext;

import static listener.main.BytecodeGenListenerHelper.*;
import static listener.main.SymbolTable.*;

public class BytecodeGenListener extends MiniCBaseListener implements ParseTreeListener {
	ParseTreeProperty<String> newTexts = new ParseTreeProperty<String>();
	SymbolTable symbolTable = new SymbolTable();

	int tab = 0;
	int label = 0;

	// program : decl+

	@Override
	public void enterFun_decl(MiniCParser.Fun_declContext ctx) {
		symbolTable.initFunDecl();

		String fname = getFunName(ctx);
		ParamsContext params;

		if (fname.equals("main")) {
			symbolTable.putLocalVar("args", Type.INTARRAY);
		} else {
			symbolTable.putFunSpecStr(ctx);
			params = (MiniCParser.ParamsContext) ctx.getChild(3);
			symbolTable.putParams(params);
		}
	}

	// var_decl : type_spec IDENT ';' | type_spec IDENT '=' LITERAL ';'|type_spec
	// IDENT '[' LITERAL ']' ';'
	@Override
	public void enterVar_decl(MiniCParser.Var_declContext ctx) {
		String varName = ctx.IDENT().getText();
		if (isArrayDecl(ctx)) {
			symbolTable.putGlobalVar(varName, Type.INTARRAY);
		} else if (isDeclWithInit(ctx)) {
			symbolTable.putGlobalVarWithInitVal(varName, Type.INT, initVal(ctx));
		} else { // simple decl
			symbolTable.putGlobalVar(varName, Type.INT);
		} 
	}

	@Override
	public void enterLocal_decl(MiniCParser.Local_declContext ctx) {
		if (isArrayDecl(ctx)) {
			symbolTable.putLocalVar(getLocalVarName(ctx), Type.INTARRAY);
		} else if (isDeclWithInit(ctx)) {
			symbolTable.putLocalVarWithInitVal(getLocalVarName(ctx), Type.INT, initVal(ctx));
		} else if(isStruct(ctx)){
			symbolTable.putStructVar(getLocalVarName(ctx),ctx.type_spec().struct_type());
		}else { // simple decl
			symbolTable.putLocalVar(getLocalVarName(ctx), Type.INT);
		}
	}

	@Override
	public void exitProgram(MiniCParser.ProgramContext ctx) {
		String classProlog = getFunProlog();

		String fun_decl = "", var_decl = "";

		for (int i = 0; i < ctx.getChildCount(); i++) {
			if (isFunDecl(ctx, i))
				fun_decl += newTexts.get(ctx.decl(i));
			else
				var_decl += newTexts.get(ctx.decl(i));
		}
		newTexts.put(ctx, classProlog + var_decl + fun_decl);
        System.out.println(newTexts.get(ctx));
	}

	// decl : var_decl | fun_decl
	@Override
	public void exitDecl(MiniCParser.DeclContext ctx) {
		String decl = "";
		if (ctx.getChildCount() == 1) {
			if (ctx.var_decl() != null) {//var_decl	
				decl += newTexts.get(ctx.var_decl());
			}
			else { // fun_decl
				decl += newTexts.get(ctx.fun_decl());
			}
		}
		newTexts.put(ctx, decl);
	}

	// stmt : expr_stmt | compound_stmt | if_stmt | while_stmt | return_stmt
	@Override
	public void exitStmt(MiniCParser.StmtContext ctx) {
		String stmt = "";
		//조건문을 통해 해당하는 stmt를 newTexts에 저장한다.
		if (ctx.getChildCount() > 0) {
			if (ctx.expr_stmt() != null) // expr_stmt
				stmt += newTexts.get(ctx.expr_stmt());
			else if (ctx.compound_stmt() != null) // compound_stmt
				stmt += newTexts.get(ctx.compound_stmt());
			else if(ctx.if_stmt()!=null) // if_stmt
				stmt+=newTexts.get(ctx.if_stmt());
			else if (ctx.while_stmt()!=null) // while_stmt
				stmt+=newTexts.get(ctx.while_stmt());
			else if(ctx.return_stmt()!=null) // return_stmt
				stmt+=newTexts.get(ctx.return_stmt());
		}
		newTexts.put(ctx, stmt);
	}

	// expr_stmt : expr ';'
	@Override
	public void exitExpr_stmt(MiniCParser.Expr_stmtContext ctx) {
		String stmt = "";
		if (ctx.getChildCount() == 2) {
			stmt += newTexts.get(ctx.expr()); // expr
		}
		newTexts.put(ctx, stmt);
	}

	// while_stmt : WHILE '(' expr ')' stmt
	/*
	 * while 변환을 위하여 반복문의 시작과 반복문을 빠져나오기 위한 label을 생성한다.
	 * expr를 통하여 결과를 불러와 해당 조건을 만족하지 않을 경우 lend로 점프하며 해당 조건을 
	 * 만족하는 경우 while의 body에 해당하는 stmt를 실행한후 반복문의 처음으로 돌아 온다.
	 */
	@Override
	public void exitWhile_stmt(MiniCParser.While_stmtContext ctx) {
		
		String whileStmt = "";
		
		String expr = newTexts.get(ctx.expr());
		String stmt = newTexts.get(ctx.stmt());
		
		String loop = symbolTable.newLabel();
		String lend = symbolTable.newLabel();
		
		whileStmt +=loop+":\n"+
					expr+"\n"+
					"ifeq"+lend+"\n"+
					stmt+"\n"+
					"goto"+loop+"\n"+
					lend +":\n";
		newTexts.put(ctx,whileStmt);
	}

	/*
	 * 함수에 대한 문법으로 funheader를 통해 함수의 헤더를 불러오며 변환한 stmt를 불러와 연결한다.
	 * 함수의 type에 따라 int형의 경우 ireturn 을 추가하며 void형의 경우 return을 추가한다.
	 * .end method를 통해 함수의 종료를 알린다.
	 * 이후 만들어진 decl을 newText에 추가한다.
	 */
	@Override
	public void exitFun_decl(MiniCParser.Fun_declContext ctx) {
		String decl ="";
		decl+= funcHeader(ctx, ctx.IDENT().getText());
		decl+= newTexts.get(ctx.compound_stmt());
		
		if(ctx.type_spec().INT()!=null){
			decl+="ireturn\n";
		}else {
			decl+="return\n";
		}
		
		decl+=".end method\n\n";
		newTexts.put(ctx, decl);
	}

	private String funcHeader(MiniCParser.Fun_declContext ctx, String fname) {
		return ".method public static " + symbolTable.getFunSpecStr(fname) + "\n" + ".limit stack "
				+ getStackSize(ctx) + "\n" + ".limit locals " + getLocalVarSize(ctx) + "\n";
	}

	@Override
	public void exitVar_decl(MiniCParser.Var_declContext ctx) {
		String varName = ctx.IDENT().getText();
		String varDecl = "";

		if (isDeclWithInit(ctx)) {
			varDecl += "putfield " + varName + "\n";
			// v. initialization => Later! skip now..:
		}
		newTexts.put(ctx, varDecl);
	}

	@Override
	public void exitLocal_decl(MiniCParser.Local_declContext ctx) {
		String varDecl = "";

		if (isDeclWithInit(ctx)) {
			String vId = symbolTable.getVarId(ctx);
			varDecl += "ldc " + ctx.LITERAL().getText() + "\n" + "istore_" + vId + "\n";
		}
		
		if(isStruct(ctx)) {
			if(isStack(ctx.type_spec().struct_type())) {
				String vId = symbolTable.getVarId("@"+ctx.IDENT().getText()+"size");
				varDecl += "ldc 0\n";
				varDecl += "istore "+ vId +'\n';
			}
			if(isQueue(ctx.type_spec().struct_type())) {
				String startId = symbolTable.getVarId("@"+ctx.IDENT().getText()+"start");
				String endId = symbolTable.getVarId("@"+ctx.IDENT().getText()+"end");
				
				varDecl+="ldc 0\n";
				varDecl+="istore "+startId+"\n";

				varDecl+="ldc 0\n";
				varDecl+="istore "+endId+"\n";
			}
		}
		newTexts.put(ctx, varDecl);
	}

	/*
	 * 모든 local_decl과 stmt를 변환하여 newTexts에 저장한다.
	 * 반복문을 통하여 local_decl과 stmt를 newTexts에서 불러와 하나로 저장한다.
	 */
	@Override
	public void exitCompound_stmt(MiniCParser.Compound_stmtContext ctx) {
		String stmt ="";
		for(int i=0;i<ctx.local_decl().size();i++) {
			stmt+=newTexts.get(ctx.local_decl(i));
		}
		
		for(int i = 0 ;i<ctx.stmt().size();i++) {
			stmt+=newTexts.get(ctx.stmt(i));
		}
		
		newTexts.put(ctx,stmt);
	}

	// if_stmt : IF '(' expr ')' stmt | IF '(' expr ')' stmt ELSE stmt;
	@Override
	public void exitIf_stmt(MiniCParser.If_stmtContext ctx) {
		String stmt = "";
		String condExpr = newTexts.get(ctx.expr());
		String thenStmt = newTexts.get(ctx.stmt(0));

		String lend = symbolTable.newLabel();
		String lelse = symbolTable.newLabel();

		if (noElse(ctx)) {
			stmt += condExpr + "\n" + 
					"ifeq " + lend + "\n" + 
					thenStmt + "\n" + 
					lend + ":" + "\n";
		} else {
			String elseStmt = newTexts.get(ctx.stmt(1));
			stmt += condExpr + "\n" + "ifeq " + lelse + "\n" + thenStmt + "\n" + "goto " + lend + "\n" + lelse + ": "
					+ elseStmt + "\n" + lend + ":" + "\n";
		}

		newTexts.put(ctx, stmt);
	}

	// return_stmt : RETURN ';' | RETURN expr ';'
	/*
	 * 자식 노드의 갯수 비교를 통하여 RETURN과 RETURN expr를 구분하며 반환값이 있을 경우 iload를 통해 반환하며 
	 * symbolTale에서 해당하는 expr의 id를 불러온다.
	 */
	@Override
	public void exitReturn_stmt(MiniCParser.Return_stmtContext ctx) {
		String stmt ="";
		if(ctx.getChildCount()>2) {
			stmt+="iload_"+symbolTable.getVarId(ctx.expr().getText())+"\n";
		}
		newTexts.put(ctx, stmt);
	}

	@Override
	public void exitExpr(MiniCParser.ExprContext ctx) {
		String expr = "";
		if (ctx.getChildCount() <= 0) {
			newTexts.put(ctx, "");
			return;
		}
		if(ctx.struct_stmt()!=null) {
			expr += newTexts.get(ctx.struct_stmt());
		}else if (ctx.getChildCount() == 1) { // IDENT | LITERAL
			if (ctx.IDENT() != null) {
				String idName = ctx.IDENT().getText();
				if (symbolTable.getVarType(idName) == Type.INT) {
					expr += "iload_" + symbolTable.getVarId(idName) + " \n";
				}
				// else // Type int array => Later! skip now..
				// expr += " lda " + symbolTable.get(ctx.IDENT().getText()).value + " \n";
			} else if (ctx.LITERAL() != null) {
				String literalStr = ctx.LITERAL().getText();
				expr += "ldc " + literalStr + " \n";
			}
		} else if (ctx.getChildCount() == 2) { // UnaryOperation
			expr = handleUnaryExpr(ctx, newTexts.get(ctx) + expr);
		} else if (ctx.getChildCount() == 3) {
			if (ctx.getChild(0).getText().equals("(")) { // '(' expr ')'
				expr = newTexts.get(ctx.expr(0));

			} else if (ctx.getChild(1).getText().equals("=")) { // IDENT '=' expr
				expr = newTexts.get(ctx.expr(0)) + "istore_" + symbolTable.getVarId(ctx.IDENT().getText()) + " \n";

			} else { // binary operation
				expr = handleBinExpr(ctx, expr);
			}
		}
		// IDENT '(' args ')' | IDENT '[' expr ']'
		else if (ctx.getChildCount() == 4) {
			if (ctx.args() != null) { // function calls
				expr = handleFunCall(ctx, expr);
			} else { // expr
				// Arrays: TODO
			}
		}
		// IDENT '[' expr ']' '=' expr
		else { // Arrays: TODO */
		}
		newTexts.put(ctx, expr);
	}

	private String handleUnaryExpr(MiniCParser.ExprContext ctx, String expr) {
		String l1 = symbolTable.newLabel();
		String l2 = symbolTable.newLabel();
		String lend = symbolTable.newLabel();

		expr += newTexts.get(ctx.expr(0));
		switch (ctx.getChild(0).getText()) {
		case "-":
			expr += "           ineg \n";
			break;
		case "--":
			expr += "ldc 1" + "\n" + "isub" + "\n";
			break;
		case "++":
			expr += "ldc 1" + "\n" + "iadd" + "\n";
			break;
		case "!":
			expr += "ifeq " + l2 + "\n" + l1 + ": " + "ldc 0" + "\n" + "goto " + lend + "\n" + l2 + ": " + "ldc 1"
					+ "\n" + lend + ": " + "\n";
			break;
		}
		return expr;
	}

	private String handleBinExpr(MiniCParser.ExprContext ctx, String expr) {
		String l2 = symbolTable.newLabel();
		String lend = symbolTable.newLabel();

		expr += newTexts.get(ctx.expr(0));
		expr += newTexts.get(ctx.expr(1));

		switch (ctx.getChild(1).getText()) {
		case "*":
			expr += "imul \n";
			break;
		case "/":
			expr += "idiv \n";
			break;
		case "%":
			expr += "irem \n";
			break;
		case "+": // expr(0) expr(1) iadd
			expr += "iadd \n";
			break;
		case "-":
			expr += "isub \n";
			break;

		case "==":
			expr += "isub " + "\n" + 
					"ifeq " + l2 + "\n" + 
					"ldc 0" + "\n" + 
					"goto " + lend + "\n" + 
					l2 + ": " + "\n"+ 
					"ldc 1" + "\n" + 
					lend + ": " + "\n";
			break;
		case "!=":
			expr += "isub " + "\n" + 
					"ifne " + l2 + "\n" + 
					"ldc 0" + "\n" + 
					"goto " + lend + "\n" + 
					l2 + ": " + "\n"+ 
					"ldc 1" + "\n" + 
					lend + ": " + "\n";
			break;
			//상위 코드를 참고하여 <=, <,>,>=를 작성하였다.
		case "<=":
			expr += "isub " + "\n" + 
					"ifle " + l2 + "\n" + 
					"ldc 0" + "\n" + 
					"goto " + lend + "\n" + 
					l2 + ": " + "\n"+ 
					"ldc 1" + "\n" + 
					lend + ": " + "\n";
			break;
			
		case "<":
			expr += "isub " + "\n" + 
					"iflt" + l2 + "\n" + 
					"ldc 0" + "\n" + 
					"goto " + lend + "\n" + 
					l2 + ": " + "\n"+ 
					"ldc 1" + "\n" + 
					lend + ": " + "\n";
			break;

		case ">=":
			expr += "isub " + "\n" + 
					"ifge " + l2 + "\n" + 
					"ldc 0" + "\n" + 
					"goto " + lend + "\n" + 
					l2 + ": " + "\n"+ 
					"ldc 1" + "\n" + 
					lend + ": " + "\n";
			break;

		case ">":
			expr += "isub " + "\n" + 
					"ifgt " + l2 + "\n" + 
					"ldc 0" + "\n" + 
					"goto " + lend + "\n" + 
					l2 + ": " + "\n"+ 
					"ldc 1" + "\n" + 
					lend + ": " + "\n";
			break;

		case "and":
			expr += "ifne " + lend + "\n" + 
					"pop" + "\n" + 
					"ldc 0" + "\n" + 
					lend + ": " + "\n";
			break;
		/*
		 * expr1 or expr2 형태의 or의 경우 expr1이 참일경우 expr2를 고려하지 않아도 되며 거짓의 경우 
		 * expr2의 결과값이 해당 or 문의 결과가 된다.
		 * 따라서 expr1이 거짓일경우 lend로 jump하여 종료하며 참일경우 스택에서 expr2의 값을 pop하고 1을 삽입한다.
		 */
		case "or":
			// <(9) Fill here>
			expr += "ifeq " + lend + "\n" + 
					"pop" + "\n" + 
					"ldc 1" + "\n" + 
					lend + ": " + "\n";
			break;

		}
		return expr;
	}

	private String handleFunCall(MiniCParser.ExprContext ctx, String expr) {
		String fname = getFunName(ctx);
		if (fname.equals("_print")) { // System.out.println
			expr = "getstatic java/lang/System/out Ljava/io/PrintStream;\n" + newTexts.get(ctx.args())
					+ "invokevirtual " + symbolTable.getFunSpecStr("_print") + "\n";
		} else {
			expr = newTexts.get(ctx.args()) + "invokestatic " + getCurrentClassName() + "/"
					+ symbolTable.getFunSpecStr(fname) + "\n";
		}

		return expr;

	}

	// args : expr (',' expr)* | ;
	@Override
	public void exitArgs(MiniCParser.ArgsContext ctx) {
		String argsStr = "";

		for (int i = 0; i < ctx.expr().size(); i++) {
			argsStr += newTexts.get(ctx.expr(i));
		}
		newTexts.put(ctx, argsStr);
	}
	
	//struct code


	@Override
	public void exitStruct_stmt(Struct_stmtContext ctx) {
		String ident = ctx.IDENT().getText();
		String stmt ="";
		Type type = symbolTable.getStuctType(ident);
		
		switch (type) {
		case STACK:
			stmt+=stackFun(ident, ctx.struct_fun());
			break;
		case QUEUE:
			stmt+=queuesFun(ident, ctx.struct_fun());
			break;

		default:
			break;
		}
		
		
		newTexts.put(ctx, stmt);
		
	}
	
	public String stackFun(String ident,Struct_funContext ctx) {
		String stmt="";
		String stackSizeId = symbolTable.getStackSize(ident);
		
		if(ctx.SIZE()!=null) {
			stmt+="iload "+stackSizeId+"\n";
		}
		
		if(ctx.PUSH()!=null) {
			String expr = newTexts.get(ctx.expr());
			String pushid = symbolTable.pushStack(ident);

			stmt+=expr;
			stmt+="istore "+pushid+'\n';
			stmt+="iload "+ stackSizeId+'\n';
			stmt += "ldc 1" + "\n" + "iadd" + "\n";
			stmt+="istore "+stackSizeId+'\n';
		}
		
		if(ctx.POP()!=null) {
			String popid = symbolTable.popStack(ident);
			stmt+="iload "+ stackSizeId+'\n';
			stmt += "ldc 1" + "\n" + "isub" + "\n";
			stmt+="istore "+stackSizeId+'\n';

			stmt+="iload " +popid+'\n';
		}

		return stmt;
	}
	
	public String queuesFun(String ident,Struct_funContext ctx) {
		String stmt="";
		String queueStart = symbolTable.getQueueStart(ident);
		String queueEnd = symbolTable.getQueueEnd(ident);
		
		if(ctx.SIZE()!=null) {
			stmt+="iload "+queueEnd+"\n";
			stmt+="iload "+queueStart+"\n";
			stmt += "isub \n";
		}
		
		if(ctx.PUSH()!=null) {
			String expr = newTexts.get(ctx.expr());
			String pushQueueId = symbolTable.pushQueue(ident);
			
			stmt+=expr;
			stmt+="istore "+pushQueueId+"\n";		
			stmt+="iload "+queueEnd +"\n";
			stmt+="ldc 1\n";
			stmt+="iadd\n";
			stmt+="istore "+queueEnd+"\n";
		}
		
		if(ctx.POP()!=null) {
			String popQueueid=symbolTable.popQueue(ident);
			
			stmt+="iload "+queueStart+"\n";
			stmt+="ldc 1\n";
			stmt+="iadd\n";
			stmt+="istore "+queueStart+"\n";
			stmt+="iload "+popQueueid+"\n";
		}

		return stmt;
	}
}
