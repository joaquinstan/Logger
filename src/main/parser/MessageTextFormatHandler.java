package main.parser;

import main.model.messages.LogMessage;

public class MessageTextFormatHandler extends FormatHandler{

	@Override
	public void parse(LogMessage message) {
		
		String oldRepr = message.toString() ;
		//	encontrar y reemplazar el %m por el mensaje
		String pattern="(?<!%)%m"; //Hacerlo mas configurable
		String newRepr = oldRepr.replaceAll(pattern, message.getMessageText());
		
		if ( newRepr != "") message.setStringRepresentation(newRepr);
		
	}

}
