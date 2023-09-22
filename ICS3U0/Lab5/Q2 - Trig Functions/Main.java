//Date: October 19th / 2022
//Description: Trig Functions

// Import Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring variables
    double angleDeg, angleRad, sine, cos, tan;

    // Asking for the angle in degrees
    angleDeg = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the angle in degrees", "What is the Angle", JOptionPane.QUESTION_MESSAGE));

    // Converting to Radiants, and then doing the calculation for Sine, Cos, and Tan
    angleRad = Math.toRadians(angleDeg);
    
    sine = Math.sin(angleRad);
    cos = Math.cos(angleRad);
    tan = Math.tan(angleRad);

    // Outputting the sine, cos and tan
    JOptionPane.showMessageDialog(null, "The Sine of " + angleDeg + " is " + sine, "Sine", JOptionPane.PLAIN_MESSAGE);
    JOptionPane.showMessageDialog(null, "The Cos of " + angleDeg + " is " + cos, "Cos", JOptionPane.PLAIN_MESSAGE);
    JOptionPane.showMessageDialog(null, "The Tan of " + angleDeg + " is " + tan, "Sine", JOptionPane.PLAIN_MESSAGE);
  }
}