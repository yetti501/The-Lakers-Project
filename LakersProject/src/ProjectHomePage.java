import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;

public class ProjectHomePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectHomePage window = new ProjectHomePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProjectHomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel title = new JPanel();
		frame.getContentPane().add(title, BorderLayout.PAGE_START);
		
		JPanel leftSideBar = new JPanel();
		frame.getContentPane().add(leftSideBar, BorderLayout.LINE_START);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		leftSideBar.add(verticalStrut);
		
		JButton btnNewProject = new JButton("New Project");
		leftSideBar.add(btnNewProject);
		
		JButton btnHomeButton = new JButton("Home Button");
		leftSideBar.add(btnHomeButton);
		
		JPanel center = new JPanel();
		frame.getContentPane().add(center, BorderLayout.CENTER);
	}

}
