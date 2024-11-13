package pharmacy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateStoc {

	private JFrame frmClaudesPharmacyApp;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStoc window = new UpdateStoc();
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
	public UpdateStoc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClaudesPharmacyApp = new JFrame();
		frmClaudesPharmacyApp.setTitle("Claude's Pharmacy App");
		frmClaudesPharmacyApp.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\eclipse workspace\\PharmacyApp\\pharmacy.png"));
		frmClaudesPharmacyApp.setBounds(100, 100, 450, 300);
		frmClaudesPharmacyApp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmClaudesPharmacyApp.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introdu medicamentul:");
		lblNewLabel.setBounds(48, 10, 167, 24);
		frmClaudesPharmacyApp.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(225, 13, 148, 19);
		frmClaudesPharmacyApp.getContentPane().add(textField);
		textField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(225, 42, 148, 26);
		frmClaudesPharmacyApp.getContentPane().add(spinner);
		
		JLabel lblIntroduCantitatea = new JLabel("Introdu cantitatea:");
		lblIntroduCantitatea.setBounds(48, 44, 167, 24);
		frmClaudesPharmacyApp.getContentPane().add(lblIntroduCantitatea);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String med=String.valueOf(textField.getText());
					//System.out.println(med);
					int now = getQuantity(String.valueOf(textField.getText()));
					int add = Integer.parseInt(String.valueOf(spinner.getValue()));
					int sum = now+add;
					//System.out.println(sum);
					updateQuantity(med,sum);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setSize(new Dimension(32, 32));
		btnNewButton.setFont(new Font("Gabriola", Font.BOLD, 20));
		btnNewButton.setIcon(new ImageIcon("D:\\eclipse workspace\\PharmacyApp\\update.png"));
		btnNewButton.setBounds(156, 103, 161, 54);
		frmClaudesPharmacyApp.getContentPane().add(btnNewButton);
	}
	public static int getQuantity(String a) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM pharmacy.drug where name like '" + a + "' ;");
		int s = 0;
		if (rs.next()) {
			s = rs.getInt("quantity");
		}
		con.close();
		return s;
	}
	
	public static void updateQuantity(String a, int b) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		Statement stmt = con.createStatement();
		stmt.executeUpdate("UPDATE `pharmacy`.`drug` SET `quantity` = '" + b + "' WHERE (`name` = '" + a + "');");
		con.close();
	}
}
