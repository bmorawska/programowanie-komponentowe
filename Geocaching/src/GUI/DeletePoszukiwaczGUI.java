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

public class DeletePoszukiwaczGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pseudonimtextField;
	
	private RootGUI rootGUI;
	
	public DeletePoszukiwaczGUI(RootGUI rootGUI) {
		
		this.rootGUI = rootGUI;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 450, 300);
		setTitle("Usuwanie poszukiwacza");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Usun");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pseudonim = "";
				boolean czyPoprawne;
					pseudonim = pseudonimtextField.getText();
					czyPoprawne = rootGUI.sprawdzCzyIstniejePoszukiwacz(pseudonim);

				if (czyPoprawne) {
					rootGUI.getRoot().odswiezPoszukiwaczy();
					rootGUI.usunPoszkiwaczaZBazy(pseudonim);
					JOptionPane.showMessageDialog(null, "Usunieto poszukiwacza" + pseudonim, "Sukces", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);
					dispose();
				}
				else {

					JOptionPane.showMessageDialog(null, "Proszę wpisać poprawne wartości", "Niepoprawne wartości", JOptionPane.ERROR_MESSAGE);
					pseudonimtextField.setText("");
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
		
		pseudonimtextField = new JTextField();
		pseudonimtextField.setBounds(208, 68, 142, 20);
		contentPane.add(pseudonimtextField);
		pseudonimtextField.setColumns(10);
	}
}
