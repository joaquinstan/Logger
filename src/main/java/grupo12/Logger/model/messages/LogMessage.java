package grupo12.Logger.model.messages;

import java.util.Date;

import grupo12.Logger.model.CallerInfo;

// Represents the message that will be logged
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
	
	public Level getLevel(){
		return level;
	}
	
	public String getLevelAsString(){
		return level.toString();
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
