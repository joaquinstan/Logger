package grupo12.Logger.model.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.ArrayList;

// Provides validation for the configuration file
public class Validator {

	private Properties conf;

	public boolean validate(String file){
		InputStream input = null;
		
		conf = new Properties();
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
		ArrayList<String> outputList = new ArrayList<String>(Arrays.asList(conf.getProperty("output","console").split(","))) ;
			int i=0;
			for (String string : outputList) {
				if (string.equals("console")){
						i++;
				}
			}
			if (i>1){
				return false;
			}
		
		
		return true;
		
	}
	
	
	
	
}