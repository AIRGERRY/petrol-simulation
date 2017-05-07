/**
 * Bill Test class
 * 
 * @author Liam
 * @version 1.1
 * @since 2 May 2017
 *
 */
package aston.station;

import static org.junit.Assert.*;
import aston.station.Bill;
import org.junit.Test;

public class BillTest {

	/* Add to Lost and getLost Test */
	
	  @Test
	  public void lostTest() {
	      Double double0 = new Double((100));
	      Bill.addToLost(double0);
	      Double double1 = Bill.getLost();
	      assertEquals((100), (double)double1, 0.01);
	  }

/* Add to bill/get bill test */
	  @Test
	  public void getBillTest1() {
	      Double double0 = new Double((100));
	      Bill.addToBill(double0);
	      Double double1 = Bill.getBill();
	      assertEquals((100), (double)double1, 0.01);
	  }

	  
	  @Test
	  public void getBillTest2(){
	      Double double0 = new Double(100);
	      Bill.addToBill(double0);
	      Bill.addToBill(double0);
	      Double double1 = Bill.getBill();
	      assertEquals(300, (double)double1, 0.01);
	  }

	  @Test
	  public void getBillTest3()  {
	      Double double0 = Bill.getBill();
	      Bill.addToLost(double0);
	  }
}
