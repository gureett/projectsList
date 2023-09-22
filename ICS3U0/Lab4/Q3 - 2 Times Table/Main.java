// Date: September 27th / 2022
// Description: 2 Times Tables will show

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    int i, intAns;
    // Creating the for loop
    for (i = 0; i <= 12; i++) {
      // Doing the Math for the times table
      intAns = 2 * i;

      // Outputting the Answer with the Question
      System.out.println("2 x " + i + " = " + intAns);
    }
  }
}