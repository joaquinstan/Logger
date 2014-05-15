package grupo12.Logger.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import grupo12.Logger.model.conf.Configuration;
import grupo12.Logger.model.messages.LogMessage;

// A chain of FormatHandlers that translate the LogMessage from a formatString
public class FormatChain {
	
	private List<FormatHandler> handlerList;
	private String formatString;
	
	public FormatChain(Configuration config){
		
		formatString = config.getPattern();
		
		handlerList = new ArrayList<FormatHandler>();
		
		handlerList.add(new MessageTextFormatHandler());
		handlerList.add(new FileNameFormatHandler());
		handlerList.add(new LevelFormatHandler());
		handlerList.add(new LineNumberFormatHandler());
		handlerList.add(new MethodNameFormatHandler());
		handlerList.add(new SeparatorFormatHandler(config.getSeparator()));
		handlerList.add(new ThreadFormatHandler());
		handlerList.add(new DateFormatHandler());
		handlerList.add(new LiteralFormatHandler());
		
	}
	
	public String parse(LogMessage message){

		message.setStringRepresentation(formatString);
		
		for (Iterator<FormatHandler> iter = handlerList.iterator();iter.hasNext();){
			FormatHandler handler=iter.next();
			handler.parse(message);	
		}
		
		return message.toString();
	}

}
