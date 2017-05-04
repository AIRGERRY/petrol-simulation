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
		this.tankSize = Config.get("motorbikeTank");
		this.queueSize = Config.get("motorbikeSize");
		this.happyTime = Config.get("motorbikeHappyTime");
		this.type = "Motorbike";
	}
	
	public String toString() {
		return "Motorbike with a " + this.tankSize + " gallon tank";
	}
	
}
