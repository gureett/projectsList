// Date: September 27th / 2022
// Description: Asks user for a password and if they get it correct then it lets them enter otherwise they have to ask the Network Admin

// Importing Swing/
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    String strPass;
    Integer Counter = 0;

    // Creating a Do While statement
    do {
      // Getting users input
      strPass = JOptionPane.showInputDialog(null, "Please enter your password!", "Password", JOptionPane.INFORMATION_MESSAGE);

      // Checking if the password is correct or not
      if (strPass.equals("SecretPassword")) {
        // End the do while statement
        Counter = 5;
      }
      else {
        Counter = Counter + 1;
        JOptionPane.showMessageDialog(null, "Incorrect Password! | Attempt: " + Counter + "/5", "Incorrect Password", JOptionPane.ERROR_MESSAGE);
      }
    }
    while (Counter != 5);
    // Checks if the user got the correct password or not
    if (strPass.equals("SecretPassword")) {
      // Tells user the password is accepted
      JOptionPane.showMessageDialog(null, "The password is accepted!", "Correct Password", JOptionPane.INFORMATION_MESSAGE);
    }
    else {
      // Tells the user the password is not accepted
      JOptionPane.showMessageDialog(null, "The password is not accepted! Please contact your Network Administrator", "Invalid Password", JOptionPane.ERROR_MESSAGE);
    }
  }
}