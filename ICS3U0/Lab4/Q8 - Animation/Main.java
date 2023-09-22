// Date: September 29th / 2022
// Desc: Night time animation

// Importing packages
import javax.swing.*;
import java.awt.*;

class Main extends JFrame {

  // Declaring Variables
  int PosX1 = 600;
  int PosX2 = 530;
  int PosX3 = 515;
  int PosX4 = 545;
  int Counter;

  int PersonPosX1LL = 205;
  int PersonPosY1L = 350;
  int PersonPosX1RL = 225;
  int PersonPosX2L = 10;
  int PersonPosY2L = 30;
  int PersonPosX1LA1 = 195;
  int PersonPosX1LA2 = 193;
  int PersonPosYA = 320;
  int PersonPosX2A = 10;
  int PersonPosY2A = 30;
  int PersonPosX1RA1 = 235;
  int PersonPosX1RA2 = 237;
  int PersonPosX1T = 205;
  int PersonPosX2T = 30;
  int PersonPosY1T = 320;
  int PersonPosY2T = 40;
  int PersonPosX1H = 207;
  int PersonPosY1H = 295;
  int PersonPosH = 25;

  // Making new class for the window
  public Main() {
    // Giving the window a title
    super("Night Time Ride");

    // Setting window size
    setSize(400, 400);

    // Making it visible
    setVisible(true);
  }

  public void paint(Graphics g) {
    // Creating Backset
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, 400, 400);
    g.setColor(Color.GRAY);
    g.fillRect(0, 200, 400, 400);

    // Creating the Moon
    g.setColor(Color.WHITE);
    g.fillOval(5, 25, 60, 60);
    g.setColor(Color.BLACK);
    g.fillOval(30, 25, 60, 60);

    // Creating the First Building
    g.setColor(Color.DARK_GRAY);
    g.fillRect(75, 75, 75, 150);

    g.setColor(Color.YELLOW);
    g.fillRect(80, 80, 25, 15);
    g.fillRect(120, 80, 25, 15);

    g.fillRect(80, 105, 25, 15);
    g.fillRect(120, 105, 25, 15);

    g.fillRect(80, 130, 25, 15);
    g.fillRect(120, 130, 25, 15);

    g.fillRect(80, 155, 25, 15);
    g.fillRect(120, 155, 25, 15);

    g.setColor(Color.WHITE);
    g.fillRect(102, 200, 20, 27);

    // Creating the Second Building
    g.setColor(Color.DARK_GRAY);
    g.fillRect(175, 75, 75, 150);

    g.setColor(Color.YELLOW);
    g.fillRect(180, 80, 25, 15);
    g.fillRect(220, 80, 25, 15);

    g.fillRect(180, 105, 25, 15);
    g.fillRect(220, 105, 25, 15);

    g.fillRect(180, 130, 25, 15);
    g.fillRect(220, 130, 25, 15);

    g.fillRect(180, 155, 25, 15);
    g.fillRect(220, 155, 25, 15);

    g.setColor(Color.WHITE);
    g.fillRect(202, 200, 20, 27);

    // Creating the Second Building
    g.setColor(Color.DARK_GRAY);
    g.fillRect(275, 75, 75, 150);

    g.setColor(Color.YELLOW);
    g.fillRect(280, 80, 25, 15);
    g.fillRect(320, 80, 25, 15);

    g.fillRect(280, 105, 25, 15);
    g.fillRect(320, 105, 25, 15);

    g.fillRect(280, 130, 25, 15);
    g.fillRect(320, 130, 25, 15);

    g.fillRect(280, 155, 25, 15);
    g.fillRect(320, 155, 25, 15);

    g.setColor(Color.WHITE);
    g.fillRect(302, 200, 20, 27);
    

