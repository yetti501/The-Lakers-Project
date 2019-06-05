package guicomponents;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
