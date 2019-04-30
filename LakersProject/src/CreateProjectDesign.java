import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateProjectDesign {

	
	public static void addCreateProjectPanel(JPanel MainPanel, JPanel CreateProjectPanel, JPanel NorthDataPage, JPanel SouthDataPage,
			JButton btnUploadImage, JButton btnMaterialsAdd, JButton btnMaterialsRemove, JButton btnToolsAdd, JButton btnToolsRemove, JButton btnInstructionAdd,
			JButton btnInstructionRemove, JButton btnSaveProject, JTextField textProjectName, JTextField textLowBoundTime, JTextField textUpperBoundTime, 
			JTextField textDescription, JComboBox dropDifficulty, JComboBox dropTimeUnits, JList listMaterials, JList listTools, JList listInstruction) {
		
		System.out.println("Add Create Project Panel.");
		MainPanel.add(CreateProjectPanel, BorderLayout.CENTER);
		CreateProjectPanel.setBackground(Color.PINK);
		
		constructNorthDataPage(NorthDataPage, btnUploadImage, textProjectName, textLowBoundTime, textUpperBoundTime, dropDifficulty, dropTimeUnits);
		constructSouthDataPage(SouthDataPage, btnMaterialsAdd, btnMaterialsRemove, btnToolsAdd, btnToolsRemove, btnInstructionAdd, btnInstructionRemove,
				listMaterials, listTools, listInstruction, textDescription);
		
		CreateProjectPanel.add(NorthDataPage, BorderLayout.PAGE_START);
		CreateProjectPanel.add(SouthDataPage, BorderLayout.CENTER);
		CreateProjectPanel.add(btnSaveProject, BorderLayout.PAGE_END);
		
		btnSaveProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnSaveProject) {
					System.out.println("New Project created");
					CreateProjectDesign.removeCreateProjectPanel(MainPanel, CreateProjectPanel);
					CenterPanelDesign.addCenterPanel(MainPanel);
					MainPanel.revalidate();
					MainPanel.repaint();
				}
			}
		});

	}
	
	public static void removeCreateProjectPanel(JPanel MainPanel, JPanel CreateProjectPanel) {
		System.out.println("Remove Create Project Panel.");
		MainPanel.remove(CreateProjectPanel);
	}
	
	public static void constructNorthDataPage(JPanel NorthDataPage, JButton btnUploadImage, JTextField textProjectName, JTextField textLowBoundtime, 
			JTextField textUpperBoundTime, JComboBox dropDifficulty, JComboBox dropTimeUnits) {
		NorthDataPage.setBackground(Color.ORANGE);
		/* LINE_START */
		NorthDataPage.add(btnUploadImage, BorderLayout.LINE_START);
		/* CNETER */
		NorthDataPage.add(textProjectName, BorderLayout.CENTER);
		NorthDataPage.add(textLowBoundtime, BorderLayout.CENTER);
		NorthDataPage.add(textUpperBoundTime, BorderLayout.CENTER);
		/* LINE_END */
		NorthDataPage.add(dropDifficulty, BorderLayout.LINE_END);
		NorthDataPage.add(dropTimeUnits, BorderLayout.LINE_END);
	}
	
	public static void constructSouthDataPage(JPanel SouthDataPage, JButton btnMaterialsAdd, JButton btnMaterialsRemove, 
			JButton btnToolsAdd, JButton btnToolsRemove, JButton btnInstructionAdd, JButton btnInstructionRemove, JList listMaterials, 
			JList listTools, JList listInstruction, JTextField textDescription) {
		SouthDataPage.setBackground(Color.YELLOW);
		/* PAGE_START */
		SouthDataPage.add(textDescription, BorderLayout.PAGE_START);
		/* LINE_START */
		//SouthDataPage.add(listMaterials, BorderLayout.LINE_START);
		SouthDataPage.add(btnMaterialsAdd, BorderLayout.LINE_START);
		SouthDataPage.add(btnMaterialsRemove, BorderLayout.LINE_START);
		/* LINE_END */
		//SouthDataPage.add(listTools, BorderLayout.LINE_END);
		SouthDataPage.add(btnToolsAdd, BorderLayout.LINE_END);
		SouthDataPage.add(btnToolsRemove, BorderLayout.LINE_END);
		/* PAGE_END */
		//SouthDataPage.add(listInstruction, BorderLayout.PAGE_END);
		SouthDataPage.add(btnInstructionAdd, BorderLayout.PAGE_END);
		SouthDataPage.add(btnInstructionRemove, BorderLayout.PAGE_END);
	}
	
	public static void removeCreateProject(JPanel MainPanel, JPanel CreateProjectPanel) {
		System.out.println("Remove Create New Project");
		MainPanel.remove(CreateProjectPanel);
	}
}
