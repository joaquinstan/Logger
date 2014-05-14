package main.parser;

import java.text.SimpleDateFormat;
import java.util.Date;

import main.model.messages.LogMessage;

public class DateFormatHandler extends FormatHandler{

	static final String dateFormatPattern = ".*(?<!%)%d\\{([^}]*)\\}.*";
	static final String pattern = "(?<!%)%d\\{([^}]*)\\}";
	
	@Override
	public  void parse(LogMessage message){
		
		String oldRepr = message.toString() ;
		Date date = message.getTimestamp();
		String dateFormatString = oldRepr.replaceAll(dateFormatPattern,"$1");

		if (!dateFormatString.equals(oldRepr)){
			
			SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
		
			String newRepr = oldRepr.replaceAll(pattern, dateFormat.format(date));
			message.setStringRepresentation(newRepr);
		}
	}

}

