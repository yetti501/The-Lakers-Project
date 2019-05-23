package guimain;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import data.Project;

public class ImportExportHelper {

	
	public static void main(String[]args) {
		ImportExportHelper ieh = new ImportExportHelper();
		
		ieh.importData("Test.csv");
	}
	
	ArrayList<Project> myProjects;
	String myFileName;
	String myUserName;
	
	public ImportExportHelper() {
		myProjects = new ArrayList<Project>();
		myFileName = "";
		myUserName = "";
	}
	
	
	public ImportExportHelper(ArrayList<Project> theProjects , String theFileName) {
		myProjects = theProjects; 
		myFileName = theFileName;
		myUserName = "";
	}
	
	
	public ImportExportHelper(ArrayList<Project> theProjects,
			String theFileName,
			String theUserName) {
		myProjects = theProjects;
		myFileName = theFileName;
		myUserName = theUserName;
	}
	
	
	public void importData(String theFileName) {
		File file = new File(theFileName);
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()) {
				String data = inputStream.next();
				String[] values = data.split(",");
				for(String s : values) {
					System.out.println(s);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public File exportData(){
		File projects = new File("projects");
		
		return projects;
	}
	
	
	public void setFileName(String newName) {
		myFileName = newName;
	}
	
	
	public void databaseView() {
		
	}
	
	
}
