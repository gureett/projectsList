import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    Double dblInch, dblCM;
    Integer Result;

    // Giving Inches its value by asking through a JOptionPane
    dblInch = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount of Inches to be converted to CM", "Inches to CM Converter", JOptionPane.QUESTION_MESSAGE));

    // Doing the Math to convert Inches to CM
    dblCM = dblInch * 2.54;

    // Outputting the Result of the conversion to the user
    JOptionPane.showMessageDialog(null, dblInch + " Inches converted to CM is " + dblCM + "CM");
  }
}