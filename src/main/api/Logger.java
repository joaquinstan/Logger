package main.api;

import main.model.messages.LogMessage;
import main.model.output.OutputManager;

public class Logger {
	
	OutputManager manager;

	// Default constructor
	public Logger() {
		manager = new OutputManager();
	}
	
	// Custom configuration
	public Logger(String configurationFile) {
		manager = new OutputManager(configurationFile);
	}
		
	private void log(LogMessage message) {
		manager.log(message);
	}
	
	public void debug(String message) {
		//LogMessage m = new LogMessage() 
	}
	
	public void info(String message) {
		
	}
	
	public void warn(String message) {
		
	}
	
	public void error(String message) {
		
	}
	
	public void fatal(String message) {
		
	}
}
