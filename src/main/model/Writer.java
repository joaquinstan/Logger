package main.model;

public interface Writer {
	public boolean init();
	public void write(String message);
	public void end();
}
