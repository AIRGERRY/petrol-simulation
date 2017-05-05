/**
 * Customer Test class
 * 
 * @author Liam
 * @version 1.1
 * @since 2 May 2017
 *
 */
package aston.person;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	/* Tests method isHappy when it equals true */
	
	@Test
	  public void isHappyTest1(){
	      Customer customer = new Customer(true);
	      boolean boolean0 = customer.isHappy();
	      assertTrue(boolean0);
	  }
	
	/* Tests method isHappy when it equals false */
	
	@Test
	  public void isHappyTest2(){
	      Customer customer0 = new Customer(false);
	      boolean boolean0 = customer0.isHappy();
	      assertFalse(boolean0);
	  }
	
	/* Tests method decrementTime, where the value of getTime is subtracted by 1. */
	
	@Test
	  public void decrementTimeTest(){
	      Customer customer = new Customer(true);
	      customer.decrementTime();
	      int int0 = customer.getTime();
	      assertEquals((-1), int0);
	  }
	
	/* Tests method getTime */
	
	 @Test
	  public void getTime(){
	      Customer customer = new Customer(true);
	      int int0 = customer.getTime();
	      assertEquals(0, int0);
	      assertTrue(customer.isHappy());
	  }
	
}