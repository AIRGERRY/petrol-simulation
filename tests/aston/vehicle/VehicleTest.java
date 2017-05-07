/**
 * Vehicle Test class
 * 
 * @author Liam
 * @version 1.1
 * @since 2 May 2017
 *
 */
package aston.vehicle;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {
	
	/* Tests whether customer is happy with Queue time*/
	
	@Test
	  public void isHappyTest(){
		  SmallCar smallCar = new SmallCar();
	      boolean boolean0 = smallCar.isHappy();
	      assertTrue(boolean0);
	      assertFalse(smallCar.tankFull());
	  }
	
	@Test
	  public void isHappyTest2(){
	      SmallCar SmallCar = new SmallCar();
	      assertTrue(SmallCar.isHappy());
	      SmallCar.happyTime = (20);
	      boolean boolean0 = SmallCar.isHappy();
	      assertTrue(boolean0);
	  }
   /* Tests incrementTank method */
	
	  @Test
	  public void TankIncrementTest(){
	      SmallCar smallCar = new SmallCar();
	      smallCar.tankSize = (2.0);
	      smallCar.incrementTank();
	      assertFalse(smallCar.tankFull());
	  }
	  
     /*Tests getType method*/
	  
	  @Test
	  public void getTypeTest(){
	      SmallCar smallCar = new SmallCar();
	      smallCar.type = "";
	      smallCar.getType();
	  }

	  /* Tests getTankSize method */
	  
	  @Test
	  public void getTankSizeTest() {
	      SmallCar smallCar = new SmallCar();
	      smallCar.tankSize = (7.0);
	      int int0 = smallCar.getTankSize();
	      assertEquals((7), int0);
	  }
	  /* Tests getQueueSize method */
	  
	  @Test
	  public void getQueueSizeTest() {
		  SmallCar smallCar = new SmallCar();
	      smallCar.queueSize = (1.0);
	      double double0 = smallCar.getQueueSize();
	      assertEquals((1.0), double0, 0.01);
	  }

/* Set Full
 */
	  @Test
	  public void setFullTest(){
	      SmallCar smallCar = new SmallCar();
	      smallCar.setFull(true);
	      assertTrue(smallCar.tankFull());
	  }

	  /* Reset Tank level */
	  
	  @Test
	  public void resetTankLevelTest(){
		  SmallCar smallCar = new SmallCar();
	      smallCar.resetTankLevel();
	      assertTrue(smallCar.isHappy());
	      assertFalse(smallCar.tankFull());
	  }

/* Tank Full Method*/
	  
	  @Test
	  public void tankFullTest(){
		  SmallCar smallCar = new SmallCar();
	      boolean boolean0 = smallCar.tankFull();
	      assertTrue(smallCar.isHappy());
	      assertFalse(boolean0);
	  }
	}