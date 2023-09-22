// Date: September 27th / 2022
// Description: Writing lyrics for a song using nested loops

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    int i, i2, i3;
    // Creating the For Loops
    for (i = 1; i <= 1; i++) {
      // Second For Loop (Nested)
      for (i2 = 1; i2 <= 4; i2++) {
        System.out.print("\nI'm too sexy for this loop,");

        // Third For Loop (Nested)
        for (i3 = 1; i3 <= 2; i3++) {
          System.out.print(" too sexy for this loop,");
        }
      }
      // Prints out the last line
      System.out.println("\nToo sexy by far!");
    }
  }
}