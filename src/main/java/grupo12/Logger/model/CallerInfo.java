package grupo12.Logger.model;

import java.util.Date;

// Class that provides information about the caller of the log message
public class CallerInfo {
	private Date timestamp;
	
	public CallerInfo(Date date){
		timestamp = date;
	}
	
	public Date getTimestamp(){
		return timestamp;
	}
	
	public String getThreadName(){
		return Thread.currentThread().getName();
	}
	
	public int getLineNumber(){
		// TODO: Esto no funciona como debería:
		int len = Thread.currentThread().getStackTrace().length-1;
		return Thread.currentThread().getStackTrace()[len].getLineNumber();
	}
	
	public String getCallingMethodName(){
		// TODO: Esto no funciona como debería:
		int len = Thread.currentThread().getStackTrace().length-1;
		return Thread.currentThread().getStackTrace()[len].getMethodName();
	}

	public String getCallingFileName() {
		// TODO: Esto no funciona como debería:
		int len = Thread.currentThread().getStackTrace().length-1;
		return Thread.currentThread().getStackTrace()[len].getFileName();
	}
}
