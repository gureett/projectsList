// Date: November 14/2022
// Desc: Reading from next file

// Importing
import java.io.*;
import javax.swing.*;

class Main {
  public static void main(String[] args) throws IOException {
    // You don't need to do FileReader file but just put the part after the equal sign into the New BUffered Reader
    // Initializing Buffered Reader with the text file
    FileReader file = new FileReader("marksInfo.txt");
    BufferedReader input = new BufferedReader(file);
    // BufferedReader input = new BufferedReader(new FileReader("marksInfo.txt")); -> Would also work instead
    
    // Declaring Variables
    String student[] = new String[5];
    double mark[] = new double[5], sum = 0, avg;

    // For Loop for giving student and mark their values
    for (int i = 0; i < mark.length; i++) {
      student[i] = input.readLine();
      mark [i] = Double.parseDouble(input.readLine());
      sum = sum + mark[i];
    }

    // Closes the buffered reader
    file.close();

    avg = sum / mark.length;

    // Initialize File Writer and Print Writer
    FileWriter outFile = new FileWriter("MarksWithAverage.txt");
    PrintWriter output = new PrintWriter(outFile);
    // PrintWriter output = new PrintWriter(new FileWriter("MarksWithAverage.txt")); -> would also work just fine
    
    // For Loop to output each persons mark and name together
    for (int i = 0; i < mark.length; i++) {
      // write to the file
      output.println(student[i]);
      output.println((int)mark[i] + "%");
      // output to user
      JOptionPane.showMessageDialog(null, student[i] + " has a mark of: " + (int)mark[i] + "%");
    } 
    // writes to the file
    output.println("Average:");
    output.println(avg + "%");
    // output to user
    JOptionPane.showMessageDialog(null, "The average of the class is " + avg + "%");

    // Closes output
    output.close();
  }
}