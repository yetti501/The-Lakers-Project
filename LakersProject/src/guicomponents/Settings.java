package guicomponents;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Main controller class for the application, sets up the GUI and its related components.
 * @author Lakers Project Team
 */

//This class is not used but was helpful becuase we were trying
//to create a settings panel.This was helpful becuase its good
//for practice in order to create frames, jpanels, jlabels.
public class Settings extends JFrame {

String userWord = "";
JTextField userInput;

public Settings() {
JFrame frame = new JFrame();
JPanel panel = new JPanel();
JLabel lable = new JLabel(" ");
JButton jButton = new JButton(" ");
userInput = new JTextField("", 30);
jButton.addActionListener( (e) -> {
   Action();
});
frame.setSize(300, 300);
//frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(panel);
panel.add(lable);
panel.add(userInput);
panel.add(jButton);
}

private void Action() {
userWord = userInput.getText();

}

public static void main(String[] args) {
new Settings();
}
}
