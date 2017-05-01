package aston.station;

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
		System.out.println("Till initialised");
	}
	
	public void run() {
		System.out.println("Till running");
		while(true) {
			try {
				if (currentCustomer == null) {
					currentCustomer = (Customer)this.queue.take();
				}
				if (currentCustomer != null) {
					System.out.println("Customer found");
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
