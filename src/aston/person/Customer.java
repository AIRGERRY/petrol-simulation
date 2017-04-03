package aston.person;

/**
 * Customer class
 * 
 * @author Gerard
 * @version 1.2
 * @since 9 Mar 2017
 *
 */

public class Customer extends PersonAttribute {
	
	/**
	 * Field for whether the customer is Happy or not.
	 */
	private boolean happy;
	
	/**
	 * Holds the time left in the {@code ShoppingArea}
	 */
	private int timeLeft;

	/**
	 * Holds the time spent in the {@code ShoppingArea}
	 */
	private int timeSpent;
	
	/**
	 * Constructor for Customer class. Initialises class variables.
	 */
	public Customer(boolean bool) {
		happy = bool;
	}

	/**
	 * Gets the current mood of the customer.
	 * @return Whether the customer is happy or not.
	 */
	public boolean isHappy() {
		return happy;
	}
	
	public int getTime() {
		return this.timeLeft;
	}
	
	public void decrementTime() {
		this.timeLeft -= 1;
	}
	
	

}
