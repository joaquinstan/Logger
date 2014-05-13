package Model;

import java.util.Date;

// Information about the caller of the log message
public class CallerInfo {
	private Date timestamp;
	private Thread callingThread;
	
	public CallerInfo(Thread thread, Date date){
		
		timestamp=date;
		callingThread=thread;
	}
	
	public Date getTimestamp(){
		return timestamp;
	}
	
	public String getThreadName(){
		
		return callingThread.getName();
	}
	
	public int getLineNumber(){
		return callingThread.getStackTrace()[2].getLineNumber();
	}
	
	public String getCallingMethodName(){
		
		StackTraceElement[] ste=callingThread.getStackTrace();
		return ste[ste.length-1].toString();
	}
}
