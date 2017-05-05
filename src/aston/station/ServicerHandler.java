package aston.station;

import aston.person.Person;
import aston.resources.Config;
import aston.resources.Ticker;
import aston.vehicle.Vehicle;

/**
 * 
 * 
 * @author Ollie
 * @version 1.0
 * @since 4 May 2017
 *
 */

public class ServicerHandler {
	
	private static ServicerHandler instance = null;
	
	Integer tillCount = ((Double) Config.get("tillCount")).intValue();
	Integer pumpCount = ((Double) Config.get("pumpCount")).intValue();

	private Till[] tills = new Till[tillCount];
	private Pump[] pumps = new Pump[pumpCount];
	
	private ServicerHandler() {
		for (int i = 0; i < tillCount; i++) {
			tills[i] = new Till(Ticker.getBarrier());
			new Thread(tills[i]).start();
		}
		for (int i = 0; i < pumpCount; i++) {
			pumps[i] = new Pump(Ticker.getBarrier());
			new Thread(pumps[i]).start();
		}
		new Thread(ShoppingArea.getInstance()).start();
	}
	
	public static ServicerHandler getInstance() {
		if (instance == null) {
			instance = new ServicerHandler();
		}
		return instance;
	}
	
	/**
	 * Gets the shortest Pump/Till
	 * 
	 * @param pump
	 *            whether it checks Pump or Till. <code>true</code> will check
	 *            shortest Pump queue, <code>false</code> will check the
	 *            shortest Till queue
	 * @return {@link Servicer} The shortest Pump/Till
	 */
	public Pump getShortestQueue(Vehicle vehicle) {
		Pump shortestPump = pumps[0];
		for (int i = 1; i < pumps.length; i++) {
			Pump newPump = pumps[i];
			if (newPump.freeSpace() > shortestPump.freeSpace()) {
				shortestPump = pumps[i];
			}
		}
		if (shortestPump.hasSpace(vehicle)) {
			return shortestPump;
		} else {
			return null;
		}
	}

	public Till getShortestQueue() {
		Till shortestTill = tills[0];
		for (int i = 0; i < tills.length; i++) {
			if (tills[i].occupiedSpaces() < shortestTill.occupiedSpaces()) {
				shortestTill = tills[i];
			}
		}
		return shortestTill;
	}
	
	/**
	 * Finds the pump that holds the person being delt with to drop them off the queue.
	 * @param person
	 * @return
	 */
	public Pump findPump(Person person) {
		for (int i = 0; i < pumpCount; i++) {
			if (pumps[i].person == person) {
				return pumps[i];
			}
		}
		return null;
	}
	
	public Pump[] getPumps() {
		return this.pumps;
	}
	
	public Till[] getTills() {
		return this.tills;
	}
	
	public boolean allEmpty() {
		int nonEmptyCount = 0;
		for (int i = 0; i < pumpCount; i++) {
			if (!pumps[i].queue.isEmpty()) {
				nonEmptyCount += 1;
			}
		}
		for (int i = 0; i < tillCount; i++) {
			if (!tills[i].queue.isEmpty()) {
				nonEmptyCount += 1;
			}
		}
		if (!ShoppingArea.getInstance().isEmpty()) {
			nonEmptyCount += 1;
		}
		return (nonEmptyCount == 0);
	}
}
