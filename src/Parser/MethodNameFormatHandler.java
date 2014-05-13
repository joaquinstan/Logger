package Parser;

import Model.LogMessage;

public class MethodNameFormatHandler extends FormatHandler{

	@Override
	public void parse(LogMessage message) {
		
		String oldRepr = message.toString();
		String methodName = message.getCallerInfo().getCallingMethodName();
		String pattern="(?<!%)%M"; //Hacerlo mas configurable
		String newRepr = oldRepr.replaceAll(pattern,methodName);
		
		
		if ( newRepr != "") message.setStringRepresentation(newRepr);
	}

	
}
