// Name: Gureet Kharod
// Date: October 22nd / 2022
// Description: Does different conversions between different base types

// Importing Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Running askUser
    askUser();
  }

  // Asking for the users options
  public static void askUser() {
    // Declaring Variables Needed
    int userOption;

    // Asking user for their option
    userOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter 1 for Binary to Decimal, 2 for Decimal to Binary, 3 for Decimal to Hexadecimal, and 4 for Hexadecimal to Decimal or 5 to Exit", "Binary Converter", JOptionPane.PLAIN_MESSAGE));

    // Checking users option
    if (userOption == 1) {
      // Starts the Binary to Decimal converter
      bd();
    }
    else if (userOption == 2) {
      // Starts the Decimal to Binary Converter
      db();
    }
    else if (userOption == 3) {
      // Starts the Decimal to Hexadecimal Converter
      dh();
    }
    else if (userOption == 4) {
      // Starts the Hexadecimal to Decimal Converter
      hd();
    }
    else if (userOption == 5) {
      System.exit(0);
    }
    else {
      // Asks user to enter a valid option
      JOptionPane.showMessageDialog(null, "Please enter a valid option", "Invalid Option", JOptionPane.ERROR_MESSAGE);
      // Restarts the program
      askUser();
    }
  }

  // For converting from Binary To Decimal
  public static void bd() {
    // Declaring Variables | dblLeft are for numbers to the left of the decimal and dblRight are for numbers to the right of the decimal
    double dblUserInput, dblLeft = 0, dblRight = 0, dblFinal = 0;
    String strUserInput, strDigit, strDecimal;
    char num;
    int l1,l2,l3,l4,l5,index;

    // Asking for User Input
    strUserInput = JOptionPane.showInputDialog(null, "Please enter the binary number you would like to convert to Decimal", "Binary Converter", JOptionPane.PLAIN_MESSAGE);

    // Getting the length of the number
    l1 = strUserInput.length();

    // Checking if there is a decimal place or not
    if (strUserInput.contains(".")) {
      // Finding the position of the decimal to split into two four loops
      index = strUserInput.indexOf(".");
      l2 = index - 1;
      // First for loop for all the numbers to the left of the decimal
      for (int i = 0; i != index; i++) {
        // Gets the digit at a certain position from a string and into a character format
        num = strUserInput.charAt(l2);
        // Takes the character and converts it to a string to be used with parseDouble to turn into a double
        strDigit = Character.toString(num);
        dblUserInput = Double.parseDouble(strDigit);

        // Doing the math calculations
        dblLeft = dblLeft + (dblUserInput * Math.pow(2,i));

        // Changing Length 2 to find the next number going right to left
        l2 = l2 - 1;
      }
      // Getting just the numbers after the decimal
      strDecimal = strUserInput.substring(index + 1, l1);
      // Getting length for the numbers after the decimal
      l3 = strDecimal.length();
      l4 = l3;
      // Second for loop for all the numbers after the decimal
      for (int i = 1; i != l3 + 1; i++) {
        // Gets the digit at a certain position from a string and into a character format
        l5 = l3 - l4;
        num = strDecimal.charAt(l5);
        // Takes the character and converts it to a string to be used with parseDouble to turn into a double
        strDigit = Character.toString(num);
        dblUserInput = Double.parseDouble(strDigit);

        // Doing the math calculations
        dblRight = dblRight + (dblUserInput * Math.pow(2,-i));

        // Changing Length 2 to find the next number going right to left
        l4 = l4 - 1;
      }
      // Adding the two together
      dblFinal = dblLeft + dblRight;
    }
    else {
      // Because we need the end number
      l2 = l1 - 1;
      // For Loop to do the math
      for (int i = 0; i != l1; i++) {
        // Gets the digit at a certain position from a string and into a character format
        num = strUserInput.charAt(l2);
        // Takes the character and converts it to a string to be used with parseDouble to turn into a double
        strDigit = Character.toString(num);
        dblUserInput = Double.parseDouble(strDigit);

        // Doing the math calculations
        dblFinal = dblFinal + (dblUserInput * Math.pow(2,i));

        // Changing Length 2 to find the next number going right to left
        l2 = l2 - 1;
        
      }
    }
    // Outputs the final result
      JOptionPane.showMessageDialog(null, strUserInput + " in decimal is " + dblFinal, "Binary Converter", JOptionPane.PLAIN_MESSAGE);
    // Restarting the program
    askUser();
  }
  // For converting from Decimal to Binary
  public static void db() {
    // Declaring Variables
    double dblUserInput, dblDivide = 0, dblLeft = 0, dblRight = 0, dblMultiply = 0;
    String strUserInput, strCalc = "", strDecimal = "", strFinal = "";
    int l1,l2,index;

    // Asking for User Input
    strUserInput = JOptionPane.showInputDialog(null, "Please enter the Decimal number you would like to convert to Binary", "Binary Converter", JOptionPane.PLAIN_MESSAGE);

    // Checking if it contains a decimal or "."
    if (strUserInput.contains(".")) {
      // Getting the position of the period or decimal "."
      index = strUserInput.indexOf(".");

      // Getting the length of the number
      l2 = strUserInput.length();
      // Giving the value of the numbers to the left of the decimal and the numbers to the right of the decimal
      dblLeft = Double.parseDouble(strUserInput.substring(0, index));
      dblRight = Double.parseDouble(strUserInput.substring(index, l2));

      dblDivide = dblLeft;
      // Do While loop to do the calculations and add the final binary number to a string
      do {
        // Doing the Math Calculations
        dblDivide = (int)dblDivide;
        dblDivide = dblDivide / 2;
        // Checking if the result is an integer without a decimal or if it is a decimal number
        if ((dblDivide % 1) == 0) {
          strCalc = strCalc + "0";
        }
        else {
          strCalc = strCalc + "1";
        }
      }
      while (dblDivide != 0);
      // Getting the length of strCalc
      l1 = strCalc.length();
      l1 = l1 - 1;
      // Putting the numbers in reverse order since it is in the wrong order right now
      for (int i = l1; i != 0; i--) {
      strFinal = strFinal + strCalc.substring(i - 1, i);
      }

      // Giving the value to dblMultiply
      dblMultiply = dblRight;
      // Do While Loop to find the decimals in binary
      do {
        // Doing the math calculations
        dblMultiply = dblMultiply * 2;
        // If Else statement to check if there is a 1 or not
        if (dblMultiply < 1) {
          strDecimal = strDecimal + "0";
        }
        else {
          strDecimal = strDecimal + "1";
        }
      }
      while (dblMultiply < 1);
      // Getting the final value
      strFinal = strFinal + "." + strDecimal;
    }
    else {
      // Turning the string number into a double
      dblUserInput = Double.parseDouble(strUserInput);
      dblDivide = dblUserInput;
      // Do While loop to do the calculations and add the final binary number to a string
      do {
        // Doing the Math Calculations
        dblDivide = (int)dblDivide;
        dblDivide = dblDivide / 2;
        // Checking if the result is an integer without a decimal or if it is a decimal number
        if ((dblDivide % 1) == 0) {
          strCalc = strCalc + "0";
        }
        else {
          strCalc = strCalc + "1";
        }
      }
      while (dblDivide != 0);
      // Getting the length of the final string value
      l1 = strCalc.length();
      l1 = l1 - 1;
      // Putting the numbers in reverse as they are in the wrong order right now
      for (int i = l1; i != 0; i--) {
      strFinal = strFinal + strCalc.substring(i - 1, i);
      }
      
    }
    // Outputting the final binary number
    JOptionPane.showMessageDialog(null, strUserInput + " in binary is " + strFinal, "Binary Converter", JOptionPane.PLAIN_MESSAGE);
    // Restarting program
    askUser();
  }
  // For converting from Decimal to Hexadecimal
  public static void dh() {
    // Declaring Variables needed
    double num, r = 0, userInput;
    String decimal, strFinal = "", strOut = "";
    int l1, index, intNum;

    // Asking user for the Decimal number to be converted
    userInput = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the Decimal number you would like to convert to Hexadecimal", "Binary Converter", JOptionPane.PLAIN_MESSAGE));

    // Giving the value to num
    num = userInput;
    // Do While Loop
    do {
      // Doing the math calculations
      num = num / 16;
      // Putting into a string to seperate the decimal and non decimal numbers
      decimal = Double.toString(num);
      // Checking if there is a decimal since then it will be a remainder
      // Finding the length of the number and index of the decimal
      l1 = decimal.length();
      l1 = l1 - 1;
      index = decimal.indexOf(".");
      // Getting the values for the decimals to find remainder
      decimal = decimal.substring(index, l1);
      if (!decimal.equals(".")) {
        // Finding the remainder
        r = Double.parseDouble(decimal);
        r = Math.ceil(r * 16);
        // Checking if the remainder is greater than 10
        if (r >= 10) {
          // Checking which decimal corresponds with which hexadecimal letter
          if (r == 10) {
            strFinal = strFinal + "A";
          }
          else if (r == 11) {
            strFinal = strFinal + "B";
          }
          else if (r == 12) {
            strFinal = strFinal + "C";
          }
          else if (r == 13) {
            strFinal = strFinal + "D";
          }
          else if (r == 14) {
            strFinal = strFinal + "E";
          }
          else if (r == 15) {
            strFinal = strFinal + "F";
          }
        }
        else {
          intNum = (int)r;
          strFinal = strFinal + intNum;
        }
      }
      else {
        // To avoid the decimal
        strFinal = strFinal + "0";
      }
      num = (int)num;
    }
    while (num != 0);
    // Getting the length of the final string value
    l1 = strFinal.length();
    // Putting the numbers in reverse as they are in the wrong order right now
    for (int i = l1; i != 0; i--) {
      strOut = strOut + strFinal.substring(i - 1, i);
    }

     // Giving the Final Output
    JOptionPane.showMessageDialog(null, userInput + " in hexadecimal is " + strOut, "Binary Converter", JOptionPane.PLAIN_MESSAGE);
    // Restarting program
    askUser();
  }
  // For converting from Hexadecimal to Decimal
  public static void hd() {
    // Declaring Variables
    String userInput, strNum, strFinal;
    double num, dblFinal = 0;
    char a;
    int length, ctr = 0;

    // Asking for users input
    userInput = JOptionPane.showInputDialog(null, "Please enter the Hexadecimal number you would like to convert to Decimal", "Binary Converter", JOptionPane.PLAIN_MESSAGE);

    // Getting the length of the hexadecimal
    length = userInput.length();
    length = length - 1;

    // For Loop to convert from hexadecimal to decimal
    for (int i = length; i >= 0; i--) {
      // Getting the character at the position starting from the right going left
      a = userInput.charAt(i);
      // Turning the character into a string and all uppercase to check if its a letter or number
      strNum = Character.toString(a);
      strNum = strNum.toUpperCase();
      // Checking if the character gotten is a number or a letter and if a letter it will give it a proper value.
      if (strNum.equals("A")) {
        strNum = "10";
      }
      else if (strNum.equals("B")) {
        strNum = "11";
      }
      else if (strNum.equals("C")) {
        strNum = "12";
      }
      else if (strNum.equals("D")) {
        strNum = "13";
      }
      else if (strNum.equals("E")) {
        strNum = "14";
      }
      else if (strNum.equals("F")) {
        strNum = "15";
      }
      // Turning it into a double to use with calculations
      num = Double.parseDouble(strNum);

      // Doing the calculations
      dblFinal = dblFinal + (num * Math.pow(16,ctr));
      ctr = ctr + 1;
    }
    // Giving the final output
    JOptionPane.showMessageDialog(null, userInput + " in decimal is " + dblFinal, "Binary Converter", JOptionPane.PLAIN_MESSAGE);
    askUser();
  }
  
}