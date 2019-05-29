package guicomponents;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonClass {
	static JButton btnCreateProject = new JButton("Create Project");	
	static JButton btnMyProject = new JButton("My Project");
	static JButton btnFavoriteProject = new JButton("Favorite Project");
	static JButton btnRemoveProject = new JButton("Remove Project");
	static JButton btnImportProject = new JButton("Import Project");
	static JButton btnExportProject = new JButton("Export Project");
	static JButton btnUploadImage = new JButton("Upload Image");
	static JButton btnMaterialsAdd = new JButton("Add Materials");
	static JButton btnMaterialsRemove = new JButton("Remove Materials");
	static JButton btnToolsAdd = new JButton("Add Tools");
	static JButton btnToolsRemove = new JButton("Remove Tools");
	static JButton btnInstructionAdd = new JButton("Add Instruction");
	static JButton btnInstructionRemove = new JButton("Remove Instruction");
	static JButton btnSaveProject = new JButton("Save New Project");
	static JButton btnProjectInfo = new JButton("Info Panel");
	
	public static void addCreateProjectBtn(JPanel panel) { panel.add(btnCreateProject);	}
	public static void removeCreateProjectBtn(JPanel panel) { panel.remove(btnCreateProject); }
	public static void addMyProjectBtn(JPanel panel) { panel.add(btnMyProject); }
	public static void removeMyProjectBtn(JPanel panel) { panel.remove(btnMyProject); }
	public static void addFavoriteProjectBtn(JPanel panel) { panel.add(btnFavoriteProject); }
	public static void removeFavoriteProjectBtn(JPanel panel) { panel.remove(btnFavoriteProject); }
	public static void addRemoveProjectBtn(JPanel panel) { panel.add(btnRemoveProject); }
	public static void removeRemoveProjectBtn(JPanel panel) { panel.remove(btnRemoveProject); }
	public static void addImportProjectBtn(JPanel panel) { panel.add(btnImportProject); }
	public static void removeImportProjectBtn(JPanel panel) { panel.remove(btnImportProject); }
	public static void addExportProjectBtn(JPanel panel) {panel.add(btnExportProject); }
	public static void removeExportProjectBtn(JPanel panel) { panel.remove(btnExportProject); }
	public static void addUploadImageBtn(JPanel panel) { panel.add(btnUploadImage); }
	public static void removeUploadImageBtn(JPanel panel) { panel.remove(btnUploadImage); } 
	public static void addMaterialsAddBtn(JPanel panel) { panel.add(btnMaterialsAdd); }
	public static void removeMaterialsAddBtn(JPanel panel) { panel.remove(btnMaterialsAdd); }
	public static void addMaterialsRemoveBtn(JPanel panel) { panel.add(btnMaterialsRemove); }
	public static void removeMaterialsRemoveBtn(JPanel panel) {panel.remove(btnMaterialsRemove); }
	public static void addToolsAddBtn(JPanel panel) { panel.add(btnToolsAdd); }
	public static void removeToolsAddBtn(JPanel panel) { panel.remove(btnToolsAdd); }
	public static void addToolsRemoveBtn(JPanel panel) { panel.add(btnToolsRemove); }
	public static void removeToolsRemoveBtn(JPanel panel) { panel.remove(btnToolsRemove); }
	public static void addInstructionAddBtn(JPanel panel) { panel.add(btnInstructionAdd); }
	public static void removeInstructionAddBtn(JPanel panel) { panel.remove(btnInstructionAdd); }
	public static void addInstructionRemoveBtn(JPanel panel) { panel.add(btnInstructionRemove); }
	public static void removeInstructionRemoveBtn(JPanel panel) { panel.remove(btnInstructionRemove); }
	public static void addSaveProjectBtn(JPanel panel) { panel.add(btnSaveProject); }
	public static void removeSaveProjectBtn(JPanel panel) { panel.remove(btnSaveProject); }
	public static void addProjectInfo(JPanel panel) { panel.add(btnProjectInfo); }
	public static void removeProjectInfo(JPanel panel) { panel.remove(btnProjectInfo); }
}
