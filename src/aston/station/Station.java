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

	Integer tillCount = ((Double) Config.get("tillCount")).intValue();
	Integer pumpCount = ((Double) Config.get("pumpCount")).intValue();

	private Till[] tills = new Till[tillCount];
	private Pump[] pumps = new Pump[pumpCount];
	private ShoppingArea shoppingArea = new ShoppingArea();
	private double moneyEarned = 0;
	private double moneyLost = 0;

	/**
	 * Singleton instance of Station class
	 */
	private static Station instance = null;

	/**
	 * Should only be called from getInstance method
	 */
	private Station() {
		System.out.println("Station started");
		for (int i = 0; i < tillCount; i++) {
			tills[i] = new Till(Ticker.getBarrier());
			new Thread(tills[i]).start();
		}
		for (int i = 0; i < pumpCount; i++) {
			pumps[i] = new Pump(Ticker.getBarrier());
			new Thread(pumps[i]).start();
		}
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
			if (getShortestQueue(person.getVehicle()) == null) {
				// todo
				System.out.println("No space, customer turns away");
				double bill = 0.0;
				bill = person.getVehicle().getTankSize() * (double) Config.get("pricePerGallon");
				moneyLost += bill;
			} else {
				joinPump(person);

				// if (person.getCustomer().isHappy() && (person.getVehicle()
				// instanceof Motorbike))
				// {
				// joinShoppingArea(person);
				// }
				// else
				// {
				// joinTill(person);
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

		Double p = Config.get("p"); //Probability for smallcar/motorbike
		Double q = Config.get("q"); //Probability for sedan
		Double t = Config.get("t"); //Probability for truck

		Boolean allowTrucks = ((Double) Config.get("allowTrucks")) == 1.0 ? true : false;

		double randomValue=0.0;
		if (p>q)
		{
			if(allowTrucks){
			randomValue = 0.01 + (p - 0.01) * Random.get().nextDouble();
			}
			else
			{
			randomValue = q + (p - q) * Random.get().nextDouble();
			}
		}
		else if(q<p)
		{
			if(allowTrucks)
			{
				randomValue = 0.01 + (q - 0.01) * Random.get().nextDouble();
			}
			else
			{
			randomValue = p + (q - p) * Random.get().nextDouble();
			}
		}
		else
		{
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
		 if (allowTrucks && p.equals(t)&& q.equals(t) && randomValue <= t) {
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
				else if (r2 == 3) {
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

		else if (q>p) {		
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
			 else if (randomValue <= q) {
				Vehicle vehicle = new Sedan();
				Customer customer = new Customer(true);	
				person = new Person(customer, vehicle, 0);				
			}
		}
		else
		{
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
			if (person!=null){
				System.out.println(person.toString());
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
		// getShortestQueue for pump and add vehicle
		getShortestQueue(person.getVehicle()).queue.put(person.getVehicle());

		// TODO Not required? Need to make sure

		// if in front of queue start topping up
		// if (person.getVehicle().tankFull()) {
		// double bill = person.getVehicle().getTankSize() *
		// (Double)Config.get("pricePerGallon");
		// person.addToBill(bill);
		// }
	}

	/**
	 * Adds a happy customer to the Shopingarea
	 * 
	 * @param person
	 *            the person who is the customer
	 * 
	 */
	public void joinShoppingArea(Person person) {
		if (person.getCustomer().isHappy()) {
			shoppingArea.addToShoppingArea(person);
			double bill = 0;
			Range range = new Range(0.0, 0.0);
			if (person.getVehicle() instanceof SmallCar) {
				range = Config.get("smallcarShoppingPrice");
			} else if (person.getVehicle() instanceof Sedan) {
				range = Config.get("sedanShoppingPrice");
			} else if (person.getVehicle() instanceof Truck) {
				range = Config.get("truckShoppingPrice");
			}
			bill = range.getLow() + (Random.get().nextInt((int) (range.getHigh() - range.getLow() + 1)));
			person.addToBill(bill);
		}
	}

	/**
	 * Adds a customer to a Till
	 * 
	 * @param person
	 *            the person who is the customer to add to a till
	 */
	public void joinTill(Person person) {
		// getShortestQueue for till and add customer

		// getShortestQueue(false).queue.put(person.getCustomer());
		// if in front
		moneyEarned += person.getBill();
		for (int i = 0; i < pumps.length; i++) {
			pumps[i].queue.take();
		}

	}

	/**
	 * Gets the shortest Pump/Till
	 * 
	 * @param pump
	 *            whether it checks Pump or Till. <code>true</code> will check
	 *            shortest Pump queue, <code>false</code> will check the
	 *            shortest Till queue
	 * @return {@link Servicer} The shortest Pump/Till
	 */
	public Pump getShortestQueue(Vehicle vehicle) {
		Pump shortestPump = pumps[0];
		for (int i = 1; i < pumps.length; i++) {
			Pump newPump = pumps[i];
			if (newPump.freeSpace() > shortestPump.freeSpace()) {
				shortestPump = pumps[i];
			}
		}
		if (shortestPump.hasSpace(vehicle)) {
			return shortestPump;
		} else {
			return null;
		}
	}

	public Till getShortestQueue() {
		Till shortestTill = tills[0];
		for (int i = 0; i < tills.length; i++) {
			if (tills[i].freeSpace() < shortestTill.freeSpace()) {
				shortestTill = tills[i];
			}
		}
		return shortestTill;
	}

	public void tick() {
		while (true) {
			newCustomerArrive();
			try { Ticker.getBarrier().await(); } catch (InterruptedException e) { System.out.println("ended"); } catch (BrokenBarrierException e) { System.out.println("ended"); }
		}
	}

	/**
	 * Getter for money earned
	 * 
	 * @return moneyEarned the money earned by the station
	 */
	public double getMoneyEarned() {
		return moneyEarned;
	}

	/**
	 * Getter for money lost
	 * 
	 * @return moneyLost the money lost due to missed sales
	 */
	public double getMoneyLost() {
		return moneyLost;
	}

	/**
	 * Adds money to the amount of money earned by the station
	 * 
	 * @param money
	 *            the amount of money for made sales
	 */
	public void addToMoneyEarned(double money) {
		moneyEarned += money;
	}

	/**
	 * Adds money to the amount of money lost by the station
	 * 
	 * @param money
	 *            the amount of money lost due to missed sales
	 */
	public void addToMoneyLost(double money) {
		moneyLost += money;
	}

}
