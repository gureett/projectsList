/*
Date: November 30th / 2022
Desc: Imports the precipitation from a file and then sorts them by precipitation and then ask the user which month and then after if they want to update the information
*/

// Importing Swing and Java IO
import javax.swing.*;
import java.io.*;
import java.text.*;

class Main {
  public static void main(String[] args) {
    // Try Catch to catch the IO Exceptions
    try {
      // Making the file reader and buffered reader
      BufferedReader input = new BufferedReader(new FileReader("data.txt"));

      // Declaring the variables needed
      String[] month = new String[12];
      double[] precipitation = new double[12];
      double sum = 0;
      double avg;

      // For Loop to feed this information into the arrays
      for (int i = 0; i < month.length; i++) {
        // Importing values into the corresponding arrays
        month[i] = input.readLine();
        precipitation[i] = Double.parseDouble(input.readLine());
        // Adds to sum to find the average precipitation later
        sum = sum + precipitation[i];
      }

      // Closes the File Reader and Buffered Reader
      input.close();

      // Finds the average precipitation
      avg = sum / month.length;

      // Sorts it by the amount of precipitation
      sortPrecip(month, precipitation);

      // Outputs to the file
      printFile(month, precipitation, avg);

      // Asks user what they want to search for
      askUser(month, precipitation, avg);
    }
    catch (IOException e) {
      // Displys an error
      JOptionPane.showMessageDialog(null, "Please recheck the contents of the text file!", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
  }

  public static void askUser(String[] m, double[] p, double avg) {
    // Declaring Variables needed
    String userInput;
    boolean isFound = false;
    double sum = 0;

    // Getting the users input
    userInput = JOptionPane.showInputDialog(null, "Please enter the month you would like to search the precipitation for!", "Precipitation Finder", JOptionPane.PLAIN_MESSAGE);

    for (int i = 0; i < m.length; i++) {
      if (userInput.equalsIgnoreCase(m[i])) {
        String ui = JOptionPane.showInputDialog(null, "The precipitation for " + m[i] + " is " + p[i] + "mm" + "\n Would you like to change the precipitation? (YES or NO)", "Precipitation Found!", JOptionPane.PLAIN_MESSAGE);
        if (ui.equalsIgnoreCase("yes")) {
          try {
            double updatedP = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the new precipitation value", "Precipitation Updater", JOptionPane.PLAIN_MESSAGE));
            p[i] = updatedP;
            for (int j = 0; j < m.length; j++) {
              sum = sum + p[j];
            }
            double average = sum / m.length;
            sortPrecip(m, p);
            printFile(m,p,average);
            JOptionPane.showMessageDialog(null, "Info have been updated!", "Updated", JOptionPane.INFORMATION_MESSAGE);
          }
          catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter a proper value!", "ERROR", JOptionPane.ERROR_MESSAGE);
          }
        }
        isFound = true;
        break;
      }
    }

    if (isFound == false) {
      JOptionPane.showMessageDialog(null, "The month you have entered has not been found! \n Please recheck the spelling and try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
  } 
 
  public static void printFile(String[] m, double[] p, double avg) {
    try {
      String out = "";
      // Declaring the File Writer
      PrintWriter output = new PrintWriter(new FileWriter("output.txt"));
      NumberFormat nf = NumberFormat.getInstance();

      // For Loop to print to the output file
      for (int i = 0; i < m.length; i++) {
        output.println(m[i]);
        output.println(p[i] + "mm");
        out = out + m[i] + ": " + p[i] + "mm" + "\n";
      }
      // Prints out the average rainfall amount
      output.println("Average Rainfall:");
      output.println(nf.format(avg) + "mm");
      output.println("Minimum Rainfall Amount:");
      output.println(p[0]);
      output.println("Maximum Rainfall Amount:");
      output.println(p[p.length - 1]);
      out = out + "Average Rainfall: " + nf.format(avg) + "mm" + "\n" + "Minimum Rainfall Amount: " + p[0] + "mm" + "\nMaximum Rainfall Amount: " + p[p.length - 1] + "mm";

      JOptionPane.showMessageDialog(null, out, "Output Data", JOptionPane.PLAIN_MESSAGE);

      // Closes the PrintWriter
      output.close();
    }
    catch (IOException e) {
      
    }
  }

  public static void sortPrecip(String[] m, double[] p) {
    // First for loop for bubble sort
    for (int i = 0; i < m.length - 1; i++) {
      for (int j = 0; j < m.length - 1; j++) {
        if (p[j] > p[j+1]) {
          // Puts the value in a temp variable
          double tempP = p[j];
          // Swaps the values
          p[j] = p[j+1];
          p[j+1] = tempP;

          // Puts the value in a temp variable
          String tempM = m[j];
          // Swaps the values
          m[j] = m[j+1];
          m[j+1] = tempM;
        }
      }
    }
  }
}