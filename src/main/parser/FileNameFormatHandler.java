package main.parser;

import main.model.messages.LogMessage;

public class FileNameFormatHandler implements FormatHandler{

	static final String pattern = "(?<!%)%F";
	
	@Override
	public void parse(LogMessage message) {
		
		String oldRepr = message.toString();
		String methodName = message.getCallerInfo().getCallingFileName();
		String newRepr = oldRepr.replaceAll(pattern,methodName);
		
		
		message.setStringRepresentation(newRepr);

	}
}
