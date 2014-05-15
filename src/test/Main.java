package test;

import main.api.Logger;

public class Main {

	public static void main(String[] args) {
		// Default logger:
		Logger logger = new Logger("src/test/user.cfg");
		debug(logger);
		logger.info("Mensaje de informacion");
		warning(logger);
		logger.error("Mensaje de error");
		logger.fatal("Mensaje de error fatal");
		logger.end();
	}

	private static void warning(Logger logger) {
		logger.warn("Mensaje de warning");
	}

	private static void debug(Logger logger) {
		logger.debug("Mensaje de debug");
	}
}
