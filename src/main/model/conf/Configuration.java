package main.model.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class Configuration {
	
	private static final String defaultMode = "INFO";
	private static final String defaultPattern = "%d{HH:mm:ss} - %p - %t - %m";
	private static final String defaultOutput = "console";
	private static final String defaultSeparator = "-";
	
	private Properties conf;
	
	public Configuration(String file) {
		configure(file);
	}
		
	public Configuration() {
		// TODO: arreglar esta ruta... la idea es que poniendo "default.cfg" deberia andar.
		this("src/main/conf/default.cfg");
	}
	
	private void configure(String file) {
		InputStream input = null;
		conf = new Properties();
		Validator validator=new Validator();
		if (!validator.validate(file)){
			System.out.println("Archivo inválido. Pasará a leer por default");
			return;
		}
		try {
			input = new FileInputStream(file);
			conf.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String getMode() {
		return conf.getProperty("mode", defaultMode);
	}
	
	public String getPattern() {
		return conf.getProperty("pattern", defaultPattern);
	}
	
	public String getSeparator() {
		return conf.getProperty("separator", defaultSeparator);
	}
	
	public ArrayList<String> getOutput() {
		return new ArrayList<String>(Arrays.asList(conf.getProperty("output",defaultOutput).split(",")));
	}
	
	public void setMode(String mode) {
		conf.setProperty("mode", mode);
	}
	
	public void setPattern(String pattern) {
		conf.setProperty("pattern", pattern);
	}
	
	public void setSeparator(String separator) {
		conf.setProperty("separator", separator);
	}
	
	public void setOutput(String output) {
		conf.setProperty("output", output);
	}
}
