package grupo12.Logger.model.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

// A class that represents a given configuration for the Logger
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
		this("src/main/java/grupo12/Logger/conf/default.cfg");
	}
	
	private void configure(String file) {
		InputStream input = null;
		conf = new Properties();
		Validator validator = new Validator();
		if (!validator.validate(file)){
			System.out.println("Archivo inválido. Se usará la configuración por default");
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
}
