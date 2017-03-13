package aston.station;

import aston.resources.Config;

/**
 * Main Station handler class
 * 
 * @author Ollie
 * @version 1.0
 * @since 4 Mar 2017
 *
 */

public class Station {
	
	private Till[] tills = new Till[Config.TILL_COUNT];
	private Pump[] pumps = new Pump[Config.PUMP_COUNT];
	
	public Station() {
		for (int i = 0; i < Config.TILL_COUNT; i++) {
			tills[i] = new Till();
			new Thread(tills[i]).start();
		}
		for (int i = 0; i < Config.PUMP_COUNT; i++) {
			pumps[i] = new Pump();
			new Thread(pumps[i]).start();
		}
	}
	
	public Servicer getShortestQueue(boolean pump) {
		return null;
	}
}
