package aston.vehicle;

import java.util.Random;

/**
 * Parent class defining the general fields for all vehicle classes.
 * 
 * @author Ollie
 * @version 1.1
 * @since 1 Mar 2017
 */

public abstract class Vehicle {
	
	private Random random = new Random();
	
	private double queueSize = 0.0;
	private int minTankSize;
	private int maxTankSize;
	private boolean tankSizeRange;
	
	
	/**
	 * Constructor for vehicles with no range in tank size
	 * @param queueSize Number of slots required by this vehicle
	 * @param minTankSize Size of the tank
	 */
	public Vehicle(double queueSize, int minTankSize) {
		this.queueSize = queueSize;
		this.minTankSize = minTankSize;
		this.tankSizeRange = false;
	}
	
	/**
	 * Constructor for vehicles with a tank size range
	 * @param queueSize Number of slots required by this vehicle
	 * @param minTankSize Minimum size of the tank
	 * @param maxTankSize Maximum size of the tank
	 */
	public Vehicle(double queueSize, int minTankSize, int maxTankSize) {
		this.queueSize = queueSize;
		this.minTankSize = minTankSize;
		this.maxTankSize = maxTankSize;
		this.tankSizeRange = true;
	}
	
	/**
	 * Gets the tank size, minTankSize if there is no range, or a random integer value between the minimum and maximum if there is a range
	 * @return
	 */
	public int getTankSize() {
		if (tankSizeRange) {
			return (this.minTankSize + (this.random.nextInt(this.maxTankSize - this.minTankSize)));
		} else {
			return (this.minTankSize);
		}
	}
	
	/**
	 * Gets the number of queue slots this vehicle takes up
	 * @return 
	 */
	public double getQueueSize() {
		return this.queueSize;
	}
	
}
