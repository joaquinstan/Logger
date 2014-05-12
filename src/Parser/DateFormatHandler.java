package Parser;

import java.text.SimpleDateFormat;
import java.util.Date;

import Model.LogMessage;

public class DateFormatHandler extends FormatHandler{

	@Override
	public  void parse(LogMessage message){
		
		String formatString = message.getFormatString() ;
		Date date=message.getCallerInfo().getTimestamp();
		//	encontrar y reemplazar el %d
		String pattern="(?!%)%d\\{(.*)\\}"; //Hacerlo mas configurable
		String dateFormatString = formatString.replaceAll(pattern,"$1");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
		
		String newRepr = formatString.replaceAll(pattern, dateFormat.format(date));
		
		message.setStringRepresentation(newRepr);
	}

}

