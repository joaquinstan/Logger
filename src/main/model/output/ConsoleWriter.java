package main.model.output;

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
