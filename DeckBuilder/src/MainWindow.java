import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Toolkit;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;

import org.json.*;


public class MainWindow {
	
private static final String version = ".2";
	
static ArrayList<Deck> decks = new ArrayList<Deck>();
static ArrayList<Card> cards = new ArrayList<Card>();
static ArrayList<Card> collection = new ArrayList<Card>();
public static ArrayList<String> CardData = new ArrayList<String>();
static String imgPath = "";
static File dir = new File(imgPath);
static Deck currentDeck;
public static HttpResponse<JsonNode> response;

static boolean dataDownloaded = false;

JLabel classLabel = new JLabel();
static JComboBox deckBox;
static JPanel deckListPanel;

Icon paladinIcon = new ImageIcon("./resources/icons/paladinicon.png");
Icon warlockIcon = new ImageIcon("./resources/icons/warlockicon.png");
Icon mageIcon = new ImageIcon("./resources/icons/mageicon.png");
Icon warriorIcon = new ImageIcon("./resources/icons/warrioricon.png");
Icon shamanIcon = new ImageIcon("./resources/icons/shamanicon.png");
Icon priestIcon = new ImageIcon("./resources/icons/priesticon.png");
Icon hunterIcon = new ImageIcon("./resources/icons/huntericon.png");
Icon rogueIcon = new ImageIcon("./resources/icons/rogueicon.png");
Icon druidIcon = new ImageIcon("./resources/icons/druidicon.png");

public static JSONObject AllCardsObj;
public static JSONArray AllCards;

public static String cardPath = "./resources/tempdata/cards/";
public static boolean loaded = false;

