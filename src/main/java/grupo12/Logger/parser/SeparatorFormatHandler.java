package grupo12.Logger.parser;

import grupo12.Logger.model.messages.LogMessage;

//Format handler for the separator for the message
public class SeparatorFormatHandler implements FormatHandler{

	static final String pattern = "(?<!%)%n";
	private String separator;
	
	public SeparatorFormatHandler(String separator){
		this.separator = separator;
	}
	
	
	@Override
	public void parse(LogMessage message) {
		
		String oldRepr = message.toString();
		String newRepr = oldRepr.replaceAll(pattern,separator);

		message.setStringRepresentation(newRepr);
	}

}
