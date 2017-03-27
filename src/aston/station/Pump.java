package aston.station;

import aston.resources.Config;

/**
 * Pump class for vehicles
 * 
 * @author Ollie
 * @version 1.0
 * @since 4 Mar 2017
 *
 */

public class Pump extends Servicer {
	
	public Pump() {
		super((Double)Config.get("queueCapacity"));
		System.out.println("Pump initialised");
	}
	
	public void run() {
		System.out.println("Pump running");
	}

}
