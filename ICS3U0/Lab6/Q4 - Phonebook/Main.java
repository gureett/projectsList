// Date: October 27th / 2022
// Desc: Puts last name first then first name

// Import Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    String name, contact;

    // Getting the users input
    name = JOptionPane.showInputDialog(null, "Please enter their First name followed by last name", "Contact Name",
        JOptionPane.PLAIN_MESSAGE);
    ;

    // Sending to method
    contact = phoneList(name);

    // Final output
    JOptionPane.showMessageDialog(null, name + " in a phone list would be " + contact, "Phone List",
        JOptionPane.PLAIN_MESSAGE);
  }

  public static String phoneList(String name) {
    // Declaring Variables
    String contactName, fn, ln;
    int length;
    int space = 0;

    // Finding the length of the string
    length = name.length();

    // For Loop to find the space
    for (int i = 0; i < length; i++) {
      if (name.charAt(i) == ' ') {
        space = i;
      }
    }

    // Splitting the first name and last name
    fn = name.substring(0, space);
    ln = name.substring(space + 1, length);

    // Getting contact name
    contactName = ln + ", " + fn;

    // Returning value
    return contactName;
  }
}