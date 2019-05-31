package guimain;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import data.Project;

/**
 * 
 * @author Thias David
 */
public class CenterPanelWithProjects {

	public static void main(String[]args) {
		CenterPanelWithProjects cpwp = new CenterPanelWithProjects();
	}
	
	
	public ArrayList<Project> myProjects;
	
	
	public CenterPanelWithProjects(){
		JFrame frame = new JFrame();
		
//		DefaultListModel<String> list = new DefaultListModel<>();
		DefaultListModel<Project> list = new DefaultListModel<>();
		
		Project p = new Project();
		Project p1 = new Project();
		Project p2 = new Project();
		

		
		
//		JList<String> projects = new JList<>(list); 
		JList<Project> projects = new JList<>(list);
		projects.setVisibleRowCount(3);
		projects.setFont(projects.getFont().deriveFont(30.0f));
		
		projects.setCellRenderer(new MyListCellRenderer());
		
//		list.addElement(p.getName() + "\n" + p.getDescription() + "\n" + p.getProjectFinances().getCost());
		list.addElement(p);
		list.addElement(p1);
		list.addElement(p2);
		
		
		projects.setBounds(400,400,400,400);
		frame.add(projects);
		frame.setSize(800, 800);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void getProjects() {
		
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
