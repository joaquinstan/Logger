package Parser;

import Model.LogMessage;

public class SeparatorFormatHandler extends FormatHandler{

	@Override
	public void parse(LogMessage message) {
		
		String oldRepr = message.toString();
		String pattern="(?<!%)%n"; 
		String newRepr = oldRepr.replaceAll(pattern," ");//obtener el separador de la config...
	
		if ( newRepr != "") message.setStringRepresentation(newRepr);
	}

}
