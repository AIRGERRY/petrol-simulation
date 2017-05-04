package aston.station;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

import aston.person.Customer;
import aston.person.Person;
import aston.person.PersonAttribute;
import aston.vehicle.Vehicle;
import aston.resources.Config;
import aston.resources.Log;

/**
 * Queue for servicers, handles both Customers and Vehicles
 * 
 * @author Ollie, Sope
 * @version 1.2
 * @since 4 Mar 2017
 *
 */

public class Queue {
	
	/**
	 * Vehicle Queue
	 */
	private ArrayBlockingQueue<Person> queue;

	/**
	 * Current level of vehicles in the queue, from queueSize constants
	 */
	private double queueLevel;
	
	/**
	 * Maximum level of this queue, for vehicles only
	 */
	private double maxLevel;
	
	/**
	 * Whether to use customers or vehicles in this queue
	 */
	private boolean usingVehicle = false;

	/**
	 * Creates a vehicle queue
	 * @param maxLevel Longest queue available
	 */
	public Queue(double maxLevel) {
		this.queue = new ArrayBlockingQueue<Person>(5);
		this.maxLevel = maxLevel;
		this.usingVehicle = true;
	}
	
	/**
	 * Creates a customer queue
	 */
	public Queue() {
		this.queue = new ArrayBlockingQueue<Person>(10);
		this.usingVehicle = false;
	}

	/**
	 * Take the next object from queue
	 * Will wait until an object is available in the queue to take
	 * @return Either a Customer or Vehicle
	 */
	public Person take() {
		Person person = this.queue.peek();
		return person;
	}
	
	/**
	 * Removes next item in queue after it has been peeked at by the previous method
	 */
	public void removeNext() {
		Person person = this.queue.poll();
		if (person != null) {
			if (usingVehicle) {
				Vehicle vehicle = person.getVehicle();
				this.queueLevel -= vehicle.getQueueSize();
			}
		}
	}

	/**
	 * Adds an object to the end of the queue, if there is space
	 * @param attribute The object to add, either a Customer or a Vehicle
	 */
	public void put(Person person) {
		try {
			Random random = new Random(((Double)Config.get("seed")).intValue());
			int timeLeft = random.nextInt(13) + 6;
			person.setTimeLeft(timeLeft);
			if (usingVehicle) {
				Vehicle vehicle = person.getVehicle();
					if ((this.queueLevel + vehicle.getQueueSize()) < (Double)Config.get("queueCapacity")) {
						this.queue.put(person);
						this.queueLevel += vehicle.getQueueSize();
						if (Config.prettyOutput) { System.out.println(vehicle.toString() + " added to pump"); }
					}
			} else {
				this.queue.put(person);
			}
		} catch (InterruptedException ex) {
			
		}

	}
	
	/**
	 * Check for whether this queue has enough space free for the vehicle
	 * @return Boolean Whether there is space or not
	 */
	public boolean hasSpace(Vehicle vehicle) {
		return ((this.queueLevel + vehicle.getQueueSize()) < this.maxLevel);
	}
	
	/**
	 * Customer method for checking there is space in the queue
	 * @return
	 */
	public boolean hasSpace() {
		return (this.queue.remainingCapacity() > this.queue.size());
	}
	
	/**
	 * Check how much space is available in this queue
	 * @return Double Amount of space free in this queue
	 */
	public double freeSpace() {
		return (this.maxLevel - this.queueLevel);
	}
	
	/**
	 * 
	 */
	public double occupiedSpaces() {
		return this.queue.size();
	}

}
