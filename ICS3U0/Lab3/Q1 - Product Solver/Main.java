//Date: September 21/2022
//Desc: 

// Importing Swing Library
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring variables needed
    double dblFirstNum, dblSecondNum, dblThirdNum, dblProduct, dblCorrectAns;
    int intResult;

    // Declaring Multiple Input Fields for future input dialog
    JTextField FnField = new JTextField(5);
    JTextField SnField = new JTextField(5);
    JTextField TnField = new JTextField(5);
    JTextField PrField = new JTextField(5);

    // Customizing JPanel for input dialog
    JPanel myPanel = new JPanel();
    myPanel.add(new JLabel("#1:")); // Giving user instruction
    myPanel.add(FnField); // Adding Declared Input Field
    myPanel.add(new JLabel("#2:")); // Giving user instruction
    myPanel.add(SnField); // Adding Declared Input Field
    myPanel.add(new JLabel("#3:")); // Giving user instruction
    myPanel.add(TnField); // Adding Declared Input Field
    myPanel.add(new JLabel("Product:")); // Giving user instruction
    myPanel.add(PrField); // Adding Declared Input Field

    // Getting Integer Value for Confirm Dialog
    intResult = JOptionPane.showConfirmDialog(null, myPanel, "Product Calc", JOptionPane.OK_OPTION);

    // If Results integer value is equal to the OK option then continue
    if (intResult == JOptionPane.OK_OPTION) {
      // Giving declared variables there values.
      dblFirstNum = Double.parseDouble(FnField.getText());
      dblSecondNum = Double.parseDouble(SnField.getText());
      dblThirdNum = Double.parseDouble(TnField.getText());
      dblProduct = Double.parseDouble(PrField.getText());

      // Finding the correct product
      dblCorrectAns = dblFirstNum * dblSecondNum * dblThirdNum;
      // Checking if the user answer is correct if so then telling the user
      if (dblProduct == dblCorrectAns) {
        JOptionPane.showMessageDialog(null, "You got the correct answer of " + dblCorrectAns, "Correct Answer!", JOptionPane.INFORMATION_MESSAGE);
      }
        // If the answer was wrong then it tells th euser and lets them know
      else {
        JOptionPane.showMessageDialog(null, "You got the wrong answer of " + dblProduct + "\nThe correct answer is " + dblCorrectAns, "Wrong Answer!", JOptionPane.INFORMATION_MESSAGE);
      }
    }
      // If they didn't click OK for the first JOptionPane then it exits the program
      else {
        System.exit(0);
    }
  }
}