    // Creating an if statement to check PosX1s position
    if (PosX1 != 250) {
      // Refilling the screen
      g.setColor(Color.GRAY);
      g.fillRect(0, 300, 400, 400);
      // The road
      g.setColor(Color.YELLOW);
      g.fillRect(0, 300, 400, 10);
      g.setColor(Color.YELLOW);
      g.fillRect(0, 390, 400, 10);
      
      // Subtracting the cars X value
      PosX1 = PosX1 - 25;
      PosX2 = PosX2 - 25;
      PosX3 = PosX3 - 25;
      PosX4 = PosX4 - 25;

      // Creating the Car
      g.setColor(Color.BLACK);
      g.fillOval(PosX1, 320, 25, 25);
      g.fillOval(PosX2, 320, 25, 25);
      g.fillRect(PosX3, 300, 125, 20);
      g.fillRect(PosX4, 280, 70, 30);

      try {
        Thread.sleep(750);
      } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
      repaint();
    }
    // Without the else statement the car disappears
    else if (PersonPosX1LL != 95) {
      // Refilling the screen
      g.setColor(Color.GRAY);
      g.fillRect(0, 300, 400, 400);
      // The road
      g.setColor(Color.YELLOW);
      g.fillRect(0, 300, 400, 10);
      g.setColor(Color.YELLOW);
      g.fillRect(0, 390, 400, 10);

      // Creating the Car
      g.setColor(Color.BLACK);
      g.fillOval(PosX1, 320, 25, 25);
      g.fillOval(PosX2, 320, 25, 25);
      g.fillRect(PosX3, 300, 125, 20);
      g.fillRect(PosX4, 280, 70, 30);

      PersonPosX1LL = PersonPosX1LL - 5;
      PersonPosX1RL = PersonPosX1RL - 5;
      PersonPosX1T = PersonPosX1T - 5;
      PersonPosX1LA1 = PersonPosX1LA1 - 5;
      PersonPosX1LA2 = PersonPosX1LA2 - 5;
      PersonPosX1RA1 = PersonPosX1RA1 - 5;
      PersonPosX1RA2 = PersonPosX1RA2 - 5;
      PersonPosX1H = PersonPosX1H - 5;
      // Creating a person
      g.setColor(Color.WHITE);
      // Legs
      g.fillRect(PersonPosX1LL, PersonPosY1L, PersonPosX2L, PersonPosY2L);
      g.fillRect(PersonPosX1RL, PersonPosY1L, PersonPosX2L, PersonPosY2L);
      // Torso
      g.fillRect(PersonPosX1T, PersonPosY1T, PersonPosX2T, PersonPosY2T);

      // Left Arm
      g.fillRect(PersonPosX1LA1, PersonPosYA, PersonPosX2A, PersonPosY2A);
      g.fillRect(PersonPosX1LA2, PersonPosYA, PersonPosX2A, PersonPosY2A);

      // Right Arm
      g.fillRect(PersonPosX1RA1, PersonPosYA, PersonPosX2A, PersonPosY2A);
      g.fillRect(PersonPosX1RA2, PersonPosYA, PersonPosX2A, PersonPosY2A);

      // Head
      g.fillOval(PersonPosX1H, PersonPosY1H, PersonPosH, PersonPosH);

      try {
        Thread.sleep(500);
      } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
      repaint();
    }

    else if (PersonPosY1L >= 238) {
      // Refilling the screen
      g.setColor(Color.GRAY);
      g.fillRect(0, 300, 400, 400);
      // The road
      g.setColor(Color.YELLOW);
      g.fillRect(0, 300, 400, 10);
      g.setColor(Color.YELLOW);
      g.fillRect(0, 390, 400, 10);

      // Creating the Car
      g.setColor(Color.BLACK);
      g.fillOval(PosX1, 320, 25, 25);
      g.fillOval(PosX2, 320, 25, 25);
      g.fillRect(PosX3, 300, 125, 20);
      g.fillRect(PosX4, 280, 70, 30);

      // person move
      PersonPosY1L = PersonPosY1L - 16;
      PersonPosY1T = PersonPosY1T - 14;
      PersonPosYA = PersonPosYA - 14;
      PersonPosY1H = PersonPosY1H - 12;

      // Prevents decapitation
      PersonPosX1LA1 = PersonPosX1LA1 + 1;
      PersonPosX1LA2 = PersonPosX1LA2 + 1;
      PersonPosX1RA1 = PersonPosX1RA1 - 2;
      PersonPosX1RA2 = PersonPosX1RA2 - 2;
      PersonPosY1L = PersonPosY1L - 2;
      PersonPosX1RL = PersonPosX1RL - 1;

      // Makes person smaller
      PersonPosX2L = PersonPosX2L - 1;
      PersonPosY2L = PersonPosY2L - 1;
      PersonPosX2T = PersonPosX2T - 2;
      PersonPosY2T = PersonPosY2T - 2;
      PersonPosX2A = PersonPosX2A - 1;
      PersonPosY2A = PersonPosY2A - 1;
      PersonPosH = PersonPosH - 2;

      
      // Creating a person
      g.setColor(Color.WHITE);
      // Legs
      g.fillRect(PersonPosX1LL, PersonPosY1L, PersonPosX2L, PersonPosY2L);
      g.fillRect(PersonPosX1RL, PersonPosY1L, PersonPosX2L, PersonPosY2L);
      // Torso
      g.fillRect(PersonPosX1T, PersonPosY1T, PersonPosX2T, PersonPosY2T);

      // Left Arm
      g.fillRect(PersonPosX1LA1, PersonPosYA, PersonPosX2A, PersonPosY2A);
      g.fillRect(PersonPosX1LA2, PersonPosYA, PersonPosX2A, PersonPosY2A);

      // Right Arm
      g.fillRect(PersonPosX1RA1, PersonPosYA, PersonPosX2A, PersonPosY2A);
      g.fillRect(PersonPosX1RA2, PersonPosYA, PersonPosX2A, PersonPosY2A);

      // Head
      g.fillOval(PersonPosX1H, PersonPosY1H, PersonPosH, PersonPosH);

      try {
        Thread.sleep(500);
      } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
      repaint();
    }
      // Needed to keep the car there otherwise it will disappear
    else {
      // The road
      g.setColor(Color.YELLOW);
      g.fillRect(0, 300, 400, 10);
      g.setColor(Color.YELLOW);
      g.fillRect(0, 390, 400, 10);
      // Creating the Car
      g.setColor(Color.BLACK);
      g.fillOval(PosX1, 320, 25, 25);
      g.fillOval(PosX2, 320, 25, 25);
      g.fillRect(PosX3, 300, 125, 20);
      g.fillRect(PosX4, 280, 70, 30);
    }

  }

  public static void main(String[] args) {
    new Main();
  }
}