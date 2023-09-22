// Date: October 27th / 2022
// Desc: Mark Converter

// Importing Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    ask();
  }
  public static void ask() {
    double option, dblUserInput;
    String strUserInput;
    
    // Asking for which option they would like
    option = Double.parseDouble(JOptionPane.showInputDialog(null, "Press 1 to convert from Letter/Number to Percentage, 2 to convert from Percentage to Letter, or 3 to exit", "Mark Converter", JOptionPane.PLAIN_MESSAGE));

    if (option == 1) {
      strUserInput = userInput();
      LetterToPercentage(strUserInput);
    }
    else if (option == 2) {
      dblUserInput = Double.parseDouble(userInput());
      // If Statement to call isValid function and check if its valid and if so then it will run the converter
    if (isValid(dblUserInput) == true) {
      PercentageToLetter(dblUserInput);
    } 
    else {
      JOptionPane.showMessageDialog(null, "Please enter a valid number", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    }
    else if (option == 3) {
      System.exit(0);
    }
    else {
      JOptionPane.showMessageDialog(null, "Please enter a valid option", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    ask();
  }
  public static String userInput() {
    // Declaring Variables
    String userInput = JOptionPane.showInputDialog(null, "Please enter your Mark", "Mark Converter", JOptionPane.PLAIN_MESSAGE);
    return userInput;
  }

  public static boolean isValid(double input) {
    // Checking if the input is between 0 and 100
    if (input >= 0 && input <= 100) {
      return true;
    }
    return false;
  }

  public static void PercentageToLetter(double mark) {
    // If Statement to find the correct output
    if (mark < 50) {
      JOptionPane.showMessageDialog(null, "You got an R", "Mark", JOptionPane.PLAIN_MESSAGE);
    } 
    else if (mark < 60) {
      JOptionPane.showMessageDialog(null, "You got an D", "Mark", JOptionPane.PLAIN_MESSAGE);
    } 
    else if (mark < 70) {
      JOptionPane.showMessageDialog(null, "You got an C", "Mark", JOptionPane.PLAIN_MESSAGE);
    } 
    else if (mark < 80) {
      JOptionPane.showMessageDialog(null, "You got an B", "Mark", JOptionPane.PLAIN_MESSAGE);
    } 
    else {
      JOptionPane.showMessageDialog(null, "You got an A", "Mark", JOptionPane.PLAIN_MESSAGE);
    }

  }

  public static void LetterToPercentage(String mark) {
    // If Statement to find the correct output
    if (mark.equals("R")) {
      JOptionPane.showMessageDialog(null, "You got a Mark Range of between 0 and 49", "Mark", JOptionPane.PLAIN_MESSAGE);
    } 
    else if (mark.equals("1-") || mark.equals("D-")) {
      JOptionPane.showMessageDialog(null, "You got a Mark Range of between 50 and 54", "Mark", JOptionPane.PLAIN_MESSAGE);
    } 
    else if (mark.equals("1+") || mark.equals("D+")) {
      JOptionPane.showMessageDialog(null, "You got a Mark Range of between 55 and 59", "Mark", JOptionPane.PLAIN_MESSAGE);
    }
    else if (mark.equals("2-") || mark.equals("C-")) {
      JOptionPane.showMessageDialog(null, "You got a Mark Range of between 60 and 64", "Mark", JOptionPane.PLAIN_MESSAGE);
    } 
    else if (mark.equals("2+") || mark.equals("C+")) {
      JOptionPane.showMessageDialog(null, "You got a Mark Range of between 65 and 69", "Mark", JOptionPane.PLAIN_MESSAGE);
    } 
    else if (mark.equals("3-") || mark.equals("B-")) {
      JOptionPane.showMessageDialog(null, "You got a Mark Range of between 70 and 74", "Mark", JOptionPane.PLAIN_MESSAGE);
    } 
    else if (mark.equals("3+") || mark.equals("B+")) {
      JOptionPane.showMessageDialog(null, "You got a Mark Range of between 75 and 79", "Mark", JOptionPane.PLAIN_MESSAGE);
    } 
    else if (mark.equals("4-") || mark.equals("A-")) {
      JOptionPane.showMessageDialog(null, "You got a Mark Range of between 80 and 90", "Mark", JOptionPane.PLAIN_MESSAGE);
    } 
    else if (mark.equals("4+") || mark.equals("A+")) {
      JOptionPane.showMessageDialog(null, "You got a Mark Range of between 91 and 100", "Mark", JOptionPane.PLAIN_MESSAGE);
    } 
    else {
      JOptionPane.showMessageDialog(null, "Please enter a valid mark!", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}