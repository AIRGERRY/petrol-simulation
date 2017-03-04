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

public abstract class Servicer {
	
	/**
	 * Holds the queue object containing the list and order of customer at the servicer
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
	 * Getter for revenue
	 * @return {double} Revenue taken by this servicer
	 */
	public double getRevenue() {
		return this.revenue;
	}
	
	/**
	 * Resets revenue back to 0
	 */
	public void resetRevenue() {
		this.revenue = 0;
	}
}
