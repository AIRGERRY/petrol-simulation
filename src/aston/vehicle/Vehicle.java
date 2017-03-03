package aston.vehicle;

import aston.resources.Random;

/**
 * Parent class defining the general fields for all vehicle classes.
 * 
 * @author Ollie
 * @version 1.2
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
	private int tankSize;
	
	/**
	 * Current level of the tank
	 */
	private int tankLevel;
	
	/**
	 * Whether or not the tank is full
	 */
	private boolean isFull;
	

	/**
	 * Constructor for vehicles with no range in tank size
	 * @param queueSize Number of slots required by this vehicle
	 * @param tankSize Size of the tank
	 */
	public Vehicle(double queueSize, int tankSize) {
		this(queueSize, tankSize, tankSize);
	}
	
	/**
	 * Constructor for vehicles with a tank size range, sets a random value between a minimum and a maximum. Resets tankLevel and isFull
	 * @param queueSize Number of slots required by this vehicle
	 * @param minTankSize Minimum size of the tank
	 * @param maxTankSize Maximum size of the tank
	 */
	public Vehicle(double queueSize, int minTankSize, int maxTankSize) {
		this.queueSize = queueSize;
		this.tankSize = minTankSize + (this.random.get().nextInt(maxTankSize - minTankSize + 1));
		this.tankLevel = 0;
		this.isFull = false;
	}
	
	/**
	 * Gets the tank size, minTankSize if there is no range, or a random integer value between the minimum and maximum if there is a range
	 * @return A suitably random value of tank size
	 */
	public int getTankSize() {
		return this.tankSize;
	}
	
	/**
	 * Gets the number of queue slots this vehicle takes up
	 * @return Number of spaces required
	 */
	public double getQueueSize() {
		return this.queueSize;
	}
	
	/**
	 * Getter for isFull field
	 * @return Whether the tank is full or not
	 */
	public boolean tankFull() {
		return this.isFull;
	}
	
	/**
	 * Increases tankLevel field by 1 unit
	 */
	public void incrementTank() {
		this.tankLevel += 1;
	}
	
	/**
	 * Resets tankLevel back to 0
	 */
	public void resetTankLevel() {
		this.tankLevel = 0;
	}
	
}
