package guicomponents;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import data.Database;
import data.Project;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Initial GUI for create project dialog.
 * @author DWLooney
 */
public class CreateProjectPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8848373101564972392L;
	private Project myProject;
	private Database myDatabase;
	private JTextField enterNameField;
	private JTextField costInput;
	private JTextField timeFrom;
	private JTextField txtTo;
	/**
	 * Create the panel.
	 */
	public CreateProjectPanel(Database theDatabase) {
		myProject = new Project();
		myDatabase = new Database();
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{615, 0};
		gridBagLayout.rowHeights = new int[]{69, 122, 90, 55, 55, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel titlePanel = new JPanel();
		GridBagConstraints gbc_titlePanel = new GridBagConstraints();
		gbc_titlePanel.fill = GridBagConstraints.BOTH;
		gbc_titlePanel.insets = new Insets(5, 5, 5, 5);
		gbc_titlePanel.gridx = 0;
		gbc_titlePanel.gridy = 0;
		add(titlePanel, gbc_titlePanel);
		GridBagLayout gbl_titlePanel = new GridBagLayout();
		gbl_titlePanel.columnWidths = new int[]{615, 0};
		gbl_titlePanel.rowHeights = new int[]{33, 23, 0};
		gbl_titlePanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_titlePanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		titlePanel.setLayout(gbl_titlePanel);
		
		JLabel lblNewLabel = new JLabel("Update/Create a Project");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		titlePanel.add(lblNewLabel, gbc_lblNewLabel);
		
		enterNameField = new JTextField();
		enterNameField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		enterNameField.setText("Enter Name...");
		GridBagConstraints gbc_enterNameField = new GridBagConstraints();
		gbc_enterNameField.fill = GridBagConstraints.BOTH;
		gbc_enterNameField.gridx = 0;
		gbc_enterNameField.gridy = 1;
		titlePanel.add(enterNameField, gbc_enterNameField);
		enterNameField.setColumns(10);
		
		JPanel centerPanel1 = new JPanel();
		GridBagConstraints gbc_centerPanel1 = new GridBagConstraints();
		gbc_centerPanel1.fill = GridBagConstraints.BOTH;
		gbc_centerPanel1.insets = new Insets(0, 5, 5, 5);
		gbc_centerPanel1.gridx = 0;
		gbc_centerPanel1.gridy = 1;
		add(centerPanel1, gbc_centerPanel1);
		centerPanel1.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel imagePanel = new JPanel();
		centerPanel1.add(imagePanel);
		GridBagLayout gbl_imagePanel = new GridBagLayout();
		gbl_imagePanel.columnWidths = new int[]{0, 0};
		gbl_imagePanel.rowHeights = new int[]{123, 0, 0};
		gbl_imagePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_imagePanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		imagePanel.setLayout(gbl_imagePanel);
		
		JPanel imgPreviewPanel = new JPanel();
		GridBagConstraints gbc_imgPreviewPanel = new GridBagConstraints();
		gbc_imgPreviewPanel.insets = new Insets(0, 0, 5, 0);
		gbc_imgPreviewPanel.fill = GridBagConstraints.BOTH;
		gbc_imgPreviewPanel.gridx = 0;
		gbc_imgPreviewPanel.gridy = 0;
		imagePanel.add(imgPreviewPanel, gbc_imgPreviewPanel);
		
		JButton uploadImageButton = new JButton("Upload Image...");
		GridBagConstraints gbc_uploadImageButton = new GridBagConstraints();
		gbc_uploadImageButton.gridx = 0;
		gbc_uploadImageButton.gridy = 1;
		imagePanel.add(uploadImageButton, gbc_uploadImageButton);
		
		JPanel summPanel = new JPanel();
		centerPanel1.add(summPanel);
		summPanel.setLayout(new BorderLayout(0, 0));
		
		JTextArea summField = new JTextArea();
		summField.setText("Enter Summary Here...");
		summPanel.add(summField);
		
		JPanel selectablesPanel = new JPanel();
		centerPanel1.add(selectablesPanel);
		GridBagLayout gbl_selectablesPanel = new GridBagLayout();
		gbl_selectablesPanel.columnWidths = new int[]{121, 96, 0};
		gbl_selectablesPanel.rowHeights = new int[]{42, 38, 26, 0, 0};
		gbl_selectablesPanel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_selectablesPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		selectablesPanel.setLayout(gbl_selectablesPanel);
		
		JLabel diffLabel = new JLabel("Select Difficulty");
		GridBagConstraints gbc_diffLabel = new GridBagConstraints();
		gbc_diffLabel.fill = GridBagConstraints.VERTICAL;
		gbc_diffLabel.insets = new Insets(5, 5, 5, 5);
		gbc_diffLabel.gridx = 0;
		gbc_diffLabel.gridy = 0;
		selectablesPanel.add(diffLabel, gbc_diffLabel);
		
		JComboBox diffSelector = new JComboBox();
		diffSelector.setModel(new DefaultComboBoxModel(new String[] {"Easy", "Medium", "Hard"}));
		GridBagConstraints gbc_diffSelector = new GridBagConstraints();
		gbc_diffSelector.insets = new Insets(5, 5, 5, 5);
		gbc_diffSelector.fill = GridBagConstraints.BOTH;
		gbc_diffSelector.gridx = 1;
		gbc_diffSelector.gridy = 0;
		selectablesPanel.add(diffSelector, gbc_diffSelector);
		
		JLabel costLabel = new JLabel("Enter Cost");
		GridBagConstraints gbc_costLabel = new GridBagConstraints();
		gbc_costLabel.insets = new Insets(5, 5, 5, 5);
		gbc_costLabel.gridx = 0;
		gbc_costLabel.gridy = 1;
		selectablesPanel.add(costLabel, gbc_costLabel);
		
		costInput = new JTextField("(Input Int)");
		GridBagConstraints gbc_costInput = new GridBagConstraints();
		gbc_costInput.insets = new Insets(5, 5, 5, 5);
		gbc_costInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_costInput.ipady = 10;
		gbc_costInput.gridx = 1;
		gbc_costInput.gridy = 1;
		selectablesPanel.add(costInput, gbc_costInput);
		costInput.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Time Required");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		selectablesPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Minutes", "Hours", "Days", "Weeks", "Months"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		selectablesPanel.add(comboBox, gbc_comboBox);
		
		timeFrom = new JTextField();
		timeFrom.setText("From");
		GridBagConstraints gbc_timeFrom = new GridBagConstraints();
		gbc_timeFrom.insets = new Insets(5, 5, 0, 5);
		gbc_timeFrom.fill = GridBagConstraints.HORIZONTAL;
		gbc_timeFrom.gridx = 0;
		gbc_timeFrom.gridy = 3;
		selectablesPanel.add(timeFrom, gbc_timeFrom);
		timeFrom.setColumns(10);
		
		txtTo = new JTextField();
		txtTo.setText("To");
		GridBagConstraints gbc_txtTo = new GridBagConstraints();
		gbc_txtTo.insets = new Insets(5, 5, 5, 5);
		gbc_txtTo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTo.gridx = 1;
		gbc_txtTo.gridy = 3;
		selectablesPanel.add(txtTo, gbc_txtTo);
		txtTo.setColumns(10);
		
		JPanel projDescrPanel = new JPanel();
		GridBagConstraints gbc_projDescrPanel = new GridBagConstraints();
		gbc_projDescrPanel.fill = GridBagConstraints.BOTH;
		gbc_projDescrPanel.insets = new Insets(5, 5, 5, 5);
		gbc_projDescrPanel.gridx = 0;
		gbc_projDescrPanel.gridy = 2;
		add(projDescrPanel, gbc_projDescrPanel);
		projDescrPanel.setLayout(new BorderLayout(0, 0));
		
		JTextArea projDescField = new JTextArea();
		projDescField.setText("Enter Project Description Here...");
		projDescrPanel.add(projDescField);
		
		JPanel matToolsPanel = new JPanel();
		GridBagConstraints gbc_matToolsPanel = new GridBagConstraints();
		gbc_matToolsPanel.insets = new Insets(5, 5, 5, 5);
		gbc_matToolsPanel.fill = GridBagConstraints.BOTH;
		gbc_matToolsPanel.gridx = 0;
		gbc_matToolsPanel.gridy = 3;
		add(matToolsPanel, gbc_matToolsPanel);
		GridBagLayout gbl_matToolsPanel = new GridBagLayout();
		gbl_matToolsPanel.columnWidths = new int[]{334, 213, 0};
		gbl_matToolsPanel.rowHeights = new int[]{30, 0, 0};
		gbl_matToolsPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_matToolsPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		matToolsPanel.setLayout(gbl_matToolsPanel);
		
		JLabel materialLabel = new JLabel("Materials");
		materialLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_materialLabel = new GridBagConstraints();
		gbc_materialLabel.insets = new Insets(0, 0, 5, 5);
		gbc_materialLabel.gridx = 0;
		gbc_materialLabel.gridy = 0;
		matToolsPanel.add(materialLabel, gbc_materialLabel);
		
		JLabel toolLabel = new JLabel("Tools");
		toolLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_toolLabel = new GridBagConstraints();
		gbc_toolLabel.insets = new Insets(0, 0, 5, 0);
		gbc_toolLabel.gridx = 1;
		gbc_toolLabel.gridy = 0;
		matToolsPanel.add(toolLabel, gbc_toolLabel);
		
		JComboBox materialPicker = new JComboBox();
		materialPicker.setEditable(true);
		materialPicker.setModel(new DefaultComboBoxModel(new String[] {"Add a Material..."}));
		GridBagConstraints gbc_materialPicker = new GridBagConstraints();
		gbc_materialPicker.insets = new Insets(0, 0, 0, 5);
		gbc_materialPicker.fill = GridBagConstraints.HORIZONTAL;
		gbc_materialPicker.gridx = 0;
		gbc_materialPicker.gridy = 1;
		matToolsPanel.add(materialPicker, gbc_materialPicker);
		
		JComboBox toolPicker = new JComboBox();
		toolPicker.setEditable(true);
		toolPicker.setModel(new DefaultComboBoxModel(new String[] {"Add a Tool..."}));
		GridBagConstraints gbc_toolPicker = new GridBagConstraints();
		gbc_toolPicker.fill = GridBagConstraints.HORIZONTAL;
		gbc_toolPicker.gridx = 1;
		gbc_toolPicker.gridy = 1;
		matToolsPanel.add(toolPicker, gbc_toolPicker);
		
		JPanel instrPanel = new JPanel();
		GridBagConstraints gbc_instrPanel = new GridBagConstraints();
		gbc_instrPanel.insets = new Insets(5, 5, 5, 5);
		gbc_instrPanel.fill = GridBagConstraints.BOTH;
		gbc_instrPanel.gridx = 0;
		gbc_instrPanel.gridy = 4;
		add(instrPanel, gbc_instrPanel);
		GridBagLayout gbl_instrPanel = new GridBagLayout();
		gbl_instrPanel.columnWidths = new int[]{382, 233, 0};
		gbl_instrPanel.rowHeights = new int[]{76, 0};
		gbl_instrPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_instrPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		instrPanel.setLayout(gbl_instrPanel);
		
		JComboBox instrPicker = new JComboBox();
		instrPicker.setModel(new DefaultComboBoxModel(new String[] {"Enter Instructions Here..."}));
		instrPicker.setToolTipText("");
		instrPicker.setEditable(true);
		GridBagConstraints gbc_instrPicker = new GridBagConstraints();
		gbc_instrPicker.insets = new Insets(0, 0, 0, 5);
		gbc_instrPicker.fill = GridBagConstraints.HORIZONTAL;
		gbc_instrPicker.gridx = 0;
		gbc_instrPicker.gridy = 0;
		instrPanel.add(instrPicker, gbc_instrPicker);
		
		JPanel controlPanel = new JPanel();
		controlPanel.getLayout();
		GridBagConstraints gbc_controlPanel = new GridBagConstraints();
		gbc_controlPanel.gridx = 1;
		gbc_controlPanel.gridy = 0;
		instrPanel.add(controlPanel, gbc_controlPanel);
		
		JButton clearButton = new JButton("Clear");
		controlPanel.add(clearButton);
		
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myProject.setName(enterNameField.getText());
				myProject.setDescription(projDescField.getText());
				myProject.setDifficulty(diffLabel.getText());
				myProject.getProjectFinances().setCost(Double.parseDouble(costInput.getText()));			
			}
		});
		controlPanel.add(saveButton);
		
		JButton quitButton = new JButton("Quit");
		controlPanel.add(quitButton);

	}

}
