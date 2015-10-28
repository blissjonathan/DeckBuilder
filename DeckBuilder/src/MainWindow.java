import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class MainWindow {

	private JFrame frmDeckbuilder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmDeckbuilder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDeckbuilder = new JFrame();
		frmDeckbuilder.setBackground(Color.LIGHT_GRAY);
		frmDeckbuilder.setResizable(false);
		frmDeckbuilder.setTitle("DeckBuilder .1");
		frmDeckbuilder.setBounds(100, 100, 450, 600);
		frmDeckbuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDeckbuilder.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmDeckbuilder.getContentPane().add(panel, "name_749988116922344");
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
	}

}
