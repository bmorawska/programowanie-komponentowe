package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class UpdatePoszukiwaczGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pseudonimStarytextField;
	
	private RootGUI rootGUI;
	private JTextField pseudonimNowyTextField;
	private JTextField EmailStaryTextField;
	private JTextField EmailNowyTextField;
	private JComboBox poziomStaryComboBox;
	private JComboBox poziomNowyComboBox;
	private String[] poziomy = {"NOWICJUSZ" , "UCZEN" , "CZELADNIK", "EKSPERT", "MISTRZ"};
	
	public UpdatePoszukiwaczGUI(RootGUI rootGUI) {
		
		this.rootGUI = rootGUI;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 450, 300);
		setTitle("Zmiana danych poszukiwacza");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ZmienDaneButton = new JButton("Zmień dane");
		ZmienDaneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pseudonim = "";
				String email = "";
				String poziom = "";
				int poziomIndex;
				boolean czyPoprawne;
				pseudonim = pseudonimStarytextField.getText();
				czyPoprawne = rootGUI.sprawdzCzyIstniejePoszukiwacz(pseudonim);
				email = EmailNowyTextField.getText();
				poziomIndex = poziomNowyComboBox.getSelectedIndex();
				
				switch(poziomIndex) {
				case 0:
					poziom = "NOWICJUSZ";
					break;
				case 1:
					poziom = "UCZEN";
					break;
				case 2:
					poziom = "CZELADNIK";
					break;
				case 3:
					poziom =  "EKSPERT";
					break;
				case 4:
					poziom =  "MISTRZ";
					break;
				default:
					poziom = "";
					break;
			}

				if (czyPoprawne) {
					rootGUI.getRoot().odswiezPoszukiwaczy();
					rootGUI.aktualizujPoszukiwaczaWBazie(pseudonim, email, poziom);
					JOptionPane.showMessageDialog(null, "Zmieniono dane poszukiwacza " + pseudonim, "Sukces", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					dispose();
				}
				else {

					JOptionPane.showMessageDialog(null, "Proszę wpisać poprawne wartości", "Niepoprawne wartości", JOptionPane.ERROR_MESSAGE);
					pseudonimStarytextField.setText("");
				}
			}
		});
		ZmienDaneButton.setBounds(160, 227, 123, 23);
		contentPane.add(ZmienDaneButton);
		
		JButton AnulujButton = new JButton("Anuluj");
		AnulujButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		AnulujButton.setBounds(301, 227, 123, 23);
		contentPane.add(AnulujButton);
		
		JLabel lblPseudonim = new JLabel("Pseudonim :");
		lblPseudonim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPseudonim.setBounds(22, 64, 89, 14);
		contentPane.add(lblPseudonim);
		
		pseudonimStarytextField = new JTextField();
		pseudonimStarytextField.setBounds(108, 63, 153, 20);
		contentPane.add(pseudonimStarytextField);
		pseudonimStarytextField.setColumns(10);
		
		JButton wczytajButton = new JButton("Wczytaj");
		wczytajButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String pseudonim;
				String email;
				String poziom;
				boolean czyPoprawne;
				pseudonim = pseudonimStarytextField.getText();
				czyPoprawne = rootGUI.sprawdzCzyIstniejePoszukiwacz(pseudonim);	
				poziom = rootGUI.getRoot().getPoziomFromPseudonim(pseudonim);
				int poziomIndex;
				
				switch(poziom) {
					case "NOWICJUSZ":
						poziomIndex = 0;
						break;
					case "UCZEN":
						poziomIndex = 1;
						break;
					case "CZELADNIK":
						poziomIndex = 2;
						break;
					case "EKSPERT":
						poziomIndex = 3;
						break;
					case "MISTRZ":
						poziomIndex = 4;
						break;
					default:
						poziomIndex = -1;
						break;
				}
				
				
				if (czyPoprawne) {
					EmailStaryTextField.setText(rootGUI.getRoot().getEmailFromPseudonim(pseudonim));
					poziomStaryComboBox.setSelectedIndex(poziomIndex);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Proszę wpisać poprawne wartości", "Niepoprawne wartości", JOptionPane.ERROR_MESSAGE);
					pseudonimStarytextField.setText("");
					EmailStaryTextField.setText("");
				}		
				
			}
		});
		wczytajButton.setBounds(22, 227, 117, 23);
		contentPane.add(wczytajButton);
		
		pseudonimNowyTextField = new JTextField();
		pseudonimNowyTextField.setColumns(10);
		pseudonimNowyTextField.setBounds(271, 63, 153, 20);
		pseudonimNowyTextField.setEditable(false);
		contentPane.add(pseudonimNowyTextField);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(22, 104, 89, 14);
		contentPane.add(lblEmail);
		
		EmailStaryTextField = new JTextField();
		EmailStaryTextField.setColumns(10);
		EmailStaryTextField.setBounds(108, 103, 153, 20);
		contentPane.add(EmailStaryTextField);
		
		EmailNowyTextField = new JTextField();
		EmailNowyTextField.setColumns(10);
		EmailNowyTextField.setBounds(271, 103, 153, 20);
		contentPane.add(EmailNowyTextField);
		
		JLabel lblAktualnaWarto = new JLabel("Aktualna wartość");
		lblAktualnaWarto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAktualnaWarto.setBounds(121, 26, 123, 14);
		contentPane.add(lblAktualnaWarto);
		
		JLabel lblNowaWarto = new JLabel("Nowa wartość");
		lblNowaWarto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNowaWarto.setBounds(254, 26, 123, 14);
		contentPane.add(lblNowaWarto);
		
		JLabel lblPoziom = new JLabel("Poziom :");
		lblPoziom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPoziom.setBounds(22, 147, 89, 14);
		contentPane.add(lblPoziom);
		
		poziomStaryComboBox = new JComboBox(poziomy);
		poziomStaryComboBox.setBounds(108, 145, 153, 23);
		contentPane.add(poziomStaryComboBox);
		
		poziomNowyComboBox = new JComboBox(poziomy);
		poziomNowyComboBox.setBounds(271, 145, 153, 23);
		
		contentPane.add(poziomNowyComboBox);
	}
}
