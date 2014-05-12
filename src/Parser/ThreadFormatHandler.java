package Parser;

import Model.LogMessage;

public class ThreadFormatHandler extends FormatHandler{

	@Override
	public void parse(LogMessage message) {
		
		String formatString = message.getFormatString();
		String threadName = message.getCallerInfo().getThreadName();
		String pattern="(?!%)%t"; //Hacerlo mas configurable
		String newRepr = formatString.replaceAll(pattern,threadName);
		
		
		message.setStringRepresentation(newRepr);
	}

}