	private JFrame frmDeckbuilder;

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		SplashWindow.createWindow();
		try {
			HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards")
					.header("X-Mashape-Key", "32dPU6CVE4mshjYVlOQh1au6LxYVp1hAEkIjsnw7zXqucLcZY3")
					.asJson();
			
			AllCardsObj = response.getBody().getObject();
			
			JSONArray basicCards = AllCardsObj.getJSONArray("Basic");
			JSONArray classicCards = AllCardsObj.getJSONArray("Classic");
			JSONArray naxCards = AllCardsObj.getJSONArray("Naxxramas");
			JSONArray loeCards = AllCardsObj.getJSONArray("The League of Explorers");
			JSONArray blackrockCards = AllCardsObj.getJSONArray("Blackrock Mountain");
			JSONArray tgtCards = AllCardsObj.getJSONArray("The Grand Tournament");
			int totalCards = AllCardsObj.getJSONArray("Basic").length() + AllCardsObj.getJSONArray("Classic").length()
								+ AllCardsObj.getJSONArray("Naxxramas").length() + AllCardsObj.getJSONArray("The League of Explorers").length()
								+ AllCardsObj.getJSONArray("Blackrock Mountain").length() + AllCardsObj.getJSONArray("The Grand Tournament").length();
			ProgressBarWindow.createWindow(totalCards);
			
			for(int i=0; i<basicCards.length();i++) {
				JSONObject tObject = basicCards.getJSONObject(i);
				Card tCard = new Card();
				if(tObject.has("playerClass")) {
					tCard.setHero(tObject.getString("playerClass"));
				}
				if(!(tObject.has("playerClass"))) {
					tCard.setHero("Neutral");
				}
				if(tObject.has("cardId")) {
					tCard.setID(tObject.getString("cardId"));
				}
				if(tObject.has("cardSet")) {
					tCard.setSet(tObject.getString("cardSet"));
				}
				if(tObject.has("name")) {
					tCard.setName(tObject.getString("name"));
				}
				if(tObject.has("type")) {
					tCard.setType(tObject.getString("type"));
				}
				if(tObject.has("text")) {
					tCard.setText(tObject.getString("text"));
				}
				if(tObject.has("attack")) {
					tCard.setAttack(tObject.getInt("attack"));
				}
				if(tObject.has("health")) {
					tCard.setHealth(tObject.getInt("health"));
				}
				if(tObject.has("img")) {
					tCard.setImg(tObject.getString("img"));
					File f = new File("./resources/tempdata/cards/" + tCard.getID() + ".png");
					if(!(f.exists())) { 
						URL url = new URL(tObject.getString("img"));
						BufferedImage bi = ImageIO.read(url);
						File outputfile = new File("./resources/tempdata/cards/" + tCard.getID() + ".png");
						ImageIO.write(bi, "png", outputfile);
					}
					ProgressBarWindow.updateBar();
				}
				if(tObject.has("cost")) {
					tCard.setCost(tObject.getInt("cost"));
				}
				if(tObject.has("rarity")) {
					tCard.setRarity(tObject.getString("rarity"));
				}
				
				cards.add(tCard);	
		}
			
			for(int i=0; i<classicCards.length();i++) {
				JSONObject tObject = classicCards.getJSONObject(i);
				Card tCard = new Card();
				if(tObject.has("playerClass")) {
					tCard.setHero(tObject.getString("playerClass"));
				}
				if(!(tObject.has("playerClass"))) {
					tCard.setHero("Neutral");
				}
				if(tObject.has("cardId")) {
					tCard.setID(tObject.getString("cardId"));
				}
				if(tObject.has("cardSet")) {
					tCard.setSet(tObject.getString("cardSet"));
				}
				if(tObject.has("name")) {
					tCard.setName(tObject.getString("name"));
				}
				if(tObject.has("type")) {
					tCard.setType(tObject.getString("type"));
				}
				if(tObject.has("text")) {
					tCard.setText(tObject.getString("text"));
				}
				if(tObject.has("attack")) {
					tCard.setAttack(tObject.getInt("attack"));
				}
				if(tObject.has("health")) {
					tCard.setHealth(tObject.getInt("health"));
				}
				if(tObject.has("img")) {
					tCard.setImg(tObject.getString("img"));
					File f = new File("./resources/tempdata/cards/" + tCard.getID() + ".png");
					if(!(f.exists())) { 
						URL url = new URL(tObject.getString("img"));
						BufferedImage bi = ImageIO.read(url);
						File outputfile = new File("./resources/tempdata/cards/" + tCard.getID() + ".png");
						ImageIO.write(bi, "png", outputfile);
					}
					ProgressBarWindow.updateBar();
				}
				if(tObject.has("cost")) {
					tCard.setCost(tObject.getInt("cost"));
				}
				if(tObject.has("rarity")) {
					tCard.setRarity(tObject.getString("rarity"));
				}
				
				cards.add(tCard);	
		}
			
			for(int i=0; i<naxCards.length();i++) {
				JSONObject tObject = naxCards.getJSONObject(i);
				Card tCard = new Card();
				if(tObject.has("playerClass")) {
					tCard.setHero(tObject.getString("playerClass"));
				}
				if(!(tObject.has("playerClass"))) {
					tCard.setHero("Neutral");
				}
				if(tObject.has("cardId")) {
					tCard.setID(tObject.getString("cardId"));
				}
				if(tObject.has("cardSet")) {
					tCard.setSet(tObject.getString("cardSet"));
				}
				if(tObject.has("name")) {
					tCard.setName(tObject.getString("name"));
				}
				if(tObject.has("type")) {
					tCard.setType(tObject.getString("type"));
				}
				if(tObject.has("text")) {
					tCard.setText(tObject.getString("text"));
				}
				if(tObject.has("attack")) {
					tCard.setAttack(tObject.getInt("attack"));
				}
				if(tObject.has("health")) {
					tCard.setHealth(tObject.getInt("health"));
				}
				if(tObject.has("img")) {
					tCard.setImg(tObject.getString("img"));
					File f = new File("./resources/tempdata/cards/" + tCard.getID() + ".png");
					if(!(f.exists())) { 
						URL url = new URL(tObject.getString("img"));
						BufferedImage bi = ImageIO.read(url);
						File outputfile = new File("./resources/tempdata/cards/" + tCard.getID() + ".png");
						ImageIO.write(bi, "png", outputfile);
					}
					ProgressBarWindow.updateBar();
				}
				if(tObject.has("cost")) {
					tCard.setCost(tObject.getInt("cost"));
				}
				if(tObject.has("rarity")) {
					tCard.setRarity(tObject.getString("rarity"));
				}
				
				cards.add(tCard);	
		}
			
			for(int i=0; i<loeCards.length();i++) {
				JSONObject tObject = loeCards.getJSONObject(i);
				Card tCard = new Card();
				if(tObject.has("playerClass")) {
					tCard.setHero(tObject.getString("playerClass"));
				}
				if(!(tObject.has("playerClass"))) {
					tCard.setHero("Neutral");
				}
				if(tObject.has("cardId")) {
					tCard.setID(tObject.getString("cardId"));
				}
				if(tObject.has("cardSet")) {
					tCard.setSet(tObject.getString("cardSet"));
				}
				if(tObject.has("name")) {
					tCard.setName(tObject.getString("name"));
				}
				if(tObject.has("type")) {
					tCard.setType(tObject.getString("type"));
				}
				if(tObject.has("text")) {
					tCard.setText(tObject.getString("text"));
				}
				if(tObject.has("attack")) {
					tCard.setAttack(tObject.getInt("attack"));
				}
				if(tObject.has("health")) {
					tCard.setHealth(tObject.getInt("health"));
				}
				if(tObject.has("img")) {
					tCard.setImg(tObject.getString("img"));
					File f = new File("./resources/tempdata/cards/" + tCard.getID() + ".png");
					if(!(f.exists())) { 
						URL url = new URL(tObject.getString("img"));
						BufferedImage bi = ImageIO.read(url);
						File outputfile = new File("./resources/tempdata/cards/" + tCard.getID() + ".png");
						ImageIO.write(bi, "png", outputfile);
					}
					ProgressBarWindow.updateBar();
				}
				if(tObject.has("cost")) {
					tCard.setCost(tObject.getInt("cost"));
				}
				if(tObject.has("rarity")) {
					tCard.setRarity(tObject.getString("rarity"));
				}
				
				cards.add(tCard);	
		}
			
			for(int i=0; i<blackrockCards.length();i++) {
				JSONObject tObject = blackrockCards.getJSONObject(i);
				Card tCard = new Card();
				if(tObject.has("playerClass")) {
					tCard.setHero(tObject.getString("playerClass"));
				}
				if(!(tObject.has("playerClass"))) {
					tCard.setHero("Neutral");
				}
				if(tObject.has("cardId")) {
					tCard.setID(tObject.getString("cardId"));
				}
				if(tObject.has("cardSet")) {
					tCard.setSet(tObject.getString("cardSet"));
				}
				if(tObject.has("name")) {
					tCard.setName(tObject.getString("name"));
				}
				if(tObject.has("type")) {
					tCard.setType(tObject.getString("type"));
				}
				if(tObject.has("text")) {
					tCard.setText(tObject.getString("text"));
				}
				if(tObject.has("attack")) {
					tCard.setAttack(tObject.getInt("attack"));
				}
				if(tObject.has("health")) {
					tCard.setHealth(tObject.getInt("health"));
				}
				if(tObject.has("img")) {
					tCard.setImg(tObject.getString("img"));
					File f = new File("./resources/tempdata/cards/" + tCard.getID() + ".png");
					if(!(f.exists())) { 
						URL url = new URL(tObject.getString("img"));
						BufferedImage bi = ImageIO.read(url);
						File outputfile = new File("./resources/tempdata/cards/" + tCard.getID() + ".png");
						ImageIO.write(bi, "png", outputfile);
					}
					ProgressBarWindow.updateBar();
				}
				if(tObject.has("cost")) {
					tCard.setCost(tObject.getInt("cost"));
				}
				if(tObject.has("rarity")) {
					tCard.setRarity(tObject.getString("rarity"));
				}
				
				cards.add(tCard);	
		}
			
			for(int i=0; i<tgtCards.length();i++) {
				JSONObject tObject = tgtCards.getJSONObject(i);
				Card tCard = new Card();
				if(tObject.has("playerClass")) {
					tCard.setHero(tObject.getString("playerClass"));
				}
				if(!(tObject.has("playerClass"))) {
					tCard.setHero("Neutral");
				}
				if(tObject.has("cardId")) {
					tCard.setID(tObject.getString("cardId"));
				}
				if(tObject.has("cardSet")) {
					tCard.setSet(tObject.getString("cardSet"));
				}
				if(tObject.has("name")) {
					tCard.setName(tObject.getString("name"));
				}
				if(tObject.has("type")) {
					tCard.setType(tObject.getString("type"));
				}
				if(tObject.has("text")) {
					tCard.setText(tObject.getString("text"));
				}
				if(tObject.has("attack")) {
					tCard.setAttack(tObject.getInt("attack"));
				}
				if(tObject.has("health")) {
					tCard.setHealth(tObject.getInt("health"));
				}
				if(tObject.has("img")) {
					tCard.setImg(tObject.getString("img"));
					File f = new File("./resources/tempdata/cards/" + tCard.getID() + ".png");
					if(!(f.exists())) { 
						URL url = new URL(tObject.getString("img"));
						BufferedImage bi = ImageIO.read(url);
						File outputfile = new File("./resources/tempdata/cards/" + tCard.getID() + ".png");
						ImageIO.write(bi, "png", outputfile);
					}
					ProgressBarWindow.updateBar();
				}
				if(tObject.has("cost")) {
					tCard.setCost(tObject.getInt("cost"));
				}
				if(tObject.has("rarity")) {
					tCard.setRarity(tObject.getString("rarity"));
				}
				
				cards.add(tCard);	
		}
			ProgressBarWindow.frame.dispose();
			
		} catch (UnirestException e1) {
			e1.printStackTrace();
		}
	
//			for(int i = 0; i<cards.size();i++) { 	//Testing
//				System.out.println(cards.get(i).toString());
//			}
			
