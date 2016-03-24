import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JRadioButton;

public class CreateDeckWindow {

	private JFrame frame;
	private JTextField textField;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateDeckWindow window = new CreateDeckWindow();
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
	public CreateDeckWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 4;
		gbc_lblName.gridy = 0;
		frame.getContentPane().add(lblName, gbc_lblName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 0;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JComboBox classes = new JComboBox();
		classes.addItem("Paladin");
		classes.addItem("Warlock");
		classes.addItem("Mage");
		classes.addItem("Warrior");
		classes.addItem("Shaman");
		classes.addItem("Priest");
		classes.addItem("Hunter");
		classes.addItem("Rogue");
		classes.addItem("Druid");
		classes.setToolTipText("Class");
		GridBagConstraints gbc_classes = new GridBagConstraints();
		gbc_classes.insets = new Insets(0, 0, 5, 0);
		gbc_classes.fill = GridBagConstraints.HORIZONTAL;
		gbc_classes.gridx = 5;
		gbc_classes.gridy = 1;
		frame.getContentPane().add(classes, gbc_classes);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Save everything
				frame.dispose();
			}
		});
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Neutral");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 4;
		gbc_rdbtnNewRadioButton.gridy = 2;
		frame.getContentPane().add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		JRadioButton rdbtnClassCards = new JRadioButton("$CLASS");
		GridBagConstraints gbc_rdbtnClassCards = new GridBagConstraints();
		gbc_rdbtnClassCards.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnClassCards.gridx = 5;
		gbc_rdbtnClassCards.gridy = 2;
		frame.getContentPane().add(rdbtnClassCards, gbc_rdbtnClassCards);
		
		JList currentList = new JList();
		GridBagConstraints gbc_currentList = new GridBagConstraints();
		gbc_currentList.insets = new Insets(0, 0, 5, 5);
		gbc_currentList.fill = GridBagConstraints.BOTH;
		gbc_currentList.gridx = 0;
		gbc_currentList.gridy = 3;
		frame.getContentPane().add(currentList, gbc_currentList);
		
		JScrollPane cardBook = new JScrollPane();
		GridBagConstraints gbc_cardBook = new GridBagConstraints();
		gbc_cardBook.gridwidth = 4;
		gbc_cardBook.insets = new Insets(0, 0, 5, 0);
		gbc_cardBook.fill = GridBagConstraints.BOTH;
		gbc_cardBook.gridx = 2;
		gbc_cardBook.gridy = 3;
		
		
		frame.getContentPane().add(cardBook, gbc_cardBook);
		
		JPanel panel = new JPanel();
		
		for(int i = 0; i<5;i++) { //5 for testing
			JButton cardButton = new JButton("");
			Image image = null;
			URL url = null;
			ImageIcon cardIcon = null;
			
			try {
				url = new URL(MainWindow.cards.get(i).getImage());
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			
			try {
				image = ImageIO.read(url);
				System.out.println("Image " + i + " loaded");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			Image tempImage = image.getScaledInstance(150, 230, java.awt.Image.SCALE_SMOOTH);
			System.out.println("Image " + i + " scaled");
			cardIcon = new ImageIcon(tempImage);
			cardButton.setPreferredSize(new Dimension(150,230));
			cardButton.setIcon(cardIcon);
			System.out.println("Image " + i + " set");

			
			panel.add(cardButton);
		}
		
		cardBook.setViewportView(panel);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 4;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnDeckHelper = new JMenu("Deck Helper");
		menuBar.add(mnDeckHelper);
		
		JMenuItem mntmOpenDeckHelper = new JMenuItem("Open Deck Helper");
		mntmOpenDeckHelper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeckHelperWindow.createWindow();
			}
		});
		mnDeckHelper.add(mntmOpenDeckHelper);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
