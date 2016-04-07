import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DeckHelperWindow {

	private JFrame frmDeckHelper;

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 254, 424, 259);
		frmDeckHelper.getContentPane().add(scrollPane);
		
		JPanel cardPanel = new JPanel();
		scrollPane.setViewportView(cardPanel);
		
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
		
		JLabel lblFinisherlabel = new JLabel("finisherlabel");
		lblFinisherlabel.setBounds(109, 108, 74, 14);
		frmDeckHelper.getContentPane().add(lblFinisherlabel);
		
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
		
		JLabel lblBoardclear = new JLabel("boardclear");
		lblBoardclear.setBounds(109, 142, 74, 14);
		frmDeckHelper.getContentPane().add(lblBoardclear);
		
		JLabel lblBurst = new JLabel("burst");
		lblBurst.setBounds(109, 176, 74, 14);
		frmDeckHelper.getContentPane().add(lblBurst);
		
		JLabel lblValue = new JLabel("value");
		lblValue.setBounds(333, 108, 74, 14);
		frmDeckHelper.getContentPane().add(lblValue);
		
		JLabel lblTempo = new JLabel("tempo");
		lblTempo.setBounds(333, 142, 74, 14);
		frmDeckHelper.getContentPane().add(lblTempo);
	}
}
