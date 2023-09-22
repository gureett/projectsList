import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // Declaring Scanner Method
    Scanner kb = new Scanner(System.in);

    // Declaring Variables
    Float km;
    Float lt;
    Float FuelConsumption;

    // Asking for User Input and taking User Input
    System.out.println("Enter the Distance Travelled in KM without any values");
    km = kb.nextFloat();
    System.out.println("Enter the amount of Fuel used in Litres without any values");
    lt = kb.nextFloat();

    // Doing the Math for Fuel Consumption litres per 100km
    FuelConsumption = lt * 100;
    FuelConsumption = FuelConsumption / km;

    // Printing Result
    System.out.println("\nThe fuel consumption of that trip is " + FuelConsumption + "L " + "Per 100 KM");

    // Closing Scanner
    kb.close();
  }
}