package aston.vehicle;

import aston.resources.Config;
import aston.resources.Random;
import aston.resources.Range;

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
		Range tank = Config.get("sedanTank");
		this.tankSize = (int)(tank.getLow() + (Random.get().nextInt((int)(tank.getHigh() - tank.getLow() + 1))));
		this.queueSize = Config.get("sedanSize");
		this.happyTime = Config.get("sedanHappyTime");
	}
	
	public String toString() {
		return "Family Sedan with a " + this.tankSize + " gallon tank";
	}
	
}
