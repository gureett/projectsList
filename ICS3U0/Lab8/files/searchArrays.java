import javax.swing.*;
import java.io.*;
import java.text.*;

public class searchArrays {
  public static void findTaxPayer(String[] ceo, String[] business, double[] income, double[] tax, String userInput) {
    // Try Catch to avoid errors crashing the program
    try {
      String out = "";
      String[] reverse = sortArrays.alphaSort(ceo,business,income,tax);
      int spaces = 0;
      int length = userInput.length();

      // Number Format
      NumberFormat nf = NumberFormat.getCurrencyInstance();
    
      //Checking how many spaces there are in the sentence
      for (int i = 0; i < length; i++) {
        if (userInput.charAt(i) == ' ') {
          spaces = spaces + 1;
        }
      }
      // Adding an extra to spaces since the sentence ends in a period or something other than a space.
      spaces = spaces + 1;
      //Declaring User Reverse
      String[] userReverse = new String[spaces];
      // For Loop to split into the last names only
      for (int i = 0; i < spaces; i++) {
        // Splits the string wherever there is a space
        String[] split = userInput.split(" ",5);
        // Puts the last name to an array by the last item in the array
        userReverse[i] = split[split.length - 1];
        for (int j = 2; j <= split.length; j++) {
          userReverse[i] = userReverse[i] + " " + split[split.length - j];
        }
      }

      // Sends to binary search to check
      int[] result = binarySearch(reverse, ceo, userReverse[0]);

      // if result is -1 then the user input is not in the list
      if (result[0] == -1) {
        JOptionPane.showMessageDialog(null, "The name entered is not in the list | Try putting in the last name", "ERROR", JOptionPane.ERROR_MESSAGE);
      }
      else if (result.length > 1) {
        for (int i = 0; i < result.length; i++) {
          out = out + ceo[result[i]] + " makes " +  nf.format(income[result[i]]) + " and owes " +  nf.format(tax[result[i]]) + " in taxes." + "\n";
        }
        JOptionPane.showMessageDialog(null, out, "Tax Finder", JOptionPane.PLAIN_MESSAGE);
      }
      // Otherwise it is in the output
      else{
        JOptionPane.showMessageDialog(null, ceo[result[0]] + " makes " +  nf.format(income[result[0]]) + " and owes " +  nf.format(tax[result[0]]) + " in taxes.", "Tax Finder", JOptionPane.PLAIN_MESSAGE);
      }
    }
    catch (Exception e) {
      
    }
  }
  public static int[] binarySearch(String[] ceo, String[] ogCEO, String searchKey) {
    // Binary Search
    int low = 0;
    int high = ceo.length - 1;
    int middle;
    int counter = 0;

    // First while loop to find out how many multiple names
    while (low <= high) {
      middle = (high + low) / 2;
      // Checks if it contains the name
      if(ceo[middle].toLowerCase().contains(searchKey.toLowerCase())) {
        counter = counter + 1;
        // Checks for any names before if they are the same since otherwise the binary search won't get them
        for (int i = middle - 1; i != -1; i--) {
          if(ceo[i].toLowerCase().contains(searchKey.toLowerCase())) {
            counter = counter + 1;
          }
            // if not then it breaks the loop
          else {
            break;
          }
        }
        low = middle + 1;
      }
      // Otherwise it checks if it is less than
      else if (searchKey.toLowerCase().charAt(0) < ceo[middle].toLowerCase().charAt(0)) {
        high = middle - 1;
      }
      // Else
      else {
        low = middle + 1;
      }
    }
    // Checks counter value:
    if (counter == 0) {
      int[] notHere = {-1};
      return notHere;
    }
    // Resetting Variables Value
    high = ceo.length -1;
    low = 0;
    int[] multiple = new int [counter];
    multiple[0] = -1;
    counter = -1;
    
    // While Loop
    while(low <= high) {
      // Finds the middle value
      middle = (high + low) / 2;
      // If the lowercase first letters at the same then it will continue its check
      if (searchKey.toLowerCase().charAt(0) == ceo[middle].toLowerCase().charAt(0) || searchKey.toLowerCase().charAt(0) == ogCEO[middle].toLowerCase().charAt(0)) {
        // Checks if it is the same name
        if(ceo[middle].equalsIgnoreCase(searchKey)) {
          int[] returnValue = {middle};
          return returnValue;
        }
          // Checks if it contains
        else if(ceo[middle].toLowerCase().contains(searchKey.toLowerCase())) {
          counter = counter + 1;
          multiple[counter] = middle;
          // Checks if any of the same name appears before the current index
          for (int i = middle - 1; i != -1; i--) {
            if(ceo[i].toLowerCase().contains(searchKey.toLowerCase())) {
              counter = counter + 1;
              multiple[counter] = i;
            }
            // if not then it breaks the loop
            else {
              break;
            }
          }
        }
        // If not it changes the value
        low = middle + 1;
      }
      // Otherwise it checks if it is less than
      else if (searchKey.toLowerCase().charAt(0) < ceo[middle].toLowerCase().charAt(0)) {
        high = middle - 1;
      }
      // Else
      else {
        low = middle + 1;
      }
    }
    return multiple;
  }
}