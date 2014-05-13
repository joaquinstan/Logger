package main.parser;

import main.model.LogMessage;

public class LevelFormatHandler extends FormatHandler{

	public  void parse(LogMessage message){
		String oldRepr = message.toString();
		String messageLevel = message.getMessageLevel();
		String pattern="(?<!%)%p"; //Hacerlo mas configurable
		String newRepr = oldRepr.replaceAll(pattern,messageLevel);
		
		if ( newRepr != "") message.setStringRepresentation(newRepr);
	}

	
	
}
