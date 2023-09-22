// Date: September 14/2022
// Description: This program converts the temperature in Celsius
// to Fahrenheit.

import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    Double dblFahrenheit, dblCelsius;

    // Asking for users input for Fahrenheit and parsing it into a double, incuding the title, message, and the icon
    dblFahrenheit = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the temperature in Fahrenheit that \nyou would like converted to Celsius", "Fahrenheit to Celsius Converter.", JOptionPane.QUESTION_MESSAGE));

    // Doing the math equation to find Celsius
    dblCelsius = dblFahrenheit - 32;
    dblCelsius = dblCelsius * 5;
    dblCelsius = dblCelsius / 9;

    // Outputting using Message Dialong with the conversion for Fahrenheit to Celsius
    JOptionPane.showMessageDialog(null, "The Conversion for " + dblFahrenheit + "F to Celsius is " + dblCelsius + "C", "Fahrenheit to Celsius Converter", JOptionPane.INFORMATION_MESSAGE);
    
  }
}