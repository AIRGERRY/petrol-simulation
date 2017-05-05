package aston.station;

import aston.person.Customer;
import aston.person.Person;
import aston.resources.Ticker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ShoppingArea class for happy customers
 * 
 * @author Ollie, Mosope
 * @version 1.3
 * @since 14 Mar 2017
 *
 */

public class ShoppingArea implements Runnable {
	
	private static ShoppingArea instance = null;
	
	private ArrayList<Person> newPersons;
	private ArrayList<Person> persons;
	
	private ShoppingArea() {
		this.persons = new ArrayList<Person>();
		this.newPersons = new ArrayList<Person>();
	}
	
	public static ShoppingArea getInstance() {
		if (instance == null) {
			instance = new ShoppingArea();
		}
		return instance;
	}
	
	public void run() {
		while (true) {
			try {
				persons.addAll(newPersons);
				newPersons = new ArrayList<Person>();
				Iterator<Person> personIterator = persons.iterator();
				while(personIterator.hasNext()) {
					Person person = personIterator.next();
					if (person != null) {
						if (person.getCustomer() != null) {
							if (person.getCustomer().getTime() == 0) {
								ServicerHandler.getInstance().getShortestQueue().queue.put(person);
								personIterator.remove();
							} else {
								person.getCustomer().decrementTime();
							}
						}
					}
				}
				Ticker.getBarrier().await();
			} catch (InterruptedException e) {
				System.out.println("ended");
			} catch (BrokenBarrierException e) {
				System.out.println("ended");
			}
		}
		
	}
	
	/**
	 * Adds a {@link Customer} to the {@code customers} array
	 * @param customer
	 */
	public void add(Person person)
	{
		newPersons.add(person);
	}
	
	public ArrayList<Person> getPersons() {
		return this.persons;
	}
	
}
