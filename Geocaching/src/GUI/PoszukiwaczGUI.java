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
import javax.swing.JList;
import java.awt.Scrollbar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PoszukiwaczGUI extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu zapiszWczytaj;
	private JMenu zapiszJako;
	private JMenuItem zapiszJakoXml;
	private JMenuItem zapiszJakoJson;
	private JMenu wczytajZ;
	private JMenuItem wczytajZXML;
	private JMenuItem wczytajZJSON;
	private JMenu ustawienia;
	private JMenuItem narzdziaFiltrowania;
	private JMenuItem wylaczProgram;
	private JMenuItem mntmPomoc;
	private JMenuItem oProgramie;
	private JPanel panelZMapa;
	private JPanel panelZTekstem;
	private JTextArea tekstWOknieInformacyjnym;
	private JButton logbookBtn;
	private JButton poszukiwaczBtn;
	private JButton skrzynkiBtn;
	private JButton btnDodajPoszukiwacza;
	private JButton btnZmienDanePoszukiwacza;
	private JButton btnUsuPoszukiwacza;

	public static void main(String[] args) {
		try {
			PoszukiwaczGUI frame = new PoszukiwaczGUI();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PoszukiwaczGUI() {
		
		//Ustawienia okna
		setBackground(Color.WHITE);
		setTitle("Geocaching");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 150, 1100, 800);
		
		//Pasek menu
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//Jedno z pól na MenuBar
		zapiszWczytaj = new JMenu("Zapisz/Wczytaj");
		menuBar.add(zapiszWczytaj);
		
		//To co się pojawi po rozwinięciu Zapisz/Wczytaj
		zapiszJako = new JMenu("Zapisz jako");
		zapiszWczytaj.add(zapiszJako);
		
		//Po rozwninięciu Zapisz/Wczytaj i potem Zapisz jako
		zapiszJakoXml = new JMenuItem("XML");
		zapiszJako.add(zapiszJakoXml);
		
		//Po rozwninięciu Zapisz/Wczytaj i potem Zapisz jako
		zapiszJakoJson = new JMenuItem("JSON");
		zapiszJako.add(zapiszJakoJson);
		
		//Po rozwinięciu Zapisz/Wczytaj
		wczytajZ = new JMenu("Wczytaj z");
		zapiszWczytaj.add(wczytajZ);
		
		//Po rozwinięciu Zapisz/Wczytaj i potem wczytaj z
		wczytajZXML = new JMenuItem("XML");
		wczytajZ.add(wczytajZXML);
		
		//Po rozwinięciu Zapisz/Wczytaj i potem wczytaj z
		wczytajZJSON = new JMenuItem("JSON");
		wczytajZ.add(wczytajZJSON);
		
		//Jedno z pól na MenuBar
		ustawienia = new JMenu("Ustawienia");
		menuBar.add(ustawienia);
		
		//Po rozwninięciu ustawienia
		narzdziaFiltrowania = new JMenuItem("Narzędzia filtrowania");
		ustawienia.add(narzdziaFiltrowania);
		
		//Po rozwinięciu ustawienia
		wylaczProgram = new JMenuItem("Wyłącz program");
		ustawienia.add(wylaczProgram);
		
		//Po rozwinieciu ustawienia 
		mntmPomoc = new JMenuItem("Pomoc");
		ustawienia.add(mntmPomoc);
		
		//Jedno z pół na menuBar
		oProgramie = new JMenuItem("O programie");
		menuBar.add(oProgramie);
		
		//całe okno
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Okno z mapą
		panelZMapa = new JPanel();
		panelZMapa.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelZMapa.setBounds(25, 47, 738, 519);
		contentPane.add(panelZMapa);
		
		//Okno z tekstem
		panelZTekstem = new JPanel();
		panelZTekstem.setBackground(Color.WHITE);
		panelZTekstem.setBounds(785, 47, 277, 370);
		contentPane.add(panelZTekstem);
		
		//Tekst informujący o tym co zrobić żeby wyświetlić dane o skrzynce 
		tekstWOknieInformacyjnym = new JTextArea(2,25);							//2 wiersze, 25 liter w każdym
		tekstWOknieInformacyjnym.setWrapStyleWord(true);						//Nie przerywa słów
		tekstWOknieInformacyjnym.setEditable(false);							//Nie można edytować 
		tekstWOknieInformacyjnym.setFont(new Font("Tahoma", Font.PLAIN, 13));	//czcionka, normalny tekst, rozmiar
		tekstWOknieInformacyjnym.setLineWrap(true);								//Zawija linię jeśli jest większa niż maksymalny rozmiar linii
		tekstWOknieInformacyjnym.setText("Kliknij na dowolnego poszukiwcza, aby uzyskać o nim więcej informacji.");	
		panelZTekstem.add(tekstWOknieInformacyjnym);
		
		//Guziczek od wchodzenia do okna z kalendarzem
		logbookBtn = new JButton("Logbook");
		logbookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		logbookBtn.setBounds(785, 428, 277, 49);
		contentPane.add(logbookBtn);
		
		//Guziczek od wchodzenia do okna z listą poszukiwaczy
		poszukiwaczBtn = new JButton("Mapa");
		poszukiwaczBtn.setBounds(785, 517, 277, 49);
		contentPane.add(poszukiwaczBtn);
		
		//Guziczek od wchodzenia do okna z listą skrzynek
		skrzynkiBtn = new JButton("Skrzynki");
		skrzynkiBtn.setBounds(785, 608, 277, 49);
		contentPane.add(skrzynkiBtn);
		
		btnDodajPoszukiwacza = new JButton("Dodaj poszukiwacza");
		btnDodajPoszukiwacza.setBounds(25, 608, 186, 49);
		contentPane.add(btnDodajPoszukiwacza);
		
		btnZmienDanePoszukiwacza = new JButton("Zmień dane poszukiwacza");
		btnZmienDanePoszukiwacza.setBounds(269, 608, 186, 49);
		contentPane.add(btnZmienDanePoszukiwacza);
		
		btnUsuPoszukiwacza = new JButton("Usuń poszukiwacza");
		btnUsuPoszukiwacza.setBounds(515, 608, 186, 49);
		contentPane.add(btnUsuPoszukiwacza);
	}
}
