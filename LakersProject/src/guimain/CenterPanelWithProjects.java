package guimain;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import data.Database;
import data.Project;

/**
 * @version 5/30/19
 * @author Thias David
 */
public class CenterPanelWithProjects extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Database myDatabase;
	
	public List<Project> myProjects;
	
	public DefaultListModel<Project> myList;
	

	/**
	 * @author Thias David
	 * @version 6/3/19
	 * @param theDatabase - the database that holds all the projects
	 */
	public CenterPanelWithProjects(Database theDatabase){
		
		myDatabase = theDatabase;
		myProjects = theDatabase.getAllProjects();
		
		JFrame frame = new JFrame();
		
		
		DefaultListModel<Project> myList = new DefaultListModel<>();
		
		JList<Project> projects = new JList<>(myList);
		projects.setVisibleRowCount(3);
		projects.setFont(projects.getFont().deriveFont(22.0f));
		
		projects.setCellRenderer(new MyListCellRenderer());
		
		JScrollPane scrolly = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		frame.setContentPane(scrolly);
		
		for( Project p : myProjects) {
			myList.addElement(p);
		}
		
		
		projects.setBounds(400,400,400,400);
		frame.add(projects);
		frame.setSize(800, 800);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/**
	 * @version 6/3/19
	 * @author Thias David
	 * @param theNewList
	 */
	public void updateProjects(List<Project> theNewList) {
		myProjects = theNewList;
		myList.clear();
		for(Project p : myProjects) {
			myList.addElement(p);
		}
	}
		
}
	

class MyListCellRenderer extends DefaultListCellRenderer{
	
	public Component getListCellRendererComponent(
			JList list, Object value, int index, 
			boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		Project project = (Project) value;
		String name = project.getName();
		Double cost = project.getProjectFinances().getCost();
		String diff = project.getDifficulty();
		String desc = project.getDescription();
		
		String label = "<html>Project Name: " + name + "<br/>Cost: " + cost + "<br/>Difficulty: " + diff + "\n" + desc;
		setText(label);
		
		return this;
	}
	
}
