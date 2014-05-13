package main.api;

import main.model.LogMessage;

public class Logger {
	

	public Logger() {

	}
	

	private boolean isPublishable(LogMessage message) {
		//
		return true;
	}
	
	private void log(LogMessage message) {
		if (isPublishable(message)) {
			// escribir
		}
	}
	
	public void debug(String message) {

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
