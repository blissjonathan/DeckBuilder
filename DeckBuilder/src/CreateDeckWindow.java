import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

import java.awt.GridLayout;
import java.awt.FlowLayout;

public class CreateDeckWindow {

	private JFrame frame;
	private JTextField nameField;
	private final Action action = new SwingAction();
	private JTextField txtSearch;
	private JPanel cardPanel;
	private String classSelected;
	private JComboBox classList;
	private Deck currentDeck = new Deck();
	private JPanel deckPanel;
	private JButton btnS;
	private JComboBox formatBox;
	private String cardPath = MainWindow.cardPath;
	private JButton classbtn;
	private JButton neutralbutton;
	private JScrollPane cardBook;

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
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 7;
		gbc_lblName.gridy = 0;
		frame.getContentPane().add(lblName, gbc_lblName);
		
		nameField = new JTextField("");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 8;
		gbc_textField.gridy = 0;
		frame.getContentPane().add(nameField, gbc_textField);
		nameField.setColumns(10);
		
		classList = new JComboBox();
		classList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 classSelected = classList.getSelectedItem().toString();
				 if(classbtn != null) {
				 classbtn.revalidate();
				 classbtn.repaint();
				 classbtn.getParent().revalidate();
				 classbtn.getParent().repaint();
				 }
				 if(classSelected != null) {
				 
				 }
				 
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
		gbc_classList.gridx = 8;
		gbc_classList.gridy = 1;
		frame.getContentPane().add(classList, gbc_classList);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentDeck != null) {
				currentDeck.setHero(classList.getSelectedItem().toString());
				currentDeck.setName(nameField.getText());
				currentDeck.setFormat(formatBox.getSelectedItem().toString());
				MainWindow.decks.add(currentDeck);
				MainWindow.deckBox.addItem(currentDeck.getName());
				MainWindow.deckBox.revalidate();
				MainWindow.deckBox.repaint();
				MainWindow.deckBox.getParent().revalidate();
				MainWindow.deckBox.getParent().repaint();
				}
				frame.dispose();
			}
		});
		
		formatBox = new JComboBox();
		formatBox.setModel(new DefaultComboBoxModel(new String[] {"Standard", "Wild"}));
		formatBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//
			}
		});
		
		neutralbutton = new JButton("");
		
		neutralbutton.setOpaque(false);
		neutralbutton.setContentAreaFilled(false);
		
		Image neutralImage = null;
		try {
			neutralImage = ImageIO.read(new File("./resources/icons/neutralicon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Image tempImage2 = neutralImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		neutralbutton.setIcon(new ImageIcon(tempImage2));
		
		neutralbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Card> neutrals;
				
				neutrals = MainWindow.createCardList("Neutral", 0);
				
				drawCardBook(neutrals);
				
			}
		});
		
		classbtn = new JButton("");
		
		classbtn.setOpaque(false);
		classbtn.setContentAreaFilled(false);
		
		Image classImage = null;
		try {
			classImage = ImageIO.read(new File("./resources/icons/" + classList.getSelectedItem().toString() + "icon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Image tempImage3 = classImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		classbtn.setIcon(new ImageIcon(tempImage3));
		
		classbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_classbtn = new GridBagConstraints();
		gbc_classbtn.insets = new Insets(0, 0, 5, 5);
		gbc_classbtn.gridx = 4;
		gbc_classbtn.gridy = 2;
		frame.getContentPane().add(classbtn, gbc_classbtn);
		GridBagConstraints gbc_neutralbutton = new GridBagConstraints();
		gbc_neutralbutton.insets = new Insets(0, 0, 5, 5);
		gbc_neutralbutton.gridx = 5;
		gbc_neutralbutton.gridy = 2;
		frame.getContentPane().add(neutralbutton, gbc_neutralbutton);
		GridBagConstraints gbc_formatBox1 = new GridBagConstraints();
		gbc_formatBox1.insets = new Insets(0, 0, 5, 0);
		gbc_formatBox1.fill = GridBagConstraints.HORIZONTAL;
		gbc_formatBox1.gridx = 8;
		gbc_formatBox1.gridy = 2;
		frame.getContentPane().add(formatBox, gbc_formatBox1);
		
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
		
		cardBook = new JScrollPane();
		GridBagConstraints gbc_cardBook = new GridBagConstraints();
		gbc_cardBook.gridwidth = 6;
		gbc_cardBook.insets = new Insets(0, 0, 5, 0);
		gbc_cardBook.fill = GridBagConstraints.BOTH;
		gbc_cardBook.gridx = 3;
		gbc_cardBook.gridy = 3;
		
		
		frame.getContentPane().add(cardBook, gbc_cardBook);
		
		cardPanel = new JPanel();
		drawCardBook(MainWindow.createCardList(classList.getSelectedItem().toString(), 0));
		
		
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		GridBagConstraints gbc_txtSearch = new GridBagConstraints();
		gbc_txtSearch.insets = new Insets(0, 0, 5, 5);
		gbc_txtSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSearch.gridx = 3;
		gbc_txtSearch.gridy = 4;
		frame.getContentPane().add(txtSearch, gbc_txtSearch);
		txtSearch.setColumns(10);
		
		btnS = new JButton();
		Image searchImage = null;
		try {
			searchImage = ImageIO.read(new File("./resources/UI icons/searchButton.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Image tempImage = searchImage.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
		Icon searchIcon = new ImageIcon(tempImage);
		btnS.setIcon(searchIcon);
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchBox(txtSearch.getText());
			}
		});
		GridBagConstraints gbc_btnS = new GridBagConstraints();
		gbc_btnS.insets = new Insets(0, 0, 5, 5);
		gbc_btnS.gridx = 5;
		gbc_btnS.gridy = 4;
		frame.getContentPane().add(btnS, gbc_btnS);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 8;
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
	
	public void drawCardBook(ArrayList<Card> _cards) {
		cardPanel = new JPanel();
			for(int i = 0; i<_cards.size();i++) {
				JButton cardButton = new JButton("");
				Image image = null;
				ImageIcon cardIcon = null;
				
			
				try {
					image = ImageIO.read(new File(cardPath + _cards.get(i).getID() + ".png"));
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
				cardButton.setName(_cards.get(i).getName());
				System.out.println("Button name set to " + MainWindow.cards.get(i).getName());
				cardButton.setOpaque(false);
				cardButton.setContentAreaFilled(false);
				cardButton.setBorderPainted(false);
				cardButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Card curCard = null;
						System.out.println(cardButton.getName() + " pressed");
						
						for(int i=0; i< _cards.size();i++) {
							if(_cards.get(i).getName().equals(cardButton.getName())) {
								curCard = _cards.get(i);
							}
						}
						
						if(curCard != null) {
							currentDeck.addCard(curCard);
							System.out.println(curCard.getName() + " added to deck");
						}
						
						String buttonName = cardButton.getName();
						JButton deckButton = new JButton(buttonName);
						deckButton.setPreferredSize(new Dimension(30,8));
						deckButton.setOpaque(false);
						deckButton.setContentAreaFilled(false);
						deckButton.setBorder(BorderFactory.createLineBorder(Color.yellow, 3));
						deckButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 15));
						
						deckButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JButton sourceButton = (JButton) e.getSource();
								System.out.println(sourceButton.getText() + " deck button pressed");
								checkPanelforRemove: {
								for(int i = 0; i < deckPanel.getComponentCount(); i++) {
								if(((JButton) deckPanel.getComponent(i)).getText().contains("(2)") &&
										((JButton) deckPanel.getComponent(i)).getText().contains(
												sourceButton.getText().replace(" (2)", ""))) {
								System.out.println("Found stacked button");
								String origName = sourceButton.getText().replace(" (2)", "");
								currentDeck.removeCard(origName);	
								((JButton) deckPanel.getComponent(i)).setText(origName);	
								deckPanel.revalidate();
								deckPanel.repaint();
								break checkPanelforRemove;
								} else if(sourceButton.getText().equals(
										((JButton) deckPanel.getComponent(i)).getText())) {
									System.out.println("Found unstacked button " + ((JButton) deckPanel.getComponent(i)).getText());
									currentDeck.removeCard(((JButton) deckPanel.getComponent(i)).getText());	
									deckPanel.remove(deckPanel.getComponent(i));	
									deckPanel.revalidate();
									deckPanel.repaint();
									break checkPanelforRemove;
								}
								
								}
								}
							}
						});
						boolean hasButton = false;
						
						checkPanel: {
						for(int i = 0; i < deckPanel.getComponentCount(); i++) {
							if(deckButton.getText().equals(((JButton) deckPanel.getComponent(i)).getText())) {
							hasButton = true;
							((JButton) deckPanel.getComponent(i)).setText(buttonName + " (2)"); 
							deckPanel.revalidate();
							deckPanel.repaint();
							break checkPanel;
							}
							else if((deckButton.getText() + " (2)").equals(((JButton) deckPanel.getComponent(i)).getText())) {
							hasButton = true;
							break checkPanel;
							} 
							else {
							hasButton = false;
							}

						}
					}	
						if(hasButton == false) {
						deckPanel.add(deckButton);
						deckPanel.revalidate();
						}
					}
				});
				
				cardPanel.add(cardButton);
				
			}
			cardPanel.revalidate();
			cardPanel.repaint();
			cardBook.setViewportView(cardPanel);
	}
	
	public void searchBox(String _card) {
		ArrayList<Card> searchedCards = new ArrayList<Card>();
		String search = txtSearch.getText();
		cardPanel = new JPanel();
		
		for(int i = 0; i < MainWindow.cards.size();i++) {
			if(MainWindow.cards.get(i).getName().contains(_card)) {
				searchedCards.add(MainWindow.cards.get(i));
			}
		}	
			
			drawCardBook(searchedCards);
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
