package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;


import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JCalendar;
import javax.swing.JCheckBox;
import com.toedter.calendar.JDateChooser;

import dane.WyroznieniaDaty;

import java.awt.Font;

public class LogbookGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private RootGUI rootGUI;
	private JTextField pseudonimPoszukiwaczaTextField;
	private JTextField nazwaSkrzynkiTextField;
	private GridBagLayout gl = new GridBagLayout();
	private JButton dodajButton;
	private String pseudonim;
	private String skrzynkaNazwa;
	private Date data;
	private JCalendar calendar;
	private Calendar dzienMiesiacRok;
	private JTextPane info;
	
	public LogbookGUI(RootGUI rootGUI) {
		super();
		
		this.rootGUI = rootGUI;
		setLayout(gl);
		
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 7;
		constraints.gridwidth = 2;
		constraints.gridheight = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.ipadx = 250;
		constraints.ipady = 250;
		
		info = new JTextPane();
		info.setEditable(false);
		info.setText("piszu piszu");
		JScrollPane scroll = new JScrollPane(info);
		add(scroll, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 8;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.ipadx = 300;
		constraints.ipady = 400;

		
		calendar = new JCalendar();
		add(calendar, constraints);
		calendar.isTodayButtonVisible();
		calendar.setSundayForeground(Color.RED);
		calendar.setTodayButtonVisible(true);
		calendar.setTodayButtonText("Pokaż dzisiejszą datę");
		WyroznieniaDaty wyroznieniaDaty = new WyroznieniaDaty(rootGUI.dajDatyOdkryc());
		calendar.addPropertyChangeListener("calendar", new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				  final Calendar c = (Calendar) evt.getNewValue();   
				  java.util.Date utilDate = c.getTime();
				  info.setText(rootGUI.pobierzInformacjeOOdkryciu(utilDate));
				
			}
		});
		calendar.getDayChooser().addDateEvaluator(wyroznieniaDaty);
		
				
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.ipadx = 70;
		constraints.ipady = 25;
		constraints.weightx = 0.1;
		
		JLabel lblDodajWpisDo = new JLabel("Dodaj wpis do Logbooka");
		lblDodajWpisDo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblDodajWpisDo, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.ipadx = 70;
		constraints.ipady = 25;
		constraints.weightx = 0.1;
		
		JLabel pseudonimPoszukiwaczaLabel = new JLabel("Pseudonim poszukiwacza");
		add(pseudonimPoszukiwaczaLabel, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.ipadx = 70;
		constraints.ipady = 25;
		constraints.weightx = 0.1;
		
		JLabel lblNazwaSkrzynki = new JLabel("Nazwa skrzynki");
		add(lblNazwaSkrzynki, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.ipadx = 70;
		constraints.ipady = 25;
		constraints.weightx = 0.1;
		
		JLabel lblDataZnalezienia = new JLabel("Data znalezienia");
		add(lblDataZnalezienia, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.ipadx = 70;
		constraints.ipady = 25;
		constraints.weightx = 0.1;
		
		JLabel lblUstawPrzypomnienie = new JLabel("Ustaw przypomnienie");
		add(lblUstawPrzypomnienie, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.ipadx = 70;
		constraints.ipady = 10;
		constraints.weightx = 0.1;
		
		pseudonimPoszukiwaczaTextField = new JTextField();
		add(pseudonimPoszukiwaczaTextField, constraints);
		pseudonimPoszukiwaczaTextField.setColumns(10);
		pseudonimPoszukiwaczaTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pseudonim = pseudonimPoszukiwaczaTextField.getText();
				if (!rootGUI.sprawdzCzyIstniejePoszukiwacz(pseudonim)) {
					JOptionPane.showMessageDialog(null, "Nie ma takiego poszukiwacza w bazie danych", "Błąd", JOptionPane.ERROR_MESSAGE);
					pseudonimPoszukiwaczaTextField.setText("");
				}
			}
		});
		
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.ipadx = 70;
		constraints.ipady = 10;
		constraints.weightx = 0.1;
		
		nazwaSkrzynkiTextField = new JTextField();
		nazwaSkrzynkiTextField.setColumns(10);
		add(nazwaSkrzynkiTextField, constraints);
		nazwaSkrzynkiTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				skrzynkaNazwa = nazwaSkrzynkiTextField.getText();
				if (!rootGUI.sprawdzCzyIstniejeSkrzynka(skrzynkaNazwa)) {
					JOptionPane.showMessageDialog(null, "Nie ma takiej skrzynki w bazie danych", "Błąd", JOptionPane.ERROR_MESSAGE);
					nazwaSkrzynkiTextField.setText("");
				}
				
			}
		});
		
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.ipadx = 95;
		constraints.ipady = 10;
		constraints.weightx = 0.5;
		
		JDateChooser dateChooser = new JDateChooser();
		add(dateChooser, constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.ipadx = 170;
		constraints.ipady = 10;
		constraints.weightx = 0.1;

		JCheckBox chckbxUstawPrzypomnienie = new JCheckBox("");
		add(chckbxUstawPrzypomnienie, constraints);
		chckbxUstawPrzypomnienie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				data = new Date(); 
				if (data.before(dateChooser.getDate()) || (dateChooser.getDate() == null)) {
					chckbxUstawPrzypomnienie.setEnabled(false);
				}
				//TODO - jakiś magiczny obiekt z dzwoneczkiem
				
			}
		});
		
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.ipadx = 95;
		constraints.ipady = 10;
		
		dodajButton = new JButton("Dodaj");
		add(dodajButton, constraints);
		dodajButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				data = dateChooser.getDate();
				System.out.println(data);
				if ((data != null) &&
					rootGUI.sprawdzCzyIstniejePoszukiwacz(pseudonim) && 
					rootGUI.sprawdzCzyIstniejeSkrzynka(skrzynkaNazwa)) 
				{ 
					java.sql.Date sqlDate = new java.sql.Date(data.getTime());
					rootGUI.dodajOdkrycieDoBazy(pseudonim, skrzynkaNazwa, sqlDate);
					JOptionPane.showMessageDialog(null, "Udało się dodać odkrycie do bazy danych", "Sukces!", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Nie udało się dodać odkrycia do bazy danych", "Błąd!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		

	}
}
