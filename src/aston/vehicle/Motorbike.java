package aston.vehicle;

/**
 * Motorbike class
 * 
 * @author Ollie
 * @version 1.0
 * @since 1 Mar 2017
 *
 */

public class Motorbike extends Vehicle {
	
	/**
	 * Defines a Motorbike according to specification
	 */
	public Motorbike() {
		super();
		this.tankSize = 5;
		this.queueSize = 0.75;
		this.happyTime = 0;
	}
	
}
