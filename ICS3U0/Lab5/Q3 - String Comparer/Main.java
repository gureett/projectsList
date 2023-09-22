//Date: October 19th/2022
//Desc: Check which word is longer

// Import Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    //Declaring Variables
    String firstWord, secondWord;
    int length1, length2;
    
    // Asking for First Word
    firstWord = JOptionPane.showInputDialog(null, "Please enter the first word", "First Word", JOptionPane.PLAIN_MESSAGE);

    // Asking for Second Word
    secondWord = JOptionPane.showInputDialog(null, "Please enter the second word", "Second Word", JOptionPane.PLAIN_MESSAGE);

    // Checking the length of each word
    length1 = firstWord.length();
    length2 = secondWord.length();

    // Checking which word is longer
    if (length1 > length2) {
      // Outputting 
      JOptionPane.showMessageDialog(null, firstWord + " has more letters than " + secondWord, "Length", JOptionPane.PLAIN_MESSAGE);
    }
    else if (length2 > length1) {
      JOptionPane.showMessageDialog(null, secondWord + " has more letters than " + firstWord, "Length", JOptionPane.PLAIN_MESSAGE);
    }
    else{
      JOptionPane.showMessageDialog(null, firstWord + " and " + secondWord + " has the same amount of letters.", "Length", JOptionPane.PLAIN_MESSAGE);
    }
  }
}