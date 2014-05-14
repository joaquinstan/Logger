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
		configureLevel();
		configureOutputs();
	}
	
	private void configureLevel() {
		loggerLevel = new Level(conf.getMode());
	}

	private void configureOutputs() {
		outputs = new ArrayList<Writer>();
		ArrayList<String> out = conf.getOutput();
		for (String output : out) {
			// TODO: esto si me ponen otro console va a funcionar "mal"
			if (output.equals("console"))
				outputs.add(new ConsoleWriter());
			else
				outputs.add(new FileWriter(output));
		}
		for (Writer output : outputs) {
			output.init();
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
		return this.loggerLevel.majorThan(message.getLevel());
	}

	
}
