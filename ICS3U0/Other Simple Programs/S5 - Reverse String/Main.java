import javax.swing.*;

class Main {
  public static void main(String[] args) {
    String ui = JOptionPane.showInputDialog("String");
    String rev = "";

    int length = ui.length();

    for (int i = length - 1; i >= 0; i--) {
      rev = rev + ui.charAt(i);
    }

    JOptionPane.showMessageDialog(null, rev);
  }
}