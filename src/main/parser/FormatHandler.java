package main.parser;

import main.model.messages.LogMessage;

// Interface generalizing the handling of the message format
public interface FormatHandler {

	public abstract void parse(LogMessage message);
	
}
