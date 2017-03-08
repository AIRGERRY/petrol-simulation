package aston.vehicle;

/**
 * 
 * 
 * @author Ollie
 * @version 1.0
 * @since 1 Mar 2017
 *
 */

public class Truck extends Vehicle {
	
	/**
	 * Defines a Truck according to the specification
	 */
	public Truck() {
		super();
		this.tankSize = 30 + (this.random.get().nextInt(40 - 30 + 1));
		this.queueSize = 2.0;
		this.happyTime = 48;
	}
}
