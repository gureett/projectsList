import java.io.*;

public class sortArrays {
  public static void sortedCEOS(String[] ceos, String[] business, double[] income) {
    // First for loop for the position of the array
    for (int i = 0; i < ceos.length - 1; i++) {
      // Second for loop to keep going to make sure it is all in order
      for(int j = 0; j < ceos.length - 1; j++) {
        //System.out.println(ceos[j]);
        //System.out.println(ceos[j+1]);
        // If Mark at I is less than the one next to it, it will swap
        if (income[j] < income[j+1]) {
          // Temp Variable
          double temp = income[j+1];
          // Swaps
          income[j+1] = income[j];
          income[j] = temp;
          // Temp Variable
          String tCEOS = ceos[j+1];
          // Swaps
          ceos[j+1] = ceos[j];
          ceos[j] = tCEOS;
          // Temp Variable
          String tBusiness = business[j+1];
          // Swaps
          business[j+1] = business[j];
          business[j] = tBusiness;
        }
      }
    }
  }
  public static String[] alphaSort(String[] ceos, String[] business, double[] income, double[] tax) {
    String [] lastName = new String[20];
    String [] reverse = new String[20];
    // For Loop to split into the last names only
    for (int i = 0; i < ceos.length; i++) {
      // Splits the string wherever there is a space
      String[] split = ceos[i].split(" ",5);
      // Puts the last name to an array by the last item in the array
      lastName[i] = split[split.length - 1];
      reverse[i] = split[split.length-1];
      for (int j = 2; j <= split.length; j++) {
        reverse[i] = reverse[i] + " " + split[split.length - j];
      }
    }
    for (int i = 0; i < ceos.length; i++) {
      for(int j = i + 1; j < ceos.length; j++) {
        if (reverse[i].compareTo(reverse[j]) > 0) {
          // Temp Variable
          double temp = income[i];
          // Swaps
          income[i] = income[j];
          income[j] = temp;
          // Temp Variable
          String tCEOS = ceos[i];
          // Swaps
          ceos[i] = ceos[j];
          ceos[j] = tCEOS;
          //Temp Variable
          String tRev = reverse[i];
          reverse[i] = reverse[j];
          reverse[j] = tRev;
          // Temp Variable
          String tBusiness = business[i];
          // Swaps
          business[i] = business[j];
          business[j] = tBusiness;
          // Temp Variable
          double tTax = tax[i];
          tax[i] = tax[j];
          tax[j] = tTax;
          // Temp Variable
          String tLast = lastName[i];
          lastName[i] = lastName[j];
          lastName[j] = tLast;
        }
      }
    }
    return reverse;
  }
}