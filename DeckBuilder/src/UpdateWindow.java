import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextField;


public class UpdateWindow {

	private JFrame frmUpdate;
	private JTextField txtUrl;
	private static String updateURL;

	/**
	 * Launch the application.
	 */
	public static void createWindow(String _updateURL) {
		updateURL = _updateURL;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateWindow window = new UpdateWindow();
					window.frmUpdate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdate = new JFrame();
		frmUpdate.setTitle("Update!");
		frmUpdate.setResizable(false);
		frmUpdate.setBounds(100, 100, 311, 207);
		frmUpdate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblANewVersion = new JLabel("A new version of DeckBuilder has been released!");
		
		JLabel lblVersion = new JLabel("Version:");
		
		JLabel lblVersionnum = new JLabel("versionnum");
		
		JLabel lblGetItAt = new JLabel("Get it at:");
		
		JButton btnOk = new JButton("OK");
		
		txtUrl = new JTextField();
		txtUrl.setText(updateURL);
		txtUrl.setEditable(false);
		txtUrl.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frmUpdate.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(115)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOk)
								.addComponent(lblGetItAt)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addComponent(lblVersion)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblVersionnum))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtUrl)
								.addComponent(lblANewVersion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblANewVersion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVersion)
						.addComponent(lblVersionnum))
					.addGap(38)
					.addComponent(lblGetItAt)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addComponent(btnOk)
					.addContainerGap())
		);
		frmUpdate.getContentPane().setLayout(groupLayout);
	}
}
