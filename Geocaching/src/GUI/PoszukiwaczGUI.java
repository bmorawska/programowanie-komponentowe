package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import java.awt.Scrollbar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;

public class PoszukiwaczGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private String[] columnNames = {"Pseudonim", "Email", "Poziom"};
	
	private RootGUI rootGUI;

	public PoszukiwaczGUI(RootGUI rootGUI) {
		
		this.rootGUI = rootGUI;
		
		//Ustawienia okna
		setBackground(Color.WHITE);
		setTitle("Geocaching");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 1100, 800);
		getContentPane().setLayout(null);
		
		JButton OdswiezBazeDanychButton = new JButton("Odśwież bazę danych");
		OdswiezBazeDanychButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = new DefaultTableModel();
			    table.setModel(model);

			    model.setColumnIdentifiers(columnNames);
			}
		});
		OdswiezBazeDanychButton.setBounds(827, 48, 231, 48);
		getContentPane().add(OdswiezBazeDanychButton);
		
		JButton btnUsuPoszukiwaczaZ = new JButton("Usuń poszukiwacza z bazy danych");
		btnUsuPoszukiwaczaZ.setBounds(827, 128, 231, 48);
		getContentPane().add(btnUsuPoszukiwaczaZ);
		
		JButton btnDodajPoszukiwaczaDo = new JButton("Dodaj poszukiwacza do bazy danych");
		btnDodajPoszukiwaczaDo.setBounds(827, 209, 231, 48);
		getContentPane().add(btnDodajPoszukiwaczaDo);
		
		JButton btnZmieDanePoszukiwacza = new JButton("Zmień dane poszukiwacza ");
		btnZmieDanePoszukiwacza.setBounds(827, 294, 231, 48);
		getContentPane().add(btnZmieDanePoszukiwacza);
		
		JLabel lblUstawieniaFiltrowania = new JLabel("Ustawienia filtrowania");
		lblUstawieniaFiltrowania.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUstawieniaFiltrowania.setBounds(859, 381, 169, 32);
		getContentPane().add(lblUstawieniaFiltrowania);
		
		JCheckBox chckbxSortujPoNazwie = new JCheckBox("Sortuj po nazwie");
		chckbxSortujPoNazwie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxSortujPoNazwie.setBounds(859, 439, 149, 23);
		getContentPane().add(chckbxSortujPoNazwie);
		
		JCheckBox chckbxSortujPoPoziomie = new JCheckBox("Sortuj po poziomie");
		chckbxSortujPoPoziomie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxSortujPoPoziomie.setBounds(859, 497, 149, 23);
		getContentPane().add(chckbxSortujPoPoziomie);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(780, 57, -736, 602);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
	}
}
