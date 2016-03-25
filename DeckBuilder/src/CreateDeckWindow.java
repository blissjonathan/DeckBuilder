import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.LayoutManager;

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

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;

import java.awt.GridLayout;
import java.awt.FlowLayout;

public class CreateDeckWindow implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private final Action action = new SwingAction();
	private JTextField txtSearch;
	private JPanel cardPanel;
	private String classSelected;
	private JComboBox cardBookBox;
	private JComboBox classList;
	private Deck currentDeck;
	private JPanel deckPanel;

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
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 5;
		gbc_lblName.gridy = 0;
		frame.getContentPane().add(lblName, gbc_lblName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 6;
		gbc_textField.gridy = 0;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		classList = new JComboBox();
		classList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 classSelected = classList.getSelectedItem().toString();
				 //cardBookBox.revalidate();
				//cardPanel.repaint();
				 
			}
		});
		classList.addItem("Rogue");
		classList.addItem("Warlock");
		classList.addItem("Mage");
		classList.addItem("Warrior");
		classList.addItem("Shaman");
		classList.addItem("Priest");
		classList.addItem("Hunter");
		classList.addItem("Paladin");
		classList.addItem("Druid");
		classList.setToolTipText("Class");
		GridBagConstraints gbc_classList = new GridBagConstraints();
		gbc_classList.insets = new Insets(0, 0, 5, 0);
		gbc_classList.fill = GridBagConstraints.HORIZONTAL;
		gbc_classList.gridx = 6;
		gbc_classList.gridy = 1;
		frame.getContentPane().add(classList, gbc_classList);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Save everything
				frame.dispose();
			}
		});
		
		cardBookBox = new JComboBox();
		cardBookBox.setModel(new DefaultComboBoxModel(new String[] {classSelected + " Cards", "Neutral Cards"}));
		cardBookBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		frame.getContentPane().add(cardBookBox, gbc_comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		deckPanel = new JPanel();
		scrollPane.setViewportView(drawDeckPanel());
		deckPanel.setLayout(new BoxLayout(deckPanel, BoxLayout.Y_AXIS));
		
		JScrollPane cardBook = new JScrollPane();
		GridBagConstraints gbc_cardBook = new GridBagConstraints();
		gbc_cardBook.gridwidth = 5;
		gbc_cardBook.insets = new Insets(0, 0, 5, 0);
		gbc_cardBook.fill = GridBagConstraints.BOTH;
		gbc_cardBook.gridx = 2;
		gbc_cardBook.gridy = 3;
		
		
		frame.getContentPane().add(cardBook, gbc_cardBook);
		
		cardPanel = new JPanel();
		
		for(int i = 0; i<MainWindow.cards.size();i++) { //5 for testing
			JButton cardButton = new JButton("");
			Image image = null;
			URL url = null;
			ImageIcon cardIcon = null;
			
			try {
				url = new URL(MainWindow.cards.get(i).getImage());
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			}
			
			if(MainWindow.cards.get(i).getHero().equals(classList.getSelectedItem().toString())) {
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
			cardButton.setName(MainWindow.cards.get(i).getName());
			System.out.println("Button name set to " + MainWindow.cards.get(i).getName());
			cardButton.setOpaque(false);
			cardButton.setContentAreaFilled(false);
			cardButton.setBorderPainted(false);
			cardButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton deckButton = new JButton(cardButton.getName());
					deckButton.setOpaque(false);
					deckButton.setContentAreaFilled(false);
					//currentDeck.add(MainWindow.getAnyCard(cardButton.getName()));
					deckPanel.add(deckButton);
					deckPanel.revalidate();
				}
			});
			
			cardPanel.add(cardButton);
			}
		}
		
		cardBook.setViewportView(cardPanel);
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		GridBagConstraints gbc_txtSearch = new GridBagConstraints();
		gbc_txtSearch.insets = new Insets(0, 0, 5, 5);
		gbc_txtSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSearch.gridx = 2;
		gbc_txtSearch.gridy = 4;
		frame.getContentPane().add(txtSearch, gbc_txtSearch);
		txtSearch.setColumns(10);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 5;
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
	
	public JPanel drawDeckPanel() {		
		if(currentDeck != null) {
		for(int i = 0; i < currentDeck.getSize(); i++) {
			JButton cardButton = new JButton();
			Card tCard;
			tCard = (Card) currentDeck.getAllCards().get(i);
			cardButton.setText(tCard.getName());
			deckPanel.add(cardButton);
			}
		}
		
		
		return deckPanel;
	}
	
	public JPanel drawCardPanel() {
		
		
		return cardPanel;
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			System.out.println("Jbutton pressed");
			JButton tempButton = (JButton) e.getSource();
			String tempName = tempButton.getName();
			if(MainWindow.getAnyCard(tempName)!=null) {
				System.out.println(tempName + " pressed");
				currentDeck.addCard(MainWindow.getAnyCard(tempName));
				drawDeckPanel();
				deckPanel.repaint();
			}
		}
	}
}
