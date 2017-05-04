package aston.station;

import java.util.concurrent.BrokenBarrierException;

import aston.person.Customer;
import aston.person.Person;
import aston.resources.Config;
import aston.resources.Random;
import aston.resources.Range;
import aston.resources.Ticker;
import aston.vehicle.Motorbike;
import aston.vehicle.Sedan;
import aston.vehicle.SmallCar;
import aston.vehicle.Truck;
import aston.vehicle.Vehicle;

/**
 * Main Station handler class
 * 
 * @author Ollie, Mosope
 * @version 1.0
 * @since 4 Mar 2017
 *
 */

public class Station {

	/**
	 * Singleton instance of Station class
	 */
	private static Station instance = null;

	/**
	 * Should only be called from getInstance method
	 */
	private Station() {
		System.out.println("Station started");
		ServicerHandler.getInstance();
		tick();
	}

	public static Station getInstance() {
		if (instance == null) {
			instance = new Station();
		}
		return instance;
	}

	/**
	 * Creates a new {@code Person} object and adds it to a {@code Pump} if
	 * there's space, then adds to ShoppingArea when happy or simply to the
	 * {@code Till} when done
	 */
	public void newCustomerArrive() {
		Person person = createPerson();
		if (person != null) {
			if (ServicerHandler.getInstance().getShortestQueue(person.getVehicle()) == null) {
				System.out.println("No space in any queues, customer turns away");
				Double bill = 0.0;
				bill = new Double(person.getVehicle().getTankSize()) * (Double) Config.get("pricePerGallon");
				Bill.addToLost(bill);
			} else {
				joinPump(person);
			}

		}
	}

	/**
	 * Helper method for creating a new {@link Person} at random
	 * 
	 * @return a {@code Person} object
	 */
	public Person createPerson() {

		Person person = null;

		Double p = Config.get("p"); // Probability for smallcar/motorbike
		Double q = Config.get("q"); // Probability for sedan
		Double t = Config.get("t"); // Probability for truck

		Boolean allowTrucks = ((Double) Config.get("allowTrucks")) == 1.0 ? true : false;

		double randomValue = 0.0;
		if (p > q) {
			if (allowTrucks) {
				randomValue = 0.01 + (p - 0.01) * Random.get().nextDouble();
			} else {
				randomValue = q + (p - q) * Random.get().nextDouble();
			}
		} else if (q < p) {
			if (allowTrucks) {
				randomValue = 0.01 + (q - 0.01) * Random.get().nextDouble();
			} else {
				randomValue = p + (q - p) * Random.get().nextDouble();
			}
		} else {
			randomValue = 0.01 + (q - 0.01) * Random.get().nextDouble();
		}

		if (allowTrucks && randomValue <= t) {
			Vehicle vehicle = new Truck();
			Customer customer = new Customer(true);
			person = new Person(customer, vehicle, 0);
		}
		if (allowTrucks && p.equals(t) && randomValue <= t) {
			int r2 = Random.get().nextInt(4);
			if (r2 == 0) {
				Vehicle vehicle = new SmallCar();
				Customer customer = new Customer(true);
				person = new Person(customer, vehicle, 0);
			} else if (r2 == 1) {
				Vehicle vehicle = new Motorbike();
				Customer customer = new Customer(true);
				person = new Person(customer, vehicle, 0);
			} else if (r2 == 2) {
				Vehicle vehicle = new Truck();
				Customer customer = new Customer(true);
				person = new Person(customer, vehicle, 0);
			}
		}
		if (allowTrucks && q.equals(t) && randomValue <= t) {
			int r2 = Random.get().nextInt(2);
			if (r2 == 0) {
				Vehicle vehicle = new Sedan();
				Customer customer = new Customer(true);
				person = new Person(customer, vehicle, 0);
			} else if (r2 == 1) {
				Vehicle vehicle = new Truck();
				Customer customer = new Customer(true);
				person = new Person(customer, vehicle, 0);
			}
		}
		if (allowTrucks && p.equals(t) && q.equals(t) && randomValue <= t) {
			int r2 = Random.get().nextInt(4);
			if (r2 == 0) {
				Vehicle vehicle = new SmallCar();
				Customer customer = new Customer(true);
				person = new Person(customer, vehicle, 0);
			} else if (r2 == 1) {
				Vehicle vehicle = new Motorbike();
				Customer customer = new Customer(true);
				person = new Person(customer, vehicle, 0);
			} else if (r2 == 2) {
				Vehicle vehicle = new Truck();
				Customer customer = new Customer(true);
				person = new Person(customer, vehicle, 0);
			} else if (r2 == 3) {
				Vehicle vehicle = new Sedan();
				Customer customer = new Customer(true);
				person = new Person(customer, vehicle, 0);
			}
		}

		else if (p.equals(q)) {
			int r2 = Random.get().nextInt(4);
			if (r2 == 0) {
				Vehicle vehicle = new SmallCar();
				Customer customer = new Customer(true);
				person = new Person(customer, vehicle, 0);
			} else if (r2 == 1) {
				Vehicle vehicle = new Sedan();
				Customer customer = new Customer(true);
				person = new Person(customer, vehicle, 0);
			} else if (r2 == 2) {
				Vehicle vehicle = new Motorbike();
				Customer customer = new Customer(true);
				person = new Person(customer, vehicle, 0);
			}
		}

		else if (q > p) {
			if (randomValue <= p) {
				int r2 = Random.get().nextInt(3);
				if (r2 == 0) {
					Vehicle vehicle = new SmallCar();
					Customer customer = new Customer(true);
					person = new Person(customer, vehicle, 0);
				} else if (r2 == 1) {
					Vehicle vehicle = new Motorbike();
					Customer customer = new Customer(true);
					person = new Person(customer, vehicle, 0);
				}
			} else if (randomValue <= q) {
				Vehicle vehicle = new Sedan();
				Customer customer = new Customer(true);
				person = new Person(customer, vehicle, 0);
			}
		} else {
			if (randomValue <= q) {

				Vehicle vehicle = new Sedan();
				Customer customer = new Customer(true);
				person = new Person(customer, vehicle, 0);

			}
			if (randomValue <= p) {
				int r2 = Random.get().nextInt(3);
				if (r2 == 0) {
					Vehicle vehicle = new SmallCar();
					Customer customer = new Customer(true);
					person = new Person(customer, vehicle, 0);
				} else if (r2 == 1) {
					Vehicle vehicle = new Motorbike();
					Customer customer = new Customer(true);
					person = new Person(customer, vehicle, 0);
				}
			}
		}
		return person;

	}

	/**
	 * Adds a vehicle to a Pump
	 * 
	 * @param person
	 *            the person who owns the vehicle
	 */
	public void joinPump(Person person) {
		ServicerHandler.getInstance().getShortestQueue(person.getVehicle()).queue.put(person);
	}

	public void tick() {
		while (true) {
			newCustomerArrive();
			try {
				Ticker.getBarrier().await();
			} catch (InterruptedException e) {
				System.out.println("ended");
			} catch (BrokenBarrierException e) {
				System.out.println("ended");
			}
		}
	}

}