		URL update = new URL("https://dl.dropboxusercontent.com/u/82755681/DeckBuilder/update.txt");
		Scanner sUpdate = new Scanner(update.openStream());
		String checkUpdate = sUpdate.next();
		StringTokenizer st = new StringTokenizer(checkUpdate,":");
		String tempversion = st.nextToken();
		System.out.println("Server version " + tempversion);
		String tempurl = st.nextToken();
		System.out.println("Server URL " + tempurl);

		
		if(!(tempversion.equals(version))) {
			UpdateWindow.createWindow(tempurl,tempversion);
		}
		
	    try {
	    	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
	    } 
	    catch (UnsupportedLookAndFeelException e) {
       // handle exception
	    }
		
	    String inputFile = "temp.txt";
		//String inputFile = "./resources/tempdata/data/data.txt";
		String line;
		try {
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
            while((line = bufferedReader.readLine()) != null) {
               StringTokenizer fileRead = new StringTokenizer(line,"|");
               String dataType = fileRead.nextToken();
               if(dataType.equals("DECK")) {
            	   Deck tempDeck = new Deck();
            	   tempDeck.setName(fileRead.nextToken());
            	   tempDeck.setHero(fileRead.nextToken());
            	   System.out.println("found saved deck " + tempDeck.getName() + tempDeck.getHero());
            	   
            	   while(fileRead.hasMoreTokens()) {
            		   Card tempCard = null;
            		   String cardName = fileRead.nextToken();
            		   for(int i = 0; i < cards.size();i++) {
            			   if(cardName != null && cards.get(i).getName().equals(cardName)) {
            				   tempCard = cards.get(i);
            			   }
            		   }
            		   tempDeck.addCard(tempCard);
            	   }
            	   decks.add(tempDeck);
               }
               
               if(dataType.equals("COLLECTION")) {
            	   while(fileRead.hasMoreTokens()) {
            		   Card tempCard = null;
            		   String cardName = fileRead.nextToken();
            		   for(int i = 0; i < cards.size();i++) {
            			   if(cardName != null && cards.get(i).getName().equals(cardName)) {
            				   tempCard = cards.get(i);
            			   }
            		   }
                	   collection.add(tempCard);
            	   }

               }
               
            }   
            
		} catch(FileNotFoundException ex) {
			System.out.println("File not found");
		}
		
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        public void run() {
	            saveData();
	        }
	    }, "Shutdown-thread"));
		
		SplashWindow.frame.dispose();
		
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
		frmDeckbuilder.setIconImage(Toolkit.getDefaultToolkit().getImage("./resources/icons/dbicon.png"));
		frmDeckbuilder.setBackground(Color.LIGHT_GRAY);
		frmDeckbuilder.setResizable(false);
		frmDeckbuilder.setTitle("DeckBuilder " + version);
		frmDeckbuilder.setBounds(100, 100, 450, 600);
		frmDeckbuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDeckbuilder.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frmDeckbuilder.getContentPane().add(panel, "name_749988116922344");
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0};
		gbl_panel_1.rowHeights = new int[]{0};
		gbl_panel_1.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnDecks = new JButton("Decks");
		
		deckBox = new JComboBox();
		
		if(decks != null) {
		for(int i =0; i < decks.size();i++) {
			deckBox.addItem(decks.get(i).getName());
		}
		}
		
		deckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deckListPanel.removeAll();
				 Object selected = deckBox.getSelectedItem();
				 System.out.println(selected.toString());
				 currentDeck = getDeck(selected.toString());
				 System.out.println("Cards in deck " + currentDeck.getAllCards());
				 
				 for(int i=0; i<currentDeck.getAllCards().size();i++) {
					JLabel cardLabel = new JLabel();
					Card curCard = currentDeck.getAllCards().get(i);
					cardLabel.setText(curCard.getName());
					cardLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
					cardLabel.setBorder(BorderFactory.createLineBorder(Color.yellow, 3));
					cardLabel.setHorizontalAlignment(SwingConstants.CENTER);
					cardLabel.setVerticalAlignment(SwingConstants.CENTER);
					
//					checkPanel: {
//						for(int x = 0; x < deckListPanel.getComponentCount(); x++) {
//							if(cardLabel.getText().equals(((JButton) deckListPanel.getComponent(i)).getText())) {
//							((JButton) deckListPanel.getComponent(i)).setText(cardLabel.getText() + " (2)"); 
//							break checkPanel;
//							} else if(!(cardLabel.getText().equals(((JButton) deckListPanel.getComponent(i)).getText()))) {
//								deckListPanel.add(cardLabel);
//							} 
//
//						}
//					}
					
					deckListPanel.add(cardLabel);
				 }
				 

				 
				deckListPanel.revalidate();
				deckListPanel.repaint();
				
				 
				 classLabel.setText(currentDeck.getHero());
				 if(currentDeck.getHero()=="Paladin") {
				 classLabel.setIcon(paladinIcon);
				 }
				 if(currentDeck.getHero()=="Hunter") {
					 classLabel.setIcon(hunterIcon);
					 }
				 if(currentDeck.getHero()=="Mage") {
					 classLabel.setIcon(mageIcon);
					 }
				 if(currentDeck.getHero()=="Warlock") {
					 classLabel.setIcon(warlockIcon);
					 }
				 if(currentDeck.getHero()=="Druid") {
					 classLabel.setIcon(druidIcon);
					 }
				 if(currentDeck.getHero()=="Priest") {
					 classLabel.setIcon(priestIcon);
					 }
				 if(currentDeck.getHero()=="Warrior") {
					 classLabel.setIcon(warriorIcon);
					 }
				 if(currentDeck.getHero()=="Rogue") {
					 classLabel.setIcon(rogueIcon);
					 }
				 if(currentDeck.getHero()=="Shaman") {
					 classLabel.setIcon(shamanIcon);
				 }
				
			}
		});
		deckBox.setToolTipText("Decks");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 9;
		gbc_comboBox.gridy = 0;
		panel_3.add(deckBox, gbc_comboBox);
			GridBagConstraints gbc_btnDecks = new GridBagConstraints();
		gbc_btnDecks.insets = new Insets(0, 0, 5, 5);
		gbc_btnDecks.gridx = 0;
		gbc_btnDecks.gridy = 1;
		panel_3.add(btnDecks, gbc_btnDecks);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 9;
		gbc_scrollPane.gridy = 1;
		panel_3.add(scrollPane, gbc_scrollPane);
		

		scrollPane.setColumnHeaderView(classLabel);
		
		deckListPanel = new JPanel();
		deckListPanel.setLayout(new BoxLayout(deckListPanel, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(deckListPanel);
		
		JButton btnCreateADeck = new JButton("Create a Deck");
		
		btnCreateADeck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				CreateDeckWindow.createWindow();
				
			}
			
		});
		
		GridBagConstraints gbc_btnCreateADeck = new GridBagConstraints();
		gbc_btnCreateADeck.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateADeck.gridx = 0;
		gbc_btnCreateADeck.gridy = 2;
		panel_3.add(btnCreateADeck, gbc_btnCreateADeck);
		
		JButton btnDeleteDeck = new JButton("Delete Deck");
		btnDeleteDeck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tempName = deckBox.getSelectedItem().toString();
				Object tempItem = deckBox.getSelectedItem();
				deckBox.removeItem(tempItem);
				
				for(int i = 0; i < decks.size(); i++) {
					if(tempName.equals(decks.get(i).getName())) {
						decks.remove(i);
					}
				}
				deckBox.repaint();
				System.out.println("Deck " + tempName + " deleted");
			}
		});
		GridBagConstraints gbc_btnDeleteDeck = new GridBagConstraints();
		gbc_btnDeleteDeck.gridwidth = 3;
		gbc_btnDeleteDeck.insets = new Insets(0, 0, 5, 0);
		gbc_btnDeleteDeck.gridx = 9;
		gbc_btnDeleteDeck.gridy = 4;
		panel_3.add(btnDeleteDeck, gbc_btnDeleteDeck);
		
		JMenuBar menuBar = new JMenuBar();
		frmDeckbuilder.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Export");
		mnFile.add(mntmNewMenuItem);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDeckbuilder.dispatchEvent(new WindowEvent(frmDeckbuilder, WindowEvent.WINDOW_CLOSING));
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnCollection = new JMenu("Collection");
		menuBar.add(mnCollection);
		
		JMenuItem mntmOpenCollection = new JMenuItem("Open Collection");
		mntmOpenCollection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CollectionWindow.createWindow(collection);
			}
		});
		mnCollection.add(mntmOpenCollection);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnHelp.add(mntmAbout);
	}
	   
	   
	   public static Card getAnyCard(String name) {
		   
		   for(int i=0; i<cards.size();i++) {
			   if(cards.get(i).getName().equals(name)) {
				   return cards.get(i);
			   } else {
				   return null;
			   }
		   }
		return null;
		   
	   }
	   
	   public static Deck getDeck(String name) {
		   
		   for(int i = 0; i < decks.size(); i++) {
			   if(decks.get(i).getName().equals(name)) {
				   return decks.get(i);
			   }
		   }
		   return null;
	   }
	   
	   public static void saveData() {
		   System.out.println("Saving...");
		   String outputFile = "./resources/tempdata/data/data.txt";
		   BufferedWriter output = null;
		   try {
			output = new BufferedWriter(new FileWriter(outputFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		   for(int i=0;i<decks.size();i++) {
			   try {
				output.write(decks.get(i).toString());
				output.newLine();
				 System.out.println("Wrote " + decks.get(i).getName() + " to file");
			} catch (IOException e) {
				System.out.println("Write deck error");
				e.printStackTrace();
			}
		   }
		   
		   String collectionStr = "COLLECTION|";
		   
		   for(int i=0; i <collection.size();i++) {
			   collectionStr =  collectionStr + collection.get(i) + "|";
		   }
		   
		   try {
			output.write(collectionStr);
			System.out.println("Wrote collection to file");
		} catch (IOException e) {
			e.printStackTrace();
		}
		  try {
			output.close();
			System.out.println("Data File saved");
		} catch (IOException e) {
			e.printStackTrace();
		}
	   }
	   
	   
	   public static ArrayList<Card> createCardList(String input, int type) {
		   ArrayList<Card> outputList = new ArrayList<Card>();
		   
		   if(type == 0) { //Get cards by Class
			   
			   for(int i = 0; i<cards.size();i++) {
				   if(cards.get(i).getHero().equals(input) && cards.get(i).hasImage() == true &&
						   (cards.get(i).getType().equals("Weapon") || cards.get(i).getType().equals("Minion") ||
								   cards.get(i).getType().equals("Spell") || cards.get(i).getType().equals("Enchantment"))) {
					   outputList.add(cards.get(i));
				   }
			   }
			   
		   }
		   
		   
		   if(type == 1) { //Get cards by name (search)
			   
			   for(int i = 0; i<cards.size();i++) {
				   if(cards.get(i).getName().equals(input) && 
						   (cards.get(i).getType().equals("Weapon") || cards.get(i).getType().equals("Minion") ||
								   cards.get(i).getType().equals("Spell") || cards.get(i).getType().equals("Enchantment"))) {
					   outputList.add(cards.get(i));
				   }
			   }
			   
			   
		   }
		   
		   if(type == 2) { //Get cards by format
			   
			   
		   }
		   
		   
		   return outputList;
	   }
	   
	   public void downloadImage() {
		   
	   }
	  
}
