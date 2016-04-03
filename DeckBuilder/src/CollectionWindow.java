import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;


public class CollectionWindow {
	
	JPanel cardPanel;
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
		frmCollectionManager.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frmCollectionManager.getContentPane().setLayout(gridBagLayout);
		
		JButton btnWar = new JButton("");
		btnWar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		Image warImage = null;
		try {
			warImage = ImageIO.read(new File("./resources/icons/warrioricon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Image tempImage = warImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnWar.setIcon(new ImageIcon(tempImage));
		
		btnWar.setOpaque(false);
		btnWar.setContentAreaFilled(false);
		GridBagConstraints gbc_btnWar = new GridBagConstraints();
		gbc_btnWar.insets = new Insets(0, 0, 5, 5);
		gbc_btnWar.gridx = 0;
		gbc_btnWar.gridy = 1;
		frmCollectionManager.getContentPane().add(btnWar, gbc_btnWar);
		
		JButton btnWarlock = new JButton("");
		btnWarlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Image warlockImage = null;
		try {
			warlockImage = ImageIO.read(new File("./resources/icons/warlockicon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		tempImage = warlockImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnWarlock.setIcon(new ImageIcon(tempImage));
		
		
		btnWarlock.setOpaque(false);
		btnWarlock.setContentAreaFilled(false);
		GridBagConstraints gbc_btnWarlock = new GridBagConstraints();
		gbc_btnWarlock.insets = new Insets(0, 0, 5, 5);
		gbc_btnWarlock.gridx = 1;
		gbc_btnWarlock.gridy = 1;
		frmCollectionManager.getContentPane().add(btnWarlock, gbc_btnWarlock);
		
		JButton btnRogue = new JButton("");
		btnRogue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Image rogueImage = null;
		try {
			rogueImage = ImageIO.read(new File("./resources/icons/rogueicon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		tempImage = rogueImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnRogue.setIcon(new ImageIcon(tempImage));
		
		btnRogue.setOpaque(false);
		btnRogue.setContentAreaFilled(false);
		GridBagConstraints gbc_btnRogue = new GridBagConstraints();
		gbc_btnRogue.insets = new Insets(0, 0, 5, 5);
		gbc_btnRogue.gridx = 2;
		gbc_btnRogue.gridy = 1;
		frmCollectionManager.getContentPane().add(btnRogue, gbc_btnRogue);
		
		JButton btnMage = new JButton("");
		btnMage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Image mageImage = null;
		try {
			mageImage = ImageIO.read(new File("./resources/icons/mageicon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		tempImage = mageImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnMage.setIcon(new ImageIcon(tempImage));
		
		btnMage.setOpaque(false);
		btnMage.setContentAreaFilled(false);
		GridBagConstraints gbc_btnMage = new GridBagConstraints();
		gbc_btnMage.insets = new Insets(0, 0, 5, 5);
		gbc_btnMage.gridx = 3;
		gbc_btnMage.gridy = 1;
		frmCollectionManager.getContentPane().add(btnMage, gbc_btnMage);
		
		JButton btnShaman = new JButton("");
		btnShaman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Image shamanImage = null;
		try {
			shamanImage = ImageIO.read(new File("./resources/icons/shamanicon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		tempImage = shamanImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnShaman.setIcon(new ImageIcon(tempImage));
		
		btnShaman.setOpaque(false);
		btnShaman.setContentAreaFilled(false);
		GridBagConstraints gbc_btnShaman = new GridBagConstraints();
		gbc_btnShaman.insets = new Insets(0, 0, 5, 5);
		gbc_btnShaman.gridx = 4;
		gbc_btnShaman.gridy = 1;
		frmCollectionManager.getContentPane().add(btnShaman, gbc_btnShaman);
		
		JButton btnDruid = new JButton("");
		btnDruid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Image druidImage = null;
		try {
			druidImage = ImageIO.read(new File("./resources/icons/druidicon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		tempImage = druidImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnDruid.setIcon(new ImageIcon(tempImage));
		
		btnDruid.setOpaque(false);
		btnDruid.setContentAreaFilled(false);
		GridBagConstraints gbc_btnDruid = new GridBagConstraints();
		gbc_btnDruid.insets = new Insets(0, 0, 5, 5);
		gbc_btnDruid.gridx = 5;
		gbc_btnDruid.gridy = 1;
		frmCollectionManager.getContentPane().add(btnDruid, gbc_btnDruid);
		
		JButton btnPaladin = new JButton("");
		btnPaladin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Image paladinImage = null;
		try {
			paladinImage = ImageIO.read(new File("./resources/icons/paladinicon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		tempImage = paladinImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnPaladin.setIcon(new ImageIcon(tempImage));
		
		btnPaladin.setOpaque(false);
		btnPaladin.setContentAreaFilled(false);
		GridBagConstraints gbc_btnPaladin = new GridBagConstraints();
		gbc_btnPaladin.insets = new Insets(0, 0, 5, 5);
		gbc_btnPaladin.gridx = 6;
		gbc_btnPaladin.gridy = 1;
		frmCollectionManager.getContentPane().add(btnPaladin, gbc_btnPaladin);
		
		JButton btnPriest = new JButton("");
		btnPriest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Image priestImage = null;
		try {
			priestImage = ImageIO.read(new File("./resources/icons/priesticon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		tempImage = priestImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnPriest.setIcon(new ImageIcon(tempImage));
		
		btnPriest.setOpaque(false);
		btnPriest.setContentAreaFilled(false);
		GridBagConstraints gbc_btnPriest = new GridBagConstraints();
		gbc_btnPriest.insets = new Insets(0, 0, 5, 5);
		gbc_btnPriest.gridx = 7;
		gbc_btnPriest.gridy = 1;
		frmCollectionManager.getContentPane().add(btnPriest, gbc_btnPriest);
		
		JButton btnHunter = new JButton("");
		btnHunter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Image hunterImage = null;
		try {
			hunterImage = ImageIO.read(new File("./resources/icons/huntericon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		tempImage = hunterImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnHunter.setIcon(new ImageIcon(tempImage));
		
		btnHunter.setOpaque(false);
		btnHunter.setContentAreaFilled(false);
		GridBagConstraints gbc_btnHunter = new GridBagConstraints();
		gbc_btnHunter.insets = new Insets(0, 0, 5, 5);
		gbc_btnHunter.gridx = 8;
		gbc_btnHunter.gridy = 1;
		frmCollectionManager.getContentPane().add(btnHunter, gbc_btnHunter);
		
		JButton btnNeutral = new JButton("");
		btnNeutral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Image neutralImage = null;
		try {
			neutralImage = ImageIO.read(new File("./resources/icons/neutralicon.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		tempImage = neutralImage.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		btnNeutral.setIcon(new ImageIcon(tempImage));
		
		btnNeutral.setOpaque(false);
		btnNeutral.setContentAreaFilled(false);
		GridBagConstraints gbc_btnNeutral = new GridBagConstraints();
		gbc_btnNeutral.insets = new Insets(0, 0, 5, 5);
		gbc_btnNeutral.gridx = 9;
		gbc_btnNeutral.gridy = 1;
		frmCollectionManager.getContentPane().add(btnNeutral, gbc_btnNeutral);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 11;
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		frmCollectionManager.getContentPane().add(scrollPane, gbc_scrollPane);
		
		cardPanel = new JPanel();
		scrollPane.setViewportView(cardPanel);
	}

}
