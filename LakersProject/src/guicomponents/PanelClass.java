package guicomponents;

import javax.swing.JPanel;

public class PanelClass {
	static JPanel MainPanel = new JPanel();
	static JPanel TitlePanel = new JPanel();
	static JPanel LeftPanel = new JPanel();
	static JPanel FooterPanel = new JPanel();
	static JPanel InfoPanel = new JPanel();
	static JPanel CenterPanel = new JPanel();
	
	public static void addTitlePanel(JPanel MainPanel) {
		MainPanel.add(TitlePanel);
	}
	
	public static void removeTitlePanel(JPanel MainPanel) {
		MainPanel.remove(TitlePanel);
	}
	
	public static void addLeftPanel(JPanel MainPanel) {
		MainPanel.add(LeftPanel);
	}
	
	public static void removeLeftPanel(JPanel MainPanel) {
		MainPanel.remove(LeftPanel);
	}
	
	public static void addFooterPanel(JPanel MainPanel) {
		MainPanel.add(FooterPanel);
	}
	
	public static void removeFooterPanel(JPanel MainPanel) {
		MainPanel.remove(FooterPanel);
	}
	
	public static void addInfoPange(JPanel MainPanel) {
		MainPanel.add(InfoPanel);
	}
	
	public static void removeInfoPanel(JPanel MainPanel) {
		MainPanel.remove(InfoPanel);
	}
	
	public static void addCenterPanel(JPanel MainPanel) {
		MainPanel.add(CenterPanel);
	}
	
	public static void removeCenterPanel(JPanel MainPanel) {
		MainPanel.remove(CenterPanel);
	}
}
