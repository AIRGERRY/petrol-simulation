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
		Range tank = (Range)Config.get("truckTank");
		this.tankSize = new Double((tank.getLow() + (Random.get().nextInt(new Double(tank.getHigh() - tank.getLow() + 1).intValue())))).intValue();
		this.queueSize = Config.get("truckSize");
		this.happyTime = Config.get("truckHappyTime");
	}
	
	public String toString() {
		return "Truck with a " + this.tankSize + " gallon tank";
	}
	
}
