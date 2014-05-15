package main.model.output;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

//A Writer implementing class that writes to a certain File
public class RecordWriter implements Writer {

	private String filename;
	private PrintWriter writer;
	
	public RecordWriter(String filename) {
		writer = null;
		this.filename = filename;
	}
		
	private boolean canWrite() {
		return writer != null;
	}
	
	public String getFileName() {
		return filename;
	}
	
	@Override
	public void write(String message) {
		if (canWrite())
			writer.println(message);
	}

	@Override
	public boolean init() {
		try {
			writer = new PrintWriter(filename,"UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void end() {
		if (writer != null)
			writer.close();
		filename = "";
		writer = null;
	}

}
