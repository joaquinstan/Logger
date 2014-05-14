package main.model;

import java.util.Date;

// Information about the caller of the log message
public class CallerInfo {
	private Date timestamp;
	
	public CallerInfo(Date date){
		
		timestamp=date;
	}
	
	public Date getTimestamp(){
		return timestamp;
	}
	
	public String getThreadName(){
		
		return Thread.currentThread().getName();
	}
	
	public int getLineNumber(){
			
		return 0;
	}
	
	public String getCallingMethodName(){
		
		return null;
	}

	public String getCallingFileName() {

		return null;


	}
}
