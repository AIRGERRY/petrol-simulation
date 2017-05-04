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
		System.out.println("+ £" + amount.toString());
		System.out.println("R= £" + getBill().toString());
	}
	
	public static Double getBill() {
		return getInstance().bill;
	}
	
	public static void addToLost(Double amount) {
		getInstance().lost += amount;
		System.out.println("- £" + amount.toString());
		System.out.println("L= £" + getLost().toString());
	}
	
	public static Double getLost() {
		return getInstance().lost;
	}

}
