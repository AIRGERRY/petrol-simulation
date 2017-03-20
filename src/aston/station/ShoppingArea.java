package aston.station;

import aston.person.Customer;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * ShoppingArea class for happy customers
 * 
 * @author Ollie
 * @version 1.1
 * @since 14 Mar 2017
 *
 */

public class ShoppingArea {
	
	private ArrayList<Customer> customers;
	
	public ShoppingArea() {
		this.customers = new ArrayList<Customer>();
		
	}
	
	public void tick() {
		Iterator<Customer> customerIterator = customers.iterator();
		while(customerIterator.hasNext()) {
			Customer customer = customerIterator.next();
			if (customer.getTime() == 0) {
				Station.getInstance().joinTill(customer);
				customerIterator.remove();
			} else {
				customer.decrementTime();
			}
		}
	}
	
	public void addToShoppingArea(Customer customer)
	{
		customers.add(customer);
	}
	
}
