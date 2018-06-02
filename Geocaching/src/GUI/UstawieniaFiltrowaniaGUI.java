package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sun.java2d.cmm.kcms.KcmsServiceProvider;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;

public class UstawieniaFiltrowaniaGUI extends JFrame {

	private JPanel contentPane;
	private JLabel poszukiwaczeLabel;
	private JLabel skrzynkiLabel;
	private JLabel logbookLabel;
	private JTextField poleDoDlugosciGeograficznej;
	private JTextField poleDoSzerokościGeograficznej;
	private RootGUI rootGUI;

	public UstawieniaFiltrowaniaGUI(RootGUI rootGUI) {
		this.rootGUI = rootGUI;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPoszukiwacze = new JLabel("Poszukiwacze");
		lblPoszukiwacze.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPoszukiwacze.setBounds(61, 54, 147, 27);
		contentPane.add(lblPoszukiwacze);
		
		JLabel lblSkrzynki = new JLabel("Skrzynki");
		lblSkrzynki.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSkrzynki.setBounds(61, 188, 147, 27);
		contentPane.add(lblSkrzynki);
		
		JCheckBox sortujPoszukiwaczyAlfabetycznieJCheckBox = new JCheckBox("Sortuj alfabetycznie");
		sortujPoszukiwaczyAlfabetycznieJCheckBox.setBounds(61, 99, 147, 23);
		contentPane.add(sortujPoszukiwaczyAlfabetycznieJCheckBox);
		sortujPoszukiwaczyAlfabetycznieJCheckBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sortujPoszukiwaczyAlfabetycznieJCheckBox.isSelected()) {
					rootGUI.posortujPoszukiwaczyAlfabetycznie();
					rootGUI.odswiezListePoszukiwaczy();
				}
				else {
					rootGUI.pomieszajPoszukiwaczy();
					rootGUI.odswiezListePoszukiwaczy();
				}
			}
		});
		
		
		poleDoDlugosciGeograficznej = new JTextField();
		poleDoDlugosciGeograficznej.setBounds(61, 452, 86, 20);
		contentPane.add(poleDoDlugosciGeograficznej);
		poleDoDlugosciGeograficznej.setColumns(10);
		
		poleDoSzerokościGeograficznej = new JTextField();
		poleDoSzerokościGeograficznej.setColumns(10);
		poleDoSzerokościGeograficznej.setBounds(157, 452, 86, 20);
		contentPane.add(poleDoSzerokościGeograficznej);
		
		JLabel lblDugo = new JLabel("długość");
		lblDugo.setBounds(61, 427, 46, 14);
		contentPane.add(lblDugo);
		
		JLabel lblSzeroko = new JLabel("szerokość");
		lblSzeroko.setBounds(157, 427, 72, 14);
		contentPane.add(lblSzeroko);
		
		JCheckBox sortujSkrzynkiAlfabetycznieCheckBox = new JCheckBox("Sortuj alfabetycznie");
		sortujSkrzynkiAlfabetycznieCheckBox.setBounds(60, 234, 148, 23);
		contentPane.add(sortujSkrzynkiAlfabetycznieCheckBox);
		sortujSkrzynkiAlfabetycznieCheckBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rootGUI.posortujSkrzynkiAlfabetycznie();
				
			}
		});
		
		JCheckBox sortujSkrzynkiPoLiczbieOdnalenien = new JCheckBox("Sortuj po liczbie odnalezień");
		sortujSkrzynkiPoLiczbieOdnalenien.setBounds(61, 278, 167, 23);
		contentPane.add(sortujSkrzynkiPoLiczbieOdnalenien);
		sortujSkrzynkiPoLiczbieOdnalenien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rootGUI.sortujSkrzynkiPoLiczbieOdnalezien();
				
			}
		});
		
		JCheckBox sortujPoDacieZalozeniaCheckBox = new JCheckBox("Sortuj po dacie założenias");
		sortujPoDacieZalozeniaCheckBox.setBounds(61, 326, 147, 23);
		contentPane.add(sortujPoDacieZalozeniaCheckBox);
		sortujPoDacieZalozeniaCheckBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (sortujPoDacieZalozeniaCheckBox.isSelected()) {
					rootGUI.sortujSkrzynkiPoDacieZalozenia();
				}
				else {
					rootGUI.pomieszajSkrzynki();
				}	
			}
		});
		
		JCheckBox sortujPoOdleglosciCheckBox = new JCheckBox("Sortuj po odlegości");
		sortujPoOdleglosciCheckBox.setBounds(61, 369, 168, 23);
		contentPane.add(sortujPoOdleglosciCheckBox);
		sortujPoOdleglosciCheckBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		JLabel lblUstawKolorTa = new JLabel("Ustaw kolor tła");
		lblUstawKolorTa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblUstawKolorTa.setBounds(350, 54, 147, 27);
		contentPane.add(lblUstawKolorTa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(360, 100, 28, 20);
		contentPane.add(comboBox);
		
		setVisible(true);
		
		
	}
}
