package main.parser;

import main.model.messages.LogMessage;

public class MethodNameFormatHandler extends FormatHandler{

	static final String pattern = "(?<!%)%M";
	
	@Override
	public void parse(LogMessage message) {
		
		String oldRepr = message.toString();
		String methodName = message.getCallerInfo().getCallingMethodName();
		String newRepr = oldRepr.replaceAll(pattern,methodName);
		
		message.setStringRepresentation(newRepr);

	}

	
}
