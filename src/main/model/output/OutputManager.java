package main.model.output;

import java.util.ArrayList;

import main.model.conf.Configuration;
import main.model.messages.*;

public class OutputManager {

	Configuration conf;
	Level loggerLevel;
	ArrayList<Writer> outputs;
	
	public OutputManager() {
		conf = new Configuration();
		configureLevel();
		configureOutputs();
	}
	
	public OutputManager(String configurationFile) {
		conf = new Configuration(configurationFile);
		configureOutputs();
		configureLevel();
	}
	
	private void configureLevel() {
		loggerLevel = new Level(conf.getMode());
	}

	private void configureOutputs() {
		ArrayList<String> out = conf.getOutput();
		// Parsear el string de output para crear las clases correspondientes...
		for (String output : out) {
			// TODO: Turbio (?)
			if (output.equals("console"))
				outputs.add(new ConsoleWriter());
			else // archivo
				outputs.add(new FileWriter(output));
		}
	}


	public void log(LogMessage message) {
		if (isPublishable(message)) {
			for (Writer output : outputs) {
				// TODO: Darle formato? (Si es asi, se delega en otro!)
				output.write(message.toString());
			}
		}
	}

	private boolean isPublishable(LogMessage message) {
		return (this.loggerLevel > message.getMessageLevel());
	}

	
}
