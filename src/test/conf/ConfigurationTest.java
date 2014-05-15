package test.conf;

import static org.junit.Assert.*;

import java.util.ArrayList;

import main.model.conf.Configuration;

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
}
