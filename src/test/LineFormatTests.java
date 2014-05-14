package test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Model.CallerInfo;
import Model.LogMessage;
import Parser.FormatChain;

public class LineFormatTests {
	
	private Date now;
	private CallerInfo ci;
	private LogMessage lm;
	private FormatChain lf;
	
	@Before
	public void setUp() throws Exception {
		
		now = new Date();
		ci= new CallerInfo(Thread.currentThread(),now);
		lm= new LogMessage("%d{dd/MM/YYYY HH:mm:ss} %m %n ---- ---- %p ---- %t ---%n","This is a %pessage",ci,"DEBUG");
		lf = new FormatChain();
	}

	@Test
	public void testComplexFormat() {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		String dateString = dateFormat.format(now);
		
		lf.parse(lm);
		
		assertEquals(lm.toString(),dateString + " This is a %pessage   ---- ---- DEBUG ---- main --- ");
		
		
	}

}
