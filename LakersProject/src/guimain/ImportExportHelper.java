package guimain;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import data.Project;

public class ImportExportHelper {

	
	ArrayList<Project> myProjects;
	String myFileName;
	String myUserName;
	String myEmail;
	private static final String DEFAULT_FILE_NAME = "settings.csv";
	
	
	public ImportExportHelper() {
		myProjects = new ArrayList<Project>();
		myFileName = DEFAULT_FILE_NAME;
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
	
	public void setUserName(String userName) {
		myUserName = userName;
	}
	
	public void setEmail(String email) {
		myEmail = email;
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
	
	
	public void importUserName(String theFileName) throws FileNotFoundException {
		File file = new File(theFileName);
		Scanner inputStream = new Scanner(file);
		while(inputStream.hasNext()) {
			String data = inputStream.next();
			String[] values = data.split(",");
			//We can assume that User Name files will only have two inputs.
			myUserName = values[0];
			myEmail = values[1];
		}
	}
	
	public File exportProjects(){
		File projects = new File("projects");
		
		return projects;
	}
	
	
	public void exportSettings() throws IOException {
		File settings = new File(myFileName);
		settings.createNewFile();
		PrintStream out = new PrintStream(settings);
		out.print(myUserName + "," + myEmail);
		out.close();
	}
	
	public void setFileName(String newName) {
		myFileName = newName;
	}
	
	
	public void databaseView() {
		
	}
	
	
}
