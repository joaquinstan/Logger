package main.parser;

import main.model.messages.LogMessage;

//Format handler for the message text
public class MessageTextFormatHandler implements FormatHandler{

	static final String pattern = "(?<!%)%m";
	@Override
	public void parse(LogMessage message) {
		
		String oldRepr = message.toString() ;
		String newRepr = oldRepr.replaceAll(pattern, message.getMessageText());
		
		message.setStringRepresentation(newRepr);

		
	}

}
