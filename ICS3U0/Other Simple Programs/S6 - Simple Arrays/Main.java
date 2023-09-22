// Date: November, 14th/2022
// Desc: In Class Arrays Lesson

// Importing Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    String student[] = new String[5];
    int i, marks[] = new int[5];

    for (i = 0; i < marks.length; i++) {
      student[i] = JOptionPane.showInputDialog("Please enter your name");
      marks[i] = Integer.parseInt(JOptionPane.showInputDialog("Please enter a mark:"));
    }
    for (i = 0; i < marks.length; i++) {
      JOptionPane.showMessageDialog(null, student[i] + "has a mark of: " + marks[i]);
    }
  }
}