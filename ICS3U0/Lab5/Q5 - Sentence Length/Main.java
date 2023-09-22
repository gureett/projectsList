// Date: October 23rd/2022
// Desc: Counts how many words are in a sentence

// Importing Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    //Declaring Variables
    String userInput;
    int length, spaces = 0;

    // Asking for users input
    userInput = JOptionPane.showInputDialog(null, "Please enter the sentence to count the words", "Word Counter", JOptionPane.PLAIN_MESSAGE);

    // Finding the length of the sentence
    length = userInput.length();
    
    // Checking how many spaces there are in the sentence
    for (int i = 0; i < length; i++) {
      if (userInput.charAt(i) == ' ') {
        spaces = spaces + 1;
      }
    }

    // Adding an extra to spaces since the sentence ends in a period or something other than a space.
    spaces = spaces + 1;

    // Output
    JOptionPane.showMessageDialog(null, "The numbers of words in your sentence is " + spaces, "Word Counter", JOptionPane.PLAIN_MESSAGE);
  }
}