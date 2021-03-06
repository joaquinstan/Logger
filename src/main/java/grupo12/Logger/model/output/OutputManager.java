package grupo12.Logger.model.output;

import java.util.ArrayList;

import grupo12.Logger.model.conf.Configuration;
import grupo12.Logger.model.messages.*;
import grupo12.Logger.parser.FormatChain;

// Class in charge of delivering the final message to Writer classes
public class OutputManager {

	Configuration conf;
	FormatChain formatChain;
	Level loggerLevel;
	ArrayList<Writer> outputs;
	
	public OutputManager() {
		conf = new Configuration();
		formatChain = new FormatChain(conf);
		configure();
	}

	public OutputManager(String configurationFile) {
		conf = new Configuration(configurationFile);
		formatChain = new FormatChain(conf);
		configure();
	}
	
	private void configure() {
		configureLevel(conf.getMode());
		configureOutputs(conf.getOutput());
	}
	
	private void configureLevel(String level) {
		loggerLevel = new Level(conf.getMode());
	}

	private void configureOutputs(ArrayList<String> out) {
		outputs = new ArrayList<Writer>();
		for (String output : out) {
			if (output.equals("console"))
				outputs.add(new ConsoleWriter());
			else
				outputs.add(new RecordWriter(output));
		}
		for (Writer output : outputs) {
			output.init();
		}
	}


	private boolean isPublishable(LogMessage message) {
		return this.loggerLevel.majorThan(message.getLevel());
	}
	
	public void log(LogMessage message) {
		if (isPublishable(message)) {
			formatChain.parse(message);
			for (Writer output : outputs) {
				output.write(message.toString());
			}
		}
	}

	public void end() {
		for (Writer writer : outputs) {
			writer.end();
		}
	}
}
