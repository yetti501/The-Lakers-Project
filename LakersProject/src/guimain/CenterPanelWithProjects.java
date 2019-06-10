//package guimain;
//
//import java.awt.Component;
//import java.awt.Dimension;
//import java.util.List;
//import java.util.ArrayList;
//
//import javax.swing.DefaultListCellRenderer;
//import javax.swing.DefaultListModel;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JList;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//
//import data.Database;
//import data.Project;
//
///**
// * 
// * @author Thias David
// */
//public class CenterPanelWithProjects extends JPanel{
////
////	public static void main(String[]args) {
////		Database db = new Database();
////		db.addProject(new Project());
////		db.addProject(new Project());
////		
////		CenterPanelWithProjects cpwp = new CenterPanelWithProjects(db);
////		
////		JFrame frame = new JFrame();
////		frame.add(cpwp);
////		frame.setVisible(true);
////		
////	}
//
//
//	public JPanel myPanel;
//	public ArrayList<Project> myProjects;
//	public Database myDatabase;
//	public DefaultListModel<Project> myList;
//	public JList<Project> myJList;
//
//
//	/**
//	 * 
//	 * @author Thias David
//	 * @version 6/6/19
//	 */
//	public CenterPanelWithProjects(Database theDatabase){
//		myPanel = new JPanel();
////		JFrame frame = new JFrame();
//		myDatabase = theDatabase;
//		
////		DefaultListModel<String> list = new DefaultListModel<>();
//		myList = new DefaultListModel<>();
//
////		JList<String> projects = new JList<>(list); 
//		myJList = new JList<>(myList);
//		myJList.setVisibleRowCount(3);
//		myJList.setFont(myJList.getFont().deriveFont(22.0f));
//
//		myJList.setCellRenderer(new MyListCellRenderer());
//
//		myJList.setVisible(true);
//		
//		for(Project p : myDatabase.getAllProjects()) {
//			myList.addElement(p);
//		}
//		
//		myJList.setVisible(true);
//		
//		JScrollPane scroll = new JScrollPane(myJList);
//		
//		
////		projects.setBounds(400,400,400,400);
//		myPanel.add(myJList);
//		myPanel.setSize(400, 400);
//		myPanel.setVisible(true);
//		myPanel.setLayout(null);
//	}
//
//	public void updateProjects(List<Project> theNewList) {
//		myDatabase = new Database();
//		myList.clear();
//		
//		
//		for(Project p : theNewList) {
//			myDatabase.addProject(p);
//			myList.addElement(p);
//		}
//		myJList = new JList<>(myList);
//		myJList.setVisibleRowCount(3);
//		myJList.setFont(myJList.getFont().deriveFont(22.0f));
//
//		myJList.setCellRenderer(new MyListCellRenderer());
//	}
//
//
//
//
//}
//
//
//
//class MyListCellRenderer extends DefaultListCellRenderer{
//
//	public Component getListCellRendererComponent(
//			JList list, Object value, int index, 
//			boolean isSelected, boolean cellHasFocus) {
//		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
//		Project project = (Project) value;
//		String name = project.getName();
//		Double cost = project.getProjectFinances().getCost();
//		String diff = project.getDifficulty();
//		String desc = project.getDescription();
//
//		String label = "<html>Project Name: " + name + "<br/>Cost: " + cost + "<br/>Difficulty: " + diff + "\n" + desc;
//		setText(label);
//
//		return this;
//	}
//
//}
//

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
		projects.setFont(projects.getFont().deriveFont(22.0f));

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
		

		String label = "<html>Project Name: " + name + "<br/>Cost: " + cost + "<br/>Difficulty: " + diff;
		setText(label);

		return this;
	}

}
