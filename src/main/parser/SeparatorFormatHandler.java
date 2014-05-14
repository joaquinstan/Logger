package main.parser;

import main.model.messages.LogMessage;

public class SeparatorFormatHandler extends FormatHandler{

	static final String pattern = "(?<!%)%n";
	private String separator;
	
	public SeparatorFormatHandler(String separator){
		this.separator = separator;
	}
	
	
	@Override
	public void parse(LogMessage message) {
		
		String oldRepr = message.toString();
		String newRepr = oldRepr.replaceAll(pattern,separator);
	
		if ( newRepr != "") message.setStringRepresentation(newRepr);
	}

}
