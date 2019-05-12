package guicomponents;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import guimain.DIYProjectMain;

public class CenterPanelDesign {

	public static void addCenterPanel(JPanel MainPanel) {
		JPanel CenterPanel = DIYProjectMain.getCenterPanel();
		MainPanel.add(CenterPanel, BorderLayout.CENTER);
		CenterPanel.setBackground(Color.DARK_GRAY);
	}
	
	public static void removeCenterPanel(JPanel MainPanel, JPanel CenterPanel) {
		System.out.println("Remove Center Panel");
		MainPanel.remove(CenterPanel);
	}
	
}
