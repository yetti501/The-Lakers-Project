package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Data representation of a single project.
 * Last Modified: 06 June 2019
 * @author DWLooney (For whole class)
 *
 */
public class Project {
	
	/** Name of the project. */
	private String myName;
	
	/** Project Description. */
	private String myDescription;
	
	/** Project difficulty. */
	private String myDifficulty;
	
	/** List of project instructions. */
	private List<String> myInstructions;
	
	/** Whether the project is favorited. */
	private boolean myFavorite;
	
	/** Stores the cost of the project. */
	private ProjFinances myProjectFinances;
	
	/** Stores the from/to and units of time. */
	private ProjTime myProjectTime;
	
	/** Stores the materials and tools of the project. */
	private ProjItems myProjectItems;
	
	/**
	 * Constructs a project with default fields.
	 */
	public Project() {
		myName = "Untitled Project";
		myDescription = "None";
		myDifficulty = "Not Given";
		myInstructions = new ArrayList<String>();
		myFavorite = false;
		myProjectFinances = new ProjFinances(0,0,0);
		myProjectTime = new ProjTime(0,0,"NA");
		myProjectItems = new ProjItems();
	}
	
	/** Gets the data representation of project finances. */
	public ProjFinances getProjectFinances() {
		return myProjectFinances;
	}
	
	/** Gets the data representation of project time. */
	public ProjTime getProjectTime() {
		return myProjectTime;
	}
	
	/** Gets the items in the project. */
	public ProjItems getProjectItems() {
		return myProjectItems;
	}
	
	/** Gets the name of the project. */
	public String getName() {
		return myName;
	}
	
	/** Sets the name of the project. */
	public void setName(String name) {
		myName = name;
	}
	
	
	/** Toggles whether the project is favorited or not. */
	public void toggleFavorite() {
		if (myFavorite) {
			myFavorite = false;
		} else {
			myFavorite = true;
		}
	}
	
	/** Gets the difficulty of the project. */
	public String getDifficulty() {
		return myDifficulty;
	}
	
	/** Sets the difficulty of the project. */
	public void setDifficulty(String diff) {
		myDifficulty = diff;	
	}
	
	/** Gets the description of the project. */
	public String getDescription() {
		return myDescription;
	}
	
	/** Sets the description of the project. */
	public void setDescription(String desc) {
		myDescription = desc;
	}
	
	/** Adds an instruction to the project. */
	public void addInstructions(String inst) {
		myInstructions.add(inst);
	}
	
	/** String representation of the project. */
	public String toString() {
		return "Name: " + myName + "\n Description: " + myDescription + "\n Difficulty: " 
				+ myDifficulty + "\n Cost: " + myProjectFinances.getCost() + "\n Time: " + myProjectTime.getStart() + "-" + myProjectTime.getEnd() + " " + myProjectTime.getUnits()
				+ "\n Materials: " + myProjectItems.getMat().toString() + "\n Tools: " + myProjectItems.getTools().toString() + "\n\n";
	}
}
