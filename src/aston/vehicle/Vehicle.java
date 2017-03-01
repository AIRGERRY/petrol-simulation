package aston.vehicle;

import aston.resources.Random;

/**
 * Parent class defining the general fields for all vehicle classes.
 * 
 * @author Ollie
 * @version 1.1
 * @since 1 Mar 2017
 */

public abstract class Vehicle {
	
	/**
	 * Instance of {@link #aston.resources.Random Random} class used for predictable results
	 */
	private Random random = Random.getInstance();
	
	/**
	 * Number of slots this vehicle takes up in a queue
	 */
	private double queueSize = 0.0;
	
	/**
	 * Minimum size of the tank. If there is no range, this is the only size
	 */
	private int minTankSize;
	
	/**
	 * Maximum size of the tank. If there is no range, this is not used
	 */
	private int maxTankSize;
	
	/**
	 * Defines whether there is a range of tank size
	 */
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
	 * @return A suitably random value of tank size
	 */
	public int getTankSize() {
		if (tankSizeRange) {
			return (this.minTankSize + (this.random.get().nextInt(this.maxTankSize - this.minTankSize)));
		} else {
			return (this.minTankSize);
		}
	}
	
	/**
	 * Gets the number of queue slots this vehicle takes up
	 * @return Number of spaces required
	 */
	public double getQueueSize() {
		return this.queueSize;
	}
	
}
