import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;


public class SplashWindow {

	public static JFrame frame;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashWindow window = new SplashWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SplashWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		Dimension dim2 = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim2.width/2-frame.getSize().width/2, dim2.height/2-frame.getSize().height/2);
		frame.setContentPane(new JLabel(new ImageIcon("./resources/UI icons/splashscreen.png")));

		
		

//		frame.setLocation(0, 0);
//		frame.setSize(dim);
//		frame.setUndecorated(true);
//		frame.setBackground(new Color(0,255,0,0));
		
	}

}
