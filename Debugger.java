package com.tnes;

import java.lang.reflect.Method;
import java.io.File;
import java.text.SimpleDateFormat;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class Debugger {
	private boolean debugging = false;
	private File logFile;
	private Map<String, DebuggerCommand> commands = new HashMap<String, DebuggerCommand>();
	
	public static String PARAM_DELIM = ",";
	
	public Debugger(boolean debugging, String logFileName) throws IOException {
		this.debugging = debugging;
		this.commands = new HashMap<String, DebuggerCommand>();
		this.logFile = new File(logFileName);
		if (this.logFile.exists()) {
			SimpleDateFormat formatter = new SimpleDateFormat("_hhmmss_MMddyyyy");
			this.logFile.renameTo(new File(logFileName + formatter.format(new Date())));
		}
		this.logFile.createNewFile();
	}
	
	public boolean isDebugging() {
		return debugging;
	}
	
	public void setDebugging(boolean debugging) {
		this.debugging = debugging;
	}
	
	public void enableDebugging() {
		this.debugging = true;
	}
	
	public void disableDebugging() {
		this.debugging = false;
	}
	
	public void debugPrint(String text) {
		if (debugging) {
			System.out.println(text);
		}
	}
	
	public void debugLog(String text) throws FileNotFoundException, IOException {
		OutputStream outStream = new FileOutputStream(logFile, true);
		Writer writer = new OutputStreamWriter(outStream);
		writer.write(text);
		writer.close();
	}
	
	/*
	 * Add a command to the list of available commands. 
	 */
	public void addCommand(String name, DebuggerCommand command) {
		commands.put(name, command);
	}
	
	/*
	 * Execute a named command.
	 */
	public void execCommand(String name, String param) throws Exception {
		DebuggerCommand command = commands.get(name);
		Object contextObject = command.getContextObject();
		Method method = command.getMethod();
		method.invoke(contextObject, param);
	}
	
	/* Debugger command object. 
	 * Methods should receive two parameters...
	 * 	1) <context> an Object that it will take it's context info from
	 *  2) <param> a String, which may be delimited by Debugger.PARAM_DELIM
	 */
	public class DebuggerCommand {
		private Method method;
		private Object contextObject;
		
		public DebuggerCommand(Method method, Object contextObject) {
			this.method = method;
			this.contextObject = contextObject;
		}
		
		public Method getMethod() {
			return method;
		}
		
		public Object getContextObject() {
			return contextObject;
		}
	}
}
