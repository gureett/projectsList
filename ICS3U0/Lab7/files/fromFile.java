// Importing Swing and IO
import javax.swing.*;
import java.io.*;

public class fromFile {
  public static void average() throws IOException {
    // Declaring Variables
    String[] student = new String[5];
    String[] finalStudent = new String[5];
    double[] mark = new double[5];
    double[] finalMark = new double[5];
    double sum = 0, avg;
    
    // Setting up buffered reader
    BufferedReader i1 = new BufferedReader(new FileReader("name.txt"));
    BufferedReader i2 = new BufferedReader(new FileReader("marks.txt"));
    
    // Try Catch in case the file doesn't have data in proper order
    try {
        // For Loop for giving student and mark their values
      for (int i = 0; i < mark.length; i++) {
        student[i] = i1.readLine();
        mark [i] = Double.parseDouble(i2.readLine());
        sum = sum + mark[i];
      }
      
      // Closes the buffered reader
      i1.close();
      i2.close();
      
      // Getting the arrays sorted from highest to lowest
      finalStudent = sortArrays.sortedStudent(student, mark);
      finalMark = sortArrays.sortedMark(student, mark);
      
      try {
      output.findAvg(finalStudent, finalMark, sum);
      }
      catch(IOException e) {
        
      }
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Please change the data in the text file to Name then Mark", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
}