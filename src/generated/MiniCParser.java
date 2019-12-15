// Generated from MiniC.g4 by ANTLR 4.4
 
package generated;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__19=1, T__18=2, T__17=3, T__16=4, T__15=5, T__14=6, T__13=7, T__12=8, 
		T__11=9, T__10=10, T__9=11, T__8=12, T__7=13, T__6=14, T__5=15, T__4=16, 
		T__3=17, T__2=18, T__1=19, T__0=20, QUEUE=21, STACK=22, VOID=23, INT=24, 
		WHILE=25, IF=26, ELSE=27, RETURN=28, OR=29, AND=30, LE=31, GE=32, EQ=33, 
		NE=34, PUSH=35, POP=36, SIZE=37, IDENT=38, LITERAL=39, DecimalConstant=40, 
		OctalConstant=41, HexadecimalConstant=42, WS=43;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'{'", "'['", "';'", "'<'", "'++'", "'--'", "'}'", 
		"']'", "'='", "'>'", "'!'", "'%'", "'('", "')'", "'*'", "'+'", "','", 
		"'-'", "'.'", "'Queue'", "'Stack'", "'void'", "'int'", "'while'", "'if'", 
		"'else'", "'return'", "'or'", "'and'", "'<='", "'>='", "'=='", "'!='", 
		"'push'", "'pop'", "'size'", "IDENT", "LITERAL", "DecimalConstant", "OctalConstant", 
		"HexadecimalConstant", "WS"
	};
	public static final int
		RULE_program = 0, RULE_decl = 1, RULE_var_decl = 2, RULE_struct_type = 3, 
		RULE_struct_fun = 4, RULE_struct_stmt = 5, RULE_type_spec = 6, RULE_fun_decl = 7, 
		RULE_params = 8, RULE_param = 9, RULE_stmt = 10, RULE_expr_stmt = 11, 
		RULE_while_stmt = 12, RULE_compound_stmt = 13, RULE_local_decl = 14, RULE_if_stmt = 15, 
		RULE_return_stmt = 16, RULE_expr = 17, RULE_args = 18;
	public static final String[] ruleNames = {
		"program", "decl", "var_decl", "struct_type", "struct_fun", "struct_stmt", 
		"type_spec", "fun_decl", "params", "param", "stmt", "expr_stmt", "while_stmt", 
		"compound_stmt", "local_decl", "if_stmt", "return_stmt", "expr", "args"
	};

	@Override
	public String getGrammarFileName() { return "MiniC.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38); decl();
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUEUE) | (1L << STACK) | (1L << VOID) | (1L << INT))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public Fun_declContext fun_decl() {
			return getRuleContext(Fun_declContext.class,0);
		}
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			setState(45);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43); var_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44); fun_decl();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_decl);
		try {
			setState(64);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47); type_spec();
				setState(48); match(IDENT);
				setState(49); match(T__16);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51); type_spec();
				setState(52); match(IDENT);
				setState(53); match(T__10);
				setState(54); match(LITERAL);
				setState(55); match(T__16);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(57); type_spec();
				setState(58); match(IDENT);
				setState(59); match(T__17);
				setState(60); match(LITERAL);
				setState(61); match(T__11);
				setState(62); match(T__16);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Struct_typeContext extends ParserRuleContext {
		public TerminalNode STACK() { return getToken(MiniCParser.STACK, 0); }
		public TerminalNode QUEUE() { return getToken(MiniCParser.QUEUE, 0); }
		public Struct_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterStruct_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitStruct_type(this);
		}
	}

	public final Struct_typeContext struct_type() throws RecognitionException {
		Struct_typeContext _localctx = new Struct_typeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_struct_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_la = _input.LA(1);
			if ( !(_la==QUEUE || _la==STACK) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Struct_funContext extends ParserRuleContext {
		public TerminalNode PUSH() { return getToken(MiniCParser.PUSH, 0); }
		public TerminalNode POP() { return getToken(MiniCParser.POP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SIZE() { return getToken(MiniCParser.SIZE, 0); }
		public Struct_funContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_fun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterStruct_fun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitStruct_fun(this);
		}
	}

	public final Struct_funContext struct_fun() throws RecognitionException {
		Struct_funContext _localctx = new Struct_funContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_struct_fun);
		try {
			setState(79);
			switch (_input.LA(1)) {
			case PUSH:
				enterOuterAlt(_localctx, 1);
				{
				setState(68); match(PUSH);
				setState(69); match(T__6);
				setState(70); expr(0);
				setState(71); match(T__5);
				}
				break;
			case POP:
				enterOuterAlt(_localctx, 2);
				{
				setState(73); match(POP);
				setState(74); match(T__6);
				setState(75); match(T__5);
				}
				break;
			case SIZE:
				enterOuterAlt(_localctx, 3);
				{
				setState(76); match(SIZE);
				setState(77); match(T__6);
				setState(78); match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Struct_stmtContext extends ParserRuleContext {
		public Struct_funContext struct_fun() {
			return getRuleContext(Struct_funContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public Struct_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterStruct_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitStruct_stmt(this);
		}
	}

	public final Struct_stmtContext struct_stmt() throws RecognitionException {
		Struct_stmtContext _localctx = new Struct_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_struct_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81); match(IDENT);
			setState(82); match(T__0);
			setState(83); struct_fun();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_specContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(MiniCParser.VOID, 0); }
		public Struct_typeContext struct_type() {
			return getRuleContext(Struct_typeContext.class,0);
		}
		public TerminalNode INT() { return getToken(MiniCParser.INT, 0); }
		public Type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterType_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitType_spec(this);
		}
	}

	public final Type_specContext type_spec() throws RecognitionException {
		Type_specContext _localctx = new Type_specContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type_spec);
		try {
			setState(88);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(85); match(VOID);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(86); match(INT);
				}
				break;
			case QUEUE:
			case STACK:
				enterOuterAlt(_localctx, 3);
				{
				setState(87); struct_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fun_declContext extends ParserRuleContext {
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Fun_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterFun_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitFun_decl(this);
		}
	}

	public final Fun_declContext fun_decl() throws RecognitionException {
		Fun_declContext _localctx = new Fun_declContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fun_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); type_spec();
			setState(91); match(IDENT);
			setState(92); match(T__6);
			setState(93); params();
			setState(94); match(T__5);
			setState(95); compound_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public TerminalNode VOID() { return getToken(MiniCParser.VOID, 0); }
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_params);
		int _la;
		try {
			setState(107);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97); param();
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(98); match(T__2);
					setState(99); param();
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105); match(VOID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_param);
		try {
			setState(117);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(109); type_spec();
				setState(110); match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112); type_spec();
				setState(113); match(IDENT);
				setState(114); match(T__17);
				setState(115); match(T__11);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Expr_stmtContext expr_stmt() {
			return getRuleContext(Expr_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_stmt);
		try {
			setState(124);
			switch (_input.LA(1)) {
			case T__14:
			case T__13:
			case T__8:
			case T__6:
			case T__3:
			case T__1:
			case IDENT:
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(119); expr_stmt();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(120); compound_stmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(121); if_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(122); while_stmt();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 5);
				{
				setState(123); return_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterExpr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitExpr_stmt(this);
		}
	}

	public final Expr_stmtContext expr_stmt() throws RecognitionException {
		Expr_stmtContext _localctx = new Expr_stmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126); expr(0);
			setState(127); match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(MiniCParser.WHILE, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitWhile_stmt(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); match(WHILE);
			setState(130); match(T__6);
			setState(131); expr(0);
			setState(132); match(T__5);
			setState(133); stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_stmtContext extends ParserRuleContext {
		public List<Local_declContext> local_decl() {
			return getRuleContexts(Local_declContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public Local_declContext local_decl(int i) {
			return getRuleContext(Local_declContext.class,i);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterCompound_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitCompound_stmt(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_compound_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135); match(T__18);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << QUEUE) | (1L << STACK) | (1L << VOID) | (1L << INT))) != 0)) {
				{
				{
				setState(136); local_decl();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__14) | (1L << T__13) | (1L << T__8) | (1L << T__6) | (1L << T__3) | (1L << T__1) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << IDENT) | (1L << LITERAL))) != 0)) {
				{
				{
				setState(142); stmt();
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148); match(T__12);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Local_declContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public Local_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterLocal_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitLocal_decl(this);
		}
	}

	public final Local_declContext local_decl() throws RecognitionException {
		Local_declContext _localctx = new Local_declContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_local_decl);
		try {
			setState(167);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150); type_spec();
				setState(151); match(IDENT);
				setState(152); match(T__16);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154); type_spec();
				setState(155); match(IDENT);
				setState(156); match(T__10);
				setState(157); match(LITERAL);
				setState(158); match(T__16);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(160); type_spec();
				setState(161); match(IDENT);
				setState(162); match(T__17);
				setState(163); match(LITERAL);
				setState(164); match(T__11);
				setState(165); match(T__16);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(MiniCParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(MiniCParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitIf_stmt(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_if_stmt);
		try {
			setState(183);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(169); match(IF);
				setState(170); match(T__6);
				setState(171); expr(0);
				setState(172); match(T__5);
				setState(173); stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(175); match(IF);
				setState(176); match(T__6);
				setState(177); expr(0);
				setState(178); match(T__5);
				setState(179); stmt();
				setState(180); match(ELSE);
				setState(181); stmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiniCParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitReturn_stmt(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_return_stmt);
		try {
			setState(191);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(185); match(RETURN);
				setState(186); match(T__16);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(187); match(RETURN);
				setState(188); expr(0);
				setState(189); match(T__16);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode GE() { return getToken(MiniCParser.GE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Struct_stmtContext struct_stmt() {
			return getRuleContext(Struct_stmtContext.class,0);
		}
		public TerminalNode LE() { return getToken(MiniCParser.LE, 0); }
		public TerminalNode AND() { return getToken(MiniCParser.AND, 0); }
		public TerminalNode EQ() { return getToken(MiniCParser.EQ, 0); }
		public TerminalNode NE() { return getToken(MiniCParser.NE, 0); }
		public TerminalNode OR() { return getToken(MiniCParser.OR, 0); }
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(194); match(T__1);
				setState(195); expr(21);
				}
				break;
			case 2:
				{
				setState(196); match(T__3);
				setState(197); expr(20);
				}
				break;
			case 3:
				{
				setState(198); match(T__13);
				setState(199); expr(19);
				}
				break;
			case 4:
				{
				setState(200); match(T__14);
				setState(201); expr(18);
				}
				break;
			case 5:
				{
				setState(202); match(T__8);
				setState(203); expr(6);
				}
				break;
			case 6:
				{
				setState(204); match(IDENT);
				setState(205); match(T__10);
				setState(206); expr(3);
				}
				break;
			case 7:
				{
				setState(207); match(LITERAL);
				}
				break;
			case 8:
				{
				setState(208); match(T__6);
				setState(209); expr(0);
				setState(210); match(T__5);
				}
				break;
			case 9:
				{
				setState(212); match(IDENT);
				}
				break;
			case 10:
				{
				setState(213); match(IDENT);
				setState(214); match(T__17);
				setState(215); expr(0);
				setState(216); match(T__11);
				}
				break;
			case 11:
				{
				setState(218); match(IDENT);
				setState(219); match(T__6);
				setState(220); args();
				setState(221); match(T__5);
				}
				break;
			case 12:
				{
				setState(223); match(IDENT);
				setState(224); match(T__17);
				setState(225); expr(0);
				setState(226); match(T__11);
				setState(227); match(T__10);
				setState(228); expr(0);
				}
				break;
			case 13:
				{
				setState(230); struct_stmt();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(274);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(272);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(233);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(234); match(T__4);
						setState(235); expr(18);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(236);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(237); match(T__19);
						setState(238); expr(17);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(239);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(240); match(T__7);
						setState(241); expr(16);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(242);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(243); match(T__3);
						setState(244); expr(15);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(245);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(246); match(T__1);
						setState(247); expr(14);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(248);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(249); match(EQ);
						setState(250); expr(13);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(251);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(252); match(NE);
						setState(253); expr(12);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(254);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(255); match(LE);
						setState(256); expr(11);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(257);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(258); match(T__15);
						setState(259); expr(10);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(260);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(261); match(GE);
						setState(262); expr(9);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(263);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(264); match(T__9);
						setState(265); expr(8);
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(266);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(267); match(AND);
						setState(268); expr(6);
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(269);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(270); match(OR);
						setState(271); expr(5);
						}
						break;
					}
					} 
				}
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_args);
		int _la;
		try {
			setState(286);
			switch (_input.LA(1)) {
			case T__14:
			case T__13:
			case T__8:
			case T__6:
			case T__3:
			case T__1:
			case IDENT:
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(277); expr(0);
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(278); match(T__2);
					setState(279); expr(0);
					}
					}
					setState(284);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 17);
		case 1: return precpred(_ctx, 16);
		case 2: return precpred(_ctx, 15);
		case 3: return precpred(_ctx, 14);
		case 4: return precpred(_ctx, 13);
		case 5: return precpred(_ctx, 12);
		case 6: return precpred(_ctx, 11);
		case 7: return precpred(_ctx, 10);
		case 8: return precpred(_ctx, 9);
		case 9: return precpred(_ctx, 8);
		case 10: return precpred(_ctx, 7);
		case 11: return precpred(_ctx, 5);
		case 12: return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3-\u0123\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\6\2*\n\2\r\2\16\2+\3\3\3\3\5\3\60\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4C\n\4"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6R\n\6\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\5\b[\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\7\ng\n\n\f\n\16\nj\13\n\3\n\3\n\5\nn\n\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13x\n\13\3\f\3\f\3\f\3\f\3\f\5\f\177\n\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\7\17\u008c\n\17\f\17\16\17\u008f\13"+
		"\17\3\17\7\17\u0092\n\17\f\17\16\17\u0095\13\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\5\20\u00aa\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u00ba\n\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u00c2\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00ea"+
		"\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0113"+
		"\n\23\f\23\16\23\u0116\13\23\3\24\3\24\3\24\7\24\u011b\n\24\f\24\16\24"+
		"\u011e\13\24\3\24\5\24\u0121\n\24\3\24\2\3$\25\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&\2\3\3\2\27\30\u0140\2)\3\2\2\2\4/\3\2\2\2\6B\3\2"+
		"\2\2\bD\3\2\2\2\nQ\3\2\2\2\fS\3\2\2\2\16Z\3\2\2\2\20\\\3\2\2\2\22m\3\2"+
		"\2\2\24w\3\2\2\2\26~\3\2\2\2\30\u0080\3\2\2\2\32\u0083\3\2\2\2\34\u0089"+
		"\3\2\2\2\36\u00a9\3\2\2\2 \u00b9\3\2\2\2\"\u00c1\3\2\2\2$\u00e9\3\2\2"+
		"\2&\u0120\3\2\2\2(*\5\4\3\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\3"+
		"\3\2\2\2-\60\5\6\4\2.\60\5\20\t\2/-\3\2\2\2/.\3\2\2\2\60\5\3\2\2\2\61"+
		"\62\5\16\b\2\62\63\7(\2\2\63\64\7\6\2\2\64C\3\2\2\2\65\66\5\16\b\2\66"+
		"\67\7(\2\2\678\7\f\2\289\7)\2\29:\7\6\2\2:C\3\2\2\2;<\5\16\b\2<=\7(\2"+
		"\2=>\7\5\2\2>?\7)\2\2?@\7\13\2\2@A\7\6\2\2AC\3\2\2\2B\61\3\2\2\2B\65\3"+
		"\2\2\2B;\3\2\2\2C\7\3\2\2\2DE\t\2\2\2E\t\3\2\2\2FG\7%\2\2GH\7\20\2\2H"+
		"I\5$\23\2IJ\7\21\2\2JR\3\2\2\2KL\7&\2\2LM\7\20\2\2MR\7\21\2\2NO\7\'\2"+
		"\2OP\7\20\2\2PR\7\21\2\2QF\3\2\2\2QK\3\2\2\2QN\3\2\2\2R\13\3\2\2\2ST\7"+
		"(\2\2TU\7\26\2\2UV\5\n\6\2V\r\3\2\2\2W[\7\31\2\2X[\7\32\2\2Y[\5\b\5\2"+
		"ZW\3\2\2\2ZX\3\2\2\2ZY\3\2\2\2[\17\3\2\2\2\\]\5\16\b\2]^\7(\2\2^_\7\20"+
		"\2\2_`\5\22\n\2`a\7\21\2\2ab\5\34\17\2b\21\3\2\2\2ch\5\24\13\2de\7\24"+
		"\2\2eg\5\24\13\2fd\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2in\3\2\2\2jh\3"+
		"\2\2\2kn\7\31\2\2ln\3\2\2\2mc\3\2\2\2mk\3\2\2\2ml\3\2\2\2n\23\3\2\2\2"+
		"op\5\16\b\2pq\7(\2\2qx\3\2\2\2rs\5\16\b\2st\7(\2\2tu\7\5\2\2uv\7\13\2"+
		"\2vx\3\2\2\2wo\3\2\2\2wr\3\2\2\2x\25\3\2\2\2y\177\5\30\r\2z\177\5\34\17"+
		"\2{\177\5 \21\2|\177\5\32\16\2}\177\5\"\22\2~y\3\2\2\2~z\3\2\2\2~{\3\2"+
		"\2\2~|\3\2\2\2~}\3\2\2\2\177\27\3\2\2\2\u0080\u0081\5$\23\2\u0081\u0082"+
		"\7\6\2\2\u0082\31\3\2\2\2\u0083\u0084\7\33\2\2\u0084\u0085\7\20\2\2\u0085"+
		"\u0086\5$\23\2\u0086\u0087\7\21\2\2\u0087\u0088\5\26\f\2\u0088\33\3\2"+
		"\2\2\u0089\u008d\7\4\2\2\u008a\u008c\5\36\20\2\u008b\u008a\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0093\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u0090\u0092\5\26\f\2\u0091\u0090\3\2\2\2\u0092"+
		"\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2"+
		"\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7\n\2\2\u0097\35\3\2\2\2\u0098\u0099"+
		"\5\16\b\2\u0099\u009a\7(\2\2\u009a\u009b\7\6\2\2\u009b\u00aa\3\2\2\2\u009c"+
		"\u009d\5\16\b\2\u009d\u009e\7(\2\2\u009e\u009f\7\f\2\2\u009f\u00a0\7)"+
		"\2\2\u00a0\u00a1\7\6\2\2\u00a1\u00aa\3\2\2\2\u00a2\u00a3\5\16\b\2\u00a3"+
		"\u00a4\7(\2\2\u00a4\u00a5\7\5\2\2\u00a5\u00a6\7)\2\2\u00a6\u00a7\7\13"+
		"\2\2\u00a7\u00a8\7\6\2\2\u00a8\u00aa\3\2\2\2\u00a9\u0098\3\2\2\2\u00a9"+
		"\u009c\3\2\2\2\u00a9\u00a2\3\2\2\2\u00aa\37\3\2\2\2\u00ab\u00ac\7\34\2"+
		"\2\u00ac\u00ad\7\20\2\2\u00ad\u00ae\5$\23\2\u00ae\u00af\7\21\2\2\u00af"+
		"\u00b0\5\26\f\2\u00b0\u00ba\3\2\2\2\u00b1\u00b2\7\34\2\2\u00b2\u00b3\7"+
		"\20\2\2\u00b3\u00b4\5$\23\2\u00b4\u00b5\7\21\2\2\u00b5\u00b6\5\26\f\2"+
		"\u00b6\u00b7\7\35\2\2\u00b7\u00b8\5\26\f\2\u00b8\u00ba\3\2\2\2\u00b9\u00ab"+
		"\3\2\2\2\u00b9\u00b1\3\2\2\2\u00ba!\3\2\2\2\u00bb\u00bc\7\36\2\2\u00bc"+
		"\u00c2\7\6\2\2\u00bd\u00be\7\36\2\2\u00be\u00bf\5$\23\2\u00bf\u00c0\7"+
		"\6\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00bb\3\2\2\2\u00c1\u00bd\3\2\2\2\u00c2"+
		"#\3\2\2\2\u00c3\u00c4\b\23\1\2\u00c4\u00c5\7\25\2\2\u00c5\u00ea\5$\23"+
		"\27\u00c6\u00c7\7\23\2\2\u00c7\u00ea\5$\23\26\u00c8\u00c9\7\t\2\2\u00c9"+
		"\u00ea\5$\23\25\u00ca\u00cb\7\b\2\2\u00cb\u00ea\5$\23\24\u00cc\u00cd\7"+
		"\16\2\2\u00cd\u00ea\5$\23\b\u00ce\u00cf\7(\2\2\u00cf\u00d0\7\f\2\2\u00d0"+
		"\u00ea\5$\23\5\u00d1\u00ea\7)\2\2\u00d2\u00d3\7\20\2\2\u00d3\u00d4\5$"+
		"\23\2\u00d4\u00d5\7\21\2\2\u00d5\u00ea\3\2\2\2\u00d6\u00ea\7(\2\2\u00d7"+
		"\u00d8\7(\2\2\u00d8\u00d9\7\5\2\2\u00d9\u00da\5$\23\2\u00da\u00db\7\13"+
		"\2\2\u00db\u00ea\3\2\2\2\u00dc\u00dd\7(\2\2\u00dd\u00de\7\20\2\2\u00de"+
		"\u00df\5&\24\2\u00df\u00e0\7\21\2\2\u00e0\u00ea\3\2\2\2\u00e1\u00e2\7"+
		"(\2\2\u00e2\u00e3\7\5\2\2\u00e3\u00e4\5$\23\2\u00e4\u00e5\7\13\2\2\u00e5"+
		"\u00e6\7\f\2\2\u00e6\u00e7\5$\23\2\u00e7\u00ea\3\2\2\2\u00e8\u00ea\5\f"+
		"\7\2\u00e9\u00c3\3\2\2\2\u00e9\u00c6\3\2\2\2\u00e9\u00c8\3\2\2\2\u00e9"+
		"\u00ca\3\2\2\2\u00e9\u00cc\3\2\2\2\u00e9\u00ce\3\2\2\2\u00e9\u00d1\3\2"+
		"\2\2\u00e9\u00d2\3\2\2\2\u00e9\u00d6\3\2\2\2\u00e9\u00d7\3\2\2\2\u00e9"+
		"\u00dc\3\2\2\2\u00e9\u00e1\3\2\2\2\u00e9\u00e8\3\2\2\2\u00ea\u0114\3\2"+
		"\2\2\u00eb\u00ec\f\23\2\2\u00ec\u00ed\7\22\2\2\u00ed\u0113\5$\23\24\u00ee"+
		"\u00ef\f\22\2\2\u00ef\u00f0\7\3\2\2\u00f0\u0113\5$\23\23\u00f1\u00f2\f"+
		"\21\2\2\u00f2\u00f3\7\17\2\2\u00f3\u0113\5$\23\22\u00f4\u00f5\f\20\2\2"+
		"\u00f5\u00f6\7\23\2\2\u00f6\u0113\5$\23\21\u00f7\u00f8\f\17\2\2\u00f8"+
		"\u00f9\7\25\2\2\u00f9\u0113\5$\23\20\u00fa\u00fb\f\16\2\2\u00fb\u00fc"+
		"\7#\2\2\u00fc\u0113\5$\23\17\u00fd\u00fe\f\r\2\2\u00fe\u00ff\7$\2\2\u00ff"+
		"\u0113\5$\23\16\u0100\u0101\f\f\2\2\u0101\u0102\7!\2\2\u0102\u0113\5$"+
		"\23\r\u0103\u0104\f\13\2\2\u0104\u0105\7\7\2\2\u0105\u0113\5$\23\f\u0106"+
		"\u0107\f\n\2\2\u0107\u0108\7\"\2\2\u0108\u0113\5$\23\13\u0109\u010a\f"+
		"\t\2\2\u010a\u010b\7\r\2\2\u010b\u0113\5$\23\n\u010c\u010d\f\7\2\2\u010d"+
		"\u010e\7 \2\2\u010e\u0113\5$\23\b\u010f\u0110\f\6\2\2\u0110\u0111\7\37"+
		"\2\2\u0111\u0113\5$\23\7\u0112\u00eb\3\2\2\2\u0112\u00ee\3\2\2\2\u0112"+
		"\u00f1\3\2\2\2\u0112\u00f4\3\2\2\2\u0112\u00f7\3\2\2\2\u0112\u00fa\3\2"+
		"\2\2\u0112\u00fd\3\2\2\2\u0112\u0100\3\2\2\2\u0112\u0103\3\2\2\2\u0112"+
		"\u0106\3\2\2\2\u0112\u0109\3\2\2\2\u0112\u010c\3\2\2\2\u0112\u010f\3\2"+
		"\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115"+
		"%\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u011c\5$\23\2\u0118\u0119\7\24\2\2"+
		"\u0119\u011b\5$\23\2\u011a\u0118\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a"+
		"\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u0121\3\2\2\2\u011e\u011c\3\2\2\2\u011f"+
		"\u0121\3\2\2\2\u0120\u0117\3\2\2\2\u0120\u011f\3\2\2\2\u0121\'\3\2\2\2"+
		"\25+/BQZhmw~\u008d\u0093\u00a9\u00b9\u00c1\u00e9\u0112\u0114\u011c\u0120";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}