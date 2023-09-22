// Date: October 23rd / 2022
// Desc: Finds the first vowel and displays it position

// Importing Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    String userInput, upperUserInput, strVowel = "";
    int length, intVowel = 0;

    // Asking for user input
    userInput = JOptionPane.showInputDialog(null, "Please enter the word", "Vowel Finder", JOptionPane.PLAIN_MESSAGE);

    // Finding the length of the string
    length = userInput.length();

    // Putting it all in uppercase
    upperUserInput = userInput.toUpperCase();
    
    // Loop to check each position
    for (int i = 0; i < length; i++) {
      if (upperUserInput.charAt(i) == 'A') {
        intVowel = i;
        i = length;
        strVowel = "A";
      }
      else if (upperUserInput.charAt(i) == 'E') {
        intVowel = i;
        i = length;
        strVowel = "E";
      }
      else if (upperUserInput.charAt(i) == 'I') {
        intVowel = i;
        i = length;
        strVowel = "I";
      }
      else if (upperUserInput.charAt(i) == 'O') {
        intVowel = i;
        i = length;
        strVowel = "O";
      }
      else if (upperUserInput.charAt(i) == 'U') {
        intVowel = i;
        i = length;
        strVowel = "U";
      }
    }

    // Output final message
    JOptionPane.showMessageDialog(null, "The first vowel is " + strVowel + " at position " + intVowel, "Vowel Finder", JOptionPane.PLAIN_MESSAGE);
  }
}