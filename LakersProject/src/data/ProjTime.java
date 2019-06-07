package data;


/**
 * Data representation of the project time.
 * Last Modified: 06 June 2019
 * @author Daniel Looney (Whole Class)
 *
 */
public class ProjTime {
	
	/** Start time for the project. */
	private int myTimeStart;
	
	/** End time for the project. */
	private int myTimeEnd;
	
	/** Time units for the project. */
	private String myTimeUnit;
	
	/** Constructs the project time with start, end and units. */
	public ProjTime(int theStart, int theEnd, String theUnit) {
		myTimeStart = theStart;
		myTimeEnd = theEnd;
		myTimeUnit = theUnit;
	}
	
	/** Returns a string representation of the time period. */
	public String getTimePeriod() {
		return myTimeEnd - myTimeStart+ " " + myTimeUnit;
	}
	
	/** Changes the time for the project. */
	public void editTime(int start, int end, String unit) {
		myTimeStart = start;
		myTimeEnd = end;
		myTimeUnit = unit;
	}
	
	/**
	 * String representation of the project.
	 */
	public String toString() {
		return myTimeUnit + "," + myTimeStart + "," + myTimeEnd;
	}
	
	/** Gets the start time of the project. */
	public int getStart() {
		return myTimeStart;
	}
	
	/** Gets the end time of the project. */
	public int getEnd() {
		return myTimeEnd;
	}
	
	/** Gets the time units for the project. */
	public String getUnits() {
		return myTimeUnit;
	}
	
	
}
