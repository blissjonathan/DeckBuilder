import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;


public class CollectionWindow {

	private JFrame frmCollectionManager;
	static ArrayList<Card> collection = new ArrayList<Card>();

	/**
	 * Launch the application.
	 */
	public static void createWindow(ArrayList<Card> _collection) {
		collection = _collection;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CollectionWindow window = new CollectionWindow();
					window.frmCollectionManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CollectionWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCollectionManager = new JFrame();
		frmCollectionManager.setTitle("Collection Manager");
		frmCollectionManager.setResizable(false);
		frmCollectionManager.setBounds(100, 100, 650, 414);
		frmCollectionManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
