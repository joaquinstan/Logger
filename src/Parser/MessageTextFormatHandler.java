package Parser;

import Model.LogMessage;

public class MessageTextFormatHandler extends FormatHandler{

	@Override
	public void parse(LogMessage message) {
		
		String formatString = message.getFormatString() ;
		//	encontrar y reemplazar el %m por el mensaje
		String pattern="(?!%)%m"; //Hacerlo mas configurable
		String newRepr = formatString.replaceAll(pattern, message.getMessageText()); 
		
		message.setStringRepresentation(newRepr);
		
	}

}
