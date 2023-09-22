import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    double dblRLength, dblRWidth, dblRadius, dblCf, dblAreaC, dblAreaR, dblRP;
    double dblPi = 3.14;
    int intResult;

    // Declaring Objects
    Object[] options = { "Area of Circle", "Area & Perimeter of Rectangle"};

    // Customizing JPanel
    JPanel panel = new JPanel();
    panel.add(new JLabel("Formulas: Circle: Area: PiR\u00B2, Circumference: 2r, Rectangle: Perimeter: 2L + 2W, Area: L x W"));

    // Showing user the JPanel that was customized and asking for options
    intResult = JOptionPane.showOptionDialog(null, panel, "Geometry Calc", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

    // Checking if the result is YES or the button with the text "Circle"
    if (intResult == JOptionPane.YES_OPTION){
      //Asking user for the Radius of the circle
      dblRadius = JOptionPane.showInputDialog(null, "Please enter the radius of the Circle", "Radius", JOptionPane.INFORMATION_MESSAGE);
      //Calculating Circumference
      dblCf = dblRadius * 2;
      //Calculating Area of Circle
      dblAreaC = dblRadius * dblRadius;
      dblAreaC = dblAreaC * dblPi

      // Showing output dialog for the final calculations:
      JOptionPane.showMessageDialog(null, "Area of Circle: " + dblAreaC + "\nCircumference: " + dblCf, "Final Calculation", JOptionPane.INFORMATION_MESSAGE);
      // Checking if the option selected was the NO option or "Rectangle"
    }
    if (intResult == JOptionPane.NO_OPTION){ 
      //Asking user for the Length and Width of the Rectangle
      dblRLength = JOptionPane.showInputDialog(null, "Please enter the Length of the Rectangle", "Length", JOptionPane.INFORMATION_MESSAGE);
      dblRWidth = JOptionPane.showInputDialog(null, "Please enter the Width of the Rectangle", "Width", JOptionPane.INFORMATION_MESSAGE);

      // Doing the math calculations for Area
      dblAreaR = dblRLength * dblRWidth;
      // Doing the math calculations for Perimeter
      dblRP = (2 * dblRLength) + (2 * dblRWidth);

      // Showing output dialog for the final calculations:
      JOptionPane.showMessageDialog(null, "Area of Rectangle: " + dblAreaR + "\nPerimeter: " + dblRP, "Final Calculation", JOptionPane.INFORMATION_MESSAGE);
    }
  }
}