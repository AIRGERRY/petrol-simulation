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
		this.tankSize = Config.TRUCK_TANK_LOW + (this.random.get().nextInt(Config.TRUCK_TANK_HIGH - Config.TRUCK_TANK_LOW + 1));
		this.queueSize = Config.TRUCK_SIZE;
		this.happyTime = Config.TRUCK_HAPPY_TIME;
	}
	
	public String toString() {
		return "Truck with a " + this.tankSize + " gallon tank";
	}
	
}
