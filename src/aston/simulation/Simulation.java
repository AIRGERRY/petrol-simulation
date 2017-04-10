package aston.simulation;

import aston.vehicle.*;
import aston.view.gui.GUI;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

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

	public static void main(String args[]) {
		Station station = Station.getInstance();
		//		System.out.println("Simulator initialised");
		//		
		//		System.out.println(new Motorbike().toString());
		//		System.out.println(new Motorbike().toString());
		//		System.out.println(new Motorbike().toString());
		//		System.out.println(new Motorbike().toString());
		//		
		//		System.out.println(new Sedan().toString());
		//		System.out.println(new Sedan().toString());
		//		System.out.println(new Sedan().toString());
		//		System.out.println(new Sedan().toString());
		//		
		//		System.out.println(new SmallCar().toString());
		//		System.out.println(new SmallCar().toString());
		//		System.out.println(new SmallCar().toString());
		//		System.out.println(new SmallCar().toString());
		//		
		//		System.out.println(new Truck().toString());
		//		System.out.println(new Truck().toString());
		//		System.out.println(new Truck().toString());
		//		System.out.println(new Truck().toString());
		//		
		//		for (int i=0; i <70; i++)
		//		{
		//			station.newCustomerArrive();
		//		}
		//		

		

		//Fuel and Shoping bill test
		System.out.println("\n Shopping bill test"+"\n"+"-----");
		for (int i=0; i<20; i++)
		{
			Person p1 = station.createPerson();
			if(p1 != null)
			{
				System.out.println(p1.toString());
				p1.getVehicle().setFull(true);
				station.joinPump(p1);
				System.out.println("fuel bill to pay: "+p1.getBill());
				station.joinShoppingArea(p1);
				System.out.println("fuel and shopping bill to pay: "+p1.getBill());
				station.addToMoneyEarned(p1.getBill());
				System.out.println("Total money earned by Station: "+station.getMoneyEarned());
				System.out.println("--\n");
			}
		}
		
		final GUI start = new GUI(); 
	}
}
