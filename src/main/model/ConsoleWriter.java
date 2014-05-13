package main.model;

public class ConsoleWriter implements Writer {

	@Override
	public void write(String message) {
		System.out.print(message);
	}

	@Override
	public boolean init() {
		return true;
	}

	@Override
	public void end() {}

}
