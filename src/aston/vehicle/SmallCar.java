package aston.vehicle;

import aston.resources.Config;
import aston.resources.Random;
import aston.resources.Range;

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
		Range tank = Config.get("smallcarTank");
		this.tankSize = (int)(tank.getLow() + (Random.get().nextInt((int)(tank.getHigh() - tank.getLow() + 1))));
		this.queueSize = Config.get("smallcarSize");
		this.happyTime = Config.get("smallcarHappyTime");
		this.type = "SmallCar";
	}
	
	public String toString() {
		return "Small car with a " + this.tankSize + " gallon tank";
	}

}
