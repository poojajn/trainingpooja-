package com.exilant.js;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JsTest02 {

	public static void main(String[] args) throws FileNotFoundException, ScriptException {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine nashhon = scriptEngineManager.getEngineByName("nashorn");
		nashhon.eval(new FileReader("resouces/com/js/external.js"));
		
		System.out.println(nashhon.eval("fnTest()"));
		System.out.println(nashhon.eval("hello('pooja')"));
	}

}
