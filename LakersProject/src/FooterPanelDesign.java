import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class FooterPanelDesign {

	public static void addFooterPanel(JPanel MainPanel, JPanel FooterPanel) {
		System.out.println("Footer Panel Added.");
		MainPanel.add(FooterPanel, BorderLayout.PAGE_END);
		FooterPanel.setBackground(Color.blue);
	}
	
	public static void removeFooterPanel(JPanel MainPanel, JPanel FooterPanel) {
		System.out.println("Footer Panel Removed.");
		MainPanel.remove(FooterPanel);
	}
}
