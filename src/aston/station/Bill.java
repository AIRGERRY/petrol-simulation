package aston.station;

/**
 * 
 * 
 * @author Ollie
 * @version 1.1
 * @since 4 May 2017
 *
 */

public class Bill {
	
	private static Bill instance = null;
	
	private Double bill;
	private Double lost;
	
	private Bill() {
		bill = 0.0;
		lost = 0.0;
	}
	
	private static Bill getInstance() {
		if (instance == null) {
			instance = new Bill();
		}
		return instance;
	}
	
	public static void addToBill(Double amount) {
		getInstance().bill += amount;
		System.out.println("+ £" + amount);
	}
	
	public static Double getBill() {
		Double amount = getInstance().bill;
		Integer intval = amount.intValue();
		Double diff = amount - intval;
		diff = diff * 10;
		Long nearest = Math.round(diff);
		diff = new Double(nearest) / 10.0;
		amount = intval + diff;
		return amount;
	}
	
	public static void addToLost(Double amount) {
		getInstance().lost += amount;
	}
	
	public static Double getLost() {
		Double amount = getInstance().lost;
		Integer intval = amount.intValue();
		Double diff = amount - intval;
		diff = diff * 10;
		Long nearest = Math.round(diff);
		diff = new Double(nearest) / 10.0;
		amount = intval + diff;
		return amount;
	}

}
