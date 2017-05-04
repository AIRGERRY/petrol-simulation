package aston.station;

import aston.person.Customer;
import aston.person.Person;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ShoppingArea class for happy customers
 * 
 * @author Ollie, Mosope
 * @version 1.3
 * @since 14 Mar 2017
 *
 */

public class ShoppingArea {
	
	private static ShoppingArea instance = null;
	
	private ArrayList<Person> persons;
	
	private ShoppingArea() {
		this.persons = new ArrayList<Person>();
	}
	
	public static ShoppingArea getInstance() {
		if (instance == null) {
			instance = new ShoppingArea();
		}
		return instance;
	}
	
	public void tick() {
		Iterator<Person> personIterator = persons.iterator();
		while(personIterator.hasNext()) {
			Person person = personIterator.next();
			if (person.getCustomer().getTime() == 0) {
				ServicerHandler.getInstance().getShortestQueue().queue.put(person);
				personIterator.remove();
			} else {
				person.getCustomer().decrementTime();
			}
		}
	}
	
	/**
	 * Adds a {@link Customer} to the {@code customers} array
	 * @param customer
	 */
	public void add(Person person)
	{
		persons.add(person);
	}
	
}
