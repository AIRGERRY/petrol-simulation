/**
 * Queue Test class
 * 
 * @author Liam
 * @version 1.1
 * @since 2 May 2017
 *
 */
package aston.station;

import static org.junit.Assert.*;
import aston.person.Customer;
import aston.person.Person;
import aston.station.Queue;
import aston.vehicle.Motorbike;
import aston.vehicle.Sedan;
import aston.vehicle.SmallCar;
import aston.vehicle.Truck;
import aston.vehicle.Vehicle;

import org.junit.Test;

public class QueueTest {

	  @Test
	  public void hasSpaceTest(){
	      Queue queue = new Queue(1.0);
	      SmallCar smallCar = new SmallCar();
	      boolean boolean0 = queue.hasSpace((Vehicle) smallCar);
	      assertTrue(boolean0);
	  }
	  
	  @Test
	  public void hasSpaceTest2() {
	      Queue queue0 = new Queue(3.0);
	      Truck truck0 = new Truck();
	      boolean boolean0 = queue0.hasSpace((Vehicle) truck0);
	      assertTrue(boolean0);
	  }
	  
	  @Test
	  public void hasSpaceTest3(){
	      Queue queue0 = new Queue(0.0);
	      Truck truck0 = new Truck();
	      boolean boolean0 = queue0.hasSpace((Vehicle) truck0);
	      assertFalse(boolean0);
	  }

	  @Test
	  public void freeSpaceTest1() {
	      Queue queue = new Queue(60.0);
	      Customer customer = new Customer(false);
	      SmallCar smallCar = new SmallCar();
	      Person person = new Person(customer, (Vehicle) smallCar, 2);
	      queue.put(person);
	      queue.put(person);
	      queue.removeNext();
	      assertEquals(59.0, queue.freeSpace(), 0.01);
	  }
	  
	  @Test
	  public void freeSpaceTest2(){
	      Queue queue = new Queue(0.0);
	      Customer customer = new Customer(true);
	      Truck truck = new Truck();
	      Person person = new Person(customer, (Vehicle) truck, 1);
	      queue.put(person);
	      person.setTimeLeft((20));
	      queue.take();
	      assertEquals((-2.0), queue.freeSpace(), 0.01);
	  }

	  

	  @Test
	  public void freeSpaceTest3(){
	      Queue queue = new Queue(0.0);
	      Customer customer = new Customer(true);
	      Truck truck = new Truck();
	      Person person = new Person(customer, (Vehicle) truck, 1);
	      queue.put(person);
	      double double0 = queue.occupiedSpaces();
	      assertEquals((-2.0), queue.freeSpace(), 0.01);
	      assertEquals(1.0, double0, 0.01);
	  }

	 

	  @Test
	  public void freeSpaceTest4() {
	      Queue queue = new Queue(3);
	      double double0 = queue.freeSpace();
	      assertEquals(3, double0, 0.01);
	  }
	  
	  @Test
	  public void freeSpaceTest5()  {
	      Queue queue = new Queue(3);
	      boolean boolean0 = queue.hasSpace();
	      assertTrue(boolean0);
	      assertEquals(3, queue.freeSpace(), 0.01);
	  }

	  /* isEmpty Test */
	  
	  @Test
	  public void isEmptyTest(){
	      Queue queue = new Queue(5);
	      boolean boolean0 = queue.isEmpty();
	      assertEquals(5, queue.freeSpace(), 0.01);
	      assertTrue(boolean0);
	  }

	  

	  @Test
	  public void isEmptyTest2(){
	      Queue queue = new Queue(0.0);
	      Customer customer = new Customer(true);
	      Truck truck = new Truck();
	      Person person = new Person(customer, (Vehicle) truck, 1);
	      queue.put(person);
	      boolean boolean0 = queue.isEmpty();
	      assertEquals((-2.0), queue.freeSpace(), 0.01);
	      assertFalse(boolean0);
	  }

	  

	  @Test
	  public void removeNextTest1(){
	      Queue queue = new Queue();
	      Person person = new Person((Customer) null, (Vehicle) null, (3));
	      queue.put(person);
	      queue.removeNext();
	      assertEquals(0.0, queue.freeSpace(), 0.01);
	  }

	 

	  @Test
	  public void removeNextTest2()  {
	      Queue queue = new Queue();
	      queue.removeNext();
	      assertEquals(0.0, queue.freeSpace(), 0.01);
	  }

	  
	  @Test
	  public void OccupiedSpacesTest(){
	      Queue queue = new Queue();
	      double double0 = queue.occupiedSpaces();
	      assertEquals(0.0, double0, 0.01);
	  }
}