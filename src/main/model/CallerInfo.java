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
		int len=Thread.currentThread().getStackTrace().length-1;
		return Thread.currentThread().getStackTrace()[len].getLineNumber();
	}//magia
	
	public String getCallingMethodName(){
		int len=Thread.currentThread().getStackTrace().length-1;
		return Thread.currentThread().getStackTrace()[len].getMethodName();
	}//magia

	public String getCallingFileName() {
		int len=Thread.currentThread().getStackTrace().length-1;
		return Thread.currentThread().getStackTrace()[len].getFileName();
	}//magia
}
