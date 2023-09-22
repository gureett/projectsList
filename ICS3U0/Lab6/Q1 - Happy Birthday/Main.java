// Name: Gureet Kharod
// Date: October 27th / 2022
// Desc: Says happy birthday to the user

// Importing Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    String userInput;

    userInput = JOptionPane.showInputDialog(null, "What is your  name?", "Name", JOptionPane.PLAIN_MESSAGE);

    // Nested Loop
    for (int i = 0; i < 3; i++) {
      for (int j = i; j == 2; j++) {
        hbu(userInput);
      }
      hb();
    }
  }
  public static void hb() {
    // Says happy birthday
    JOptionPane.showMessageDialog(null, "Happy Birthday to you!", "Happy Birthday", JOptionPane.PLAIN_MESSAGE);
  }
  public static void hbu(String name) {
    // Happy Birthday with User
    JOptionPane.showMessageDialog(null, "Happy Birthday Dear " + name, "Happy Birthday", JOptionPane.PLAIN_MESSAGE);
  }
}