// Importing Swing and IO
import javax.swing.*;
import java.io.*;
import java.text.*;

public class importingData {
   public static void importing(String userInput) {
    // Try Catch in case the file doesn't have data in proper order
    try {
      // Setting up buffered reader
      BufferedReader input = new BufferedReader(new FileReader(JOptionPane.showInputDialog(null,"Please enter the tax info file name", "File Name", JOptionPane.PLAIN_MESSAGE)));

      // Declaring Variables
    int arrayLength = Integer.parseInt(input.readLine());
    String[] ceos = new String[arrayLength];
    String[] business = new String[arrayLength];
    double[] income = new double[arrayLength];
      
      // For Loop for giving student and mark their values
      for(int i = 0; i < ceos.length; i++) {
        String[] split = input.readLine().split(",",5);
        ceos[i] = split[0];
        business[i] = split[1];
        income[i] = Double.parseDouble(split[2]);
      }
      // Getting the arrays sorted from highest to lowest
      sortArrays.sortedCEOS(ceos, business, income);
      //sortedBusiness = sortArrays.sortedBusiness(ceos, business, income);
      //sortedIncome = sortArrays.sortedIncome(ceos, business, income);
      
      // Closes the buffered reader
      input.close();

      // Finds tax and also outputs to a file
      double[] tax = calcTax(ceos, business, income);

      searchArrays.findTaxPayer(ceos, business, income, tax, userInput);
      
   }
   catch(IOException e) {
     JOptionPane.showMessageDialog(null, "Please change the data in the text file to Name then Mark", "Error", JOptionPane.ERROR_MESSAGE);
  }
 }
  public static double[] calcTax(String[] ceo, String[] business, double[] income) {
    double[] tax = new double[20];
    String out = "";
    try {
      // Declaring Print Writer
      PrintWriter output = new PrintWriter(new FileWriter("taxinfo.txt"));
      // Number Format
      NumberFormat nf = NumberFormat.getCurrencyInstance();
        
      for (int i = 0; i < income.length; i++) {
        // Checking the income
        if (income[i] > 10000000) {
          tax[i] = income[i] * 0.53;
          // write to the file
          output.println(ceo[i] + "," + business[i] + "," + nf.format(income[i]) + "," + nf.format(tax[i]));
          out = out + ceo[i] + "," + business[i] + "," + nf.format(income[i]) + "," + nf.format(tax[i]) + "\n";
          //output.println(sortedBusiness[i]);
          //output.println(nf.format(sortedIncome[i]));
          //output.println(nf.format(tax));
        }
        else {
          tax[i] = income[i] * 0.40;
          // write to the file
          output.println(ceo[i] + "," + business[i] + "," + nf.format(income[i]) + "," + nf.format(tax));
          out = out + ceo[i] + "," + business[i] + "," + nf.format(income[i]) + "," + nf.format(tax[i]) + "\n";
          //output.println(sortedBusiness[i]);
          //output.println(nf.format(sortedIncome[i]));
          //output.println(nf.format(tax));
        }
      }
      //Outputs to user with GUI
      //JOptionPane.showMessageDialog(null, out, "Tax Info", JOptionPane.PLAIN_MESSAGE);
    // Closes output
    output.close();
    }
    catch (Exception e) {
      JOptionPane.showMessageDialog(null,"Please recheck the file name and the file entered", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
  return tax;
  }
}