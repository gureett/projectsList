import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    double dblCelsius, dblFahrenheit;
    int intResult;

    // Declaring objects for specific names for buttons
    Object[] options = { "Convert to Celsius", "Convert to Fahrenheit"};

    // Creating custom JPanel and adding labels and a textfield.
    JPanel panel = new JPanel();
    panel.add(new JLabel("Please enter the temperature you would like to convert"));
    JTextField textField = new JTextField(10);
    panel.add(textField);

    // Showing an option Dialog which gives multiple options and customized with JPanel to have a textfield.
    intResult = JOptionPane.showOptionDialog(null, panel, "Temperature Converter", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

    // Checking if the result is YES or the button with the text "Celsius"
    if (intResult == JOptionPane.YES_OPTION){
      // If result was YES or Fahrenheit then we are giving the variable Celsius the textfields text but parsed as a double.
      dblFahrenheit = Double.parseDouble(textField.getText());
      
      // Doing the math conversion from Fahrenheit to Celsius
      dblCelsius = dblFahrenheit - 32;
      dblCelsius = dblCelsius * 5;
      dblCelsius = dblCelsius / 9;
      
      // Outputing the final result of the converstion to the user using a Message Dialog
       JOptionPane.showMessageDialog(null, "The Conversion for " + dblFahrenheit + "F to Celsius is " + dblCelsius + "C", "Temperature Converter", JOptionPane.INFORMATION_MESSAGE);

      // Checking if the option selected was the NO option or "Fahreneheit"
    }
    if (intResult == JOptionPane.NO_OPTION){ 
      //Giving the variable dblCelsius a value from the textfields but parsed as a double
      dblCelsius = Double.parseDouble(textField.getText());

      // Doing the math conversion from Celsius to Fahrenheit
      dblFahrenheit = dblCelsius * 9 / 5 + 32;

      // Outputting using Message Dialong with the conversion for Celsius to Fahrenheit
    JOptionPane.showMessageDialog(null, "The Conversion for " + dblCelsius + " C to Fahrenheit is " + dblFahrenheit + "F", "Temperature Converter", JOptionPane.INFORMATION_MESSAGE);
    }
  }
}