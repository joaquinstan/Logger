package main.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.model.LogMessage;

public class FormatChain {
	
	private List<FormatHandler> handlerList;
	
	public FormatChain(){
		handlerList = new ArrayList<FormatHandler>();
		
		
		handlerList.add(new MessageTextFormatHandler());
		handlerList.add(new FileNameFormatHandler());
		handlerList.add(new LevelFormatHandler());
		handlerList.add(new LineNumberFormatHandler());
		handlerList.add(new MethodNameFormatHandler());
		handlerList.add(new SeparatorFormatHandler());
		handlerList.add(new ThreadFormatHandler());
		handlerList.add(new DateFormatHandler());
		handlerList.add(new LiteralFormatHandler());
		
	}
	
	public String parse(LogMessage message){
		
		for (Iterator<FormatHandler> iter = handlerList.iterator();iter.hasNext();){
			FormatHandler handler=iter.next();
			
			handler.parse(message);
			
		}
		
		return message.toString();
	}

}
