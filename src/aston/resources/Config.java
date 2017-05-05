package aston.resources;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * Global project constants
 * 
 * @author Ollie
 * @version 1.0
 * @since 8 Mar 2017
 *
 */

public class Config {
	
	private static HashMap<String, Double> configDouble;
	private static HashMap<String, Range> configRange;
	
	public static final boolean prettyOutput = true;
		
	private static Config instance = null;
	
	private Config() {
		this.configDouble = new HashMap<String, Double>();
		this.configRange = new HashMap<String, Range>();
		
		internalSet("ticksPerMinute", 6.0);
		internalSet("totalTicks", 1440.0);
		
		//Tank sizes
		internalSet("motorbikeTank", 5.0);
		internalSet("smallcarTank", new Range(7.0, 9.0));
		internalSet("sedanTank", new Range(12.0, 18.0));
		internalSet("truckTank", new Range(30.0, 40.0));
		
		//Queue sizes
		internalSet("motorbikeSize", 0.75);
		internalSet("smallcarSize", 1.0);
		internalSet("sedanSize", 1.5);
		internalSet("truckSize", 2.0);

		//Happytime
		internalSet("motorbikeHappyTime", 0.0);
		internalSet("smallcarHappyTime", 30.0);
		internalSet("sedanHappyTime", 60.0);
		internalSet("truckHappyTime", 48.0);

		//Shopping price range
		internalSet("smallcarShoppingPrice", new Range(5.0, 10.0));
		internalSet("sedanShoppingPrice", new Range(8.0, 16.0));
		internalSet("truckShoppingPrice", new Range(15.0, 20.0));
		
		//Shopping time range
		internalSet("smallcarShoppingTime", new Range(2.0, 4.0));
		internalSet("sedanShoppingTime", new Range(2.0, 5.0));
		internalSet("truckShoppingTime", new Range(4.0, 6.0));
		
		//Price per gallon
		internalSet("pricePerGallon", 1.2);
		
		//Shopping probability
		internalSet("smallcarShopping", 0.3);
		internalSet("sedanShopping", 0.4);
		internalSet("truckShopping", 1.0);
		
		//Vehicle probability
		internalSet("p", 0.05); //Probability for smallcar/motorbike
		internalSet("q", 0.05); //Probability for sedan
		internalSet("t", 0.02); //Probability for truck
		
		//Servicer details
		internalSet("pumpCount", 4.0);
		internalSet("tillCount", 4.0);
		internalSet("queueCapacity", 3.0);

		//Allow trucks
		internalSet("allowTrucks", 1.0);
		
		//Seed
		internalSet("seed", 25.0);
	}
	
	private static Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}
	
	public static void set(String key, Object value) {
		getInstance().internalSet(key, value);
	}
	
	public static <T> T get(String key) {
		for (Entry<String, Double> entry : getInstance().configDouble.entrySet()) {
			if (entry.getKey().equals(key)) {
				return (T)entry.getValue();
			}
		}
		for (Entry<String, Range> entry : getInstance().configRange.entrySet()) {
			if (entry.getKey().equals(key)) {
				return (T)entry.getValue();
			}
		}
		return null;
	}
	
	private void internalSet(String key, Object value) {
		if (value instanceof Range) {
			Iterator dbIt = configDouble.entrySet().iterator();
			while (dbIt.hasNext()) {
				Entry<String, Double> entry = (Entry<String, Double>) dbIt.next();
				if (entry.getKey().equals(key)) {
					dbIt.remove();
					break;
				}
			}
			configRange.put(key, (Range)value);
		} else if (value instanceof Double) {
			Iterator dbIt = configRange.entrySet().iterator();
			while (dbIt.hasNext()) {
				Entry<String, Range> entry = (Entry<String, Range>) dbIt.next();
				if (entry.getKey().equals(key)) {
					dbIt.remove();
					break;
				}
			}
			configDouble.put(key, (Double)value);
		}
	}
	
	public static String outString() {
		String output = "";
		Iterator<Entry<String, Range>> rangeIt = getInstance().configRange.entrySet().iterator();
		while(rangeIt.hasNext()) {
			Entry<String, Range> entry = rangeIt.next();
			output += "[" + entry.getKey() + " = " + entry.getValue().toString() + "] ";
		}
		Iterator<Entry<String, Double>> doubleIt = getInstance().configDouble.entrySet().iterator();
		while(doubleIt.hasNext()) {
			Entry<String, Double> entry = doubleIt.next();
			output += "[" + entry.getKey() + " = " + entry.getValue() + "] ";
		}
		return output;
	}
}
