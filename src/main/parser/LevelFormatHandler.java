package main.parser;

import main.model.messages.LogMessage;

public class LevelFormatHandler extends FormatHandler{

	static final String pattern = "(?<!%)%p";
	
	public  void parse(LogMessage message){
		String oldRepr = message.toString();
		String messageLevel = message.getMessageLevelAsString();
		String newRepr = oldRepr.replaceAll(pattern,messageLevel);
		
		message.setStringRepresentation(newRepr);
	}

	
	
}
