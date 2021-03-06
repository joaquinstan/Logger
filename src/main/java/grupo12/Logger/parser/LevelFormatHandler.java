package grupo12.Logger.parser;

import grupo12.Logger.model.messages.LogMessage;

//Format handler for the message Level
public class LevelFormatHandler implements FormatHandler{

	static final String pattern = "(?<!%)%p";
	
	public  void parse(LogMessage message){
		String oldRepr = message.toString();
		String messageLevel = message.getLevelAsString();
		String newRepr = oldRepr.replaceAll(pattern,messageLevel);
		
		message.setStringRepresentation(newRepr);

	}

	
	
}
