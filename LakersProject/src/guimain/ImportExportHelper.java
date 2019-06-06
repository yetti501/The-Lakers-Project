package guimain;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import data.Project;

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
	
	public ImportExportHelper(Database theProjects) {
		myProjects = theProjects
		myFileName = DEFAULT_FILE_NAME;
		myUserName = "";
		myEmail = "";
	}
	
	public void setUserName(String userName) {
		myUserName = userName;
	}
	
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
			buff = new BufferedReader(new FileReader(theFileName));
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
					
					proj.setName(row.get(currIndex));
					proj.setDifficulty(row.get(currIndex + 3));
					proj.getProjectFinances().setCost(Double.parseDouble(row.get(currIndex + 4)));
					proj.getProjectTime().editTime(Integer.parseInt(row.get(currIndex + 6)), Integer.parseInt(row.get(currIndex + 7)), row.get(currIndex + 5));
					proj.setDescription(row.get(currIndex) + 8);
					
					//Add Materials
					String materials = row.get(currIndex + 9);
					String[] mats = materials.split(".");
					for (String str : mats) {
						proj.getProjectItems().addMat(str);
					}
					
					//Add tools
					String tools = row.get(currIndex + 10);
					String[] tool = materials.split(".");
					for (String str : tool) {
						proj.getProjectItems().addTool(str);
					}
					currIndex += 12;
					System.out.println(proj.toString());
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
		
//		public void exportFile(ArrayList<String> elements) throws IOException {		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a file name: ");
		String myFileName = scanner.nextLine();
		myFileName =myFileName.concat(".csv");
		System.out.println("File Name: " + myFileName);
		File file = new File(myFileName);
		FileWriter outputFile = new FileWriter(file);
		String FILEHEADER = "Project Number,Project Name,Project Summary,Difficulty,Cost,Time Units,Start Time,End Time,Project Description,Materials List,Tools List,Instruction List\n";
		outputFile.append(FILEHEADER);
		
		Project pro = new Project();
		int counter= 0;
		try {
			outputFile.append(new Integer(counter).toString());
			outputFile.append(",");
			outputFile.append(pro.getName());
			outputFile.append(",");
			outputFile.append("");
			outputFile.append(",");
			outputFile.append(pro.getDifficulty());
			outputFile.append(",");
			outputFile.append(pro.getProjectFinances().toString());
			outputFile.append(",");
			outputFile.append(pro.getProjectTime().toString());
			outputFile.append(",");
			outputFile.append("");
			outputFile.append(",");
			outputFile.append("");
			outputFile.append(",");
			outputFile.append(pro.getDescription());
			outputFile.append(",");
			outputFile.append(pro.getProjectItems().getMat().toString());
			outputFile.append(",");
			outputFile.append(pro.getProjectItems().getTools().toString());
			outputFile.append(",");
			outputFile.append("");
			
			
		}  catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		scanner.close();
		outputFile.close();
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
