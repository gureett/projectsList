// Date: September 27th / 2022
// Description: Displays a pattern

class Main {
  public static void main(String[] args) {
    // First for loop that makes a new line
    for (int i = 10; i>1; i = i-1) {
      // Second for loop to make the dollar signs
      for (int i2 = i; i2>1; i2= i2-1) {
        System.out.print("$");
      }
      // Makes new line
      System.out.print("\n");
    }
  }
}