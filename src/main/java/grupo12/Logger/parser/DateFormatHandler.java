package grupo12.Logger.parser;

import java.text.SimpleDateFormat;
import java.util.Date;

import grupo12.Logger.model.messages.LogMessage;

// Format handler for the Date 
public class DateFormatHandler implements FormatHandler{

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

