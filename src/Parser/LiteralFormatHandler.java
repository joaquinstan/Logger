package Parser;

import Model.LogMessage;

public class LiteralFormatHandler extends FormatHandler{
	@Override
	public void parse(LogMessage message) {
		
		String formatString = message.getFormatString() ;
		String pattern="%%"; //Hacerlo mas configurable
		String newRepr = formatString.replaceAll(pattern, "%"); 
		
		message.setStringRepresentation(newRepr);
		
	}
}
