package listener.main;

import java.util.Hashtable;

import generated.MiniCParser;
import generated.MiniCParser.ExprContext;
import generated.MiniCParser.Fun_declContext;
import generated.MiniCParser.If_stmtContext;
import generated.MiniCParser.Local_declContext;
import generated.MiniCParser.ParamContext;
import generated.MiniCParser.ParamsContext;
import generated.MiniCParser.Struct_typeContext;
import generated.MiniCParser.Type_specContext;
import generated.MiniCParser.Var_declContext;
import listener.main.SymbolTable;
import listener.main.SymbolTable.VarInfo;

public class BytecodeGenListenerHelper {
	
	// <boolean functions>
	
	static boolean isFunDecl(MiniCParser.ProgramContext ctx, int i) {
		return ctx.getChild(i).getChild(0) instanceof MiniCParser.Fun_declContext;
	}
	
	// type_spec IDENT '[' ']'
	static boolean isArrayParamDecl(ParamContext param) {
		return param.getChildCount() == 4;
	}
	
	// global vars
	static int initVal(Var_declContext ctx) {
		return Integer.parseInt(ctx.LITERAL().getText());
	}

	// var_decl	: type_spec IDENT '=' LITERAL ';
	static boolean isDeclWithInit(Var_declContext ctx) {
		return ctx.getChildCount() == 5 ;
	}
	// var_decl	: type_spec IDENT '[' LITERAL ']' ';'
	static boolean isArrayDecl(Var_declContext ctx) {
		return ctx.getChildCount() == 6;
	}

	// <local vars>
	// local_decl	: type_spec IDENT '[' LITERAL ']' ';'
	static int initVal(Local_declContext ctx) {
		return Integer.parseInt(ctx.LITERAL().getText());
	}

	static boolean isArrayDecl(Local_declContext ctx) {
		return ctx.getChildCount() == 6;
	}
	
	static boolean isDeclWithInit(Local_declContext ctx) {
		return ctx.getChildCount() == 5 ;
	}
	
	/*
	 * 선언된 함수의 타입을 검사하는 함수로서 VOID()가 존재할경우 참을 아닐경우 거짓을 반환한다.
	 */
	static boolean isVoidF(Fun_declContext ctx) {
		if(ctx.type_spec().VOID()!=null){
			return true;
		}else {
			return false;
		}
	}
	
	static boolean isIntReturn(MiniCParser.Return_stmtContext ctx) {
		return ctx.getChildCount() ==3;
	}


	static boolean isVoidReturn(MiniCParser.Return_stmtContext ctx) {
		return ctx.getChildCount() == 2;
	}
	
	// <information extraction>
	static String getStackSize(Fun_declContext ctx) {
		return "32";
	}
	static String getLocalVarSize(Fun_declContext ctx) {
		return "32";
	}
	
	/*
	 * 타입에 따라 V(void), I(int)를 반환한다. 
	 */
	static String getTypeText(Type_specContext typespec) {
		if (typespec.VOID()!=null) {
			return "V";
		}
		if(typespec.INT()!=null) {
			return "I";
		}
		return typespec.getText();
	}
	
	static String getParamTypesText(ParamsContext params) {
		String typeText = "";
		
		for(int i = 0; i < params.param().size(); i++) {
			MiniCParser.Type_specContext typespec = (MiniCParser.Type_specContext)  params.param(i).getChild(0);
			typeText += getTypeText(typespec); // + ";";
		}
		return typeText;
	}
	
	// 해당 변수, 함수의 이름을 반환하며 IDENT()를 getText를 통해 String으로 반환한다.
	static String getParamName(ParamContext param) {
		return param.IDENT().getText();
	}
	
	static String getLocalVarName(Local_declContext local_decl) {
		return local_decl.IDENT().getText();
	}
	
	static String getFunName(Fun_declContext ctx) {
		return ctx.IDENT().getText();
	}
	
	static String getFunName(ExprContext ctx) {
		return ctx.IDENT().getText();
	}
	
	static boolean noElse(If_stmtContext ctx) {
		return ctx.getChildCount() < 5;
	}
	
	/*
	 * 프로그램의 prolog로서 클래스를 선언하고 상속과 default생성자를 추가해준다.
	 */
	static String getFunProlog() {
		String prolog = "";
		prolog+= ".class public "+ getCurrentClassName()+"\n"+
				".super java/lang/Object\n"+
				".method public <init>()V\n"+
				"aload_0\n"+
				"invokenonvirtual java/lang/Object/<init>()V\n"+
				"return\n"+
				".end method\n\n";
		return prolog;
	}
	
	static String getCurrentClassName() {
		return "Test";
	}
	
	static boolean isStruct(Local_declContext ctx) {
		if(ctx.type_spec().struct_type()!=null)
			return true;
		else
			return false;
	}
	
	static boolean isQueue(Struct_typeContext ctx) {
		if(ctx.QUEUE()!=null)
			return true;
		else
			return false;
	}
	
	static boolean isStack(Struct_typeContext ctx) {
		if(ctx.STACK()!=null)
			return true;
		else
			return false;
	}
}
