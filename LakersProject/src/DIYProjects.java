import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class DIYProjects implements ActionListener{
/**** FRAMES *****/
	JFrame FRAME = new JFrame("DIY Project");
	
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
	JButton btnInstructionRemove = new JButton("REmove Instruction");
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
	
	
	/***** Center Panel *****/
	static JPanel CenterPanel = new JPanel();
	
	
	
/*
 * This is where all the different frame objects will be added to the DIY Projects frame. 
 */
	public DIYProjects() {
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
		
/***** FRAME *****/
		FRAME.add(MainPanel);
		FRAME.setPreferredSize(new Dimension(800, 600));
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FRAME.pack();
		FRAME.setVisible(true);
	}
	
	public static JPanel getCenterPanel() {
		return CenterPanel;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Hello Grant");
		
		System.out.println("Before DB Call");
		JDBC.JDBCSource();
		System.out.println("AfterDB Call");
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new DIYProjects();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
