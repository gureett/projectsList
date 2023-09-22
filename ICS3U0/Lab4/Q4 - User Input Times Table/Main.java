// Date: September 27th / 2022
// Description: Asks user for which time tables they would like to learn

// Importing Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    int i, intAns, intUserInput;
    String strOutput = "";

    // Showing input dialog for the user to enter which times table they would like to learn
    intUserInput = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the integer you would like to learn the times table for!", "Times Tables", JOptionPane.PLAIN_MESSAGE));

    // Creating a for loop for every combination
    for (i = 0 ; i <= 12; i++) {
      // Doing the Math for the times table
      intAns = intUserInput * i;

      // Putting all values in a string
      strOutput = strOutput + intUserInput + " x " + i + " = " + intAns + "\n";
    }

    // Showing the user the output of all the answer
    JOptionPane.showMessageDialog(null, strOutput, "Times Tables", JOptionPane.PLAIN_MESSAGE);
  }
}