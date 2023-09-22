//Date: October 19th/2022
//Desc: Places words from alpha order

//Import Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    String firstWord, secWord;
    char w1,w2;
    int aw1,aw2;

    // Asking user for the two words
    firstWord = JOptionPane.showInputDialog(null, "Please enter the first word", "First Word", JOptionPane.PLAIN_MESSAGE);
    secWord = JOptionPane.showInputDialog(null, "Please enter the second word", "Second Word", JOptionPane.PLAIN_MESSAGE);

    // Making all the letters undercase for the ASCII code
    firstWord = firstWord.toLowerCase();
    secWord = secWord.toLowerCase();
    
    // Getting the first letter of each word
    w1 = firstWord.charAt(0);
    w2 = secWord.charAt(0);

    // Getting the ASCII value of each words first letter
    aw1 = (int)w1;
    aw2 = (int)w2;

    // Comparing the ASCII values to see which one comes before
    if (aw1 < aw2) {
      // Output
      JOptionPane.showMessageDialog(null,firstWord + " comes before " + secWord + " in the alphabet.", "First Word Comes First", JOptionPane.PLAIN_MESSAGE);
    }
    else if (aw2 < aw1) {
      JOptionPane.showMessageDialog(null,secWord + " comes before " + firstWord + " in the alphabet.", "Second Word Comes First", JOptionPane.PLAIN_MESSAGE);
    }
    else {
      JOptionPane.showMessageDialog(null,firstWord + " starts the same as " + secWord + " in the alphabet.", "Same", JOptionPane.PLAIN_MESSAGE);
    }
  }
}