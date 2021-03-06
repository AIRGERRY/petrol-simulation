package aston.station;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import aston.person.Customer;
import aston.resources.Config;
import aston.vehicle.Vehicle;

/**
 * 
 * 
 * @author Ollie
 * @version 1.0
 * @since 4 Mar 2017
 *
 */

public class Till extends Servicer {
	
	private Customer currentCustomer = null;

	public Till(CyclicBarrier barrier) {
		super();
		this.barrier = barrier;
	}
	
	public void run() {
		while(true) {
			try {
				if (currentCustomer == null) {
					this.person = this.queue.take();
					if (this.person != null) {
						currentCustomer = this.person.getCustomer();
					}
				}
				if (currentCustomer != null) {
					if (this.person.getTimeLeft() > 0) {
						this.person.decrementTime();
					} else {
						Bill.addToBill(this.person.getBill());
						Pump pump = ServicerHandler.getInstance().findPump(this.person);
						pump.endTransaction();
						this.queue.removeNext();
						currentCustomer = null;
						this.person = null;
					}
				}
				this.barrier.await();
			} catch (InterruptedException e) {
				System.out.println("Crashed");
			} catch (BrokenBarrierException e) {
				return;
			}
		}
	}
}
