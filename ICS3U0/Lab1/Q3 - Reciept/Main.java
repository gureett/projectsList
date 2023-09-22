import javax.swing.*;
import java.time.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    String companyNm;
    String Item1Nm;
    String Item2Nm;
    String Item3Nm;
    String Item4Nm;
    Float Item1;
    Float Item2;
    Float Item3;
    Float Item4;
    Float Subtotal;
    Float Total;

    // Asks for user input for the following options Company Name, Items Name, Items Price,
    companyNm = JOptionPane.showInputDialog("Please enter Company Name");
    Item1Nm = JOptionPane.showInputDialog("Please enter Item 1 Name:");
    Item1 = Float.parseFloat(JOptionPane.showInputDialog("Please enter " + Item1Nm + " Price: $"));
    Item2Nm = JOptionPane.showInputDialog("Please enter Item 2 Name:");
    Item2 = Float.parseFloat(JOptionPane.showInputDialog("Please enter " + Item2Nm + " Price: $"));
    Item3Nm = JOptionPane.showInputDialog("Please enter Item 3 Name:");
    Item3 = Float.parseFloat(JOptionPane.showInputDialog("Please enter " + Item3Nm + " Price: $"));
    Item4Nm = JOptionPane.showInputDialog("Please Enter Item 4 Name:");
    Item4 = Float.parseFloat(JOptionPane.showInputDialog("Please enter " + Item4Nm + " Price: $"));

    // Doing Math to figure out the total and subtotal of items.
    Subtotal = Item1 + Item2 + Item3 + Item4;
    Total = Subtotal * 1.13f;

    // Getting Date and Time
    java.util.Date date = new java.util.Date();

    // Output the final message with all information given and time (Receipt)
    JOptionPane.showMessageDialog(null, companyNm + "\n" + date + "\n" + Item1Nm + " $" + Item1 + "\n" + Item2Nm + " $" + Item2 + "\n" + Item3Nm + " $" + Item3 + "\n" + Item4Nm + " $" + Item4 + "\nSubtotal: " + Subtotal + "\nTotal: ");
      
  }
}