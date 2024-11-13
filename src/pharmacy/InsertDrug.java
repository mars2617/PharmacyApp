package pharmacy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class InsertDrug {

	private JFrame frmClaudesPharmacyApp;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertDrug window = new InsertDrug();
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
	public InsertDrug() {
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
		frmClaudesPharmacyApp.setBounds(100, 100, 542, 583);
		frmClaudesPharmacyApp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmClaudesPharmacyApp.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Denumirea medicamentului");
		lblNewLabel.setBounds(10, 52, 167, 19);
		frmClaudesPharmacyApp.getContentPane().add(lblNewLabel);

		JLabel lblDescriereaMedicamentului = new JLabel("Descrierea medicamentului");
		lblDescriereaMedicamentului.setBounds(10, 123, 167, 19);
		frmClaudesPharmacyApp.getContentPane().add(lblDescriereaMedicamentului);

		JLabel lblTara = new JLabel("Tara");
		lblTara.setBounds(50, 194, 84, 19);
		frmClaudesPharmacyApp.getContentPane().add(lblTara);

		JLabel lblCantitatea = new JLabel("Cantitatea");
		lblCantitatea.setBounds(50, 265, 84, 19);
		frmClaudesPharmacyApp.getContentPane().add(lblCantitatea);

		JLabel lblDiagnostic = new JLabel("Diagnostic");
		lblDiagnostic.setBounds(50, 336, 84, 19);
		frmClaudesPharmacyApp.getContentPane().add(lblDiagnostic);

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(50, 407, 84, 19);
		frmClaudesPharmacyApp.getContentPane().add(lblData);

		JLabel lblPretul = new JLabel("Pretul");
		lblPretul.setBounds(50, 478, 84, 19);
		frmClaudesPharmacyApp.getContentPane().add(lblPretul);

		textField = new JTextField();
		textField.setBounds(187, 52, 258, 19);
		frmClaudesPharmacyApp.getContentPane().add(textField);
		textField.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(187, 120, 258, 63);
		frmClaudesPharmacyApp.getContentPane().add(textArea);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(187, 194, 258, 19);
		frmClaudesPharmacyApp.getContentPane().add(textField_1);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(187, 265, 51, 20);
		frmClaudesPharmacyApp.getContentPane().add(spinner);

		textField_2 = new JTextField();
		textField_2.setBounds(187, 336, 258, 19);
		frmClaudesPharmacyApp.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(187, 407, 258, 19);
		frmClaudesPharmacyApp.getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(187, 478, 126, 19);
		frmClaudesPharmacyApp.getContentPane().add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("Adauga medicament");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = textField.getText();
					String description = textArea.getText();
					String country = textField_1.getText();
					int quantity = (Integer) spinner.getValue();
					String diagnosis = textField_2.getText();
					String date = textField_3.getText();
					String pr = textField_4.getText();
					float price = Float.parseFloat(pr);

					insertDrug(name, description, country, quantity, diagnosis, date, price);
					searchDrug(name);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ivalid data. Please try again!", "Registration ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

				textField.setText("");
				textArea.setText("");
				textField_1.setText("");
				spinner.setValue(0);
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\eclipse workspace\\PharmacyApp\\pills.png"));
		btnNewButton.setBounds(323, 477, 190, 63);
		frmClaudesPharmacyApp.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Inapoi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmClaudesPharmacyApp.dispose();
			}
		});
		btnNewButton_1.setBounds(187, 507, 85, 21);
		frmClaudesPharmacyApp.getContentPane().add(btnNewButton_1);
	}

	public static void insertDrug(String name, String description, String country, int quantity, String diagnosis,
			String date, float price) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "root");
		Statement stmt = con.createStatement();
		stmt.executeUpdate(
				"INSERT INTO `pharmacy`.`drug` ( `name`, `description`, `country`, `quantity`, `diagnosis`, `date`, `price`)"
						+ "VALUES ('" + name + "', '" + description + "', '" + country + "', '" + quantity + "', '"
						+ diagnosis + "', '" + date + "', '" + price + "');");
		con.close();
	}

	public static void searchDrug(String j) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet rs5 = stmt.executeQuery("SELECT * FROM pharmacy.drug where name like '" + j + "' ;");
		if (rs5.next()) {
			JOptionPane.showMessageDialog(null, "Inregistrarea medicamentului cu succes!");
		} else {
			JOptionPane.showMessageDialog(null, "Inregistrare nereusita. Incercati din nou!", "Eroare de inregistrare",
					JOptionPane.ERROR_MESSAGE);
		}
		con.close();

	}

}
