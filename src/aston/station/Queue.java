package aston.station;

import java.util.concurrent.ArrayBlockingQueue;

import aston.person.Customer;
import aston.vehicle.Vehicle;

/**
 * Queue for servicers
 * 
 * @author Ollie, Sope
 * @version 1.2
 * @since 4 Mar 2017
 *
 */

public class Queue {

	private ArrayBlockingQueue<Vehicle> queue;

	private double queueLevel;

	public Queue() {
		this.queue = new ArrayBlockingQueue<Vehicle>(4);
	}

	public Vehicle take() {
		try {
			Vehicle vehicle = this.queue.take();
			this.queueLevel -= vehicle.getQueueSize();
			return vehicle;
		} catch (InterruptedException ex) {
			System.out.println("Problem taking object from queue");
			return null;
		}
	}

	public void put(Vehicle vehicle) {
		try {
			this.queueLevel += vehicle.getQueueSize();
			this.queue.put(vehicle);
		} catch (InterruptedException ex) {
			System.out.println("Problem adding object to queue - " + vehicle.toString());
		}

	}

}
