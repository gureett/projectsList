/*
Date: November 15th/2022
Desc: Lab 7 Arrays, taking input and then changing it

Importing Swing */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Main extends JFrame implements ActionListener{
  // Declaring JFrame Items
  JButton btnFile, btnInput;
  
  public Main() {
    // Giving the window a title
    super("Marks");

    // Setting window size
    setSize(350, 150);

    // Making JButton
    btnFile = new JButton("Import from File");
    btnInput = new JButton("Import for User");

    // Adding Action Listener
    btnFile.addActionListener(this);
    btnInput.addActionListener(this);

    // Setting Layout
    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.gridx = 0;
    c.gridy = 0;
    add(btnFile, c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0;
    c.insets = new Insets(0,25,0,0);
    c.gridx = 1;
    c.gridy = 0;
    add(btnInput, c);

    // Making it visible
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    // Depending on the button that is clicked, a different method will be run
    if (e.getSource() == btnFile) {
      try {
        fromFile.average();
      }
      catch(IOException i) {
        i.printStackTrace();
      }
    }
    else if (e.getSource() == btnInput) {
      fromUserInput.average();
    }
  }
  
  public static void main(String[] args) {
    new Main();
  }
}