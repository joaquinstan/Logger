package main.parser;

import main.model.messages.LogMessage;

public class LineNumberFormatHandler extends FormatHandler {

	@Override
	public  void parse(LogMessage message){
		
		String oldRepr = message.toString();
		String lineNumber = Integer.toString(message.getCallerInfo().getLineNumber());
		String pattern="(?<!%)%L"; //Hacerlo mas configurable
		String newRepr = oldRepr.replaceAll(pattern,lineNumber);
		
		
		if ( newRepr != "") message.setStringRepresentation(newRepr);
	}
}
