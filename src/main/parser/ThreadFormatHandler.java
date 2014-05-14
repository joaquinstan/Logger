package main.parser;

import main.model.messages.LogMessage;

public class ThreadFormatHandler extends FormatHandler{

	static final String pattern = "(?<!%)%t";
	@Override
	public void parse(LogMessage message) {
		
		String oldRepr = message.toString();
		String threadName = message.getCallerInfo().getThreadName();
		String newRepr = oldRepr.replaceAll(pattern,threadName);
		
		
		if ( newRepr != "") message.setStringRepresentation(newRepr);
	}

}
