package aston.station;

import aston.person.Customer;
import aston.person.Person;
import aston.resources.Config;
import aston.resources.Random;
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

	private Till[] tills = new Till[Config.TILL_COUNT];
	private Pump[] pumps = new Pump[Config.PUMP_COUNT];
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
		for (int i = 0; i < Config.TILL_COUNT; i++) {
			tills[i] = new Till();
			new Thread(tills[i]).start();
		}
		for (int i = 0; i < Config.PUMP_COUNT; i++) {
			pumps[i] = new Pump();
			new Thread(pumps[i]).start();
		}
	}

	public static Station getInstance() {
		if (instance == null) {
			instance = new Station();
		}
		return instance;
	}

	/**
	 * Creates a new {@code Person} object and adds it to a {@code Pump} if there's space, then adds to ShoppingArea when happy or simply to the {@code Till} when done
	 */
	public void newCustomerArrive()
	{
		Person person = createPerson();
		if(person != null){
			//if isSpace(), joinPump()
			//if happy(), joinShoppingArea()
			//joinTill()
		}
	}

	/**
	 * Helper method for creating a new {@link Person} at random
	 * @return a {@code Person} object
	 */
	public Person createPerson()
	{
		double r = Random.get().nextDouble();
		Person person = null;

		if (Config.ALLOW_TRUCKS && r <= Config.T ){
			Vehicle vehicle = new Truck();
			Customer customer = new Customer(true);
			 person = new Person(customer,vehicle, 0);
			 return person;
		}
		if(Config.P == Config.Q)
		{
			int r2 = Random.get().nextInt(4);  
			if(r2 ==0 ) {
				Vehicle vehicle = new SmallCar();
				Customer customer = new Customer(true);
				person = new Person(customer,vehicle, 0);
			}
			else if (r2 == 1){
				Vehicle vehicle = new Sedan();
				Customer customer = new Customer(true);
				 person = new Person(customer,vehicle, 0);
			}
			else if (r2 == 3){
				Vehicle vehicle = new Motorbike();
				Customer customer = new Customer(true);
				 person = new Person(customer,vehicle, 0);
			}
			return person;
		}
		
		else{
			
			person = null;
			if(r>0.05)
			{
				r = r /10;
				while(r > 0.05)
				{
					r=r-0.01;
				}
				
			}
			if (Config.ALLOW_TRUCKS && r <= Config.T ){
				Vehicle vehicle = new Truck();
				Customer customer = new Customer(true);
				 person = new Person(customer,vehicle, 0);
			}
			 if(r <= Config.P ) {
				 int r2 = Random.get().nextInt(3);  
					if(r2 ==0 ) {
				Vehicle vehicle = new SmallCar();
				Customer customer = new Customer(true);
				 person = new Person(customer,vehicle, 0);
					}
					else if (r2 ==1)
					{
						Vehicle vehicle = new Motorbike();
						Customer customer = new Customer(true);
						 person = new Person(customer,vehicle, 0);
					}
			}
			 if (r <= Config.Q){
				Vehicle vehicle = new Sedan();
				Customer customer = new Customer(true);
				person = new Person(customer,vehicle, 0);
			}
			return person;

		}
	}

	/**
	 * Adds a vehicle to a Pump
	 * @param person the person who owns the vehicle
	 * @param vehicle the vehicle to add to a pump
	 */
	public void joinPump(Person person,Vehicle vehicle)
	{
		// getShortestQueue for pump and add vehicle
		if(vehicle.tankFull())
		{
			double bill = vehicle.getTankSize() * Config.PRICE_PER_GALLON;
			person.addToBill(bill);
		}
	}

	/**
	 * Adds a happy customer to the Shopingarea
	 * @param person the person who is the customer
	 * @param customer the customer to add to the shopping area
	 */
	public void joinShoppingArea(Person person, Customer customer)
	{
		if(customer.isHappy())
		{
			shoppingArea.addToShoppingArea(customer);
			double bill = 0;
			Random random = Random.getInstance();
			if (person.getVehicle().getClass() == SmallCar.class)
			{
				bill = Config.SMALLCAR_SHOPPING_LOW + (random.get().nextInt(Config.SMALLCAR_SHOPPING_HIGH - Config.SMALLCAR_SHOPPING_LOW + 1));
			}
			else if (person.getVehicle().getClass() == Sedan.class)
			{
				bill = Config.SEDAN_SHOPPING_LOW + (random.get().nextInt(Config.SEDAN_SHOPPING_HIGH - Config.SEDAN_SHOPPING_LOW + 1));
			}
			else if (person.getVehicle().getClass() == Truck.class)
			{
				bill = Config.TRUCK_SHOPPING_LOW + (random.get().nextInt(Config.TRUCK_SHOPPING_HIGH - Config.TRUCK_SHOPPING_LOW + 1));
			}
			
			person.addToBill(bill);
		}
	}

	/**
	 * Adds a customer to a Till
	 * @param customer the customer to add to a till
	 */
	public void joinTill(Customer customer)
	{
		//getShortestQueue for till and add customer
	}

	/**
	 * Gets the shortest Pump/Till
	 * @param pump whether it checks Pump or Till. <code>true</code> will check shortest Pump queue, <code>false</code> will check the shortest Till queue
	 * @return {@link Servicer} The shortest Pump/Til
	 */
	public Servicer getShortestQueue(boolean pump) {
		if (pump)
		{
			Pump shortestPump = pumps[0];
			for (int i = 0; i<pumps.length; i++)
			{
				//if pumps[i].getCapacity() < shortestPump
				// shortestpump = pumps[i]
			}
			return shortestPump;			
		}
		Till shortestTill = tills[0];
		for (int i = 0; i<tills.length; i++)
		{
			//if tills[i].getCapacity() < shortestTill
			// shortestpump = pumps[i]
		}
		return shortestTill;
	}

	/**
	 * Getter for money earned
	 * @return moneyEarned the money earned by the station
	 */
	public double getMoneyEarned() {
		return moneyEarned;
	}


	/**
	 * Getter for money lost
	 * @return moneyLost the money lost due to missed sales
	 */
	public double getMoneyLost() {
		return moneyLost;
	}

	/**
	 * Adds money to the amount of money earned by the station
	 * @param money the amount of money for made sales
	 */
	public void addToMoneyEarned(double money)
	{
		moneyEarned += money;
	}

	/**
	 * Adds money to the amount of money lost by the station
	 * @param money the amount of money lost due to missed sales
	 */
	public void addToMoneyLost(double money)
	{
		moneyLost += money;
	}

}
