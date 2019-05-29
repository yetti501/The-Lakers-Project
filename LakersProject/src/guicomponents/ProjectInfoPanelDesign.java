package guicomponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ProjectInfoPanelDesign {
	
	public static void addProjectPanel(JPanel MainPanel, JPanel InfoPanel) {
		System.out.println("Added Info Panel.");
		
		//classMain.MainPanel.add(classMain.InfoPanel, BorderLayout.CENTER)l;
		MainPanel.add(InfoPanel);
		FlowLayout layout = new FlowLayout();
		layout.setHgap(10);
		layout.setVgap(10);
		InfoPanel.setLayout(layout);
		InfoPanel.setBackground(Color.RED);
		InfoPanel.add(new JButton("Close Window"));
		
		returnMain();
		
		PanelClass.addCenterPanel(MainPanel);
	}
	
	public static void removeInfoPanel(JPanel MainPanel, JPanel InfoPanel) {
		System.out.println("Info Panel Removed");
		MainPanel.remove(InfoPanel);
	}	
	
	public static void returnMain() {
		ButtonClass.addCreateProjectBtn(PanelClass.MainPanel);
	}
	
}
