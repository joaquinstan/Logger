package grupo12.Logger.api;

import java.util.Date;

import grupo12.Logger.model.CallerInfo;
import grupo12.Logger.model.messages.LogMessage;
import grupo12.Logger.model.output.OutputManager;

// Main API Class, Represents a Logger
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
		LogMessage logMessage = new LogMessage(message,new CallerInfo(new Date()),"DEBUG");
		log(logMessage);
	}
	
	public void info(String message) {
		LogMessage logMessage = new LogMessage(message,new CallerInfo(new Date()),"INFO");
		log(logMessage);
	}
	
	public void warn(String message) {
		LogMessage logMessage = new LogMessage(message,new CallerInfo(new Date()),"WARNING");
		log(logMessage);
	}
	
	public void error(String message) {
		LogMessage logMessage = new LogMessage(message,new CallerInfo(new Date()),"ERROR");
		log(logMessage);
	}
	
	public void fatal(String message) {
		LogMessage logMessage = new LogMessage(message,new CallerInfo(new Date()),"FATAL");
		log(logMessage);
	}
	
	public void end() {
		manager.end();
	}
}