package pharmacy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AddAdmin {

	private JFrame frmClaudesPharmacyApp;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAdmin window = new AddAdmin();
					window.frmClaudesPharmacyApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClaudesPharmacyApp = new JFrame();
		frmClaudesPharmacyApp
				.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\eclipse workspace\\PharmacyApp\\pharmacy.png"));
		frmClaudesPharmacyApp.setTitle("Claude's Pharmacy App");
		frmClaudesPharmacyApp.setBounds(100, 100, 350, 296);
		frmClaudesPharmacyApp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmClaudesPharmacyApp.getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Vreti sa faceti admin un user inregistrat deja?", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(10, 21, 316, 97);
		frmClaudesPharmacyApp.getContentPane().add(panel_1);

		textField = new JTextField();
		textField.setBounds(110, 23, 96, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Make admin");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					makeAdmin1(String.valueOf(textField.getText()));
					JOptionPane.showMessageDialog(null, "Inregistrare reusita!", "Mesaj de inregistrare",
							JOptionPane.INFORMATION_MESSAGE);
					textField.setText(null);
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(97, 52, 122, 21);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Nume:");
		lblNewLabel.setBounds(10, 23, 45, 13);
		panel_1.add(lblNewLabel);

		

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Insereaza un user nou ca admin", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 128, 316, 97);
		frmClaudesPharmacyApp.getContentPane().add(panel_2);

		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(Color.GRAY);
		btnRegister.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 16));
		btnRegister.setBackground(new Color(0, 255, 255));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				InsertUser.main(null);

			}
		});
		btnRegister.setBounds(103, 38, 109, 21);
		panel_2.add(btnRegister);
	}

	public static void makeAdmin(String a) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("UPDATE `pharmacy`.`users` SET `admin` = '1' WHERE (`username` = '" + a + "');");
		con.close();
	}
	
	public static void makeAdmin1(String a) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("UPDATE `pharmacy`.`users` SET `admin` = '1' WHERE (`name` = '" + a + "');");
		con.close();
	}
}
