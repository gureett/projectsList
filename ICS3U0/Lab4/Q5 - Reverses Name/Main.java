// Date: Oct, 21/2022
// Desc: Writes name in reverse order

// Importing Java
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring variables
    String name, reverseName = "";
    int length;
    
    // Asking user for their name
    name = JOptionPane.showInputDialog(null, "What is your name?", "Name in Reverse Order", JOptionPane.QUESTION_MESSAGE);

    // Finding the length of their name
    length = name.length();

    // For Loop to write their name in reverse order no matter how long their name is
    for (int i = length; i != 0; i--) {
      reverseName = reverseName + name.substring(i - 1, i);
    }
    // Output
    JOptionPane.showMessageDialog(null, "Your name in reverse would be " + reverseName);
  }
}