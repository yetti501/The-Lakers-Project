package guimain;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.swing.*;

import data.Database;
import data.Project;
import guicomponents.CreateProjectPanel;
/**
 * Main controller class for the application, sets up the GUI and its related components.
 * @author Lakers Project Team
 */
public class DIYProjectMain implements Serializable{
	
	private static final long serialVersionUID = -109507167636461364L;

	/** Import Export Helper **/
	private ImportExportHelper myImpExpHelper;
	
	
/** APPLICATION SETTINGS */
	private String myUserName;
	private String myEmail;
	private ImportExportHelper imp;
	private Database myDatabase;
	
/** Version Field */
	public static double myVersion;
	
/**** FRAMES *****/
	private JFrame FRAME;
	
/**** PANELS ****/
	private final JPanel myMainPanel;
    private final JPanel myTitlePanel;
	private final JPanel myLeftPanel;
	private final JPanel myFooterPanel = new JPanel();
	private final JPanel myInfoPanel;
	private CreateProjectPanel myCreateProjectPanel;
	
/**** Menu Bar *****/
	private JMenuBar myMenuBar;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Class classMain = Class.forName("DIYProjectMain");
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
		
		//Fields for model
		myUserName = "Not Set";
		myEmail = "Not Set";
		FRAME = new JFrame("DIY Project Planner | " + "UserName: " + myUserName);
		myDatabase = new Database();
		myCreateProjectPanel = new CreateProjectPanel(myDatabase);
		myImpExpHelper = new ImportExportHelper(myDatabase);
		
		///Construct Panel
		myLeftPanel = new JPanel();
		myMainPanel = new JPanel();
		myInfoPanel = new JPanel();
		myTitlePanel = new JPanel();
		myMenuBar = new JMenuBar();
		//Setup main panel
		myMainPanel.setBackground(Color.DARK_GRAY);
		myMainPanel.setLayout(new BorderLayout());
		myMainPanel.add(myFooterPanel, BorderLayout.SOUTH);
		
		//Constructor Methods
		createInfoPanel();
		createLeftPanel();
		createTitlePanel();
		createMenu();
		

		
		//Add components / setup frame
		FRAME.setJMenuBar(myMenuBar);
		FRAME.setPreferredSize(new Dimension(800, 600));
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FRAME.getContentPane().add(myMainPanel);
		FRAME.repaint();
		FRAME.pack();
		FRAME.setLocationRelativeTo(null);
		FRAME.setVisible(true);
		
		/** Version stuffs */
		Version projVersion = new Version(this);
		myVersion = projVersion.getVersion();
		projVersion.setVersion();
	}
	
	//Creating the infopanel.
	public void createInfoPanel() {
		FlowLayout layout = new FlowLayout();
		layout.setHgap(10);
		layout.setVgap(10);
		myInfoPanel.setLayout(layout);
		myInfoPanel.setBackground(Color.LIGHT_GRAY);
		myInfoPanel.add(new JButton("Close Window"));
	}
	//Creating buttons on panels so user can easily click on them.
	public void createLeftPanel() {
		JButton btnCreateProject = new JButton("Create Project");	
		JButton btnImportProject = new JButton("Import Projects");
		btnImportProject.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	                if(e.getSource() == btnImportProject) {
	                	myImpExpHelper.importProjects(myUserName);
	                	String importedProjects = "Imported Projects: " + "\n";
	                	for (Project p : myDatabase.getAllProjects()) {
		                	importedProjects += p.toString();	
	                	}
	                	JOptionPane.showMessageDialog(FRAME, importedProjects);

	                }
	        	}
	        });
		
		JButton btnExportProject = new JButton("Export Projects");
		btnExportProject.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	                if(e.getSource() == btnExportProject) {
	                	myImpExpHelper.exportProjects(myUserName);
	    		        JOptionPane.showMessageDialog(FRAME, "Exported Succesfully!");
	                }
	        	}
	        });
		
		
		JButton btnProjectInfo = new JButton("My Projects");
		
		myLeftPanel.setBackground(Color.DARK_GRAY);
		myLeftPanel.setLayout(new BoxLayout(myLeftPanel, BoxLayout.Y_AXIS));
		
	    btnCreateProject.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	                if(e.getSource() == btnCreateProject) {
	                	myMainPanel.remove(myCreateProjectPanel);
	                	myCreateProjectPanel = new CreateProjectPanel(myDatabase);
	                	myMainPanel.remove(myInfoPanel);
	                	myMainPanel.add(myCreateProjectPanel, BorderLayout.CENTER);
	                	myMainPanel.revalidate();
	                	myMainPanel.repaint();
	                	FRAME.pack();
	                } else {
	                	System.out.println("CREATE NEW PROJECT NOT PRESSED!");
	                }
	                
	        }  
	    });  
	    
		btnProjectInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myMainPanel.remove(myCreateProjectPanel);
				myMainPanel.add(myInfoPanel, BorderLayout.CENTER);
				myMainPanel.revalidate();
				myMainPanel.repaint();
			}
		});
	    
	    myLeftPanel.add(btnCreateProject);
	    myLeftPanel.add(btnImportProject);
	    myLeftPanel.add(btnExportProject);
	    myLeftPanel.add(btnProjectInfo);
	    myMainPanel.add(myLeftPanel, BorderLayout.WEST);
	}
	
	//This is our background look for our webapplication
	//This is how we want to display our application.
	public void createTitlePanel() {
		myTitlePanel.setBackground(Color.GRAY);
		JLabel titleLabel = new JLabel("Lakers DIY Planner");
		titleLabel.setFont(new Font("Arial", 1, 20));
		myTitlePanel.add(titleLabel);
		myMainPanel.add(myTitlePanel, BorderLayout.NORTH);	
	}
	
	//This creates the menu for file and help. 
	//When user clicks on File they can Set/Change Username 
	
	public void createMenu() {
		JMenu help = new JMenu("Help");
		JMenu file = new JMenu("File");
		myMenuBar.add(file);
		JMenuItem setUsername = new JMenuItem(new AbstractAction("Set/Change Username..."){

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		        myUserName = JOptionPane.showInputDialog(FRAME, "Please enter a username.");
		        FRAME.setTitle("DIY Project | " + "UserName: " + myUserName);
		        JOptionPane.showMessageDialog(FRAME, "User Name Changed Successfully!");

		    }
		});
		JMenuItem setEmail = new JMenuItem(new AbstractAction("Set/Change Email..."){

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		        myEmail = JOptionPane.showInputDialog(FRAME, "Please Enter an Email Address.");
		        JOptionPane.showMessageDialog(FRAME, "Email Changed Successfully!");
		    }
		});
		
		file.add(setUsername);
		file.add(setEmail);
		//When user clicks help they will see our about
		//Users will see our info displayed on screen.
		myMenuBar.add(help);
		JMenuItem about = new JMenuItem(new AbstractAction("About..."){
		private static final long serialVersionUID = 1L;
			public void actionPerformed(ActionEvent e) {
		        JOptionPane.showMessageDialog(FRAME, "Made by the Lakers Project Team!\n Version: " + myVersion);
		    }
		});
		help.add(about);

			
	}
}
