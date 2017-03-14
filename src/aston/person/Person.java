package aston.person;

import aston.vehicle.Vehicle;

/**
 * Person class
 * 
 * @author Gerard, Ollie, Mosope
 * @version 1.1
 * @since 9 Mar 2017
 *
 */

public class Person {
	/**
	 * Instantiation of the {@code Customer} object.
	 */
	private Customer person;

	/**
	 * instantiation of the {@code Vehicle} object.
	 */
	private Vehicle vehicle;

	/**
	 * Amount of time spent waiting at the queue.
	 */
	private int spentWaiting;

	/**
	 * Constructor for {@code Person} class. Initialises class variables.
	 */
	public Person(Customer customer, Vehicle vehicle, int time) {
		this.person = customer;
		this.vehicle = vehicle;
		this.spentWaiting = time;
	}

	
	/**
	 * Getter for {@code vehicle} field
	 * @return the Vehicle object
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	/**
	 * Getter for {@code person} field
	 * @return the Customer object.
	 */
	public Customer getCustomer() {
		return this.person;
	}

	/**
	 * Gets the number of time spent waiting at the queue.
	 * @return The value of the amount spent waiting.
	 */
	public int timeSpent() {
		return this.spentWaiting;
	}
	
	
	public String toString() {
		boolean status = person.isHappy();
		if (status == false){
			return "Unhappy Customer driving a " + vehicle.toString();
		}
		return "happy Customer driving a " + vehicle.toString() ;
	}

}
