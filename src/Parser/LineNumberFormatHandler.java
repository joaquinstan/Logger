package Parser;

import Model.LogMessage;

public class LineNumberFormatHandler extends FormatHandler {

	@Override
	public  void parse(LogMessage message){
		
		String formatString = message.getFormatString();
		String lineNumber = Integer.toString(message.getCallerInfo().getLineNumber());
		String pattern="(?!%)%L"; //Hacerlo mas configurable
		String newRepr = formatString.replaceAll(pattern,lineNumber);
		
		
		message.setStringRepresentation(newRepr);
	}
}
