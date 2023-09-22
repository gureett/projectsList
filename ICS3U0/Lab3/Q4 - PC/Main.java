//Date: September 22/2022
//Desc: Giving prices depending on the user input

// Importing Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables needed\
    int intRam, intStorage;

    // Asking user for desired ram and storing in a variable
    intRam = Integer.parseInt(JOptionPane.showInputDialog("How much ram would you like in your Computer from 2,4,8 \n(Please enter just the number)"));

    // if they put in correct ram then it continues with asking for storage and then price otherwise it will say invalid option
    if (intRam == 8) {
      // Asking user for the amount of ram and then outputting the price
      intStorage = Integer.parseInt(JOptionPane.showInputDialog("How much Storage would you like? 160GB or 320GB"));
      if (intStorage == 160) {
        JOptionPane.showMessageDialog(null, "The price of a computer with " + intRam + "GB of Ram and " + intStorage + "GB of Storage is $999.99", "Price", JOptionPane.INFORMATION_MESSAGE);
      }
      else if (intStorage == 320) {
        JOptionPane.showMessageDialog(null, "The price of a computer with " + intRam + "GB of Ram and " + intStorage + "GB of Storage is $1229.99", "Price", JOptionPane.INFORMATION_MESSAGE);
     }
        // If invalid option then it tells user and restarts programs
      else {
        JOptionPane.showMessageDialog(null, "Please enter a valid storage option of 160 or 320", "Invalid Option", JOptionPane.ERROR_MESSAGE);
        main(args);
      }
    }

    else if (intRam == 4) {
      intStorage = Integer.parseInt(JOptionPane.showInputDialog("How much Storage would you like? 160GB or 320GB"));
      if (intStorage == 160) {
        JOptionPane.showMessageDialog(null, "The price of a computer with " + intRam + "GB of Ram and " + intStorage + "GB of Storage is $649.99", "Price", JOptionPane.INFORMATION_MESSAGE);
      }
      else if (intStorage == 320) {
        JOptionPane.showMessageDialog(null, "The price of a computer with " + intRam + "GB of Ram and " + intStorage + "GB of Storage is $899.99", "Price", JOptionPane.INFORMATION_MESSAGE);
     }
      else {
        JOptionPane.showMessageDialog(null, "Please enter a valid storage option of 160 or 320", "Invalid Option", JOptionPane.ERROR_MESSAGE);
        main(args);
      }
    }

    else if (intRam == 2) {
      intStorage = Integer.parseInt(JOptionPane.showInputDialog("How much Storage would you like? 160GB or 320GB"));
      if (intStorage == 160) {
        JOptionPane.showMessageDialog(null, "The price of a computer with " + intRam + "GB of Ram and " + intStorage + "GB of Storage is $599.99", "Price", JOptionPane.INFORMATION_MESSAGE);
      }
      else if (intStorage == 320) {
        JOptionPane.showMessageDialog(null, "The price of a computer with " + intRam + "GB of Ram and " + intStorage + "GB of Storage is $799.50", "Price", JOptionPane.INFORMATION_MESSAGE);
     }
      else {
        JOptionPane.showMessageDialog(null, "Please enter a valid storage option of 160 or 320", "Invalid Option", JOptionPane.ERROR_MESSAGE);
        main(args);
      }
    }
    // Telling user for invalid option and restarts the program
    else {
      JOptionPane.showMessageDialog(null, "Please enter a valid option from 2,4,8", "Invalid Option", JOptionPane.ERROR_MESSAGE);
      main(args);
    }
  }
}