package data;

public class ProjTime {
	private int myTimeStart;
	
	private int myTimeEnd;
	
	private String myTimeUnit;
	
	public ProjTime(int theStart, int theEnd, String theUnit) {
		myTimeStart = theStart;
		myTimeEnd = theEnd;
		myTimeUnit = theUnit;
	}
	
	public String getTimePeriod() {
		return myTimeStart - myTimeEnd + " " + myTimeUnit;
	}
	
	public void editTime(int start, int end, String unit) {
		myTimeStart = start;
		myTimeEnd = end;
		myTimeUnit = unit;
	}
}
