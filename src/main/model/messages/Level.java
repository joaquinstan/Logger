package main.model.messages;

public class Level {
	
	public static final int OFF = 0;
	public static final int DEBUG = 1;
	public static final int INFO = 2;
	public static final int WARNING = 3;
	public static final int ERROR = 4;
	public static final int FATAL = 5;
	
	private String level;
	private int leveln;
	
	public Level(String level) {
		this.level = level;
		// TODO: Esto es feo...
		switch (level) {
			case "OFF":
				this.leveln = OFF;
				break;
			case "DEBUG":
				this.leveln = DEBUG;
				break;
			case "INFO":
				this.leveln = INFO;
				break;
			case "WARNING":
				this.leveln = WARNING;
				break;
			case "ERROR":
				this.leveln = ERROR;
				break;			
			case "FATAL":
				this.leveln = FATAL;
				break;
			default:
				this.level = "INFO";
				this.leveln = INFO;
				break;
		}		
	}
	
	public String asString() {
		return level;
	}

	public int getLevelNumber() {
		return leveln;
	}
	
	public boolean majorThan (Level otherLevel) {
		return leveln > otherLevel.leveln;
	}
}
