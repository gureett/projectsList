import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    // Declaring Variables
    int firstNumber;
    int secondNumber;
    int sum;
    int subtract;
    int multiply;
    float divide;
    
    // Setup for Keyboard Input
    BufferedReader kb = new BufferedReader (new InputStreamReader (System.in)) ;

    // Promt and read the first number from the user and convert to Integer
    System.out.println ("Enter first integer");
    firstNumber = Integer.parseInt(kb.readLine());

    // Read second number from user an convert to Integer
    System.out.println ("Enter second integer");
      secondNumber = Integer.parseInt(kb.readLine());

    // Does all operations
    sum = firstNumber + secondNumber;
    multiply = firstNumber * secondNumber;
    divide = firstNumber / secondNumber;
    subtract = firstNumber - secondNumber;

      // Display Result
      System.out.println ("Addition Result: " + sum + "\nSubtraction Result: " + subtract + "\nMultiplication Result: " + multiply + "\nDivision Result " + divide);

    kb.close();
  }
}