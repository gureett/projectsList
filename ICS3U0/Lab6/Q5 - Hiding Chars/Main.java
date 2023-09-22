// Date: October 27th / 2022
// Desc: Hides the password

// Import Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    String userInput, out;

    // Getting users input
    userInput = JOptionPane.showInputDialog(null, "Please enter your phrase", "Enter Phrase", JOptionPane.PLAIN_MESSAGE);

    // Sending to the method
    out = hideChars(userInput);

    // Final Output
    JOptionPane.showMessageDialog(null, out, "Hidden", JOptionPane.PLAIN_MESSAGE);
  }

  public static String hideChars(String input) {
    // Declaring variables
    int length;
    String hidden = "";

    // Length of the string
    length = input.length();

    // For loop to replace the text with stars
    for (int i = 0; i != length; i++) {
      if(isASpace(input.charAt(i)) == true) {
        hidden = hidden + " ";
      }
      else {
        hidden = hidden + "*";
      }
    }

    return hidden;
  }

  public static Boolean isASpace(char check) {
    if (check == ' ') {
      return true;
    }
    else {
      return false;
    }
  }
}