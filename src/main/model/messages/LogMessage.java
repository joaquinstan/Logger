package main.model.messages;

import java.util.Date;

import main.model.CallerInfo;

public class LogMessage {

	private Level level;
	private String messageText;
	private String stringRepresentation;
	private CallerInfo callerInfo;
	
	public LogMessage(String messageText, CallerInfo callerInfo, String level){

		this.messageText = messageText;
		this.callerInfo = callerInfo;
		this.stringRepresentation = "";
		this.level = new Level(level);
		
	}
	
	public String toString(){
		return stringRepresentation;
	}
	
	public String getMessageText(){
		return messageText;
	}
	
	public Level getMessageLevel(){
		return level;
	}
	
	public String getMessageLevelAsString(){
		return level.asString();
	}
	

	public void setStringRepresentation(String newRepresentation){
		stringRepresentation = newRepresentation;
	}

	public CallerInfo getCallerInfo(){
		return callerInfo;
	}

	public Date getTimestamp() {
		// TODO Auto-generated method stub
		return callerInfo.getTimestamp();
	}
}
