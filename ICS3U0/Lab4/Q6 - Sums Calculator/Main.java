// Date: September 27th / 2022
// Description: Calculates the sum of two numbers and the numbers between them

// Importing Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    Integer intNum1, intNum2, intNum, intResult;
    Integer intSum = 0;

    // Declaring Multiple Input Fields for future inputs
    JTextField intNum1Field = new JTextField(5);
    JTextField intNum2Field = new JTextField(5);

    // Declaring new panel for input dialog
    JPanel myPanel = new JPanel();
    myPanel.add(new JLabel("Please enter 2 Numbers:"));
    myPanel.add(new JLabel("Number 1:")); // Giving user instruction
    myPanel.add(intNum1Field); // Adding Declared Input Field
    myPanel.add(new JLabel("Number 2:")); // Giving user instruction
    myPanel.add(intNum2Field); // Adding Declared Input Field

    // Getting Integer Value for Confirm Dialog
    intResult = JOptionPane.showConfirmDialog(null, myPanel, "Please Enter Two Numbers", JOptionPane.OK_OPTION);
    
    // If Results integer value is equal to the OK option then continue
    if (intResult == JOptionPane.OK_OPTION) {
      // Giving declared variables there values.
      intNum1 = Integer.parseInt(intNum1Field.getText());
      intNum2 = Integer.parseInt(intNum2Field.getText());

      // Creating For Loop to add all the numbers in between
      for (intNum = intNum1; intNum <= intNum2; intNum++) {
        intSum = intSum + intNum;
      }

      // Showing the User the output
      JOptionPane.showMessageDialog(null, "The sum of the numbers are: " + intSum, "Sum Finder",  JOptionPane.PLAIN_MESSAGE);
    }
    else {
      System.exit(0);
    }
  }
}