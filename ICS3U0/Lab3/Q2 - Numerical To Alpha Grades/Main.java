//Date: September 21/2022
//Desc: Grading System

// Importing Scanner
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // Declaring Scanner and variable for Marks
    Scanner input = new Scanner(System.in);
    int intMark;

    // Asking user for their grade and storing in a variable
    System.out.println("\n\nPlease enter Student Mark:");
    intMark = input.nextInt();

    // Checking whether or not the mark is within the 0-100 mark range and if so then it goes through the if statements till its true
    if (intMark >= 0 && intMark <= 100){
      if (intMark >= 80) {
        System.out.println("\n\nYou have an A");
  
      }
      else if (intMark >= 70){
        System.out.println("\n\nYou have an B");
      }
      else if (intMark >= 60) {
        System.out.println("\n\nYou have an C");
      }
      else if (intMark >= 50) {
        System.out.println("\n\nYou have an D");
      }
      else if (intMark >= 0) {
        System.out.println("\n\nYou have an F");
      }
    }
      // If the mark is not valid then it tells the user and restarts the program
    else {
      System.out.println("\n\nPlease enter a number between 0 and 100");
      main(args);
    }
  }
}