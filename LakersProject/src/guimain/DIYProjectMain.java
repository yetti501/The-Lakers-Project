package guimain;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.swing.*;

import data.Database;
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
		FRAME = new JFrame("DIY Project | " + "UserName: " + myUserName);
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
	
	
	public void createInfoPanel() {
		FlowLayout layout = new FlowLayout();
		layout.setHgap(10);
		layout.setVgap(10);
		myInfoPanel.setLayout(layout);
		myInfoPanel.setBackground(Color.LIGHT_GRAY);
		myInfoPanel.add(new JButton("Close Window"));
	}
	
	public void createLeftPanel() {
		JButton btnCreateProject = new JButton("Create Project");	
		JButton btnMyProject = new JButton("My Project");
		JButton btnFavoriteProject = new JButton("Favorite Project");
		JButton btnRemoveProject = new JButton("Remove Project");
		JButton btnImportProject = new JButton("Import Project");
		btnImportProject.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	                if(e.getSource() == btnImportProject) {
	                	myImpExpHelper.importProjects(myUserName);
	                	JOptionPane.showMessageDialog(FRAME, myDatabase.getAllProjects());

	                }
	        	}
	        });
		
		JButton btnExportProject = new JButton("Export Project");
		btnExportProject.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	                if(e.getSource() == btnExportProject) {
	                	myImpExpHelper.exportProjects(myUserName);
	    		        JOptionPane.showMessageDialog(FRAME, "Exported Succesfully!");
	                }
	        	}
	        });
		
		
		JButton btnProjectInfo = new JButton("Info Panel");
		
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
	    myLeftPanel.add(btnMyProject);
	    myLeftPanel.add(btnFavoriteProject);
	    myLeftPanel.add(btnRemoveProject);
	    myLeftPanel.add(btnImportProject);
	    myLeftPanel.add(btnExportProject);
	    myLeftPanel.add(btnProjectInfo);
	    myMainPanel.add(myLeftPanel, BorderLayout.WEST);
	}
	
	public void createTitlePanel() {
		myTitlePanel.setBackground(Color.GRAY);
		JLabel titleLabel = new JLabel("DIY Project");
		titleLabel.setFont(new Font("Arial", 1, 20));
		myTitlePanel.add(titleLabel);
		myMainPanel.add(myTitlePanel, BorderLayout.NORTH);	
	}
	
	
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
		
		JMenuItem exportSettings = new JMenuItem(new AbstractAction("Export Settings..."){

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		        String fileName = myUserName + ".csv";      
		        imp.setFileName(fileName);
		        imp.setEmail(myEmail);
		        imp.setUserName(myUserName);
		        try {
					imp.exportSettings();
			        JOptionPane.showMessageDialog(FRAME, "Exported Settings Successfully");
				} catch (IOException e1) {

				}

		    }
		});
		
		JMenuItem importSettings = new JMenuItem(new AbstractAction("Import Settings..."){

			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
		        String fileName = JOptionPane.showInputDialog(FRAME, "Please Enter a File to Import Settings From.");
		        try {
					imp.importUserName(fileName);
			        myUserName = imp.myUserName;
			        myEmail = imp.myEmail;
			        JOptionPane.showMessageDialog(FRAME, "Imported Username " + myUserName + " and Email " + myEmail);
			        FRAME.setTitle("DIY Project | " + "UserName: " + myUserName);

					
				} catch (FileNotFoundException e1) {
			        JOptionPane.showMessageDialog(FRAME, "File not found, please try again!");
				}
		    }
		});
		
		file.add(setUsername);
		file.add(setEmail);
		file.add(exportSettings);
		file.add(importSettings);

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
