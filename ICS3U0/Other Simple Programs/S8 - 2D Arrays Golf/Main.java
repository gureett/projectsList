// Date: November 17th/2022
// Desc: Golf strokes program

// Importing Java Swing
import javax.swing.*;

class Main {
  public static void main(String[] args) {
    // Declaring Variables
    String golfScores[][] = new String [4][3];
    String output = "";
    int totalScore[] = new int[4];

    // For Loop for each player
    for (int i = 0; i < golfScores.length; i++) {
      // Nested loop to ask for the score on the hole they hit
      for (int j = 0; j < golfScores[0].length; j++) {
        golfScores[i][j] = JOptionPane.showInputDialog(null, "Player " + (i + 1) + " please enter your score for Hole " + (j + 1));
        // Adds to find the total score of the the player
        totalScore[i] = totalScore[i] + Integer.parseInt(golfScores[i][j]);
      }
    }
    // For outputting the total strokes each player had
    for (int i = 0; i < totalScore.length; i++) {
      output = output + "Player " + (i + 1) + " had a total strokes of " + totalScore[i] + "\n";
    }
    JOptionPane.showMessageDialog(null, output);
  }
}