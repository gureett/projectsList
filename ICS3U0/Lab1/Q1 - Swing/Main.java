import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    String Nm;
    String St;
    String Ct;
    String Ps;
    int Result;

    // Declaring Multiple Input Fields for future input dialog
    JTextField nmField = new JTextField(10);
    JTextField stField = new JTextField(10);
    JTextField ctField = new JTextField(10);
    JTextField psField = new JTextField(10);
     
    // Declaring new panel for input dialog
    JPanel myPanel = new JPanel();
    myPanel.add(new JLabel("Name:")); // Giving user instruction
    myPanel.add(nmField); // Adding Declared Input Field
    myPanel.add(Box.createVerticalStrut(15)); // Adding Vertical Spacer
    myPanel.add(new JLabel("Street:")); // Giving user instruction
    myPanel.add(stField); // Adding Declared Input Field
    myPanel.add(Box.createVerticalStrut(15)); // Adding Vertical Spacer
    myPanel.add(new JLabel("City:")); // Giving user instruction
    myPanel.add(ctField); // Adding Declared Input Field
    myPanel.add(Box.createVerticalStrut(15)); // Adding Vertical Spacer
    myPanel.add(new JLabel("Postal Code:")); // Giving user instruction
    myPanel.add(psField); // Adding Declared Input Field
    myPanel.add(Box.createVerticalStrut(15)); // Adding Vertical Spacer

    // Getting Integer Value for Confirm Dialog
    Result = JOptionPane.showConfirmDialog(null, myPanel, "Please enter your Name and Address:", JOptionPane.OK_OPTION);
    
    // If Results integer value is equal to the OK option then continue
    if (Result == JOptionPane.OK_OPTION) {
      // Giving declared variables there values.
      Nm = nmField.getText();
      St = stField.getText();
      Ct = ctField.getText();
      Ps = psField.getText();
      
      JOptionPane.showMessageDialog(null, "Name: " + Nm + "\nStreet: " + St + "\nCity: " + Ct + "\nPostal Code: " + Ps);
    }
  }
}