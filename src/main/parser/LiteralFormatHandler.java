package main.parser;

import main.model.messages.LogMessage;

public class LiteralFormatHandler extends FormatHandler{
	@Override
	public void parse(LogMessage message) {
		
		String oldRepr = message.toString() ;
		String pattern="%%"; //Hacerlo mas configurable
		String newRepr = oldRepr.replaceAll(pattern, "%"); 
		
		if ( newRepr != "") message.setStringRepresentation(newRepr);
		
	}
}
