package aston.person;

import aston.resources.Config;
import aston.vehicle.Vehicle;

/**
 * Person class
 * 
 * @author Gerard, Ollie, Mosope
 * @version 1.5
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
	 * Time left in till queue.
	 */
	private int timeLeft;

	/**
	 * Holds the bill to pay tills, this includes the price of the fuel and the
	 * items bought at the shopping area
	 */
	private double billToPay;

	/**
	 * Constructor for {@code Person} class. Initialises class variables.
	 */
	public Person(Customer customer, Vehicle vehicle, int time) {
		this.person = customer;
		this.vehicle = vehicle;
	}

	/**
	 * Getter for {@code vehicle} field
	 * 
	 * @return the Vehicle object
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * Getter for {@code person} field
	 * 
	 * @return the Customer object.
	 */
	public Customer getCustomer() {
		return this.person;
	}

	/**
	 * Gets the number of time spent waiting at the queue.
	 * 
	 * @return The value of the amount spent waiting.
	 */
	public int getTimeLeft() {
		return this.timeLeft;
	}

	/**
	 * Sets time left in till queue
	 * 
	 * @param timeLeft
	 */
	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}

	public void decrementTime() {
		this.timeLeft -= 1;
	}

	/**
	 * @return {@code billToPay} the total bill to pay
	 */
	public double getBill() {
		return this.person.getMoneySpent() + (new Double(this.vehicle.getTankSize()) * (Double)Config.get("pricePerGallon"));
	}

	public String toString() {
		boolean status = person.isHappy();
		if (status == false) {
			return "Unhappy customer driving a " + vehicle.toString();
		}
		return "Happy customer driving a " + vehicle.toString();
	}

}
