package grupo12.Logger.parser;

import grupo12.Logger.model.messages.LogMessage;

// Interface generalizing the handling of the message format
public interface FormatHandler {

	public abstract void parse(LogMessage message);
	
}
