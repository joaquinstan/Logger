package main.parser;

import main.model.messages.LogMessage;

public class MessageTextFormatHandler extends FormatHandler{

	static final String pattern = "(?<!%)%m";
	@Override
	public void parse(LogMessage message) {
		
		String oldRepr = message.toString() ;
		String newRepr = oldRepr.replaceAll(pattern, message.getMessageText());
		
		message.setStringRepresentation(newRepr);
		
	}

}
