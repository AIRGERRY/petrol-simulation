package aston.vehicle;

import aston.resources.Config;

/**
 * Family sedan class
 *
 * @author Ollie
 * @version 1.1
 * @since 1 Mar 2017
 *
 */

public class Sedan extends Vehicle {

	/**
	 * Defines a Family Sedan according to specification
	 */
	public Sedan() {
		super();
		this.tankSize = Config.SEDAN_TANK_LOW + (this.random.get().nextInt(Config.SEDAN_TANK_HIGH - Config.SEDAN_TANK_LOW + 1));
		this.queueSize = Config.SEDAN_SIZE;
		this.happyTime = Config.SEDAN_HAPPY_TIME;
	}
	
	public String toString() {
		return "Family Sedan with a " + this.tankSize + " gallon tank";
	}
	
}
