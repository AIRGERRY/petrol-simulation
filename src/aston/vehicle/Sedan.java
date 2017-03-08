package aston.vehicle;

/**
 * Family sedan class
 *
 * @author Ollie
 * @version 1.0
 * @since 1 Mar 2017
 *
 */

public class Sedan extends Vehicle {

	/**
	 * Defines a Family Sedan according to specification
	 */
	public Sedan() {
		super();
		this.tankSize = 12 + (this.random.get().nextInt(18 - 12 + 1));
		this.queueSize = 1.5;
		this.happyTime = 60;
	}
	
}
