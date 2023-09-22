//Date: October 19th
//Desc: Checks if a phrase is a palindrome

// Importing Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    String sentence, sentenceOG;
    char l1, l2;
    int a1, a2, length, check = 0;

    // Getting sentance from user
    sentenceOG = JOptionPane.showInputDialog(null, "Please enter your sentence to see if it is a palindrome!", "Palindrome Checker - Input", JOptionPane.PLAIN_MESSAGE);

    // Removing all spaces and other characters from the sentance
    sentence = sentenceOG.replaceAll("[^a-zA-Z0-9]", "");

    // Making it all uppercase
    sentence = sentence.toUpperCase();

    // Getting the length of the Sentence
    length = sentence.length();
    length = length - 1;

    // Checking if the sentence is a palindrome by checking if the first letter is the same as the last and so on and so forth.
    for (int i = length; i != 0; i = i - 1) {
      // Getting the first letter and the last letter and so on and getting the ASCII value of them
      l1 = sentence.charAt(i);
      a1 = (int)l1;
      l2 = sentence.charAt(length - i);
      a2 = (int)l2;
      // Checks if the ASCII code is the same meaning the letters are the same and if so then the check will go up
      if (a1 == a2) {
        check = check + 1;
      }
      // If not then it failed the test and it tells the program it failed by not adding to check so check will not equal to the length
      else 
      {
        
      }
    }
    // Checking if the word was a palindrome
    if (check == length) {
      // Output
      JOptionPane.showMessageDialog(null, sentenceOG + " is a palindrome.", "Palindrome Checker", JOptionPane.PLAIN_MESSAGE);
    }
    else {
      // Output
      JOptionPane.showMessageDialog(null, sentenceOG + " is not palindrome.", "Palindrome Checker", JOptionPane.PLAIN_MESSAGE);
    }
  }
}