import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CardImageWindow {

	private String name;
	public static JFrame frame;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	/**
	 * Launch the application.
	 */
	public static void createWindow(ImageIcon _card) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardImageWindow window = new CardImageWindow(_card);
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
	public CardImageWindow(ImageIcon _card) {
		initialize(_card);
		frame.setVisible(true);
	}


	public void destroyFrame() {
		frame.dispose();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ImageIcon _card) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 307, 465);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		int x = (int) b.getX();
		int y = (int) b.getY();
		frame.setLocation(x,y);
		frame.setContentPane(new JLabel(_card));
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			frame.dispose();
			}
		});
	}

}

