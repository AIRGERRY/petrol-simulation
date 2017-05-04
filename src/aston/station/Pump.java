package aston.station;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import aston.person.Person;
import aston.resources.Config;
import aston.vehicle.*;
import aston.resources.Range;

/**
 * Pump class for vehicles
 * 
 * @author Ollie
 * @version 1.0
 * @since 4 Mar 2017
 *
 */

public class Pump extends Servicer {
	
	private Vehicle currentVehicle = null;
	
	public boolean atTill = false;
	
	public Pump(CyclicBarrier barrier) {
		super((Double)Config.get("queueCapacity"));
		this.barrier = barrier;
		System.out.println("Pump initialised");
	}
	
	public void run() {
		System.out.println("Pump running");
		while(true) {
			try {
				if (currentVehicle == null) {
					this.person = this.queue.take();
					if (this.person != null) {
						currentVehicle = this.person.getVehicle();
					}
				}
				if (currentVehicle != null) {
					if (!atTill) {
						if (!currentVehicle.tankFull()) {
							currentVehicle.incrementTank();
						} else {
							atTill = true;
							boolean happy = currentVehicle.isHappy();
							this.person.getCustomer().setHappy(happy);
							if (happy) {
								Random random = new Random(((Double)Config.get("seed")).intValue());
								int goingToShoppingArea = random.nextInt(11);
								if (currentVehicle instanceof Motorbike) {
									joinTill(person);
								} else if (currentVehicle instanceof Sedan) {
									if (goingToShoppingArea < (10 * ((Double)Config.get("sedanShopping")).intValue())) {
										person.getCustomer().setTime(random.nextInt(((Range)Config.get("sedanShoppingTime")).getHigh().intValue() * 6 + 1) + ((Range)Config.get("sedanShoppingTime")).getLow().intValue() * 6);
										person.getCustomer().setMoneySpent(random.nextInt(((Range)Config.get("sedanShoppingPrice")).getHigh().intValue() + 1) + ((Range)Config.get("sedanShoppingPrice")).getLow().intValue());
										joinShoppingArea(person);
									} else {
										joinTill(person);
									}
								} else if (currentVehicle instanceof SmallCar) {
									if (goingToShoppingArea < (10 * ((Double)Config.get("smallcarShopping")).intValue())) {
										person.getCustomer().setTime(random.nextInt(((Range)Config.get("smallcarShoppingTime")).getHigh().intValue() * 6 + 1) + ((Range)Config.get("smallcarShoppingTime")).getLow().intValue() * 6);
										person.getCustomer().setMoneySpent(random.nextInt(((Range)Config.get("smallcarShoppingPrice")).getHigh().intValue() + 1) + ((Range)Config.get("smallcarShoppingPrice")).getLow().intValue());
										joinShoppingArea(person);
									} else {
										joinTill(person);
									}
								} else if (currentVehicle instanceof Truck) {
									if (goingToShoppingArea < (10 * ((Double)Config.get("truckShopping")).intValue())) {
										person.getCustomer().setTime(random.nextInt(((Range)Config.get("truckShoppingTime")).getHigh().intValue() * 6 + 1) + ((Range)Config.get("truckShoppingTime")).getLow().intValue() * 6);
										person.getCustomer().setMoneySpent(random.nextInt(((Range)Config.get("truckShoppingPrice")).getHigh().intValue() + 1) + ((Range)Config.get("truckShoppingPrice")).getLow().intValue());
										joinShoppingArea(person);
									} else {
										joinTill(person);
									}
								}
							} else {
								joinTill(person);
							}
						}
					}	
				}
				this.barrier.await();
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted");
			} catch (BrokenBarrierException e) {
				return;
			}
		}
	}
	
	private void joinTill(Person person) {
		Till till = ServicerHandler.getInstance().getShortestQueue();
		till.queue.put(person);
		System.out.println("Customer in a " + currentVehicle.toString() + " went to a till");
	}
	
	private void joinShoppingArea(Person person) {
		ShoppingArea.getInstance().add(person);
		System.out.println("Customer in a " + currentVehicle.toString() + " went to the shopping area");
	}

}
