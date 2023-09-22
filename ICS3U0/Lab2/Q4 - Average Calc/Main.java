// Date: September 16th / 2022
// Description: A Calculator to find the average of marks from 4 user inputs

import javax.swing.*;
import java.text.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    Double dblFirstMark, dblSecondMark, dblThirdMark, dblFourthMark, dblAvgMark;
    int Result;

    // Declaring Number Formatting
    NumberFormat num = NumberFormat.getInstance();
    num.setMaximumFractionDigits(0);

    // Declaring Multiple Input Fields for future input dialog
    JTextField fmField = new JTextField(5);
    JTextField smField = new JTextField(5);
    JTextField tmField = new JTextField(5);
    JTextField fhmField = new JTextField(5);

    // Declaring new panel for input dialog
    JPanel myPanel = new JPanel();
    myPanel.add(new JLabel("1st Mark:")); // Giving user instruction
    myPanel.add(fmField); // Adding Declared Input Field
    myPanel.add(new JLabel("2nd Mark:")); // Giving user instruction
    myPanel.add(smField); // Adding Declared Input Field
    myPanel.add(new JLabel("3rd Mark:")); // Giving user instruction
    myPanel.add(tmField); // Adding Declared Input Field
    myPanel.add(new JLabel("4th Mark:")); // Giving user instruction
    myPanel.add(fhmField); // Adding Declared Input Field

    // Getting Integer Value for Confirm Dialog
    Result = JOptionPane.showConfirmDialog(null, myPanel, "Average Mark Calculator", JOptionPane.OK_OPTION);

    // If Results integer value is equal to the OK option then continue
    if (Result == JOptionPane.OK_OPTION) {
      // Giving declared variables there values.
      dblFirstMark = Double.parseDouble(fmField.getText());
      dblSecondMark = Double.parseDouble(smField.getText());
      dblThirdMark = Double.parseDouble(tmField.getText());
      dblFourthMark = Double.parseDouble(fhmField.getText());

      //Doing the Math Calculations to find Mean which is a type of Average
      dblAvgMark = dblFirstMark + dblSecondMark + dblThirdMark + dblFourthMark;
      dblAvgMark = dblAvgMark / 4;

      // Showing the final output of the average marks and it is formatted
      JOptionPane.showMessageDialog(null, "The average for your marks are " + num.format(dblAvgMark) + "%", "Average Mark Calculator", JOptionPane.INFORMATION_MESSAGE);
    }
  }
}