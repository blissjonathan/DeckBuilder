import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.*;



public class MainWindow {
ArrayList<Deck> decks = new ArrayList<Deck>();


	private JFrame frmDeckbuilder;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String inputFile = "data.txt";
		String line;
		try {
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   
            
		} catch(FileNotFoundException ex) {
			
		}
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
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnDecks = new JButton("Decks");
		btnDecks.addActionListener(new actionListener());
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Decks");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 9;
		gbc_comboBox.gridy = 0;
		panel_3.add(comboBox, gbc_comboBox);
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
		
		String[] tmp = new String[30];
		for(int i=0;i<30;i++) {
			tmp[i]=("Label " +i);
		}
		
		
		JList list = new JList(tmp);

		scrollPane.setViewportView(list);
		
		JLabel lblclass = new JLabel("$CLASS");
		scrollPane.setColumnHeaderView(lblclass);
		
		JButton btnCreateADeck = new JButton("Create a Deck");
		btnCreateADeck.addActionListener(new actionListener());
		GridBagConstraints gbc_btnCreateADeck = new GridBagConstraints();
		gbc_btnCreateADeck.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateADeck.gridx = 0;
		gbc_btnCreateADeck.gridy = 2;
		panel_3.add(btnCreateADeck, gbc_btnCreateADeck);
		
		JMenuBar menuBar = new JMenuBar();
		frmDeckbuilder.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Export");
		mnFile.add(mntmNewMenuItem);
		
		JMenu mnCollection = new JMenu("Collection");
		menuBar.add(mnCollection);
	}
	
	   class actionListener implements ActionListener{
		      public void actionPerformed(ActionEvent e) {
		      if (e.getSource().toString()=="Decks"){
		      }
		      if (e.getSource().toString()=="Create a Deck"){
		      }
		  }
	   }

}
