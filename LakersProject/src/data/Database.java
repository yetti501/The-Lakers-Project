package data;

import java.util.ArrayList;
import java.util.List;

public class Database {
	private List<Project> myProjects;
	
	public Database() {
		myProjects = new ArrayList<Project>();
	}
	
	public void addProject(Project proj) {
		myProjects.add(proj);
	}
	
	public Project getProject(String projName) {
		for (Project p : myProjects) {
			if (p.getName().equals(projName)) {
				return p;
			}
		}
		return null;
	}
	
	public void sortByDifficulty(String diff) {
		
	}
	
	public void sortByCost(int low, int high) {
		
	}
}
