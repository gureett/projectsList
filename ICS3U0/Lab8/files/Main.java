/*
Name: Gureet Kharod
Date: November 23rd/2022
Desc: Lab 8 searching and sorting arrays

Importing Swing */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Main extends JFrame implements ActionListener{
  // Declaring JFrame Elements
  JButton btnSearch;
  JButton btnExit;
  JTextField txtSearch;
  JLabel lblInstruct;
  
  public Main() {
    // Giving the window a title
    super("Find Tax Payouts");

    // Setting window size
    setSize(350, 150);

    // Making JButton
    btnSearch = new JButton("Search");
    btnExit = new JButton("Exit");
    txtSearch = new JTextField();
    lblInstruct = new JLabel("Please enter the name you want to search for:");

    // Adding Action Listener
    btnSearch.addActionListener(this);
    btnExit.addActionListener(this);

    // Setting Layout
    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 3;
    c.gridwidth = 2;
    c.gridx = 0;
    c.gridy = 0;
    add(lblInstruct, c);
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipadx = 150;
    c.gridwidth = 2;
    c.weightx = 0;
    c.insets = new Insets(5,50,0,50);
    c.gridx = 0;
    c.gridy = 1;
    add(txtSearch, c);
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridwidth = 1;
    c.ipadx = 5;
    c.weightx = 0;
    c.insets = new Insets(10,50,0,0);
    c.gridx = 0;
    c.gridy = 2;
    add(btnSearch, c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridwidth = 1;
    c.ipadx = 30;
    c.weightx = 0;
    c.insets = new Insets(10,72,0,50);
    c.gridx = 1;
    c.gridy = 2;
    add(btnExit, c);

    // Making it visible
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btnSearch) {
      try {
        importingData.importing(txtSearch.getText());
      }
      catch(Exception i) {
      }
    }
    else if (e.getSource() == btnExit) {
      System.exit(0);
    }
  }
  
  public static void main(String[] args) {
    new Main();
  }
}