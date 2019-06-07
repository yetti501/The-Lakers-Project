package data;

public class ProjFinances {
	private double myCost;
	private double mySavings;
	private double myBreakEvenPoint;
	
	public ProjFinances(double theCost, double theSavings, double theBreakEvenPoint) {
		myCost = theCost;
		mySavings = theSavings;
		myBreakEvenPoint = theBreakEvenPoint;
	}
	
	public double calculateBreakEven(double cost, double savings) {
		return 0;
	}
	
	public double getBreakEven() {
		return myBreakEvenPoint;
	}
	
	public double getCost() {
		return myCost;
	}
	
	public void setCost(double cost) {
		myCost = cost;
	}
	
	public String toString() {
		return "" + myCost;
	}
}
