package main.parser;

import main.model.messages.LogMessage;

public class LevelFormatHandler extends FormatHandler{

	public  void parse(LogMessage message){
		String oldRepr = message.toString();
		String messageLevel = message.getMessageLevelAsString();
		String pattern="(?<!%)%p"; //Hacerlo mas configurable
		String newRepr = oldRepr.replaceAll(pattern,messageLevel);
		
		if ( newRepr != "") message.setStringRepresentation(newRepr);
	}

	
	
}
