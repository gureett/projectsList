import java.util.Scanner;

class Main {
  public static void main(String[] args) {
  
    int intDice1 = (int)(Math.random() * 6) + 1;
    int intDice2 = (int)(Math.random() * 6) + 1;
    int intTotal = intDice1 + intDice2;

    System.out.println("Welcome to my dice game!");

    if (intTotal==2) {
      answer1(args);
    }
      // "||" is for "or" in java
    else if (intTotal==7 || intTotal==11) {
      answer2(args);
    } 

    else {
      answer3(args);
    }
  }

  public static void answer1(String[] args) {
    System.out.println("Snake Eyes! You Lose");
    Ask(args);
  }

  public static void answer2(String[] args) {
    System.out.println("You Win!!");
    Ask(args);
  }

  public static void answer3(String[] args) {
    System.out.println("Try Again!");
    Ask(args);
  }

  public static void Ask(String[] args) {
    Scanner input = new Scanner(System.in);
    String strPlayAgain;
    System.out.println("Would you like to play again? Yes or No?");
    strPlayAgain = input.nextLine();
    if (strPlayAgain.equals("Yes")) {
      main(args);
    }
    else if (strPlayAgain.equals("No")) {
      
    }
    else {
      Ask(args);
    }
  }
}