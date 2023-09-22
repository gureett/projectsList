import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring String Value and asking User for Input
    String strPass = JOptionPane.showInputDialog(null, "Enter your password:", "Password", JOptionPane.INFORMATION_MESSAGE);

    // Checkin gif the String equals a certain value then running code
    if (strPass.equals("Password")) {
      
      JOptionPane.showMessageDialog(null, "Welcome Agent!", "Agent", JOptionPane.INFORMATION_MESSAGE);
      
    }

      // Checking if the String value is another value than the one before
    else if (strPass.equals("AgentX")) {
      JOptionPane.showMessageDialog(null, "Welcome Agent 2!", "Agent 2", JOptionPane.INFORMATION_MESSAGE);
    }

    // if both ifs don't go through then show a message dialog
    else {
      JOptionPane.showMessageDialog(null, "Wrong Password", "Agent", JOptionPane.ERROR_MESSAGE);
      // Restarts the program
      main(args);
    }
  }
}