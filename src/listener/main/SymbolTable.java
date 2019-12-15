package listener.main;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.jws.soap.SOAPBinding.ParameterStyle;

import com.sun.javafx.image.IntPixelGetter;

import generated.MiniCParser;
import generated.MiniCParser.Fun_declContext;
import generated.MiniCParser.Local_declContext;
import generated.MiniCParser.ParamContext;
import generated.MiniCParser.ParamsContext;
import generated.MiniCParser.Struct_typeContext;
import generated.MiniCParser.Type_specContext;
import generated.MiniCParser.Var_declContext;
import jdk.nashorn.internal.ir.BreakableNode;
import listener.main.SymbolTable.Type;
import static listener.main.BytecodeGenListenerHelper.*;

public class SymbolTable {
	enum Type {
		INT, INTARRAY, VOID, ERROR, STACK, QUEUE
	}

	static public class VarInfo {
		Type type;
		int id;
		int initVal;

		public VarInfo(Type type, int id, int initVal) {
			this.type = type;
			this.id = id;
			this.initVal = initVal;
		}

		public VarInfo(Type type, int id) {
			this.type = type;
			this.id = id;
			this.initVal = 0;
		}
	}

	static public class FInfo {
		public String sigStr;
	}

	private Map<String, VarInfo> _lsymtable = new HashMap<>(); // local v.
	private Map<String, VarInfo> _gsymtable = new HashMap<>(); // global v.
	private Map<String, FInfo> _fsymtable = new HashMap<>(); // function

	private int _globalVarID = 0;
	private int _localVarID = 0;
	private int _labelID = 0;
	private int _tempVarID = 0;

	SymbolTable() {
		initFunDecl();
		initFunTable();
	}

	void initFunDecl() { // at each func decl
		_lsymtable.clear();
		_localVarID = 0;
		_labelID = 0;
		_tempVarID = 32;
	}

	/*
	 * 해당하는 map에 변수의 이름과 타입을 저장하고 id값을 증가시킨다.
	 */
	void putLocalVar(String varname, Type type) {
		VarInfo newLocalVar = new VarInfo(type, _localVarID);
		_lsymtable.put(varname, newLocalVar);
		_localVarID++;
	}

	void putGlobalVar(String varname, Type type) {
		VarInfo newLocalVar = new VarInfo(type, _globalVarID);
		_gsymtable.put(varname, newLocalVar);
		_globalVarID++;
	}

	void putLocalVarWithInitVal(String varname, Type type, int initVar) {
		VarInfo newLocalvar = new VarInfo(type, _localVarID, initVar);
		_lsymtable.put(varname, newLocalvar);
		_localVarID++;
	}

	void putGlobalVarWithInitVal(String varname, Type type, int initVar) {
		VarInfo newLocalVar = new VarInfo(type, _globalVarID, initVar);
		_gsymtable.put(varname, newLocalVar);
		_globalVarID++;

	}

	// param의 갯수만큼 반복하며 로컬 변수로 저장한다.
	void putParams(MiniCParser.ParamsContext params) {
		for (int i = 0; i < params.param().size(); i++) {
			ParamContext param = params.param(i);
			putLocalVar(getParamName(param), Type.INT);
		}
	}

	private void initFunTable() {
		FInfo printlninfo = new FInfo();
		printlninfo.sigStr = "java/io/PrintStream/println(I)V";

		FInfo maininfo = new FInfo();
		maininfo.sigStr = "main([Ljava/lang/String;)V";
		_fsymtable.put("_print", printlninfo);
		_fsymtable.put("main", maininfo);
	}

	// 해당 입력에 따라 함수 테이블을 조사하여 값을 반환한다.
	public String getFunSpecStr(String fname) {
		return this._fsymtable.get(fname).sigStr;
	}

	public String getFunSpecStr(Fun_declContext ctx) {
		return this._fsymtable.get(getFunName(ctx)).sigStr;
	}

	/*
	 * 입력받은 Fun_decl을 저장하는 함수로서 param의 값과 반환값을 byteCode로 변환하여
	 * name(argtype)returnType의 형태로 함수 테이블에 저장한다. helper의 isVoidF와
	 * getParamTypesText를 사용하여 저장한다.
	 */
	public String putFunSpecStr(Fun_declContext ctx) {
		String fname = getFunName(ctx);
		String argtype = "";
		String rtype = "";
		String res = "";

		ParamsContext params = ctx.params();
		argtype += getParamTypesText(ctx.params());

		if (isVoidF(ctx)) {
			rtype = "V";
		} else {
			rtype = "I";
		}

		res = fname + "(" + argtype + ")" + rtype;

		FInfo finfo = new FInfo();
		finfo.sigStr = res;
		_fsymtable.put(fname, finfo);

		return res;
	}

