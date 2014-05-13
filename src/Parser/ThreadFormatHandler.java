package Parser;

import Model.LogMessage;

public class ThreadFormatHandler extends FormatHandler{

	@Override
	public void parse(LogMessage message) {
		
		String oldRepr = message.toString();
		String threadName = message.getCallerInfo().getThreadName();
		String pattern="(?<!%)%t"; //Hacerlo mas configurable
		String newRepr = oldRepr.replaceAll(pattern,threadName);
		
		
		if ( newRepr != "") message.setStringRepresentation(newRepr);
	}

}
