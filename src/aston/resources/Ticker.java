package aston.resources;

import java.util.concurrent.CyclicBarrier;

import aston.simulation.Simulation;
import aston.station.Station;

/**
 * Class that handles ticks and timings
 * 
 * @author Ollie
 * @version 1.0
 * @since 27 Mar 2017
 *
 */

public class Ticker {
	public static Integer currentTick = 0;
	
	private static Runnable tick = new Runnable() {
		public void run() {
			if (currentTick == ((Double)Config.get("totalTicks")).intValue()) {
				barrier = null;
				System.out.println("Simulation complete");
				Simulation.end();
			} else {
				currentTick += 1;
				System.out.println("Current tick - " + currentTick);
			}
		}
	};
	
	private static CyclicBarrier barrier = null;
	
	private static Ticker instance = null;
	
	private Ticker() {
		int threadCount = (int)((Double)Config.get("tillCount") + (Double)Config.get("pumpCount")) + 1;		
	}	
	
	public static CyclicBarrier getBarrier() {
		if (barrier == null) {
			barrier = new CyclicBarrier((int)((Double)Config.get("tillCount") + (Double)Config.get("pumpCount")) + 1, tick);
		}
		return barrier;
	}
}
