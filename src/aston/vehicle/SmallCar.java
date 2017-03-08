package aston.vehicle;

/**
 * Small car class
 *
 * @author Ollie
 * @version 1.1
 * @since 1 Mar 2017
 *
 */

public class SmallCar extends Vehicle {
	
	/**
	 * Defines a Small Car according to specification
	 */
	public SmallCar() {
		super();
		this.tankSize = 7 + (this.random.get().nextInt(9 - 7 + 1));
		this.queueSize = 1.0;
		this.happyTime = 30;
	}

}
