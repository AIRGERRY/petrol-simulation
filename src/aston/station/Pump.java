package aston.station;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import aston.resources.Config;
import aston.vehicle.Vehicle;

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
					currentVehicle = (Vehicle)this.queue.take();
				}
				if (currentVehicle != null) {
					if (!currentVehicle.tankFull()) {
						currentVehicle.incrementTank();
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

}
