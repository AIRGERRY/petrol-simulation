package aston.vehicle;

import aston.resources.Config;

/**
 * Motorbike class
 * 
 * @author Ollie
 * @version 1.1
 * @since 1 Mar 2017
 *
 */

public class Motorbike extends Vehicle {
	
	/**
	 * Defines a Motorbike according to specification
	 */
	public Motorbike() {
		super();
		this.tankSize = Config.MOTORBIKE_TANK;
		this.queueSize = Config.MOTORBIKE_SIZE;
		this.happyTime = Config.MOTORBIKE_HAPPY_TIME;
	}
	
}
