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
	
	/* Tests method setHappy*/
	
	@Test
	  public void setHappy(){
	      Customer customer = new Customer(true);
	      customer.setHappy(true);
	      assertTrue(customer.isHappy());
	  }

	
	/* Tests method isHappy */
	
	@Test
	  public void isHappyTest1(){
	      Customer customer = new Customer(true);
	      boolean boolean0 = customer.isHappy();
	      assertTrue(boolean0);
	  }
	
	@Test
	  public void isHappyTest2(){
	      Customer customer = new Customer(false);
	      boolean boolean0 = customer.isHappy();
	      assertFalse(boolean0);
	  }
	
	/*Test Method MoneySpent */
	
	@Test
	  public void MoneySpent1(){
	      Customer customer = new Customer(false);
	      customer.setMoneySpent(100);
	      int int0 = customer.getMoneySpent();
	      assertEquals(100, int0);
	  }

	  public void MoneySpent2(){
	      Customer customer = new Customer(false);
	      int int0 = customer.getMoneySpent();
	      assertEquals(0, int0);
	      assertFalse(customer.isHappy());
	  }
	
	/*Test Method Set Time */
	
	 @Test
	  public void setTime(){
	      Customer customer = new Customer(true);
	      customer.setTime(100);
	      int int0 = customer.getTime();
	      assertEquals(100, int0);
	  }
	 
	 /* Tests method getTime */
		
	 @Test
	  public void getTime(){
	      Customer customer = new Customer(true);
	      int int0 = customer.getTime();
	      assertEquals(0, int0);
	      assertTrue(customer.isHappy());
	  }
	
	/* Tests method decrementTime, where the value of getTime is subtracted by 1. */
	
	@Test
	  public void decrementTimeTest(){
	      Customer customer = new Customer(true);
	      customer.decrementTime();
	      int int0 = customer.getTime();
	      assertEquals((-1), int0);
	  }
	
}