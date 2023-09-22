import javax.swing.*;
import java.text.*;

class Main {
  public static void main(String[] args) {
    //Declaring Number Format
    NumberFormat number = NumberFormat.getInstance();
    number.setMaximumFractionDigits(2);
    // Declaring Variables
    double dblA, dblB, dblC;

    // Showing input dialogs for the values
    dblA = Double.parseDouble(JOptionPane.showInputDialog(null, "Pythagorean formula: c\u00B2 = b\u00B2 + a\u00B2 | Please enter value of A", "Calc", JOptionPane.INFORMATION_MESSAGE));
    dblB = Double.parseDouble(JOptionPane.showInputDialog(null, "Pythagorean formula: c\u00B2 = b\u00B2 + a\u00B2 | Please enter value of B", "Calc", JOptionPane.INFORMATION_MESSAGE));

    // Doing the Math Calculations
    dblA = dblA * dblA;
    dblB = dblB * dblB;
    dblC = dblA + dblB;
    dblC = Math.sqrt(dblC);

    // Outputting the Result
    JOptionPane.showMessageDialog(null, "The hypotenuses value is " + number.format(dblC));
    
  }
}