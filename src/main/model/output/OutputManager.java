package main.model.output;

import java.util.ArrayList;

import main.model.conf.Configuration;
import main.model.messages.*;
import main.parser.FormatChain;

public class OutputManager {

	Configuration conf;
	FormatChain formatChain;
	Level loggerLevel;
	ArrayList<Writer> outputs;
	
	public OutputManager() {
		conf = new Configuration();
		formatChain = new FormatChain(conf);
		configureLevel();
		configureOutputs();
	}
	
	public OutputManager(String configurationFile) {
		conf = new Configuration(configurationFile);
		formatChain = new FormatChain(conf);
		configureOutputs();
		configureLevel();
	}
	
	private void configureLevel() {
		loggerLevel = new Level(conf.getMode());
	}

	private void configureOutputs() {
		ArrayList<String> out = conf.getOutput();
		for (String output : out) {
			if (output.equals("console"))
				outputs.add(new ConsoleWriter());
			else
				outputs.add(new FileWriter(output));
		}
	}


	public void log(LogMessage message) {
		if (isPublishable(message)) {
			formatChain.parse(message);
			for (Writer output : outputs) {
				output.write(message.toString());
			}
		}
	}

	private boolean isPublishable(LogMessage message) {
		return (this.loggerLevel.getLevelNumber() > message.getMessageLevel().getLevelNumber());
	}

	
}
