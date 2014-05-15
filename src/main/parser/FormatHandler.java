package main.parser;

import main.model.messages.LogMessage;

public interface FormatHandler {

	public abstract void parse(LogMessage message);
	
}
