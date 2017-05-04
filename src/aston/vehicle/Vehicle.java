package aston.vehicle;

import aston.person.PersonAttribute;
import aston.resources.Random;

/**
 * Parent class defining the general fields for all vehicle classes.
 * 
 * @author Ollie, Mosope 
 * @version 2.0
 * @since 1 Mar 2017
 */

public abstract class Vehicle extends PersonAttribute {
	
	/**
	 * Instance of {@link #aston.resources.Random Random} class used for predictable results
	 */
	protected Random random = Random.getInstance();
	
	/**
	 * Number of slots this vehicle takes up in a queue
	 */
	protected double queueSize = 0.0;
	
	/**
	 * Size of the tank
	 */
	protected double tankSize;
	
	/**
	 * Current level of the tank
	 */
	protected double tankLevel;
	
	/**
	 * Whether or not the tank is full
	 */
	private boolean isFull;
	
	/**
	 * Vehicle type
	 */
	protected String type;
	
	/**
	 * Holds time spent in the current queue
	 */
	protected int timeSpent;
	
	/**
	 * Time before a customer is declared 'unhappy'
	 */
	protected double happyTime;
	
	
	
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
		return new Double(this.tankSize).intValue();
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
		this.timeSpent += 1;
		if (this.tankLevel == this.tankSize) {
			setFull(true);
		}
	}
	
	/**
	 * Resets {@code tankLevel} back to 0
	 */
	public void resetTankLevel() {
		this.tankLevel = 0;
		this.isFull = false;
	}

	/**
	 * Sets the vaule of {@code isFull}
	 * @param b {@code true} or {@code false} value
	 */
	public void setFull(boolean b)
	{
		isFull = b;
	}
	
	/**
	 * Returns whether or not a customer is happy with their queue time
	 */
	public boolean isHappy() {
		return (this.timeSpent <= this.happyTime);
	}
	
	/**
	 * Vehicle type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Abstract method for defining a vehicle in a string
	 */
	public abstract String toString();
	
}
