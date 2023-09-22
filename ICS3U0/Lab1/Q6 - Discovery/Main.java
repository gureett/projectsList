import javax.swing.*;

class Main {
  public static void main(String[] args) {

    // Show Message Dialogs with different Icons, Names, and Information
    JOptionPane.showMessageDialog(null, "Information", "Information Message", JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(null, "Error", "Error Message", JOptionPane.ERROR_MESSAGE);
    JOptionPane.showMessageDialog(null, "Warning", "Warning Message", JOptionPane.WARNING_MESSAGE);

    // Different Exit Sequences
    JOptionPane.showMessageDialog(null, "Information\nHello", "Information Message", JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(null, "Information\'Hello\'", "Information Message", JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(null, "\\Information", "Information Message", JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(null, "\"Information\"", "Information Message", JOptionPane.INFORMATION_MESSAGE);
    JOptionPane.showMessageDialog(null, "\fInformation", "Information Message", JOptionPane.INFORMATION_MESSAGE);
  }
}