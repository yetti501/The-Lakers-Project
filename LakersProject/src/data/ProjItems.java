package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Data representation of the project time span.
 * Last Modified: 06 June 2019
 * @author Daniel Looney (Whole Class)
 *
 */
public class ProjItems {
	
	/** Project materials */
	private List<String> myMaterials;
	
	/** Project Tools */
	private List<String> myTools;
	
	/**
	 * Constructs the lists representation materials and tools.
	 */
	public ProjItems() {
		myMaterials = new ArrayList<String>();
		myTools = new ArrayList<String>();
	}
	
	/**Adds a material to the project. */
	public void addMat(String material) {
		myMaterials.add(material);
	}
	
	/** Removes a material from the project. */
	public void removeMat(String material) {
		if (myMaterials.contains(material)) {
			myMaterials.remove(material);
		}
	}
	
	/** Clears all materials in the project. */
	public void clearMat() {
		myMaterials.clear();
	}
	
	/** Gets a list of materials in the project. */
	public List<String> getMat() {
		return myMaterials;
	}
	
	/** Adds a tool to the project. */
	public void addTool(String tool) {
		myTools.add(tool);
	}
	
	/** Removes a tool from the project. */
	public void removeTool(String tool) {
		if (myTools.contains(tool)) {
			myTools.remove(tool);
		}
	}
	
	/** Clears all tools in the project. */
	public void clearTool() {
		myTools.clear();
	}
	
	/** Gets a list of tools in the project. */
	public List<String> getTools() {
		return myTools;
	}
	
	/** String representation of the project items. */
	public String toString() {
		String output = "\"";
		for (String temp : myMaterials) {
			output += (temp ) +",";
		}
		output+="\"";
		output += ",";
		output+="\"";
		for (String temp : myTools) {
			output += temp + ",";
		}
		output+="\"";
		return output;
	}
	
}
