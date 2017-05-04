package aston.simulation;

import aston.vehicle.*;
import aston.view.gui.GUI;


import aston.person.Person;
import aston.resources.*;
import aston.station.*;

/**
 * Main runnable class for the simulation
 * 
 * @author Ollie, Mosope
 * @version 1.0
 * @since 1 Mar 2017
 *
 */

public class Simulation {
	
	public static Station station = null;

	public static void main(String args[]) {
		if (args.length == 0) {
			final GUI start = new GUI(); 
		} else if (args.length == 5) {
			Config.set("p", args[0]);
			Config.set("q", args[1]);
			Config.set("pumpCount", args[2]);
			Config.set("tillCount", args[3]);
			Config.set("allowTrucks", args[4]);
			Simulation.station = Station.getInstance();
		} else {
			System.out.println("Incorrect arguments supplied. p, q, pumps, tills, trucks");
		}
	}
	
	public static void end() {
		System.exit(0);
	}
}
