package aston.resources;

/**
 * Class that handles ticks and timings
 * 
 * @author Ollie
 * @version 1.0
 * @since 27 Mar 2017
 *
 */

public class Ticker {
	public Integer currentTick;
	public Integer maxTicks;
	
	private static Ticker instance = null;
	
	public static void startTicker() {
		if (instance == null) {
			instance = new Ticker();
		}
		
	}
	
	private Ticker() {
		for (currentTick = 0; currentTick <= maxTicks; currentTick++) {
			tick();
		}
	}
	
	private void tick() {
		
	}
}
