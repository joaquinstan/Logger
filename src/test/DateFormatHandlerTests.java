package test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import Model.CallerInfo;
import Model.LogMessage;
import Parser.DateFormatHandler;

public class DateFormatHandlerTests {

	
	@Test
	public void testBasicDateFormat() {
		
		Date now = new Date();
		CallerInfo ci= new CallerInfo(Thread.currentThread(),now);
		LogMessage lm= new LogMessage("%d{dd/MM/YYYY HH:mm:ss}","",ci,"DEBUG");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		String dateString = dateFormat.format(now);
		
		DateFormatHandler dfh = new DateFormatHandler();
		dfh.parse(lm);
	
		assertEquals(lm.toString(),dateString);
	}

}
