package Parser;

import Model.LogMessage;

public class LevelFormatHandler extends FormatHandler{

	public  void parse(LogMessage message){
		String formatString = message.getFormatString();
		String messageLevel = message.getMessageLevel();
		String pattern="(?!%)%p"; //Hacerlo mas configurable
		String newRepr = formatString.replaceAll(pattern,messageLevel);
		
		message.setStringRepresentation(newRepr);
	}

	
	
}
