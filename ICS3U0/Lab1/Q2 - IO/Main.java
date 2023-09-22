import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    // Setup for Keyboard Input
    BufferedReader kb = new BufferedReader (new InputStreamReader (System.in)) ;
    
    // Declaring Variables
    String Name;
    String Street;
    String City;
    String Postal;

    //Prompt the User
    System.out.println ("Please enter your Name");

    // Read input from the user
    Name = kb.readLine();

    //Prompt the User
    System.out.println ("Please enter your Street");

    // Read input from the user
    Street = kb.readLine();

    //Prompt the User
    System.out.println ("Please enter your City");

    // Read input from the user
    City = kb.readLine();

    //Prompt the User
    System.out.println ("Please enter your Postal Code");

    // Read input from the user
    Postal = kb.readLine();

    // Printing out the final result
    System.out.println("\nName: " + Name + "\nStreet: " + Street + "\nCity: " + City + "\nPostal Code: " + Postal);

    kb.close();
  }
}