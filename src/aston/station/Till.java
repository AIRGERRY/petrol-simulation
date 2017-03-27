package aston.station;

import aston.resources.Config;

/**
 * 
 * 
 * @author Ollie
 * @version 1.0
 * @since 4 Mar 2017
 *
 */

public class Till extends Servicer {

	public Till() {
		super((Double)Config.get("queueCapacity"));
		System.out.println("Till initialised");
	}
	
	public void run() {
		System.out.println("Till running");
	}
}
