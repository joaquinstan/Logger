package main.parser;

import main.model.messages.LogMessage;

public class LiteralFormatHandler extends FormatHandler{
	
	static final String pattern = "%%";
	
	@Override
	public void parse(LogMessage message) {
		
		String oldRepr = message.toString();
		String newRepr = oldRepr.replaceAll(pattern, "%"); 
		
		message.setStringRepresentation(newRepr);

		
	}
}
