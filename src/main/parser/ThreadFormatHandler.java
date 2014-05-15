package main.parser;

import main.model.messages.LogMessage;

//Format handler for the Thread name
public class ThreadFormatHandler implements FormatHandler{

	static final String pattern = "(?<!%)%t";
	@Override
	public void parse(LogMessage message) {
		
		String oldRepr = message.toString();
		String threadName = message.getCallerInfo().getThreadName();
		String newRepr = oldRepr.replaceAll(pattern,threadName);
				
		message.setStringRepresentation(newRepr);
	}

}
