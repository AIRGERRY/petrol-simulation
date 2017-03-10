package aston.vehicle;

import aston.resources.Random;

/**
 * Parent class defining the general fields for all vehicle classes.
 * 
 * @author Ollie
 * @version 1.3
 * @since 1 Mar 2017
 */

public abstract class Vehicle {
	
	/**
	 * Instance of {@link #aston.resources.Random Random} class used for predictable results
	 */
	protected Random random = Random.getInstance();
	
	/**
	 * Number of slots this vehicle takes up in a queue
	 */
	protected double queueSize = 0.0;
	
	/**
	 * Minimum size of the tank. If there is no range, this is the only size
	 */
	protected int tankSize;
	
	/**
	 * Current level of the tank
	 */
	protected int tankLevel;
	
	/**
	 * Whether or not the tank is full
	 */
	private boolean isFull;
	
	/**
	 * Holds time spent in the current queue
	 */
	protected int timeSpent;
	
	/**
	 * Time before a customer is declared 'unhappy'
	 */
	protected int happyTime;
	
	
	
	/**
	 * Constructor for vehicles. Initialises class variables
	 */
	public Vehicle() {
		this.tankLevel = 0;
		this.isFull = false;
		this.timeSpent = 0;
	}
	
	/**
	 * Gets the tank size
	 * @return The tank size
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
	 * Getter for {@code isFull}
	 * @return Whether the tank is full or not
	 */
	public boolean tankFull() {
		return this.isFull;
	}
	
	/**
	 * Increases {@code tankLevel} field by 1 unit
	 */
	public void incrementTank() {
		this.tankLevel += 1;
	}
	
	/**
	 * Resets {@code tankLevel} back to 0
	 */
	public void resetTankLevel() {
		this.tankLevel = 0;
	}
	
}
