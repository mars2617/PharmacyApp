package pharmacy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class InsertUser {

	private JFrame frmClaudesPharmacyApp;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private JPasswordField passwordField;
	int ad = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertUser window = new InsertUser();
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
	public InsertUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClaudesPharmacyApp = new JFrame();
		frmClaudesPharmacyApp.setTitle("Claude's Pharmacy App");
		frmClaudesPharmacyApp
				.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\eclipse workspace\\PharmacyApp\\pharmacy.png"));
		frmClaudesPharmacyApp.setBounds(100, 100, 445, 533);
		frmClaudesPharmacyApp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmClaudesPharmacyApp.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Insert the name:");
		lblNewLabel.setBounds(10, 29, 148, 21);
		frmClaudesPharmacyApp.getContentPane().add(lblNewLabel);

		JLabel lblInsertTheSurname = new JLabel("Insert the surname:");
		lblInsertTheSurname.setBounds(10, 79, 148, 21);
		frmClaudesPharmacyApp.getContentPane().add(lblInsertTheSurname);

		JLabel lblInsertTheUsername = new JLabel("Insert the username:");
		lblInsertTheUsername.setBounds(10, 129, 148, 21);
		frmClaudesPharmacyApp.getContentPane().add(lblInsertTheUsername);

		JLabel lblInsertThePassword = new JLabel("Insert the password:");
		lblInsertThePassword.setBounds(10, 179, 148, 21);
		frmClaudesPharmacyApp.getContentPane().add(lblInsertThePassword);

		JLabel lblInsertTheAdress = new JLabel("Insert the adress:");
		lblInsertTheAdress.setBounds(10, 229, 148, 21);
		frmClaudesPharmacyApp.getContentPane().add(lblInsertTheAdress);

		JLabel lblInsertThePhone = new JLabel("Insert the phone:");
		lblInsertThePhone.setBounds(10, 279, 148, 21);
		frmClaudesPharmacyApp.getContentPane().add(lblInsertThePhone);

		JLabel lblInsertTheEmail = new JLabel("Insert the email:");
		lblInsertTheEmail.setBounds(10, 329, 148, 21);
		frmClaudesPharmacyApp.getContentPane().add(lblInsertTheEmail);

		JLabel lblIsTheUser = new JLabel("Is the user an admin?");
		lblIsTheUser.setBounds(10, 429, 148, 21);
		frmClaudesPharmacyApp.getContentPane().add(lblIsTheUser);

		JLabel lblInsertTheCountry = new JLabel("Insert the country:");
		lblInsertTheCountry.setBounds(10, 379, 148, 21);
		frmClaudesPharmacyApp.getContentPane().add(lblInsertTheCountry);

		textField = new JTextField();
		textField.setBounds(168, 30, 148, 19);
		frmClaudesPharmacyApp.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(168, 80, 148, 19);
		frmClaudesPharmacyApp.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(168, 130, 148, 19);
		frmClaudesPharmacyApp.getContentPane().add(textField_2);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(168, 230, 148, 19);
		frmClaudesPharmacyApp.getContentPane().add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(168, 280, 148, 19);
		frmClaudesPharmacyApp.getContentPane().add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(168, 330, 148, 19);
		frmClaudesPharmacyApp.getContentPane().add(textField_6);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(168, 380, 148, 19);
		frmClaudesPharmacyApp.getContentPane().add(textField_8);

		passwordField = new JPasswordField();
		passwordField.setBounds(168, 180, 148, 20);
		frmClaudesPharmacyApp.getContentPane().add(passwordField);

		JCheckBox chckbxNewCheckBox = new JCheckBox("");

		chckbxNewCheckBox.setBounds(164, 429, 37, 21);
		frmClaudesPharmacyApp.getContentPane().add(chckbxNewCheckBox);

		JButton btnNewButton = new JButton("Register!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String surname = textField_1.getText();
				String username = textField_2.getText();
				String password = passwordField.getText();
				String adress = textField_4.getText();
				String phone = textField_5.getText();
				String email = textField_6.getText();
				if (chckbxNewCheckBox.isSelected()) {
					ad = 1;
				}
				int admin = ad;
				String country = textField_8.getText();
				try {
					insertUser(name, surname, username, password, adress, phone, email, admin, country);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					searchUser(username);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				passwordField.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				ad = 0;
				textField_8.setText("");
			}
			
		});
		btnNewButton.setBounds(207, 429, 109, 21);
		frmClaudesPharmacyApp.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmClaudesPharmacyApp.dispose();
			}
		});
		btnNewButton_1.setBounds(207, 460, 109, 21);
		frmClaudesPharmacyApp.getContentPane().add(btnNewButton_1);

	}

	public static void insertUser(String name, String surname, String username, String password, String adress,
			String phone, String email, int admin, String country) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
		Statement stmt = con.createStatement();
		stmt.executeUpdate(
				"INSERT INTO `pharmacy`.`users` ( `name`, `surname`, `username`, `password`, `adress`, `phone`, `email`, `admin`, `country`)"
						+ "VALUES ('" + name + "', '" + surname + "', '" + username + "', '" + password + "', '"
						+ adress + "', '" + phone + "', '" + email + "', '" + admin + "', '" + country + "');");
		con.close();
	}
	
	public static void searchUser(String j) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet rs5 = stmt.executeQuery("SELECT * FROM pharmacy.users where username like '" + j + "' ;");
		if (rs5.next()) {
			JOptionPane.showMessageDialog(null, "Registration complete!");
		}else {
			JOptionPane.showMessageDialog(null, "Registration incomplete. Please try again!", "Registration ERROR", JOptionPane.ERROR_MESSAGE);
		}
		con.close();

	}
}
