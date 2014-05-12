package Parser;

import Model.LogMessage;

public class MethodNameFormatHandler extends FormatHandler{

	@Override
	public void parse(LogMessage message) {
		
		String formatString = message.getFormatString();
		String methodName = message.getCallerInfo().getCallingMethodName();
		String pattern="(?!%)%M"; //Hacerlo mas configurable
		String newRepr = formatString.replaceAll(pattern,methodName);
		
		
		message.setStringRepresentation(newRepr);
	}

	
}
