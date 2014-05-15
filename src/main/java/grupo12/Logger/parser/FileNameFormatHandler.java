package grupo12.Logger.parser;

import grupo12.Logger.model.messages.LogMessage;

//Format handler for the FileName
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
