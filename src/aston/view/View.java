package aston.view;

/**
 * View Parent class, defining class constants for children
 * 
 * @author Ollie
 * @version 1.0
 * @since 8 Mar 2017
 *
 */

public class View {
	
	private boolean atPump = true;
	private double fuelCount = 0;
	private boolean atTill = true;
	private double custSpent = 0;
	
	public void vehicleAtPump(){
		if(atPump){
		System.out.println("A vehicle is at the pump");
	} else {
		System.out.println("A vehcile has left the pump");}
	}
	
	public void atTill(){
		if(atTill){
		System.out.println("A customer is at the till");
	} else {
		System.out.println("A customer has left the till");
		}
	}
	
	public void amountSpent(){
		if (custSpent > 0){
		System.out.println("The customer has spent " + custSpent );
	} else {
		System.out.println("The customer has not spent anything");
		}
	}
	
	public void amountOfFuel(){
		if (fuelCount > 0){
		System.out.println("Vechicle topped up " + fuelCount + "gallons");
	} else {
		System.out.println("No fuel was used");
		}
	
	}
}
