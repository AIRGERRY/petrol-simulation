package aston.resources;

/**
 * Global project constants
 * 
 * @author Ollie
 * @version 1.0
 * @since 8 Mar 2017
 *
 */

public class Config {
	
	public static final int TICKS_PER_MINUTE = 6;
	
	//Tank size
	public static final int MOTORBIKE_TANK = 5;
	public static final int SMALLCAR_TANK_LOW = 7;
	public static final int SMALLCAR_TANK_HIGH = 9;
	public static final int SEDAN_TANK_LOW = 12;
	public static final int SEDAN_TANK_HIGH = 18;
	public static final int TRUCK_TANK_LOW = 30;
	public static final int TRUCK_TANK_HIGH = 40;
	
	//Queue size
	public static final double MOTORBIKE_SIZE = 0.75;
	public static final double SMALLCAR_SIZE = 1;
	public static final double SEDAN_SIZE = 1.5;
	public static final double TRUCK_SIZE = 2;
	
	//Happy time
	public static final int MOTORBIKE_HAPPY_TIME = 0;
	public static final int SMALLCAR_HAPPY_TIME = 5;
	public static final int SEDAN_HAPPY_TIME = 10;
	public static final int TRUCK_HAPPY_TIME = 8;
	
	//Shopping price range
	public static final int SMALLCAR_SHOPPING_LOW = 5;
	public static final int SMALLCAR_SHOPPING_HIGH = 10;
	public static final int SEDAN_SHOPPING_LOW = 8;
	public static final int SEDAN_SHOPPING_HIGH = 16;
	public static final int TRUCK_SHOPPING_LOW = 15;
	public static final int TRUCK_SHOPPING_HIGH = 20;
	
	//Pump price
	public static final double PRICE_PER_GALLON = 1.50;
	
	//Shopping time range
	public static final int SMALLCAR_SHOPPING_TIME_LOW = 2;
	public static final int SMALLCAR_SHOPPING_TIME_HIGH = 4;
	public static final int SEDAN_SHOPPING_TIME_LOW = 2;
	public static final int SEDAN_SHOPPING_TIME_HIGH = 5;
	public static final int TRUCK_SHOPPING_TIME_LOW = 4;
	public static final int TRUCK_SHOPPING_TIME_HIGH = 6;
	
	//Shopping probability
	public static final double SMALLCAR_SHOPPING = 0.3;
	public static final double SEDAN_SHOPPING = 0.4;
	public static final double TRUCK_SHOPPING = 1.0;
	
	//Vehicle probability

	public static final double P = 0.05; //0.01, 0.02, 0.03, 0.04, 0.05; Probability for SmallCar/Motorbike
	public static final double Q = 0.05; //0.01, 0.02, 0.03, 0.04, 0.05; Probability for Sedan
	public static double T = 0.02; // Probability for Truck
	
	//Servicer details
	public static final int PUMP_COUNT = 4;
	public static final int TILL_COUNT = 4;
	public static final double QUEUE_CAPACITY = 3.0;
	
	//Allow trucks
	public static final boolean ALLOW_TRUCKS = true;
	
	//Random generator seed
	public static final int SEED = 420;

}
