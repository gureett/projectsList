//Date: October 18th/2022
//Description:

//Import Swing
import javax.swing.*;
import java.text.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    double userInput, rwNum, sqrtNum, pwrNum;

    // Declares the Number Format
    NumberFormat nf=NumberFormat.getInstance();
    nf.setMaximumFractionDigits(2);

    // Asking for user input
    userInput = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter a number", "Enter a Number", JOptionPane.QUESTION_MESSAGE));

    // Outputting rounded whole number
    rwNum = Math.round(userInput);
    JOptionPane.showMessageDialog(null, userInput + " rounded to a whole number is " + rwNum, "Rounded To Whole Number", JOptionPane.PLAIN_MESSAGE);

    // Outputting number rounded to 2 decimals
    JOptionPane.showMessageDialog(null, userInput + " rounded to 2 decimal places is " + nf.format(userInput), "Rounded to 2 Decimals", JOptionPane.PLAIN_MESSAGE);

    // Outputting the square root of the number
    sqrtNum = Math.sqrt(userInput);
    JOptionPane.showMessageDialog(null, userInput + " square rooted is " + sqrtNum, "Square Rooted Number", JOptionPane.PLAIN_MESSAGE);

    // Outputting the answer to the power of the number
    pwrNum = Math.pow(userInput, 5);
    JOptionPane.showMessageDialog(null, userInput + " raised to the power of 5 is " + pwrNum, "Raised Power", JOptionPane.PLAIN_MESSAGE);
  }
}