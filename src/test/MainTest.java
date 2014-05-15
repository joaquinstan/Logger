package test;

import main.api.Logger;

public class MainTest {

	public static void main(String[] args) {
		// Default logger:
		Logger logger = new Logger("src/test/user.cfg");
		logger.debug("Mensaje de debug");
		logger.info("Mensaje de informacion. Logger creado");
		logger.warn("Mensaje de warning");
		logger.error("Mensaje de error");
		logger.fatal("Error fatal");
		logger.end();
	}

}
