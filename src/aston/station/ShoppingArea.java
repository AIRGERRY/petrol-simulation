package aston.station;

import aston.person.Customer;
import aston.person.Person;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ShoppingArea class for happy customers
 * 
 * @author Ollie, Mosope
 * @version 1.1
 * @since 14 Mar 2017
 *
 */

public class ShoppingArea {
	
	private ArrayList<Person> persons;
	
	public ShoppingArea() {
		this.persons = new ArrayList<Person>();
		
	}
	
	public void tick() {
		Iterator<Person> personIterator = persons.iterator();
		while(personIterator.hasNext()) {
			Person person = personIterator.next();
			if (person.getCustomer().getTime() == 0) {
				
				Station.getInstance().joinTill(person);
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
	public void addToShoppingArea(Person person)
	{
		persons.add(person);
	}
	
}
