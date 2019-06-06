package guimain;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	
//	/**/
//	String myProjectNumber;
//	String myProjectName;
//	String myProjectSummary;
//	String myDifficulty;
//	String myCost;
//	String myTime;
//	String myStartTime;
//	String myEndTime;
//	String myProjectDescription;
//	String myMaterialsList;
//	String myToolsList;
//	String myInstructionList;
//	/**/
	
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
//		File file = new File(theFileName);
//		try {
//			Scanner inputStream = new Scanner(file);
//			while(inputStream.hasNext()) {
//				String data = inputStream.next();
//				String[] values = data.split(",");
//				for(String s : values) {
//					System.out.println(s);
//				}
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
		BufferedReader buff = null;
		String line = "";
		String delimiter = ",";
		String quotes = "\"";
		ArrayList<String> row = new ArrayList<String>(); 
//		ArrayList<ArrayList<String>> elements = new ArrayList<ArrayList<String>>(); 
		
		
		try {
			buff = new BufferedReader(new FileReader(theFileName));
			while((line = buff.readLine()) != null) { // Reads the first line, aka skipping it because the first line is useless.
				
				while((line = buff.readLine()) != null) { // Actually reads the data and adds it to the Array List
					String[] data = line.split(quotes);
					String[] temp = data[0].split(delimiter);
					for(int i = 0; i < temp.length; i++) {
						row.add(temp[i]);
					}
					row.add(data[1]);
					row.add(data[3]);
					row.add(data[5]);					
				}
			}

			/*
			 * row 0 : Project Number
			 * row 1 : Project Name
			 * row 2 : Project Summary
			 * row 3 : Difficulty
			 * row 4 : Cost
			 * row 5 : Time Units
			 * row 6 : Start Time
			 * row 7 : End Time
			 * row 8 : Project Description
			 * row 9 : Materials List
			 * row 10 : Tools List
			 * row 11 : Instruction List  
			 */
			
//				System.out.println("Project Number: " + row.get(0) + "\n"
//						 + "Project Name: " + row.get(1) + "\n"
//						 + "Project Summary: " + row.get(2) + "\n"
//						 + "Difficulty: " + row.get(3) + "\n"
//						 + "Cost: " + row.get(4) + "\n"
//						 + "Time Units: " + row.get(5) + "\n"
//						 + "Start Time: " + row.get(6) + "\n"
//						 + "End Time: " + row.get(7) + "\n"
//						 + "Project Description: "+ row.get(8) + "\n"
//						 + "Materials List: " + row.get(9) + "\n"
//						 + "Tools List: " + row.get(10) + "\n"
//						 + "Instruction List: " + row.get(11));
//				System.out.println("\n");

			buff.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return row;
//		return elements;
		
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
// 		File projects = new File("projects");
		
// 		return projects;
		
		public void exportFile(ArrayList<String> elements) throws IOException {		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a file name: ");
		String myFileName = scanner.nextLine();
		myFileName =myFileName.concat(".csv");
		System.out.println("File Name: " + myFileName);
		File file = new File(myFileName);
		FileWriter outputFile = new FileWriter(file);
		String FILEHEADER = "Project Number,Project Name,Project Summary,Difficulty,Cost,Time Units,Start Time,End Time,Project Description,Materials List,Tools List,Instruction List\n";
		outputFile.append(FILEHEADER);
		
		try {
			for(int i = 0; i < elements.size(); i++) {
				
				if(i % 11 == 0 && i != 1) {
					outputFile.append("\n");
				} else {
					outputFile.append(elements.get(i) + ",");
				}
			}
			
		}  catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		scanner.close();
		outputFile.close();
	}
}
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