	// 변수명을 통해 id를 반환한다.
	String getVarId(String name) {
		VarInfo var = _lsymtable.get(name);
		return Integer.toString(var.id);
	}

	Type getVarType(String name) {
		VarInfo lvar = (VarInfo) _lsymtable.get(name);
		if (lvar != null) {
			return lvar.type;
		}

		VarInfo gvar = (VarInfo) _gsymtable.get(name);
		if (gvar != null) {
			return gvar.type;
		}

		return Type.ERROR;
	}

	String newLabel() {
		return "label" + _labelID++;
	}

	String newTempVar() {
		String id = "";
		return id + _tempVarID--;
	}

	// global
	public String getVarId(Var_declContext ctx) {
		String sname = "";
		sname += getVarId(ctx.IDENT().getText());
		return sname;
	}

	// local
	public String getVarId(Local_declContext ctx) {
		String sname = "";
		sname += getVarId(ctx.IDENT().getText());
		return sname;
	}

	// struct put
	Type putStructVar(String name, Struct_typeContext ctx) {
		Type type = null;
		if (isStack(ctx)) {
			type = Type.STACK;
		} else if (isQueue(ctx)) {
			type = Type.QUEUE;
		}

		switch (type) {
		case STACK:
			putStackVar(name);
			break;
		case QUEUE:
			putQueueVar(name);
			break;
		default:
			break;
		}

		return type;
	}

	void putStackVar(String varname) {
		VarInfo stackinfo = new VarInfo(Type.STACK, _localVarID);
		_lsymtable.put(varname, stackinfo);
		_localVarID++;

		VarInfo newLocalvar = new VarInfo(Type.INT, _localVarID, 0);
		_lsymtable.put("@" + varname + "size", newLocalvar);
		_localVarID++;
	}

	void putQueueVar(String varname) {
		VarInfo newQueue = new VarInfo(Type.QUEUE, _localVarID);
		_lsymtable.put(varname, newQueue);
		_localVarID++;

		VarInfo newLocalvarstart = new VarInfo(Type.INT, _localVarID, 0);
		_localVarID++;
		VarInfo newLocalvarend = new VarInfo(Type.INT, _localVarID, 0);
		_localVarID++;

		_lsymtable.put("@"+varname + "start", newLocalvarstart);
		_lsymtable.put("@"+varname + "end", newLocalvarend);
	}

	Type getStuctType(String name) {
		VarInfo info = _lsymtable.get(name);
		return info.type;
	}

	// push
	public String pushStack(String name) {
		VarInfo newLocalVar = new VarInfo(Type.INT, _localVarID, 0);
		VarInfo stackSizeInfo = _lsymtable.get("@" + name + "size");

		_lsymtable.put("@" + name + stackSizeInfo.initVal, newLocalVar);
		_localVarID++;
		stackSizeInfo.initVal++;
		_lsymtable.put("@" + name + "size", stackSizeInfo);
		return Integer.toString(newLocalVar.id);
	}

	// pop
	public String popStack(String name) {
		VarInfo stackSizeInfo = _lsymtable.get("@" + name + "size");
		stackSizeInfo.initVal--;
		VarInfo popLocalVar = _lsymtable.get("@" + name + stackSizeInfo.initVal);
		_lsymtable.put("@" + name + "size", stackSizeInfo);
		return Integer.toString(popLocalVar.id);
	}

	// size
	public String getStackSize(String name) {
		VarInfo stackSizeinfo = _lsymtable.get("@" + name + "size");
		return Integer.toString(stackSizeinfo.id);
	}

	public String getQueueStart(String name) {
		VarInfo queueStartInfo = _lsymtable.get("@" + name + "start");
		return Integer.toString(queueStartInfo.id);
	}

	public String getQueueEnd(String name) {
		VarInfo queuEndInfo = _lsymtable.get("@" + name + "end");
		return Integer.toString(queuEndInfo.id);
	}
	
	public String pushQueue(String name) {
		VarInfo queueEndInfo = _lsymtable.get("@"+name+"end");
		queueEndInfo.initVal++;
		
		VarInfo newQueueInfo = new VarInfo(Type.INT, _localVarID);
		_localVarID++;
		
		_lsymtable.put("@"+name+queueEndInfo.initVal, newQueueInfo);
		_lsymtable.put("@"+name+"end",queueEndInfo);
		
		
		return Integer.toString(newQueueInfo.id);
	}
	
	public String popQueue(String name) {
		VarInfo queueStartInfo = _lsymtable.get("@"+name+"start");
		queueStartInfo.initVal++;
		VarInfo queuePopInfo = _lsymtable.get("@"+name+queueStartInfo.initVal);
		_lsymtable.put("@"+name+"start", queueStartInfo);
		return Integer.toString(queuePopInfo.id);
	}
	
}
