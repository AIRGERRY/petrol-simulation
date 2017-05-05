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
	private boolean toRemoveCurrent = false;
	
	public boolean atTill = false;
	
	public Pump(CyclicBarrier barrier) {
		super((Double)Config.get("queueCapacity"));
		this.barrier = barrier;
	}
	
	public void run() {
		while(true) {
			try {
				if (currentVehicle == null) {
					this.person = this.queue.take();
					if (this.person != null) {
						currentVehicle = this.person.getVehicle();
					}
				}
				if (currentVehicle != null) {
					if (this.person.getTimeLeft() != 0) {
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
										if (goingToShoppingArea < (10 * ((Double)Config.get("sedanShopping")))) {
											person.getCustomer().setTime(random.nextInt(((Range)Config.get("sedanShoppingTime")).getHigh().intValue() * 6 + 1) + ((Range)Config.get("sedanShoppingTime")).getLow().intValue() * 6);
											person.getCustomer().setMoneySpent(random.nextInt(((Range)Config.get("sedanShoppingPrice")).getHigh().intValue() + 1) + ((Range)Config.get("sedanShoppingPrice")).getLow().intValue());
											joinShoppingArea(person);
										} else {
											joinTill(person);
										}
									} else if (currentVehicle instanceof SmallCar) {
										if (goingToShoppingArea < (10 * ((Double)Config.get("smallcarShopping")))) {
											person.getCustomer().setTime(random.nextInt(((Range)Config.get("smallcarShoppingTime")).getHigh().intValue() * 6 + 1) + ((Range)Config.get("smallcarShoppingTime")).getLow().intValue() * 6);
											person.getCustomer().setMoneySpent(random.nextInt(((Range)Config.get("smallcarShoppingPrice")).getHigh().intValue() + 1) + ((Range)Config.get("smallcarShoppingPrice")).getLow().intValue());
											joinShoppingArea(person);
										} else {
											joinTill(person);
										}
									} else if (currentVehicle instanceof Truck) {
										if (goingToShoppingArea < (10 * ((Double)Config.get("truckShopping")))) {
											person.getCustomer().setTime(random.nextInt(((Range)Config.get("truckShoppingTime")).getHigh().intValue() * 6 + 1) + ((Range)Config.get("truckShoppingTime")).getLow().intValue() * 6);
											person.getCustomer().setMoneySpent(random.nextInt(((Range)Config.get("truckShoppingPrice")).getHigh().intValue() + 1) + ((Range)Config.get("truckShoppingPrice")).getLow().intValue());
											Double t = ((Double)Config.get("t"));
											t = t * 1.05;
											if (t > 0.02) {
												t = 0.02;
											}
											Config.set("t", t);
											joinShoppingArea(person);
										} else {
											joinTill(person);
										}
									}
								} else {
									if (currentVehicle instanceof Truck) {
										Config.set("t", ((Double)Config.get("t")) * 0.8);
									}
									joinTill(person);
								}
							}
						}	
					}
					
				}
				if (toRemoveCurrent) {
					this.currentVehicle = null;
					this.toRemoveCurrent = false;
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
		if (Config.prettyOutput) { System.out.println("Customer in a " + currentVehicle.toString() + " went to a till"); }
	}
	
	private void joinShoppingArea(Person person) {
		ShoppingArea.getInstance().add(person);
		if (Config.prettyOutput) { System.out.println("Customer in a " + currentVehicle.toString() + " went to the shopping area"); }
	}
	
	public void endTransaction() {
		this.queue.removeNext();
		this.atTill = false;
		this.toRemoveCurrent = true;
	}

}
