package main.parser;

import main.model.messages.LogMessage;

public abstract class FormatHandler {
	
	public abstract void parse(LogMessage message);
	
}
