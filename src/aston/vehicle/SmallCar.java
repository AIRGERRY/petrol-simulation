package aston.vehicle;

import aston.resources.Config;

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
		this.tankSize = Config.SMALLCAR_TANK_LOW + (this.random.get().nextInt(Config.SMALLCAR_TANK_HIGH - Config.SMALLCAR_TANK_LOW + 1));
		this.queueSize = Config.SMALLCAR_SIZE;
		this.happyTime = Config.SMALLCAR_HAPPY_TIME;
	}
	
	public String toString() {
		return "Small car with a " + this.tankSize + " gallon tank";
	}

}
