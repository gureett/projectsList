
// Date: October 27th / 2022
// Desc: Add Tax to the final price

// Importing Swing
import javax.swing.*;
import java.text.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    double userInput, finalPrice;

    // Number Format
    NumberFormat nf = NumberFormat.getCurrencyInstance();
    
    // Getting the user input for the price
    userInput = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the price!", "Price", JOptionPane.PLAIN_MESSAGE));

    // Calling the function
    finalPrice = tax(userInput);

    // Outputting
    JOptionPane.showMessageDialog(null, "Your total with tax is " + nf.format(finalPrice), "Final Price", JOptionPane.PLAIN_MESSAGE);
  }
  
  public static double tax(double input) {
    // Find the calculations
    double total = input * 1.13;
    return total;
  }
}