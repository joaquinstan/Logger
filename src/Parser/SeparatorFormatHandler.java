package Parser;

import Model.LogMessage;

public class SeparatorFormatHandler extends FormatHandler{

	@Override
	public void parse(LogMessage message) {
		
		String formatString = message.getFormatString();
		String pattern="(?!%)%n"; 
		String newRepr = formatString.replaceAll(pattern," ");//obtener el separador de la config...
	
		message.setStringRepresentation(newRepr);
	}

}
