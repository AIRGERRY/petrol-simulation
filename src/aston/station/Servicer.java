package aston.station;

import java.util.concurrent.CyclicBarrier;

import aston.person.Person;
import aston.person.PersonAttribute;
import aston.resources.Config;
import aston.vehicle.Vehicle;

/**
 * Parent class for Pump and Till
 * Holds a queue and takings for the simulation
 * 
 * @author Ollie
 * @version 1.0
 * @since 4 Mar 2017
 *
 */

public abstract class Servicer implements Runnable {
	
	/**
	 * personAttribute for sharing between queues
	 */
	protected Person person;
	
	/**
	 * Holds the CyclicBarrier object for ticks
	 */
	protected CyclicBarrier barrier;
	
	/**
	 * Holds the {@code queue} object containing the list and order of customer at the servicer
	 */
	public Queue queue;
	
	/**
	 * Running total for revenue taken by this servicer
	 */
	protected double revenue;
	
	/**
	 * Creates and initialises the fields of this class
	 */
	public Servicer(double maxLevel) {
		this.queue = new Queue(maxLevel);
		this.revenue = 0.0;		
	}
	
	public Servicer() {
		this.queue = new Queue();
		this.revenue = 0.0;
	}
	
	/**
	 * Getter for {@code revenue}
	 * @return {@code double} Revenue taken by this servicer
	 */
	public double getRevenue() {
		return this.revenue;
	}
	
	/**
	 * Resets {@code revenue} back to 0
	 */
	public void resetRevenue() {
		this.revenue = 0;
	}
	
	/**
	 * Passthrough for {@code hasSpace} queue function
	 * @return boolean {@code hasSpace}
	 */
	public boolean hasSpace(Vehicle vehicle) {
		return this.queue.hasSpace(vehicle);
	}
	
	/**
	 * Passthrough for {@code hasSpace} queue function
	 * @return boolean {@code hasSpace}
	 */
	public boolean hasSpace() {
		return this.queue.hasSpace();
	}
	
	/**
	 * Passthrough for {@code freeSpace} queue function
	 * @return boolean {@code freeSpace}
	 */
	public double freeSpace() {
		return this.queue.freeSpace();
	}
	
	/**
	 * Size of queue
	 */
	public double occupiedSpaces() {
		return this.queue.occupiedSpaces();
	}
	
	/**
	 * Forces child classes to not compile until the run method is defined
	 */
	public abstract void run();
}
