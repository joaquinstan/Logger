package grupo12.Logger.parser;

import grupo12.Logger.model.messages.LogMessage;

//Format handler for the calling method name
public class MethodNameFormatHandler implements FormatHandler{

	static final String pattern = "(?<!%)%M";
	
	@Override
	public void parse(LogMessage message) {
		
		String oldRepr = message.toString();
		String methodName = message.getCallerInfo().getCallingMethodName();
		String newRepr = oldRepr.replaceAll(pattern,methodName);
		
		message.setStringRepresentation(newRepr);

	}

	
}
