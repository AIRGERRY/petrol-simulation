package aston.resources;

/**
 * Singleton random class for whole program
 * 
 * @author Ollie, Mosope
 * @version 1.0
 * @since 1 Mar 2017
 *
 */

public class Random {
	
	/**
	 * Instance of the Java Random class used to generate values
	 */
	private java.util.Random random;
	
	/**
	 * Singleton instance of this class
	 */
	private static Random instance = null;
	
	/**
	 * Private constructor, should only be accessed from {@link #getInsance() getInstance}
	 */
	private Random() {
		random = new java.util.Random(new Integer((((Double) (Config.get("seed"))).intValue())));
	}
	
	/**
	 * Ensures the series of random numbers returned is always consistent with the seed
	 * @return The singleton instance of this class
	 */
	public static Random getInstance() {
		if (instance == null) {
			instance = new Random();
		}
		return instance;
	}
	
	/**
	 * Gets the random object without needing to call {@link #getInstance() getInstance} first
	 * @return Java Random object consistent with the rest of the program
	 */
	public static java.util.Random get() {
		return getInstance().random;
	}
}
