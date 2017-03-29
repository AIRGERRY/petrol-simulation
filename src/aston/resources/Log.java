package aston.resources;

/**
 * Static logger class, for writing to a combination of the console and files.
 * 
 * @author Ollie
 * @version 1.0
 * @since 29 Mar 2017
 *
 */

public class Log {
	
	/**
	 * Singleton pattern instance variable
	 */
	private static Log instance = null;
	
	/**
	 * Default constructor
	 */
	private Log() {}
	
	/**
	 * Callable log method, passthrough to default output
	 * @param stringToLog String to log to system
	 */
	public static void log(String stringToLog) {
		log(stringToLog, 1);
	}
	
	/**
	 * Callable log method, writes to console, file, or both depending on severity level
	 * @param stringToLog String to log to system
	 * @param severity Integer to determine destination for {@code stringToLog}
	 */
	public static void log(String stringToLog, Integer severity) {
		Log log = getInstance();
		switch (severity) {
		case 1:
			log.consoleWrite(stringToLog);
			break;
		case 2:
			log.fileWrite(stringToLog);
			break;
		case 3:
			log.consoleWrite(stringToLog);
			log.fileWrite(stringToLog);
			break;
		}
	}
	
	/**
	 * Singleton pattern {@code getInstance} method
	 * @return
	 */
	public static Log getInstance() {
		if (instance == null) {
			instance = new Log();
		}
		return instance;
	}
	
	/**
	 * Console writer method
	 * @param stringToWrite String to log to system
	 */
	private void consoleWrite(String stringToWrite) {
		System.out.println(stringToWrite);
	}
	
	/**
	 * File writer method
	 * @param stringtoWrite String to log to system
	 */
	private void fileWrite(String stringtoWrite) {
		
	}
}
