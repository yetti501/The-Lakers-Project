import java.awt.*;
import javax.swing.*;

public class TitlePanelDesign {

	public static void addTitlePanel(JPanel MainPanel, JPanel TitlePanel) {
		System.out.println("Added Title Panel.");
		MainPanel.add(TitlePanel, BorderLayout.PAGE_START);	
		TitlePanel.setBackground(Color.GRAY);
		
		JLabel titleLabel = new JLabel("DIY Project");
		titleLabel.setFont(new Font("Arial", 1, 20));
		TitlePanel.add(titleLabel);
		
	}
	
	public static void removeTitlePanel(JPanel MainPanel, JPanel TitlePanel) {
		System.out.println("Remove Title Panel");
		MainPanel.remove(TitlePanel);
	}
}
