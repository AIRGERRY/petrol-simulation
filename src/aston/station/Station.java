package aston.station;

/**
 * 
 * 
 * @author Ollie
 * @version 1.0
 * @since 4 Mar 2017
 *
 */

public class Station {
	
	private Till[] tills = new Till[4];
	private Pump[] pumps = new Pump[4];
	
	public Station() {
		for (int i = 0; i < 4; i++) {
			tills[i] = new Till();
			pumps[i] = new Pump();
		}
		
		for (int i = 0; i < 4; i++) {
			new Thread(tills[i]).start();
			new Thread(pumps[i]).start();
		}
	}
}
