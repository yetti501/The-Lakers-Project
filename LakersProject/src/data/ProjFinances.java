package data;


/**
 * Data representation of project cost/finances
 * Last Modified: 06 June 2019
 * @author Daniel Looney (Whole Class)
 *
 */
public class ProjFinances {
	
	/** Project Cost */
	private double myCost;
	
	/**Project Savings */
	private double mySavings;
	
	/**Project Break-Even Point */
	private double myBreakEvenPoint;
	
	/**
	 * Constructs the project finances
	 * @param theCost Cost of project
	 * @param theSavings savings of project
	 * @param theBreakEvenPoint Break-even point of project
	 */
	public ProjFinances(double theCost, double theSavings, double theBreakEvenPoint) {
		myCost = theCost;
		mySavings = theSavings;
		myBreakEvenPoint = theBreakEvenPoint;
	}
	
	/** Calculates break-even point */
	public double calculateBreakEven(double cost, double savings) {
		return 0;
	}
	
	/** Gets break-even point */
	public double getBreakEven() {
		return myBreakEvenPoint;
	}
	
	/** Gets the cost of the program. */
	public double getCost() {
		return myCost;
	}
	
	/** Sets the cost of the program. */
	public void setCost(double cost) {
		myCost = cost;
	}
	
	/** String representation of the finances. */ 
	public String toString() {
		return "" + myCost;
	}
}
