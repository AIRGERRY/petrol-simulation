package aston.station;

import java.util.concurrent.ArrayBlockingQueue;

import aston.person.Customer;
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
	 * Customer Queue
	 */
	private ArrayBlockingQueue<Customer> cQueue;
	
	/**
	 * Vehicle Queue
	 */
	private ArrayBlockingQueue<Vehicle> vQueue;

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
		this.vQueue = new ArrayBlockingQueue<Vehicle>(4);
		this.maxLevel = maxLevel;
		this.usingVehicle = true;
	}
	
	/**
	 * Creates a customer queue
	 */
	public Queue() {
		this.cQueue = new ArrayBlockingQueue<Customer>(10);
		this.usingVehicle = false;
	}

	/**
	 * Take the next object from queue
	 * Will wait until an object is available in the queue to take
	 * @return Either a Customer or Vehicle
	 */
	public PersonAttribute take() {
		if (usingVehicle) {
			Vehicle vehicle = this.vQueue.poll();
			if (vehicle != null) { this.queueLevel -= vehicle.getQueueSize(); }
			return vehicle;
		} else {
			Customer customer = this.cQueue.poll();
			return customer;
		}
	}

	/**
	 * Adds an object to the end of the queue, if there is space
	 * @param attribute The object to add, either a Customer or a Vehicle
	 */
	public void put(PersonAttribute attribute) {
		try {
			if (usingVehicle) {
				if (attribute instanceof Vehicle) {
					Vehicle vehicle = (Vehicle)attribute;
					if ((this.queueLevel + vehicle.getQueueSize()) < (Double)Config.get("queueCapacity")) {
						this.vQueue.put(vehicle);
						this.queueLevel += vehicle.getQueueSize();
						System.out.println(vehicle.toString() + " added to pump");
					}
				} else {
					Log.log("Using vehicle, but a vehicle was not submitted to the queue", 3);
				}
			} else {
				if (attribute instanceof Customer) {
					Customer customer = (Customer)attribute;
					this.cQueue.put(customer);
				} else {
					Log.log("Using customer, but a customer was not submitted to the queue", 3);
				}
			}
		} catch (InterruptedException ex) {
			Log.log("Adding attribute to queue was interrupted", 3);
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
		return (this.cQueue.remainingCapacity() > this.cQueue.size());
	}
	
	/**
	 * Check how much space is available in this queue
	 * @return Double Amount of space free in this queue
	 */
	public double freeSpace() {
		return (this.maxLevel - this.queueLevel);
	}

}
