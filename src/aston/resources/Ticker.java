package aston.resources;

import java.util.concurrent.CyclicBarrier;

import aston.person.Person;
import aston.simulation.Simulation;
import aston.station.Bill;
import aston.station.Pump;
import aston.station.ServicerHandler;
import aston.station.ShoppingArea;
import aston.station.Station;
import aston.station.Till;

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
			if (currentTick >= ((Double)Config.get("totalTicks")).intValue()) {
				//Station.stopGeneration();
				//if (ServicerHandler.getInstance().allEmpty()) {
					barrier = null;
					if (Config.prettyOutput) {
						System.out.println("Simulation complete");
						System.out.println("");
						System.out.println("");
						System.out.println("Revenue - £" + Bill.getBill().toString());
						System.out.println("Loss - £" + Bill.getLost().toString());
					} else {
						System.out.println(Bill.getBill().toString() + " " + Bill.getLost().toString());
					}
					Simulation.end();
				//}
			}
			currentTick += 1;
			if (Config.prettyOutput) {
				System.out.println("Current tick - " + currentTick);
				System.out.println("PUMPS");
				Pump[] pumps = ServicerHandler.getInstance().getPumps();
				String pumpString = "";
				for (int i = 0; i < pumps.length; i++) {
					if (pumps[i].queue.take() != null) {
						pumpString += "|" + String.format("%1$18s", pumps[i].queue.freeSpace() + " in queue") + "|";
					} else {
						pumpString += "|                  |";
					}
				}
				System.out.println(pumpString);
				
				pumpString = "";
				for (int i = 0; i < pumps.length; i++) {
					if (pumps[i].queue.take() != null) {
						pumpString += "|" + String.format("%1$18s", pumps[i].queue.take().getVehicle().getType()) + "|";
					} else {
						pumpString += "|                  |";
					}
				}
				System.out.println(pumpString);
				
				pumpString = "";
				for (int i = 0; i < pumps.length; i++) {
					if (pumps[i].queue.take() != null) {
						pumpString += "|" + String.format("%1$18s", pumps[i].queue.take().getVehicle().getTankSize()) + "|";
					} else {
						pumpString += "|                  |";
					}
				}
				System.out.println(pumpString);
				System.out.println("TILLS");
				Till[] tills = ServicerHandler.getInstance().getTills();
				String tillString = "";
				for (int i = 0; i < tills.length; i++) {
					if (tills[i].queue.take() != null) {
						tillString += "|" + String.format("%1$18s", tills[i].queue.occupiedSpaces() + " in queue") + "|";
					} else {
						tillString += "|                  |";
					}
				}
				System.out.println(tillString);
				
				tillString = "";
				for (int i = 0; i < tills.length; i++) {
					if (tills[i].queue.take() != null) {
						tillString += "|" + String.format("%1$18s", tills[i].queue.take().getVehicle().getType()) + "|";
					} else {
						tillString += "|                  |";
					}
				}
				System.out.println(tillString);
				
				tillString = "";
				for (int i = 0; i < tills.length; i++) {
					if (tills[i].queue.take() != null) {
						tillString += "|" + String.format("%1$18s", tills[i].queue.take().getTimeLeft()) + "|";
					} else {
						tillString += "|                  |";
					}
				}
				System.out.println(tillString);
				System.out.println("");
				System.out.println("SHOPPING AREA");
				for (Person person : ShoppingArea.getInstance().getPersons()) {
					System.out.println("|    " + person.getVehicle().toString() + " in shopping area.");
				}
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
			}
		}
	};
	
	private static CyclicBarrier barrier = null;
	
	private static Ticker instance = null;
	
	private Ticker() {
		
	}	
	
	public static CyclicBarrier getBarrier() {
		if (barrier == null) {
			barrier = new CyclicBarrier((int)((Double)Config.get("tillCount") + (Double)Config.get("pumpCount")) + 2, tick);
		}
		return barrier;
	}
}
