import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
      
    System.out.println("What is your name?");

    String fname = input.nextLine();

    System.out.println("Nice to meet you " + fname + "! What is your favourite book?");

    input.nextLine();

    String [] comments = {"Nice!", "Cool!", "Interesting!", "Me too!"};
    Random rand = new Random();
    int randNum = rand.nextInt(4);

    String answer = comments[randNum];

    System.out.println(answer);
  }
}