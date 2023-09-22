// Date: September 22/2022
// Desc: Checks the speed the user was going and gives an appropriate fine

// Importing swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring variables needed
    double dblSpeed;

    // Showing input dialog and asking user for their speed
    dblSpeed = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the speed you were going without km/h", "Speeding Calculator", JOptionPane.INFORMATION_MESSAGE));

    // Using if statements to see if it is a valid speed
    if (dblSpeed < 0) {
      // Telling user the speed is invalid and restarting the program
      JOptionPane.showMessageDialog(null, "Please enter a valid speed", "False Information", JOptionPane.ERROR_MESSAGE);
      main(args);
    }

    else {
      // Checking the speed given and what fine they should get accordingly.
      if (dblSpeed >= 141) {
        JOptionPane.showMessageDialog(null, "You have a $500 fine for going " + dblSpeed + "km/h.", "Fine", JOptionPane.INFORMATION_MESSAGE);
      }
      else if (dblSpeed >= 131) {
        JOptionPane.showMessageDialog(null, "You have a $300 fine for going " + dblSpeed + "km/h.", "Fine", JOptionPane.INFORMATION_MESSAGE);
      }
      else if (dblSpeed >= 121) {
        JOptionPane.showMessageDialog(null, "You have a $150 fine for going " + dblSpeed + "km/h.", "Fine", JOptionPane.INFORMATION_MESSAGE);
      }
      else if (dblSpeed >= 101) {
        JOptionPane.showMessageDialog(null, "You have a $80 fine for going " + dblSpeed + "km/h.", "Fine", JOptionPane.INFORMATION_MESSAGE);
    }
      else {
        JOptionPane.showMessageDialog(null, "You have a recieved no fine for going " + dblSpeed + "km/h.", "No Fine", JOptionPane.INFORMATION_MESSAGE);
      }
    }
  }
}
