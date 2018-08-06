package com.exilant.js;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JsTest01 {

	public static void main(String[] args) throws ScriptException {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashhon = scriptEngineManager.getEngineByName("nashhon");
		String name = "pooja";
		Integer result = null;
		nashhon.eval("print('" + name + "')");
		result = (Integer) nashhon.eval("10" + "20");
		System.out.println("Result is" + result);
	}

}
