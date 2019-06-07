package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores all of the projects in the program.
 * Last Modified: 6 June 2019
 * @author Daniel Looney (For entire class)
 */
public class Database {
	
	/** Stores all of the Projects. */
	private List<Project> myProjects;
	
	/**
	 * Constructs the database.
	 */
	public Database() {
		myProjects = new ArrayList<Project>();
	}
	
	/**
	 * Adds a project to the database
	 * @param proj Project to be added to the database
	 */
	public void addProject(Project proj) {
		myProjects.add(proj);
	}
	
	/**
	 * Gets a project based of it's name.
	 * @param projName Name of project to get.
	 * @return Found project in database.
	 */
	public Project getProject(String projName) {
		Project curr = null;
		for (Project p : myProjects) {
			if (p.getName().equals(projName)) {
				curr = p;
			}
		}
		return curr;
	}
	
	/**
	 * Gets a list of all projects the database.
	 * @return List of all projects in the database.
	 */
	public List<Project> getAllProjects(){
		return myProjects;
	}
	
	//TODO
	public void sortByDifficulty(String diff) {
		
	}
	//TODO
	public void sortByCost(int low, int high) {
		
	}
}
