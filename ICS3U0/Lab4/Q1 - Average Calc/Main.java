// Date: September 27th / 2022
// Description: Finds the average of the grades entered


// Importing Swing
import javax.swing.*;

class Main {
  
  // Declaring Variables
    int intGrades;
    int intAvg = 0;
    int Counter = 0;
  
  public static void main(String[] args) {
    
    // Running Grades program
    Main program = new Main();
    program.grades(args);

  }
  public void grades(String[] args) {
    // Creating the Do While statement
    do {
      intGrades = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter your grades to find the Average of, (When finished type -1)", "Average Grade Calculator", JOptionPane.PLAIN_MESSAGE));

      // Creating an If statement to check if the user enter -1 and to not run any code if they did
      if (intGrades == -1) {
        
      }
      else {
        // Creating another if statement within to check if a proper grade was entered and if not then telling the user and restarting the program
        if (intGrades > 100 || intGrades < 0) {
          JOptionPane.showMessageDialog(null, "Please enter a valid mark!", "Error: Invalid Mark", JOptionPane.ERROR_MESSAGE);
        }
        else {
          // Adds the grades together and gives counter +1 value
          intAvg = intAvg + intGrades;
          Counter = Counter + 1;
        }
      }
      
    }
    while (intGrades != -1);

    // Calculating the Average
    intAvg = intAvg / Counter;

    // Outputting the Average to the User
    JOptionPane.showMessageDialog(null, "The average for your grades are " + intAvg + "%", "Average Grade Calculator", JOptionPane.PLAIN_MESSAGE);
  }
}