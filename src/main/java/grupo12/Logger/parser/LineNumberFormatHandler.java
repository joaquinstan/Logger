package grupo12.Logger.parser;

import grupo12.Logger.model.messages.LogMessage;

//Format handler for the line number
public class LineNumberFormatHandler implements FormatHandler {

	static final String pattern = "(?<!%)%L";
	
	@Override
	public  void parse(LogMessage message){
		
		String oldRepr = message.toString();
		String lineNumber = Integer.toString(message.getCallerInfo().getLineNumber());
		String newRepr = oldRepr.replaceAll(pattern,lineNumber);
		
		message.setStringRepresentation(newRepr);

	}
}
