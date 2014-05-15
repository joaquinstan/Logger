package main.model.output;

// A Writer implementing class that writes to Console
public class ConsoleWriter implements Writer {

	@Override
	public void write(String message) {
		System.out.println(message);
	}

	@Override
	public boolean init() {
		return true;
	}

	@Override
	public void end() {}

}
