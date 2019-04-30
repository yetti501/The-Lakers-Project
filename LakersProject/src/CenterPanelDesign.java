import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class CenterPanelDesign {

	public static void addCenterPanel(JPanel MainPanel) {
		JPanel CenterPanel = DIYProjects.getCenterPanel();
		MainPanel.add(CenterPanel, BorderLayout.CENTER);
		CenterPanel.setBackground(Color.RED);
	}
	
	public static void removeCenterPanel(JPanel MainPanel, JPanel CenterPanel) {
		System.out.println("Remove Center Panel");
		MainPanel.remove(CenterPanel);
	}
	
}
