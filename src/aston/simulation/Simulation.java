package aston.simulation;

import aston.vehicle.*;
import aston.resources.*;

/**
 * Main runnable class for the simulation
 * 
 * @author Ollie
 * @version 1.0
 * @since 1 Mar 2017
 *
 */

public class Simulation {

	public static void main(String args[]) {
		Motorbike motorbike = new Motorbike();
		Sedan sedan = new Sedan();
		SmallCar smallcar = new SmallCar();
		Truck truck = new Truck();
		
		System.out.println("Motorbike");
		System.out.println(motorbike.getTankSize());
		System.out.println(motorbike.getQueueSize());
		
		System.out.println("Sedan");
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getTankSize());
		System.out.println(sedan.getQueueSize());
		
		System.out.println("SmallCar");
		System.out.println(smallcar.getTankSize());
		System.out.println(smallcar.getTankSize());
		System.out.println(smallcar.getTankSize());
		System.out.println(smallcar.getTankSize());
		System.out.println(smallcar.getTankSize());
		System.out.println(smallcar.getTankSize());
		System.out.println(smallcar.getQueueSize());
		
		System.out.println("Truck");
		System.out.println(truck.getTankSize());
		System.out.println(truck.getTankSize());
		System.out.println(truck.getTankSize());
		System.out.println(truck.getTankSize());
		System.out.println(truck.getTankSize());
		System.out.println(truck.getTankSize());
		System.out.println(truck.getQueueSize());
	}
}
