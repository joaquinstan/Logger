package test.conf;

import static org.junit.Assert.*;

import java.util.ArrayList;

import main.conf.Configuration;

import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void testDefaultConfiguration() {
		Configuration defaultConf = new Configuration();
		ArrayList<String> output = null;
		
		assertEquals("INFO",defaultConf.getMode());
		assertEquals("%d{HH:mm:ss} - %p - %t - %m",defaultConf.getPattern());
		
		output = defaultConf.getOutput();
		assertEquals(1, output.size());
		assertTrue(output.contains("console"));
		
		assertEquals("-", defaultConf.getSeparator());
	}

	@Test
	public void testUserConfiguration() {
		Configuration userConf = new Configuration("src/test/conf/userConf.cfg");
		ArrayList<String> output = null;
		
		assertEquals("DEBUG",userConf.getMode());
		assertEquals("%d{HH:mm:ss} %n %p %n %m",userConf.getPattern());
		
		output = userConf.getOutput();
		assertEquals(2, output.size());
		assertTrue(output.contains("console"));
		assertTrue(output.contains("log.txt"));
		
		assertEquals("|", userConf.getSeparator());
	}
	
	@Test
	public void testSetMode() {
		Configuration defaultConf = new Configuration();
		
		defaultConf.setMode("WARNING");
		
		assertEquals("WARNING", defaultConf.getMode());
	}

	@Test
	public void testSetPattern() {
		Configuration defaultConf = new Configuration();
		
		defaultConf.setPattern("%m");
		
		assertEquals("%m", defaultConf.getPattern());
	}

	@Test
	public void testSetSeparator() {
		Configuration defaultConf = new Configuration();
		
		defaultConf.setSeparator("|");
		
		assertEquals("|", defaultConf.getSeparator());
	}
	
	@Test
	public void testSetOutput() {
		Configuration defaultConf = new Configuration();
		ArrayList<String> output = null;
		
		defaultConf.setOutput("log.txt,console");
				
		output = defaultConf.getOutput();
		assertEquals(2, output.size());
		assertTrue(output.contains("console"));
		assertTrue(output.contains("log.txt"));
	}

}
