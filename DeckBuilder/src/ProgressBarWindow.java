import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class ProgressBarWindow {

  public static JProgressBar pbar;
  public static JFrame frame;
  
  public static void updateBar() {
    pbar.setValue(pbar.getValue() + 1);
  }

  public static void createWindow(int value) {
	pbar = new JProgressBar(0,value);
	pbar.setValue(0);
	pbar.setStringPainted(true);
    frame = new JFrame("Loading...");
    frame.setUndecorated(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(pbar);
    frame.pack();
    frame.setVisible(true);
  }
  
  public static void setLoc(int x, int y) {
	  frame.setLocation(x, y);
  }
}
