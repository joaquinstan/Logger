package main.parser;

import main.model.messages.LogMessage;

//Format handler for the literal sign
public class LiteralFormatHandler implements FormatHandler{
	
	static final String pattern = "%%";
	
	@Override
	public void parse(LogMessage message) {
		
		String oldRepr = message.toString();
		String newRepr = oldRepr.replaceAll(pattern, "%"); 
		
		message.setStringRepresentation(newRepr);

		
	}
}
