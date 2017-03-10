package aston.person;

/**
 * Customer class
 * 
 * @author Gerard
 * @version 1.1
 * @since 9 Mar 2017
 *
 */

public class Customer
{
  /**
  * Field for whether the customer is Happy or not.
  */
  private boolean happy;
 
  
  /**
   * Constructor for Customer class. Initialises class variables.
   */
  public Customer(boolean bool) 
  {
      happy = bool;
  }
  
  /**
   * Gets the current mood of the customer.
   * @return Whether the customer is happy or not.
   */
  public boolean isHappy()
  {
    return happy; 
  }
  
}
