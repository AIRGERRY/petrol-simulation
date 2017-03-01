package aston.resources;

/**
 * Singleton random class for whole program
 * 
 * @author Ollie
 * @version 1.0
 * @since 1 Mar 2017
 *
 */

public class Random {
	
	/**
	 * Configurable seed to give predictably random results through different runs of the system
	 */
	private static int SEED = 420;
	
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
		random = new java.util.Random(SEED);
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
	 * @return
	 */
	public java.util.Random get() {
		return getInstance().random;
	}
}
