package guimain;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.swing.*;

import data.JDBC;
import guicomponents.CenterPanelDesign;
import guicomponents.CreateProjectDesign;
import guicomponents.FooterPanelDesign;
import guicomponents.LeftPanelDesign;
import guicomponents.TitlePanelDesign;


/**
 * Main controller class for the application, sets up the GUI and its related components.
 * @author Lakers Project Team
 */
public class DIYProjectMain implements ActionListener, Serializable{
	

	private static final long serialVersionUID = -109507167636461364L;

	
	/** APPLICATION SETTINGS */
	String myUserName;
	String myEmail;
	ImportExportHelper imp;
	
/** Version Field */
	public static double myVersion;
	
/**** FRAMES *****/
	JFrame FRAME;
	
/**** PANELS ****/
	JPanel MainPanel = new JPanel();
	static JPanel TitlePanel = new JPanel();
	static JPanel LeftPanel = new JPanel();
	static JPanel FooterPanel = new JPanel();
	
/***** BUTTONS: Left Panel *****/
	JButton btnCreateProject = new JButton("Create Project");	
	JButton btnMyProject = new JButton("My Project");
	JButton btnFavoriteProject = new JButton("Favorite Project");
	JButton btnRemoveProject = new JButton("Remove Project");
	JButton btnImportProject = new JButton("Import Project");
	JButton btnExportProject = new JButton("Export Project");
/***** Create New Project Panel *****/
	/* Panels */
	JPanel CreateProjectPanel = new JPanel();
	JPanel NorthDataPage = new JPanel();
	JPanel SouthDataPage = new JPanel();	
	/* Buttons */
	JButton btnUploadImage = new JButton("Upload Image");
	JButton btnMaterialsAdd = new JButton("Add Materials");
	JButton btnMaterialsRemove = new JButton("Remove Materials");
	JButton btnToolsAdd = new JButton("Add Tools");
	JButton btnToolsRemove = new JButton("Remove Tools");
	JButton btnInstructionAdd = new JButton("Add Instruction");
	JButton btnInstructionRemove = new JButton("Remove Instruction");
	JButton btnSaveProject = new JButton("Save New Project");
	/* Text Fields */
	JTextField textProjectName = new JTextField("Enter Project Name");
	JTextField textLowBoundTime = new JTextField("Enter Time");
	JTextField textUpperBoundTime = new JTextField("Enter Time");
	JTextField textDescription = new JTextField("Project Description");
	/* Drop Downs */
	String[] difficultyArray = {"Easy", "Medium", "Hard", "Expert", "Do Not Attempt"};
	JComboBox dropDifficulty = new JComboBox(difficultyArray);
	String[] timeArray = {"Seonds", "Minutes", "Hours", "Days", "Weeks", "Months", "Years", "Decades"};
	JComboBox dropTimeUnits = new JComboBox(timeArray);
	/* Lists */
	String[] MaterialArray;
	JList<String> listMaterials = new JList<>(MaterialArray);
	String[] ToolArray;
	JList<String> listTools = new JList<>(ToolArray);
	String[] InstructionArray;
	JList<String> listInstruction = new JList<>(InstructionArray);
	
	/* Menu Bar */
	JMenuBar menuBar = new JMenuBar();
	JMenu help = new JMenu("Help");
	JMenu file = new JMenu("File");
	JMenuItem about;
	
	
	/***** Center Panel *****/
	static JPanel CenterPanel = new JPanel();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		System.out.println("Before DB Call");
		JDBC.JDBCSource();
		System.out.println("AfterDB Call");
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new DIYProjectMain();
			}
		});
	}
	
	
