package main.parser;

import java.text.SimpleDateFormat;
import java.util.Date;

import main.model.LogMessage;

public class DateFormatHandler extends FormatHandler{

	@Override
	public  void parse(LogMessage message){
		
		String oldRepr = message.toString() ;
		Date date=message.getCallerInfo().getTimestamp();
		//	encontrar y reemplazar el %d
		String pattern=".*(?<!%)%d\\{([^}]*)\\}.*"; //Hacerlo mas configurable
		String dateFormatString = oldRepr.replaceAll(pattern,"$1");

		if (!dateFormatString.equals(oldRepr)){
			SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
		
			String newRepr = oldRepr.replaceAll("(?<!%)%d\\{([^}]*)\\}", dateFormat.format(date));
			message.setStringRepresentation(newRepr);
		}
	}

}

