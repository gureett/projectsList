import java.io.*;
import javax.swing.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new FileReader("test.txt"));

    String playerNames[];
    int playerGoals[];

    playerNames = new String [7];
    playerGoals = new int [7];

    // loop to load file into arrays
    for (int i = 0 ; i < playerNames.length ; i++) {
      playerNames[i] = input.readLine();
      playerGoals[i] = Integer.parseInt(input.readLine());
    }
    input.close();

    //for (int j = 0; j < playerGoals.length; j++) {
      //System.out.println(playerNames[j] + " has a score of " + playerGoals[j] + " points");
   // }
    String toFind = JOptionPane.showInputDialog(null, "Please enter the player you would like to find", "Player to find!", JOptionPane.PLAIN_MESSAGE);

    int pos = lookFor(toFind, playerNames);
    if (pos == -1) {
      JOptionPane.showMessageDialog(null, "Not in list!");
    }
    else {
      JOptionPane.showMessageDialog(null, playerNames[pos] + " has " + playerGoals[pos] + " goals");
    }
  }

  public static int lookFor(String in, String[] playerNames) {
    int check = -1;
    for (int i = 0; i < playerNames.length; i++) {
      if (in.equalsIgnoreCase(playerNames[i])) {
        check = i;
        break;
      }
    }
    return check;
  }
  
  
}