/**
 * 
 * This is where all the different frame objects will be added to the DIY Projects frame. 
 * 
 */
	public DIYProjectMain() {
		
		myUserName = "Not Set";
		myEmail = "Not Set";
		FRAME = new JFrame("DIY Project | " + "UserName: " + myUserName);
		imp = new ImportExportHelper();
		
		Version projVersion = new Version(this);
		projVersion.setVersion();
		myVersion = projVersion.getVersion();
		
		MainPanel.setLayout(new BorderLayout());
/***** TITLE PANEL *****/				
		TitlePanelDesign.addTitlePanel(MainPanel, TitlePanel);
		
/***** LEFT PANEL *****/		
		//LeftPanelDesign.addLeftPanel(MainPanel, LeftPanel, CenterPanel, CreateProjectPanel, DataPage, NorthDataPage, SouthDataPage,
		//		btnCreateProject, btnMyProject, btnFavoriteProject, btnRemoveProject, btnImportProject, btnExportProject);
		
		MainPanel.add(LeftPanel, BorderLayout.LINE_START);
		LeftPanel.setBackground(Color.DARK_GRAY);
		
		LeftPanel.setLayout(new BoxLayout(LeftPanel, BoxLayout.Y_AXIS));
		
	    btnCreateProject.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	                if(e.getSource() == btnCreateProject) {
	                	System.out.println("CREATE NEW PROJECT PRESSED");
	                	CenterPanelDesign.removeCenterPanel(MainPanel, CenterPanel);
	                	CreateProjectDesign.addCreateProjectPanel(MainPanel, CreateProjectPanel, NorthDataPage, SouthDataPage,
	                			btnUploadImage, btnMaterialsAdd, btnMaterialsRemove, btnToolsAdd, btnToolsRemove, btnInstructionAdd, btnInstructionRemove, btnSaveProject, 
	                			textProjectName, textLowBoundTime, textUpperBoundTime, textDescription, dropDifficulty, dropTimeUnits, 
	                			listMaterials, listTools, listInstruction);
	                	MainPanel.revalidate();
	                	MainPanel.repaint();
	                } else {
	                	System.out.println("CREATE NEW PROJECT NOT PRESSED");
	                }
	                
	        }  
	    });  
		
		LeftPanel.add(btnCreateProject);
		LeftPanel.add(btnMyProject);
		LeftPanel.add(btnFavoriteProject);
		LeftPanel.add(btnRemoveProject);
		LeftPanel.add(btnImportProject);
		LeftPanel.add(btnExportProject);
		
/***** CENTER PANEL *****/
		CenterPanelDesign.addCenterPanel(MainPanel);
		
/***** CREATE PROJECT PANEL *****/
		//CreateProjectDesign.buildCreateProjectPanel(MainPanel, CreateProjectPanel);
		
/***** FOOTER PANEL *****/
		FooterPanelDesign.addFooterPanel(MainPanel, FooterPanel);
		
/** MENU BAR */	
		menuBar.add(file);
		

		
		JMenuItem setUsername = new JMenuItem(new AbstractAction("Set/Change Username..."){
		    public void actionPerformed(ActionEvent e) {
		        myUserName = JOptionPane.showInputDialog(FRAME, "Please enter a username.");
		        FRAME.setTitle("DIY Project | " + "UserName: " + myUserName);
		        JOptionPane.showMessageDialog(FRAME, "User Name Changed Successfully!");

		    }
		});
		JMenuItem setEmail = new JMenuItem(new AbstractAction("Set/Change Email..."){
		    public void actionPerformed(ActionEvent e) {
		        myEmail = JOptionPane.showInputDialog(FRAME, "Please Enter an Email Address.");
		        JOptionPane.showMessageDialog(FRAME, "Email Changed Successfully!");
		    }
		});
		
		JMenuItem exportSettings = new JMenuItem(new AbstractAction("Export Settings..."){
		    public void actionPerformed(ActionEvent e) {
		        String fileName = JOptionPane.showInputDialog(FRAME, "Please Enter a File to export Settings to (.csv)...");      
		        imp.setFileName(fileName);
		        imp.setEmail(myEmail);
		        imp.setUserName(myUserName);
		        try {
					imp.exportSettings();
			        JOptionPane.showMessageDialog(FRAME, "Exported Settings Successfully");
				} catch (IOException e1) {
			        JOptionPane.showMessageDialog(FRAME, "Error Exporting Settings!");
				}

		    }
		});
		
		JMenuItem importSettings = new JMenuItem(new AbstractAction("Import Settings..."){
		    public void actionPerformed(ActionEvent e) {
		        String fileName = JOptionPane.showInputDialog(FRAME, "Please Enter a File to Import Settings From.");
		        imp.importUserName(fileName);
		        myUserName = imp.myUserName;
		        myEmail = imp.myEmail;
		        JOptionPane.showMessageDialog(FRAME, "Imported Username " + myUserName + " and Email " + myEmail);
		        FRAME.setTitle("DIY Project | " + "UserName: " + myUserName);
		    }
		});
		
		file.add(setUsername);
		file.add(setEmail);
		file.add(exportSettings);
		file.add(importSettings);

		menuBar.add(help);
		 about = new JMenuItem(new AbstractAction("About..."){
			    public void actionPerformed(ActionEvent e) {
			        JOptionPane.showMessageDialog(FRAME, "Made by the Lakers Project Team!\n Version: " + myVersion);
			    }
			});
			help.add(about);
/***** FRAME *****/
		FRAME.setJMenuBar(menuBar);
		FRAME.add(MainPanel);
		FRAME.setPreferredSize(new Dimension(800, 600));
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FRAME.pack();
		FRAME.setLocationRelativeTo(null);
		FRAME.setVisible(true);
	}
	
	public static JPanel getCenterPanel() {
		return CenterPanel;
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
