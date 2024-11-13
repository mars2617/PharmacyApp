package pharmacy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class PharmacyApp {

	private JFrame frmPharmacylogin;
	private static JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PharmacyApp window = new PharmacyApp();
					window.frmPharmacylogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PharmacyApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPharmacylogin = new JFrame();
		frmPharmacylogin.getContentPane().setLocale(Locale.US);
		frmPharmacylogin.setTitle("Claude's Pharmacy App");
		frmPharmacylogin
				.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\eclipse workspace\\PharmacyApp\\pharmacy.png"));
		frmPharmacylogin.setBounds(100, 100, 450, 300);
		frmPharmacylogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPharmacylogin.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(63, 53, 101, 28);
		frmPharmacylogin.getContentPane().add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(63, 109, 101, 28);
		frmPharmacylogin.getContentPane().add(lblPassword);

		setTextField(new JTextField());
		getTextField().setBounds(170, 58, 121, 19);
		frmPharmacylogin.getContentPane().add(getTextField());
		getTextField().setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(170, 114, 121, 19);
		frmPharmacylogin.getContentPane().add(passwordField);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = getTextField().getText();
				String password = passwordField.getText();
				try {
					login(username, password);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frmPharmacylogin.dispose();
			}
		});
		btnNewButton.setBounds(88, 202, 85, 21);
		frmPharmacylogin.getContentPane().add(btnNewButton);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertUser.main(null);
			}
		});
		btnRegister.setBounds(261, 202, 85, 21);
		frmPharmacylogin.getContentPane().add(btnRegister);
	}

	public static void login(String username, String password) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM pharmacy.users where username like '" + username + "' AND "
				+ "password like '" + password + "';");
		if (rs.next()) {
			JOptionPane.showMessageDialog(null, "Logare reusita!", "Mesaj de log in", JOptionPane.INFORMATION_MESSAGE);
			LocalDate nowDate = LocalDate.now();
			LocalTime nowTime = LocalTime.now();
			FileWriter fileWriter;
			fileWriter = new FileWriter(new File("loginfo.txt"), true);
			fileWriter.write("User: " + username + "\n");
			fileWriter.write("Logat la data " + nowDate + " si ora: " + nowTime + "\n");
			fileWriter.write("\n");
			fileWriter.write("---------------------------------" + "\n");
			fileWriter.write("\n");
			fileWriter.flush();
			fileWriter.close();
			WindowPharmacyApp.main(null);
		} else {

			JOptionPane.showMessageDialog(null, "Invalid login. Please try again!", "Login ERROR",
					JOptionPane.ERROR_MESSAGE);
			PharmacyApp.main(null);
		}
		con.close();
	}

	public static JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
}
