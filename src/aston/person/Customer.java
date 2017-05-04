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
	 * Money spent in shoppingArea
	 */
	private int moneySpent;
	
	/**
	 * Constructor for Customer class. Initialises class variables.
	 */
	public Customer(boolean bool) {
		happy = bool;
	}
	
	/**
	 * Set customer mood
	 */
	public void setHappy(boolean happy) {
		this.happy = happy;
	}

	/**
	 * Gets the current mood of the customer.
	 * @return Whether the customer is happy or not.
	 */
	public boolean isHappy() {
		return happy;
	}
	
	public int getMoneySpent() {
		return this.moneySpent;
	}
	
	public void setMoneySpent(int moneySpent) {
		this.moneySpent = moneySpent;
	}
	
	public void setTime(int time) {
		this.timeLeft = time;
	}
	
	public int getTime() {
		return this.timeLeft;
	}
	
	public void decrementTime() {
		this.timeLeft -= 1;
	}
	
	

}
