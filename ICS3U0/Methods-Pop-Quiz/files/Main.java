/* 
Date: Nov, 10/2022
Description: Checks the weight of the bag and then gives the proper output
*/

// Importing Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    double userInput;
    String weightMsg;
    // Getting Users Input for the Weight
    userInput = Double.parseDouble(JOptionPane.showInputDialog(null,"Please enter the weight of your baggage", "Baggage Check", JOptionPane.PLAIN_MESSAGE));
    
    // Sending to the converting function
    weightMsg = convertWeightToMessage(userInput);

    // Displaying final output
    JOptionPane.showMessageDialog(null, weightMsg, "Baggage Check", JOptionPane.PLAIN_MESSAGE);
  }

  // Function Class to convert Weight into the proper Message and send it back
  public static String convertWeightToMessage(double weight) {
    // Declaring Variables
    String msg;
    double price;

    // If Statement to check the weight of the bag
    if (weight < 0) {
      // Giving the variable the output
      msg = "Error! Invalid Weight";
    }
    else if (weight >= 0 && weight <= 15) {
      // Giving the variable the output
      msg = "Your baggage has a valid weight";
    }
    else if (weight >= 16 && weight <= 20) {
      // Doing the math calcuations for the fee
      price = weight - 15;
      price = price * 15;

      // Giving the variable the output
      msg = "Your bag is overweight! The fee you have to pay is $" + price;
    }
    else {
      // Giving the variable the output
      msg = "Overweight - Not Permitted";
    }
    // Return Statement
    return msg;
  }
}