// Date: September 14/2022
// Description: This program converts the temperature in Fahrenheit
// to Celsius.

import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    Double dblCelsius, dblFahrenheit;

    // Asking for users input for celsius and parsing it into a double, incuding the title, message, and the icon
    dblCelsius = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the temperature in celsius that \nyou would like converted to Fahrenheit", "Celsius to Fahrenheit Converter.", JOptionPane.QUESTION_MESSAGE));

    // Doing the math equation to find Fahrenheit
    dblFahrenheit = dblCelsius * 9 / 5 + 32;

    // Outputting using Message Dialong with the conversion for Celsius to Fahrenheit
    JOptionPane.showMessageDialog(null, "The Conversion for " + dblCelsius + "C to Fahrenheit is " + dblFahrenheit + "F", "Celsius to Fahrenheit Converter", JOptionPane.INFORMATION_MESSAGE);
    
  }
}