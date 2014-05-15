package grupo12.Logger.model.output;

public interface Writer {
	public boolean init();
	public void write(String message);
	public void end();
}
