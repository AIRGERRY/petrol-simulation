package aston.simulation;

import aston.vehicle.*;

import com.sun.org.apache.bcel.internal.generic.NEW;

import aston.resources.*;
import aston.station.*;

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
		Station station = Station.getInstance();
		System.out.println("Simulator initialised");
		
		System.out.println(new Motorbike().toString());
		System.out.println(new Motorbike().toString());
		System.out.println(new Motorbike().toString());
		System.out.println(new Motorbike().toString());
		
		System.out.println(new Sedan().toString());
		System.out.println(new Sedan().toString());
		System.out.println(new Sedan().toString());
		System.out.println(new Sedan().toString());
		
		System.out.println(new SmallCar().toString());
		System.out.println(new SmallCar().toString());
		System.out.println(new SmallCar().toString());
		System.out.println(new SmallCar().toString());
		
		System.out.println(new Truck().toString());
		System.out.println(new Truck().toString());
		System.out.println(new Truck().toString());
		System.out.println(new Truck().toString());
		
		for (int i=0; i <70; i++)
		{
			station.newCustomerArrive();
		}
		
	}
}
