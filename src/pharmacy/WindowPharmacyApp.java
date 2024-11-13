package pharmacy;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import javax.imageio.IIOImage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultDesktopManager;
import javax.swing.DesktopManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class WindowPharmacyApp {

	private JFrame frmClaudesPharmacyApp;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JComboBox comboBox;
	static JTextArea textArea_1;
	static JSpinner spinner;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	JPanel panel_1;
	JRadioButton rdbtnCumparatorulNuDetine;
	JRadioButton rdbtnNewRadioButton;
	JPanel panel_2;

	JPanel panel_6;
	JScrollPane scrollPane;
	DefaultTableModel model;
	float total = 0;
	float total1 = 0;
	private JTable table_1;
	JSpinner spinner_1;
	JRadioButton rdbtnNewRadioButton_1;
	JRadioButton rdbtnNewRadioButton_1_1;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowPharmacyApp window = new WindowPharmacyApp();
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
	public WindowPharmacyApp() {
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
		frmClaudesPharmacyApp.setBounds(100, 100, 719, 519);
		frmClaudesPharmacyApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClaudesPharmacyApp.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.PINK);
		menuBar.setBackground(Color.PINK);
		menuBar.setBounds(0, 0, 745, 22);
		frmClaudesPharmacyApp.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Meniu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Fereastra noua");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowPharmacyApp.main(null);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Refresh");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				spinner.setValue(0);
				textArea_1.setText(null);

			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Print");
		mnNewMenu.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Exit");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);

		JMenu mnNewMenu_1 = new JMenu("Actiuni");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Adaugare admin");
		try {
			if (checkAdmin(String.valueOf(PharmacyApp.getTextField().getText())) == 1) {

				mntmNewMenuItem_1.setEnabled(true);
			} else {
				mntmNewMenuItem_1.setEnabled(false);
			}
		} catch (ClassNotFoundException | SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAdmin.main(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Stergere user");
		mnNewMenu_1.add(mntmNewMenuItem_1_1);
		try {
			if (checkAdmin(String.valueOf(PharmacyApp.getTextField().getText())) == 1) {
				System.out.println(checkAdmin(String.valueOf(PharmacyApp.getTextField().getText())));
				mntmNewMenuItem_1_1.setEnabled(true);
			} else {
				mntmNewMenuItem_1_1.setEnabled(false);
			}
		} catch (ClassNotFoundException | SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Adaugare medicament");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertDrug.main(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Update stoc");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStoc.main(null);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);

		JMenu mnNewMenu_2 = new JMenu("Ajutor");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Despre aplicatie");
		mnNewMenu_2.add(mntmNewMenuItem_2);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 35, 685, 437);
		frmClaudesPharmacyApp.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Informatii medicament", null, panel, null);
		tabbedPane.setEnabledAt(0, true);
		panel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(null, "Cautare in stoc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setToolTipText("");
		panel_3.setBounds(10, 10, 660, 144);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("Denumire:");
		lblNewLabel.setBounds(48, 39, 75, 13);
		panel_3.add(lblNewLabel);

		JLabel lblDiagnostic = new JLabel("Diagnostic:");
		lblDiagnostic.setBounds(48, 91, 86, 13);
		panel_3.add(lblDiagnostic);

		textField = new JTextField();
		textField.setBounds(152, 36, 151, 19);
		panel_3.add(textField);
		textField.setColumns(10);

		try {
			comboBox = new JComboBox(new DefaultComboBoxModel(searchDrugDes()));
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		comboBox.setBounds(152, 87, 151, 21);
		panel_3.add(comboBox);
		ImageIcon search = new ImageIcon("D:\\eclipse workspace\\PharmacyApp\\search.png");
		JButton btnNewButton = new JButton("Cauta", search);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (textField.getText().equals("")) {
						String selected = comboBox.getSelectedItem().toString();
						searchDrugComboBox(selected);
					} else {
						searchDrug(textField.getText());
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Gabriola", Font.BOLD, 30));

		btnNewButton.setBounds(449, 31, 184, 90);
		panel_3.add(btnNewButton);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Informatii", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 161, 660, 239);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblDisponibilitate = new JLabel("Disponibilitate:");
		lblDisponibilitate.setBounds(47, 22, 90, 13);
		panel_4.add(lblDisponibilitate);

		JLabel lblDescriere = new JLabel("Descriere:");
		lblDescriere.setBounds(47, 63, 90, 13);
		panel_4.add(lblDescriere);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(147, 57, 488, 70);
		panel_4.add(scrollPane_2);

		textArea_1 = new JTextArea();
		scrollPane_2.setViewportView(textArea_1);
		textArea_1.setBackground(Color.WHITE);
		textArea_1.setEditable(false);

		JLabel lblCantitate = new JLabel("Cantitate:");
		lblCantitate.setBounds(47, 145, 90, 13);
		panel_4.add(lblCantitate);

		JLabel lblPret = new JLabel("Pret:");
		lblPret.setBounds(47, 184, 90, 13);
		panel_4.add(lblPret);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(147, 181, 64, 19);
		panel_4.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblRonbucata = new JLabel("RON/bucata");
		lblRonbucata.setBounds(223, 184, 90, 13);
		panel_4.add(lblRonbucata);

		JButton btnNewButton_1 = new JButton("Adauga in cos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_3.setText(textField.getText() + "(" + comboBox.getSelectedItem().toString() + ")");
				tabbedPane.setSelectedComponent(panel_1);

				total = 0 + Float.parseFloat(textField_1.getText());

			}
		});
		btnNewButton_1.setIcon(new ImageIcon("D:\\eclipse workspace\\PharmacyApp\\shopping-cart (1).png"));
		btnNewButton_1.setBounds(399, 137, 236, 92);
		panel_4.add(btnNewButton_1);

		spinner = new JSpinner();
		spinner.setEnabled(false);
		spinner.setBounds(147, 142, 42, 20);
		panel_4.add(spinner);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(147, 19, 488, 19);
		panel_4.add(textField_2);
		textField_2.setColumns(10);

		panel_1 = new JPanel();
		tabbedPane.addTab("Vanzare medicament", null, panel_1, null);
		panel_1.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(
				new TitledBorder(null, "Informatii reteta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 10, 660, 227);
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		Object[] row = new Object[20];

		JButton btnNewButton_2 = new JButton("Adauga in lista de cumparaturi");
		btnNewButton_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected()) {
					String h = textField_5.getText();
					try {
						if ((h != null) && (comp(h))) {
							textField_4.setText((String) compensare(h));
							total = total-(total * Float.parseFloat(textField_4.getText()) / 100);
						}
					} catch (ClassNotFoundException | SQLException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
				}

				row[0] = table_1.getRowCount() + 1;
				row[1] = textField.getText();
				try {
					row[2] = descriere(textField.getText());
				} catch (ClassNotFoundException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				row[3] = spinner_1.getValue();
				String r = "";
				if (rdbtnNewRadioButton.isSelected()) {
					r = "DA";
				} else {
					r = "NU";
				}
				row[4] = r;

				if (rdbtnNewRadioButton.isSelected()) {
					try {
						row[5] = compensare(textField_5.getText());
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					row[5] = "0";
				}

				model.addRow(row);
				String q = spinner_1.getValue().toString();
				float t4 = Float.parseFloat(q) * total;
				total1 = total1 + t4;
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_2.setHorizontalTextPosition(SwingConstants.LEADING);
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setBounds(443, 10, 207, 64);
		panel_5.add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("Cauta medicament");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedComponent(panel);
			}
		});
		btnNewButton_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2_1.setIcon(new ImageIcon("D:\\eclipse workspace\\PharmacyApp\\search.png"));
		btnNewButton_2_1.setBounds(443, 82, 207, 64);
		panel_5.add(btnNewButton_2_1);

		JButton btnNewButton_2_2 = new JButton("Finalizare lista cumparaturi");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedComponent(panel_2);
				String t = String.valueOf(total1);
				textField_6.setText(t);
			}
		});
		btnNewButton_2_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2_2.setBounds(443, 154, 207, 64);
		panel_5.add(btnNewButton_2_2);

		JLabel lblNewLabel_1 = new JLabel("Medicament:");
		lblNewLabel_1.setBounds(10, 32, 85, 13);
		panel_5.add(lblNewLabel_1);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(91, 29, 193, 19);
		panel_5.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Cantitate:");
		lblNewLabel_1_1.setBounds(308, 31, 54, 13);
		panel_5.add(lblNewLabel_1_1);

		spinner_1 = new JSpinner();
		spinner_1.setBounds(379, 24, 54, 29);
		panel_5.add(spinner_1);

		rdbtnNewRadioButton = new JRadioButton("Cumparatorul detine reteta prescrisa");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected()) {

					rdbtnCumparatorulNuDetine.setEnabled(false);
					textField_5.setEditable(true);
				} else {
					rdbtnCumparatorulNuDetine.setEnabled(true);
					textField_5.setEditable(false);
				}
			}
		});
		rdbtnNewRadioButton.setBounds(24, 71, 409, 21);
		panel_5.add(rdbtnNewRadioButton);

		rdbtnCumparatorulNuDetine = new JRadioButton("Cumparatorul NU detine reteta prescrisa");
		rdbtnCumparatorulNuDetine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnCumparatorulNuDetine.isSelected()) {
					rdbtnNewRadioButton.setEnabled(false);
				} else {
					rdbtnNewRadioButton.setEnabled(true);
				}
			}
		});
		rdbtnCumparatorulNuDetine.setBounds(24, 103, 409, 21);
		panel_5.add(rdbtnCumparatorulNuDetine);

		JLabel lblNewLabel_2 = new JLabel("Compensare:");
		lblNewLabel_2.setBounds(91, 150, 85, 13);
		panel_5.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Numarul retetei:");
		lblNewLabel_2_1.setBounds(91, 180, 96, 13);
		panel_5.add(lblNewLabel_2_1);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(188, 147, 67, 19);
		panel_5.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(188, 177, 96, 19);
		panel_5.add(textField_5);

		panel_6 = new JPanel();
		panel_6.setBorder(
				new TitledBorder(null, "Lista cumparaturi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(10, 249, 660, 151);
		panel_1.add(panel_6);
		panel_6.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 33, 640, 108);
		panel_6.add(scrollPane_1);

		table_1 = new JTable();
		model = new DefaultTableModel();
		Object[] column = { "Nr. Crt.", "Denumire", "Descriere", "Cantitate", "Reteta", "Compensare %" };

		model.setColumnIdentifiers(column);
		table_1.setModel(model);
		scrollPane_1.setViewportView(table_1);

		panel_2 = new JPanel();
		tabbedPane.addTab("Incasare plata", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Total de plata:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(151, 68, 126, 13);
		panel_2.add(lblNewLabel_3);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(298, 66, 171, 19);
		panel_2.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblNewLabel_3_1 = new JLabel("RON");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3_1.setBounds(481, 68, 48, 13);
		panel_2.add(lblNewLabel_3_1);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(
				new TitledBorder(null, "Printeaza Comanda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(139, 149, 445, 78);
		panel_2.add(panel_7);
		panel_7.setLayout(null);

		rdbtnNewRadioButton_1 = new JRadioButton("DA");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton_1.isSelected()) {
					rdbtnNewRadioButton_1_1.setEnabled(false);

				} else {
					rdbtnNewRadioButton_1_1.setEnabled(true);

				}

			}
		});
		rdbtnNewRadioButton_1.setBounds(100, 30, 50, 21);
		panel_7.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_1_1 = new JRadioButton("NU");
		rdbtnNewRadioButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton_1_1.isSelected()) {
					rdbtnNewRadioButton_1.setEnabled(false);

				} else {
					rdbtnNewRadioButton_1.setEnabled(true);

				}
			}
		});
		rdbtnNewRadioButton_1_1.setBounds(239, 30, 50, 21);
		panel_7.add(rdbtnNewRadioButton_1_1);

		JButton btnNewButton_3 = new JButton("Inapoi");
		btnNewButton_3.setIcon(new ImageIcon("D:\\eclipse workspace\\PharmacyApp\\back.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedComponent(panel_1);
			}
		});
		btnNewButton_3.setBounds(57, 295, 97, 46);
		panel_2.add(btnNewButton_3);

		JButton btnNewButton_3_1 = new JButton("Anulare Comanda");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				spinner.setValue(0);
				textArea_1.setText(null);
				spinner_1.setValue(0);
				textField_6.setText(null);
				rdbtnNewRadioButton_1.setSelected(false);
				rdbtnNewRadioButton_1_1.setSelected(false);
				rdbtnNewRadioButton_1_1.setEnabled(true);
				rdbtnNewRadioButton_1.setEnabled(true);
				textField_3.setText(null);
				rdbtnNewRadioButton.setSelected(false);
				rdbtnNewRadioButton.setEnabled(true);
				rdbtnCumparatorulNuDetine.setSelected(false);
				rdbtnCumparatorulNuDetine.setEnabled(true);
				textField_4.setText(null);
				textField_5.setText(null);
			}
		});
		btnNewButton_3_1.setIcon(new ImageIcon("D:\\eclipse workspace\\PharmacyApp\\multiply.png"));
		btnNewButton_3_1.setBounds(211, 295, 172, 46);
		panel_2.add(btnNewButton_3_1);

		JButton btnNewButton_3_2 = new JButton("Finalizare Comanda");
		btnNewButton_3_2.setIcon(new ImageIcon("D:\\eclipse workspace\\PharmacyApp\\checked.png"));
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int j = 0;
				while (j < table_1.getRowCount()) {
					String a = (table_1.getModel().getValueAt(j, 1)).toString();
					int b = 0;
					try {
						b = getQuantity(a) - Integer.parseInt((table_1.getModel().getValueAt(j, 3)).toString());
					} catch (NumberFormatException | ClassNotFoundException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						updateQuantity(a, b);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					j++;
				}

				FileWriter fileWriter;
				try {
					fileWriter = new FileWriter(new File("print.txt"));
					fileWriter.write("          Claude's Pharmacy APP" + "\n");
					fileWriter.write("           Bucuresti, Sector 6 " + "\n");
					fileWriter.write("              UIC 123456789" + "\n");
					fileWriter.write("           Bucuresti, Sector 6 " + "\n");
					fileWriter.write("           Bucuresti, Sector 6 " + "\n");
					fileWriter.write("           NR. ZDDS BG123456789" + "\n");
					fileWriter.write("          #0001   " + PharmacyApp.getTextField().getText() + "   0001" + "\n");
					fileWriter.write("                ORIGINAL" + "\n");
					fileWriter.write("          FACTURA NR. 0000001001" + "\n");
					fileWriter.write("        NUV: XX123456-0001-0000001" + "\n");
					int i = 0;
					while (i < table_1.getRowCount()) {
						fileWriter.write("     " + table_1.getModel().getValueAt(i, 1) + "\n");
						fileWriter.write("        Cantitate............" + table_1.getModel().getValueAt(i, 3) + "\n");

						String pret = "";
						try {
							pret = String.valueOf(price(table_1.getModel().getValueAt(i, 1)));
							fileWriter.write("        Pret / buc.  ........" + pret + " LEI" + "\n");
							i++;
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
					fileWriter.write("     Total..................." + textField_6.getText() + "LEI" + "\n");

					fileWriter.flush();
					fileWriter.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (rdbtnNewRadioButton_1.isSelected()) {
					ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "print.txt");
					try {
						pb.start();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btnNewButton_3_2.setBounds(440, 295, 183, 46);
		panel_2.add(btnNewButton_3_2);

		JLabel lblNewLabel_4 = new JLabel("Logat ca:");
		lblNewLabel_4.setBounds(471, 26, 83, 13);
		frmClaudesPharmacyApp.getContentPane().add(lblNewLabel_4);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(585, 24, 96, 16);
		frmClaudesPharmacyApp.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		textField_7.setText(String.valueOf(PharmacyApp.getTextField().getText()));
	}

	public static void searchDrug(String j) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet rs5 = stmt.executeQuery("SELECT * FROM pharmacy.drug where name like '" + j + "' ;");
		if (rs5.next()) {
			int q = rs5.getInt("quantity");
			if (q > 0) {
				textField_2.setText("Medicamentul se afla pe stoc!");
			} else {
				textField_2.setText("Scuze! Medicamentul NU se afla pe stoc!");
			}
			textArea_1.setText(rs5.getString("description"));
			spinner.setValue(rs5.getInt("quantity"));
			textField_1.setText(rs5.getString("price"));
			try {
				comboBox.setSelectedItem(rs5.getString("diagnosis"));

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null,
					"Nu exista un medicament care sa corespunda cautarii. Incercati din nou!", "Eroare de cautare",
					JOptionPane.ERROR_MESSAGE);
		}
		con.close();

	}

	public static void searchDrugComboBox(String j) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet rs6 = stmt.executeQuery("SELECT * FROM pharmacy.drug where diagnosis like '" + j + "' ;");
		if (rs6.next()) {
			int q = rs6.getInt("quantity");
			if (q > 0) {
				textField_2.setText("Medicamentul se afla pe stoc!");
			}
			textArea_1.setText(rs6.getString("description"));
			spinner.setValue(rs6.getInt("quantity"));
			textField_1.setText(rs6.getString("price"));
			textField.setText(rs6.getString("name"));

		} else {
			JOptionPane.showMessageDialog(null,
					"Nu exista un medicament care sa corespunda cautarii. Incercati din nou!", "Eroare de cautare",
					JOptionPane.ERROR_MESSAGE);
		}
		con.close();

	}

	public static String[] searchDrugDes() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet rs7 = stmt.executeQuery("SELECT * FROM pharmacy.drug;");
		String[] str = new String[20];
		int i = 0;
		while (rs7.next()) {

			str[i] = rs7.getString("diagnosis");
			i++;
		}
		con.close();
		return str;
	}

	public static Object descriere(String j) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet rs4 = stmt.executeQuery("SELECT * FROM pharmacy.drug where name like '" + j + "' ;");
		String s = "";
		if (rs4.next()) {
			s = rs4.getString("description");
		}
		con.close();
		return s;
	}

	public static Object compensare(String j) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet rs3 = stmt.executeQuery("SELECT * FROM pharmacy.recipe where recipe_no like '" + j + "' ;");
		String s = "";
		if (rs3.next()) {
			s = rs3.getString("compensation");
		}
		con.close();
		return s;
	}

	public static Object price(Object object) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet rs2 = stmt.executeQuery("SELECT * FROM pharmacy.drug where name like '" + object + "' ;");
		String s = "";
		if (rs2.next()) {
			s = rs2.getString("price");
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

	public static int checkAdmin(String a) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet rs8 = stmt.executeQuery("SELECT * FROM pharmacy.users where username like '" + a + "' ;");
		int s = 0;
		if (rs8.next()) {
			s = rs8.getInt("admin");
		}
		con.close();
		return s;
	}

	public static Boolean comp(String j) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		Statement stmt = con.createStatement();
		ResultSet rs3 = stmt.executeQuery("SELECT * FROM pharmacy.recipe where recipe_no like '" + j + "' ;");
		Boolean s = false;
		if (rs3.next()) {
			s = true;
		}
		con.close();
		return s;
	}

}
