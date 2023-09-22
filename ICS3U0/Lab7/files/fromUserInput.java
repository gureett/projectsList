// Importing Swing and IO
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class fromUserInput extends JFrame implements ActionListener {
  // Declaring variables
  String[] student = new String[5];
  String[] finalStudent = new String[5];
  double[] mark = new double[5];
  double[] finalMark = new double[5];
  double sum = 0;
  int counter = 0;
  JTextField txtStudent, txtMark;
  JLabel lblStudent, lblMark;
  JButton btnSubmit;
  
  public fromUserInput() {
    // Giving the window a title
    super("Marks");

    // Setting window size
    setSize(350, 200);

    // Making J Elements
    btnSubmit = new JButton("Submit");
    
    txtStudent = new JTextField();
    txtMark = new JTextField();
    
    lblStudent = new JLabel("Please enter your Name!");
    lblMark = new JLabel("Please enter your Mark!");

    btnSubmit.addActionListener(this);

    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridx = 0;
    c.gridy = 0;
    add(lblStudent, c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridx = 0;
    c.gridy = 1;
    c.insets = new Insets(5,0,0,0);
    add(txtStudent, c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridx = 0;
    c.gridy = 2;
    c.insets = new Insets(10,0,0,0);
    add(lblMark, c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridx = 0;
    c.gridy = 3;
    c.insets = new Insets(5,0,0,0);
    add(txtMark,c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridx = 0;
    c.gridy = 4;
    c.insets = new Insets(15,0,0,0);
    add(btnSubmit, c);

    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    // Checking if counter is less than mark length
    if (counter < mark.length) {
      // if so then it gives the student and mark array its value from the text boxes
      student[counter] = txtStudent.getText();
      // Try Catch in case the information entered is not an actual mark
      try {
      mark[counter] = Double.parseDouble(txtMark.getText());
        // Then finds the sum
      sum = sum + mark[counter];
      // Resets the text boxes to be empty
      txtStudent.setText("");
      txtMark.setText("");

      if (counter == mark.length - 1) {
        // Getting the arrays sorted from highest to lowest
        finalStudent = sortArrays.sortedStudent(student, mark);
        finalMark = sortArrays.sortedMark(student, mark);
        
        // Sends to the output to find the average
        try {
          output.findAvg(finalStudent, finalMark, sum);
        }
        catch(IOException i) {
          
        }
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
      }

      // Adds to counter
      counter = counter + 1;
    }
    catch (Exception l) {
      JOptionPane.showMessageDialog(null, "Please enter a valid mark!", "Error", JOptionPane.ERROR_MESSAGE);
      // Resets the text boxes to be empty
      txtStudent.setText("");
      txtMark.setText("");
      }
    }
  }
  
  public static void average() {
    new fromUserInput();
  }
}