package aston.resources;

/**
 * 
 * 
 * @author Ollie
 * @version 1.0
 * @since 25 Mar 2017
 *
 */

public class Range {
	
	private Double low;
	private Double high;
	
	public Range(Double low, Double high) {
		this.low = low;
		this.high = high;
	}
	
	public Double getLow() {
		return this.low;
	}
	
	public Double getHigh() {
		return this.high;
	}

}
