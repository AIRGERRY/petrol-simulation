package aston.vehicle;

import aston.resources.*;

/**
 * 
 * 
 * @author Ollie
 * @version 1.1
 * @since 1 Mar 2017
 *
 */

public class Truck extends Vehicle {
	
	/**
	 * Defines a Truck according to the specification
	 */
	public Truck() {
		super();
		Range tank = Config.get("truckTank");
		this.tankSize = (int)(tank.getLow() + (Random.get().nextInt((int)(tank.getHigh() - tank.getLow() + 1))));
		this.queueSize = Config.get("truckSize");
		this.happyTime = Config.get("truckHappyTime");
	}
	
	public String toString() {
		return "Truck with a " + this.tankSize + " gallon tank";
	}
	
}
