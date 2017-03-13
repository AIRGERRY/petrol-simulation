package aston.station;

/**
 * Parent class for Pump and Till
 * Holds a queue and takings for the simulation
 * 
 * @author Ollie
 * @version 1.0
 * @since 4 Mar 2017
 *
 */

//TODO
//Queue length method, to tell parent threads if this servicer is available for adding customers to

public abstract class Servicer implements Runnable {
	
	/**
	 * Holds the {@code queue} object containing the list and order of customer at the servicer
	 */
	protected Queue queue;
	
	/**
	 * Running total for revenue taken by this servicer
	 */
	protected double revenue;
	
	/**
	 * Creates and initialises the fields of this class
	 */
	public Servicer() {
		this.queue = new Queue();
		this.revenue = 0.0;		
	}
	
	/**
	 * Getter for {@code revenue}
	 * @return {@code double} Revenue taken by this servicer
	 */
	public double getRevenue() {
		return this.revenue;
	}
	
	/**
	 * Resets {@code revenue} back to 0
	 */
	public void resetRevenue() {
		this.revenue = 0;
	}
	
	/**
	 * Forces child classes to not compile until the run method is defined
	 */
	public abstract void run();
}
