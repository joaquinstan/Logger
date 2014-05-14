package main.parser;

import main.model.messages.LogMessage;

public class LineNumberFormatHandler extends FormatHandler {

	static final String pattern = "(?<!%)%L";
	
	@Override
	public  void parse(LogMessage message){
		
		String oldRepr = message.toString();
		String lineNumber = Integer.toString(message.getCallerInfo().getLineNumber());
		String newRepr = oldRepr.replaceAll(pattern,lineNumber);
		
		message.setStringRepresentation(newRepr);

	}
}
