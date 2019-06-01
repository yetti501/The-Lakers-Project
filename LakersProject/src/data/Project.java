package data;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String myName;
	private String myDescription;
	private String myDifficulty;
	private List<String> myInstructions;
	private boolean myFavorite;
	private ProjFinances myProjectFinances;
	private ProjTime myProjectTime;
	private ProjItems myProjectItems;
	
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
	
	public ProjFinances getProjectFinances() {
		return myProjectFinances;
	}
	
	public ProjTime getProjectTime() {
		return myProjectTime;
	}
	
	public ProjItems getProjectItems() {
		return myProjectItems;
	}
	
	public String getName() {
		return myName;
	}
	
	public void setName(String name) {
		myName = name;
	}
	
	public void toggleFavorite() {
		if (myFavorite) {
			myFavorite = false;
		} else {
			myFavorite = true;
		}
	}
	
	public String getDifficulty() {
		return myDifficulty;
	}
	
	public void setDifficulty(String diff) {
		myDifficulty = diff;	
	}
	
	public String getDescription() {
		return myDescription;
	}
	
	public void setDescription(String desc) {
		myDescription = desc;
	}
	
	public void addInstructions(String inst) {
		myInstructions.add(inst);
	}
	
	public String toString() {
		return "Name: " + myName + "\n Desc: " + myDescription + "\n Difficulty: " 
				+ myDifficulty + "\n Cost: " + myProjectFinances.getCost() + "\n Time: " + myProjectTime.getTimePeriod() 
				+ "\n Materials: " + myProjectItems.getMat().toString() + "\n Tools: " + myProjectItems.getTools().toString();
	}
}
