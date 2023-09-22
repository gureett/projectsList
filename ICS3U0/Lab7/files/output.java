import javax.swing.*;
import java.io.*;

class output {
  
  public static void findAvg(String student[], double mark[], double sum) throws IOException {  
    // Declaring Variables
    String out ="";
    double avg;

    // Finding average
    avg = sum / mark.length;

    // Declaring Print Writer
    PrintWriter output = new PrintWriter(new FileWriter("MarksWithAverage.txt"));

    for (int i = 0; i < mark.length; i++) {
      
      // write to the file
      output.println(student[i]);
      output.println((int)mark[i] + "%");

      // Adds to the output string
      out = out + student[i] + " has a mark of: " + (int)mark[i] + "%" + "\n";
      
    } 
    
    // writes to the file
    output.println("Average:");
    output.println(avg + "%");
    
    // output to user
    out = out + "The average of the class is " + avg + "%";
    JOptionPane.showMessageDialog(null, out);
    
    // Closes output
    output.close();
  }
}