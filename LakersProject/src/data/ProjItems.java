package data;

import java.util.ArrayList;
import java.util.List;

public class ProjItems {
	private List<String> myMaterials;
	private List<String> myTools;
	
	public ProjItems() {
		myMaterials = new ArrayList<String>();
		myTools = new ArrayList<String>();
	}
	
	public void addMat(String material) {
		myMaterials.add(material);
	}
	
	public void removeMat(String material) {
		if (myMaterials.contains(material)) {
			myMaterials.remove(material);
		}
	}
	
	public void clearMat() {
		myMaterials.clear();
	}
	
	public List<String> getMat() {
		return myMaterials;
	}
	
	public void addTool(String tool) {
		myTools.add(tool);
	}
	
	public void removeTool(String tool) {
		if (myTools.contains(tool)) {
			myTools.remove(tool);
		}
	}
	
	public void clearTool() {
		myTools.clear();
	}
	
	public List<String> getTools() {
		return myTools;
	}
}
