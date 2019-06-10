package guimain;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import data.Database;
import data.Project;

/**
 * This class implements our import and export function 
 * @author Lakers Project Team
 */

//Setting up variables
public class ImportExportHelper {
	Database myProjects;
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
	
	//This function is important becuase we want to display our username
	//Also want to display our email name
	public ImportExportHelper(Database theProjects) {
		myProjects = theProjects;
		myFileName = DEFAULT_FILE_NAME;
		myUserName = "";
		myEmail = "";
	}
	
	//Sets the username
	public void setUserName(String userName) {
		myUserName = userName;
	}
	
	//Sets the emailaddress of the user
	public void setEmail(String email) {
		myEmail = email;
	}
	
	public void importProjects(String theFileName) {
		
		BufferedReader buff = null;
		String line = "";
		String delimiter = ",";
		String quotes = "\"";

//		ArrayList<ArrayList<String>> elements = new ArrayList<ArrayList<String>>(); 
		
		
		int currIndex = 0;
		
		try {
			buff = new BufferedReader(new FileReader(theFileName + ".csv"));
			while((line = buff.readLine()) != null) { // Reads the first line, aka skipping it because the first line is useless.

				
				while((line = buff.readLine()) != null) { // Actually reads the data and adds it to the Array List
					
					ArrayList<String> row = new ArrayList<String>(); 
					Project proj = new Project();
					String[] data = line.split(quotes);
					String[] temp = data[0].split(delimiter);
					for(int i = 0; i < temp.length; i++) {
						row.add(temp[i]);
					}
					row.add(data[1]);
					row.add(data[3]);
					row.add(data[5]);
					
					proj.setName(row.get(currIndex + 1));
					proj.setDifficulty(row.get(currIndex + 3));
					proj.getProjectFinances().setCost(Double.parseDouble(row.get(currIndex + 4)));
					proj.getProjectTime().editTime(Integer.parseInt(row.get(currIndex + 6)), Integer.parseInt(row.get(currIndex + 7)), row.get(currIndex + 5));
					proj.setDescription(row.get(currIndex + 8));
					
					//Add Materials
					String materials = row.get(currIndex + 9);
					String[] mats = materials.split(",");
					for (String str : mats) {
						proj.getProjectItems().addMat(str);
					}
					
					//Add tools
					String tools = row.get(currIndex + 10);
					String[] tool = materials.split(",");
					for (String str : tool) {
						proj.getProjectItems().addTool(str);
					}
					//currIndex += 12;
					myProjects.addProject(proj);
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
			
			
			
			
			buff.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	
	//importuserName   
	
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
	
	//Exports projects function where we will convert our files to csv
	public void exportProjects(String theFileName){
		System.out.println(myProjects.getAllProjects());
		String myFileName = theFileName;
		myFileName =myFileName.concat(".csv");
		System.out.println("File Name: " + myFileName);
		try {
		BufferedWriter outputFile = new BufferedWriter(new FileWriter(myFileName));
		String FILEHEADER = "Project Number,Project Name,Project Summary,Difficulty,Cost,Time Units,Start Time,End Time,Project Description,Materials List,Tools List,Instruction List\n";

		outputFile.append(FILEHEADER);
		for (Project pro : myProjects.getAllProjects()) {
			int counter= 0;
				//Row 0
				outputFile.append(new Integer(counter).toString());
				outputFile.append(",");
				//Row 1
				outputFile.append(pro.getName());
				outputFile.append(",");
				//Row 2
				outputFile.append("Not Implemented");
				outputFile.append(",");
				//Row 3
				outputFile.append(pro.getDifficulty());
				outputFile.append(",");
				//Row 4
				outputFile.append(pro.getProjectFinances().toString());
				outputFile.append(",");
				//Row 5-7
				outputFile.append(pro.getProjectTime().toString());
				outputFile.append(",");
				//Row 8
				outputFile.append(pro.getDescription());
				outputFile.append(",");
				//Rows 9-10
				outputFile.append(pro.getProjectItems().toString());
				outputFile.append(",");
				//Row 11
				outputFile.append("\"Not Implemented\"");
				outputFile.append("\n");
				counter +=1;
		}
		
		outputFile.close();	
		}  catch (IOException e) {
			System.out.println(e.getMessage());
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
