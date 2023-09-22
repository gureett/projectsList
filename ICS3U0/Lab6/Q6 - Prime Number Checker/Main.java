// Date: October 27th / 2022
// Desc: Mark Converter

// Importing Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    askUser();
  }
  public static void askUser() {
    // Declaring the variables needed
    double dblUserInput;
    int intUserInput,option;
    Boolean isPrime;

    // Taking the users input
    option = Integer.parseInt(JOptionPane.showInputDialog(null, "Press 1 to check if it is a prime number, or 2 to exit", "Select", JOptionPane.PLAIN_MESSAGE));

    // Checking the option inputted
    if (option == 1) {
      // Taking the users input
    dblUserInput = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter a number to check if it is Prime Number", "Prime Check", JOptionPane.PLAIN_MESSAGE));

    // Convert to integer
    intUserInput = (int)dblUserInput;

    // Calling function to check if it is a prime number
    isPrime = isPrimeNum(dblUserInput);

    // If it is true then tell the user that otherwise tell them it is not a prime number
    if (isPrime == true) {
      JOptionPane.showMessageDialog(null, intUserInput + " is a prime number", "Prime Number", JOptionPane.PLAIN_MESSAGE);
    }
    else {
      JOptionPane.showMessageDialog(null, intUserInput + " is not a prime number", "Prime Number", JOptionPane.PLAIN_MESSAGE);
    }
    }
    else if (option == 2) {
      // exits
      System.exit(0);
    }
    else {
      JOptionPane.showMessageDialog(null, "Please enter a valid option!", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    askUser();
  }
  public static Boolean isPrimeNum(double n) {
    // Check if the number is less than or 1
    if (n <= 1) {
      return false;
    }
    //Checks if the number is 2
    if (n == 2) {
      return true;
    }
    // Check if it is a multiple of 2
    else if (n % 2 == 0) {
      return false;
    }
    // If not, then just check the odds
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
      if (n % i == 0)
        return false;
    }
    return true;
  }
}