package GUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import wyjatki.NiepoprawneDaneException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class InsertPoszukiwaczGUI extends JFrame {

	private static final long serialVersionUID = -1677346960576417795L;
	
	private JPanel contentPane;
	private JTextField pseudonimtextField;
	private JTextField emailtextField;
	
	private RootGUI rootGUI;
	
	public InsertPoszukiwaczGUI(RootGUI rootGUI) {
		
		this.rootGUI = rootGUI;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 450, 300);
		setTitle("Dodawanie poszukiwacza");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Dodaj");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pseudonim = "";
				String email = "";
				boolean czyPoprawne = true;
				try {
					pseudonim = pseudonimtextField.getText();
					email = emailtextField.getText();
					if (pseudonim == "" || email == "") {
						throw new NiepoprawneDaneException("Niepoprawne dane");
					}
					else if (pseudonim.length() < 5 || email.length() < 5) {
						throw new NiepoprawneDaneException("Niepoprawne dane");
					}
					else if (!email.contains("@")) {
						throw new NiepoprawneDaneException("Niepoprawne dane");
					}
				}
				catch (NiepoprawneDaneException e) {
					JOptionPane.showMessageDialog(null, "Proszę wpisać poprawne wartości", "Niepoprawne wartości", JOptionPane.ERROR_MESSAGE);
					czyPoprawne = false;
					
				}
				if (czyPoprawne) {
					rootGUI.getRoot().odswiezPoszukiwaczy();
					rootGUI.dodajPoszukiwaczaDoBazy(pseudonim, email);
					JOptionPane.showMessageDialog(null, "Dodano nowego poszukiwacza", "Sukces", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					dispose();
				}
				else {
					pseudonimtextField.setText("");
					emailtextField.setText("");
				}
			}
		});
		btnNewButton.setBounds(70, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Anuluj");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		btnNewButton_1.setBounds(261, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblPseudonim = new JLabel("Pseudonim :");
		lblPseudonim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPseudonim.setBounds(70, 69, 89, 14);
		contentPane.add(lblPseudonim);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(108, 120, 46, 14);
		contentPane.add(lblEmail);
		
		pseudonimtextField = new JTextField();
		pseudonimtextField.setBounds(208, 68, 142, 20);
		contentPane.add(pseudonimtextField);
		pseudonimtextField.setColumns(10);
		
		emailtextField = new JTextField();
		emailtextField.setColumns(10);
		emailtextField.setBounds(208, 119, 142, 20);
		contentPane.add(emailtextField);
	}
}
