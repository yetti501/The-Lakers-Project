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
		Project curr = null;
		for (Project p : myProjects) {
			if (p.getName().equals(projName)) {
				curr = p;
			}
		}
		return curr;
	}
	
	public List<Project> getAllProjects(){
		return myProjects;
	}
	
	public void sortByDifficulty(String diff) {
		
	}
	
	public void sortByCost(int low, int high) {
		
	}
}
