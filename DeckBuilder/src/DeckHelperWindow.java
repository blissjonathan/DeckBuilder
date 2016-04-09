import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class DeckHelperWindow {

	private JFrame frmDeckHelper;
	private JPanel cardPanel;
	private JScrollPane helpBook;
	private JLabel lblBurst;
	private JLabel lblBoardclear;
	private JLabel lblTempo;
	private JLabel lblValue;
	private JLabel lblFinisher;

	/**
	 * Launch the application.
	 * @return 
	 */
	public static void createWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeckHelperWindow window = new DeckHelperWindow();
					window.frmDeckHelper.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeckHelperWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDeckHelper = new JFrame();
		frmDeckHelper.setTitle("Deck Helper");
		frmDeckHelper.setResizable(false);
		frmDeckHelper.setBounds(100, 100, 450, 553);
		frmDeckHelper.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDeckHelper.getContentPane().setLayout(null);
		frmDeckHelper.setLocation(CreateDeckWindow.frame.getX()+CreateDeckWindow.frame.getWidth(), 
				CreateDeckWindow.frame.getY());
		
		JLabel lblDeckName = new JLabel("Deck Name:");
		lblDeckName.setBounds(10, 11, 69, 24);
		frmDeckHelper.getContentPane().add(lblDeckName);
		
		JLabel lblClass = new JLabel("Class:");
		lblClass.setBounds(10, 46, 69, 24);
		frmDeckHelper.getContentPane().add(lblClass);
		
		helpBook = new JScrollPane();
		helpBook.setBounds(10, 254, 424, 259);
		frmDeckHelper.getContentPane().add(helpBook);
		
		cardPanel = new JPanel();
		helpBook.setViewportView(cardPanel);
		
		JLabel deckName = new JLabel("NAME");
		deckName.setBounds(70, 16, 46, 14);
		frmDeckHelper.getContentPane().add(deckName);
		
		JLabel lblClassLabel = new JLabel("CLASS LABEL");
		lblClassLabel.setBounds(44, 51, 86, 14);
		frmDeckHelper.getContentPane().add(lblClassLabel);
		
		JLabel lblSuggestedArchetype = new JLabel("Suggested Archetype:");
		lblSuggestedArchetype.setBounds(234, 16, 120, 14);
		frmDeckHelper.getContentPane().add(lblSuggestedArchetype);
		
		JLabel lblSuggestedCards = new JLabel("Suggested Cards");
		lblSuggestedCards.setBounds(10, 236, 106, 14);
		frmDeckHelper.getContentPane().add(lblSuggestedCards);
		
		JLabel lblGetarchetype = new JLabel("GETARCHETYPE");
		lblGetarchetype.setBounds(344, 16, 90, 14);
		frmDeckHelper.getContentPane().add(lblGetarchetype);
		
		JLabel lblCheckList = new JLabel("Check List:");
		lblCheckList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCheckList.setBounds(10, 81, 106, 14);
		frmDeckHelper.getContentPane().add(lblCheckList);
		
		JButton btnFinisher = new JButton("Finisher");
		btnFinisher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFinisher.setBounds(10, 104, 89, 23);
		frmDeckHelper.getContentPane().add(btnFinisher);
		
		lblFinisher = new JLabel("");
		lblFinisher.setBounds(109, 108, 74, 14);
		frmDeckHelper.getContentPane().add(lblFinisher);
		
		JButton btnBoardClear = new JButton("Board Clear");
		btnBoardClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBoardClear.setBounds(10, 138, 89, 23);
		frmDeckHelper.getContentPane().add(btnBoardClear);
		
		JButton btnBurst = new JButton("Burst");
		btnBurst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBurst.setBounds(10, 172, 89, 23);
		frmDeckHelper.getContentPane().add(btnBurst);
		
		JButton btnValue = new JButton("Value");
		btnValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValue.setBounds(234, 104, 89, 23);
		frmDeckHelper.getContentPane().add(btnValue);
		
		JButton btnNewButton = new JButton("Tempo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(234, 138, 89, 23);
		frmDeckHelper.getContentPane().add(btnNewButton);
		
		lblBoardclear = new JLabel("");
		lblBoardclear.setBounds(109, 142, 74, 14);
		frmDeckHelper.getContentPane().add(lblBoardclear);
		
		lblBurst = new JLabel("");
		lblBurst.setBounds(109, 176, 74, 14);
		frmDeckHelper.getContentPane().add(lblBurst);
		
		lblValue = new JLabel("");
		lblValue.setBounds(333, 108, 74, 14);
		frmDeckHelper.getContentPane().add(lblValue);
		
		lblTempo = new JLabel("");
		lblTempo.setBounds(333, 142, 74, 14);
		frmDeckHelper.getContentPane().add(lblTempo);
		
		setLabels();
	}
	
	public void setLabels() {
		
		ImageIcon xicon = null;
		ImageIcon checkicon = null;	
		try {
			Image xmark = ImageIO.read(new File("./resources/UI icons/xmark.png"));
			Image checkmark = ImageIO.read(new File("./resources/UI icons/checkmark.png"));
			xmark = xmark.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
			checkmark = checkmark.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
			xicon = new ImageIcon(xmark);
			checkicon = new ImageIcon(checkmark);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		if(CreateDeckWindow.currentDeck.hasFinisher()==true) {
		lblFinisher.setIcon(checkicon);
		}
		if(CreateDeckWindow.currentDeck.hasFinisher()==false) {
		lblFinisher.setIcon(xicon);
		}
		
		if(CreateDeckWindow.currentDeck.hasBurst()==true) {
		lblBurst.setIcon(checkicon);
		}
		if(CreateDeckWindow.currentDeck.hasBurst()==false) {
		lblBurst.setIcon(xicon);
		}
		
		if(CreateDeckWindow.currentDeck.hasAOE()==true) {
		lblBoardclear.setIcon(checkicon);
		}
		if(CreateDeckWindow.currentDeck.hasAOE()==false) {
		lblBoardclear.setIcon(xicon);
		}		
		if(CreateDeckWindow.currentDeck.hasTempo()==true) {
		lblTempo.setIcon(checkicon);
		}
		if(CreateDeckWindow.currentDeck.hasTempo()==false) {
		lblTempo.setIcon(xicon);
		}
	}
	
	public void drawHelpBook(ArrayList<Card> _cards) {
		cardPanel = new JPanel();
		cardPanel.setLayout(new GridLayout((_cards.size()/2)+1,2));	
		
			for(int i = 0; i<_cards.size();i++) {
				JButton cardButton = new JButton("");
				Image image = null;
				ImageIcon cardIcon = null;
				
			
				try {
					image = ImageIO.read(new File("./resources/tempdata/cards/" + _cards.get(i).getID() + ".png"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				Image tempImage = image.getScaledInstance(150, 230, java.awt.Image.SCALE_SMOOTH);
				cardIcon = new ImageIcon(tempImage);
				cardButton.setPreferredSize(new Dimension(150,230));
				cardButton.setIcon(cardIcon);
				cardButton.setName(_cards.get(i).getName());
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
							CreateDeckWindow.currentDeck.addCard(curCard);
							System.out.println(curCard.getName() + " added to deck");
						}
						
						String buttonName = cardButton.getName();
						JButton deckButton = new JButton(buttonName);
						deckButton.setPreferredSize(new Dimension(30,8));
						deckButton.setOpaque(false);
						deckButton.setContentAreaFilled(false);
						deckButton.setBorder(BorderFactory.createLineBorder(Color.yellow, 3));
						deckButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 23));
						deckButton.setMinimumSize(new Dimension(Integer.MAX_VALUE, 23));
						deckButton.setHorizontalAlignment(SwingConstants.LEFT);
						
						BufferedImage bi = new BufferedImage(tempImage.getWidth(null), tempImage.getHeight(null),
						        BufferedImage.TYPE_INT_ARGB);

						    Graphics g = bi.createGraphics();
						    g.drawImage(tempImage, 0, 0, null);
						    g.dispose();
						
						BufferedImage croppedImage = bi.getSubimage(46, 52, 60, 23);
						ImageIcon finalImage = new ImageIcon(croppedImage);
						deckButton.setIcon(finalImage);
						
						deckButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								JButton sourceButton = (JButton) e.getSource();
								System.out.println(sourceButton.getText() + " deck button pressed");
								checkPanelforRemove: {
								for(int i = 0; i < CreateDeckWindow.deckPanel.getComponentCount(); i++) {
								if(((JButton) CreateDeckWindow.deckPanel.getComponent(i)).getText().contains("(2)") &&
										((JButton) CreateDeckWindow.deckPanel.getComponent(i)).getText().contains(
												sourceButton.getText().replace(" (2)", ""))) {
								System.out.println("Found stacked button");
								String origName = sourceButton.getText().replace(" (2)", "");
								CreateDeckWindow.currentDeck.removeCard(origName);	
								((JButton) CreateDeckWindow.deckPanel.getComponent(i)).setText(origName);	
								CreateDeckWindow.deckPanel.revalidate();
								CreateDeckWindow.deckPanel.repaint();
								break checkPanelforRemove;
								} else if(sourceButton.getText().equals(
										((JButton) CreateDeckWindow.deckPanel.getComponent(i)).getText())) {
									System.out.println("Found unstacked button " + ((JButton) CreateDeckWindow.deckPanel.getComponent(i)).getText());
									CreateDeckWindow.currentDeck.removeCard(((JButton) CreateDeckWindow.deckPanel.getComponent(i)).getText());	
									CreateDeckWindow.deckPanel.remove(CreateDeckWindow.deckPanel.getComponent(i));	
									CreateDeckWindow.deckPanel.revalidate();
									CreateDeckWindow.deckPanel.repaint();
									break checkPanelforRemove;
								}
								
								}
								}
							}
						});
						boolean hasButton = false;
						
						checkPanel: {
						for(int i = 0; i < CreateDeckWindow.deckPanel.getComponentCount(); i++) {
							if(deckButton.getText().equals(((JButton) CreateDeckWindow.deckPanel.getComponent(i)).getText())) {
							hasButton = true;
							if(!(curCard.getRarity().equals("Legendary")) && CreateDeckWindow.currentDeck.getSize() < 30) {
							((JButton) CreateDeckWindow.deckPanel.getComponent(i)).setText(buttonName + " (2)"); 
							}
							CreateDeckWindow.deckPanel.revalidate();
							CreateDeckWindow.deckPanel.repaint();
							break checkPanel;
							} else if((deckButton.getText() + " (2)").equals(((JButton) CreateDeckWindow.deckPanel.getComponent(i)).getText())) {
							hasButton = true;
							break checkPanel;
							} else {
							hasButton = false;
							}
						}
					}	
						if(hasButton == false && CreateDeckWindow.currentDeck.getSize() < 30) {
						CreateDeckWindow.deckPanel.add(deckButton);
						CreateDeckWindow.deckPanel.revalidate();
						CreateDeckWindow.deckPanel.repaint();
						}
					}
				});
				
				cardPanel.add(cardButton);
				
			}
			cardPanel.revalidate();
			cardPanel.repaint();
			helpBook.setViewportView(cardPanel);
	}
	
}
