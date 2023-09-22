// Date: October 3rd/2022
// Desc: Animation

// Importing stuff
import javax.swing.*;
import java.awt.*;

class Main extends JFrame {
  ImageIcon car, bg, person;
  Integer i;
  Integer cx = 500;
  Integer px = 20;
  Integer py = 160;
  public Main() {
    // Giving the window a title
    super("Night Time Ride");

    // Setting window size
    setSize(480, 252);

    // Making Image Icons
    bg = new ImageIcon("bg.jpg");
    car = new ImageIcon("car.png");
    person = new ImageIcon("person.png");

    // Making it visible
    setVisible(true);
  }

  public void paint(Graphics g) {
    // For Loop to make the car move, and person for Image Icons
    for (i=0; i<=500; i++) {
      bg.paintIcon(this,g,0,0);
      car.paintIcon(this,g,cx - i,160);
      try {
        Thread.sleep(50);
      } 
      catch (InterruptedException ex) {
      }
    }
    for (i = 0; i <=227; i++) {
      bg.paintIcon(this,g,0,0);
      car.paintIcon(this,g,0,160);
      person.paintIcon(this,g,px + i,py);
      try {
        Thread.sleep(50);
      } 
      catch (InterruptedException ex) {
      }
    }
    for (i = 0; i <=20; i++) {
      bg.paintIcon(this,g,0,0);
      car.paintIcon(this,g,0,160);
      person.paintIcon(this,g,227,py - i);
      try {
        Thread.sleep(50);
      } 
      catch (InterruptedException ex) {
      }
    }
    // Repainting the car to make it look like the person entered the building
    bg.paintIcon(this,g,0,0);
    car.paintIcon(this,g,0,160);
  }
  
  public static void main(String[] args) {
    new Main();
  }
}