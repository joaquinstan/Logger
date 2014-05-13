package main.model;

public class LogMessage {
	
	private String formatString;
	private String level;
	private String messageText;
	private String stringRepresentation;
	private CallerInfo callerInfo;
	
	public LogMessage(String formatString,String messageText,CallerInfo callerInfo, String level){
		
		this.formatString = formatString;
		this.messageText = messageText;
		this.callerInfo = callerInfo;
		this.stringRepresentation = formatString;
		this.level=level;
		
	}
	
	public String toString(){
		return stringRepresentation;
	}
	
	public String getFormatString(){
		return formatString;
	}
	
	public String getMessageText(){
		return messageText;
	}
	
	public String getMessageLevel(){
		return level;
	}
	
	public void setStringRepresentation(String newRepresentation){
		stringRepresentation=newRepresentation;
	}

	public CallerInfo getCallerInfo(){
		return callerInfo;
	}
}
