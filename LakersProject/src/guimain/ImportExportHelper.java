package guimain;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import data.Project;

public class ImportExportHelper {

	
	public static void main(String[]args) {
		ImportExportHelper ieh = new ImportExportHelper();
		
		ieh.importUserName("Test.csv");
		System.out.println(ieh.myUserName);
		System.out.println(ieh.myEmail);
	}
	
	ArrayList<Project> myProjects;
	String myFileName;
	String myUserName;
	String myEmail;
	
	public ImportExportHelper() {
		myProjects = new ArrayList<Project>();
		myFileName = "";
		myUserName = "";
		myEmail = "";
	}
	
	
	public ImportExportHelper(ArrayList<Project> theProjects , String theFileName) {
		myProjects = theProjects; 
		myFileName = theFileName;
		myUserName = "";
		myEmail = "";
	}
	
	
	public ImportExportHelper(ArrayList<Project> theProjects,
			String theFileName,
			String theUserName,
			String theEmail) {
		myProjects = theProjects;
		myFileName = theFileName;
		myUserName = theUserName;
		myEmail = theEmail;
	}
	
	
	public void importProjects(String theFileName) {
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
	
	
	public void importUserName(String theFileName) {
		File file = new File(theFileName);
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()) {
				String data = inputStream.next();
				String[] values = data.split(",");
				//We can assume that User Name files will only have two inputs.
				myUserName = values[0];
				myEmail = values[1];
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public File exportProjects(){
		File projects = new File("projects");
		
		return projects;
	}
	
	
	public File exportUserName() {
		File userName = new File("username.csv");
		
		
		return userName;
	}
	
	public void setFileName(String newName) {
		myFileName = newName;
	}
	
	
	public void databaseView() {
		
	}
	
	
}
