package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class PoszukiwaczGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	                           
	private JTable table;
	private RootGUI rootGUI;
	private Object dane[][];
	private JButton updateButton;
	private JButton insertButton;
	private JButton deleteButton;
	private JButton odswiezButton;
	private JLabel napis;
	private static final String obrazekPoszukiwacz = "/obrazki/poszukiwacz.png";
	private ImageIcon ikona;

	public PoszukiwaczGUI(RootGUI rootGUI) {
		super();
		
		this.rootGUI = rootGUI;
		dane = rootGUI.poszukiwaczeArrayListToObject2D();
		
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.FIRST_LINE_START;
		constraints.weighty = 0.01;
		
		ikona = new ImageIcon(LogbookGUI.class.getResource(obrazekPoszukiwacz));
		napis = new JLabel("      Dane poszukiwaczy", ikona, JLabel.CENTER);
		napis.setFont(new Font("Tahoma", 10 , 30));
		add(napis, constraints);
		
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 3;
		constraints.gridheight = 5;
		constraints.ipadx = 200;
		constraints.ipady = 480;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.weightx = 0.01;
		constraints.weighty = 0.01;

		table = new JTable(new Tabelka(dane));
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		
		JScrollPane tableScrollPane = new JScrollPane(table);
		add(tableScrollPane , constraints);
		setOpaque(true);

		constraints.gridx = 3;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.ipadx = 30;
		constraints.ipady = 10;
		constraints.anchor = GridBagConstraints.CENTER;
		updateButton = new JButton("Zmień dane o poszukiwacza");
		add(updateButton , constraints);
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdatePoszukiwaczGUI updatePoszukiwaczGUI = new UpdatePoszukiwaczGUI(rootGUI);
			}
		});
		
		constraints.gridx = 3;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.ipadx = 25;
		constraints.ipady = 10;
		constraints.anchor = GridBagConstraints.CENTER;
		insertButton = new JButton("Dodaj nowego poszukiwacza");
		add(insertButton , constraints);
		insertButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InsertPoszukiwaczGUI insertPoszukiwaczGUI = new InsertPoszukiwaczGUI(rootGUI);
			}
		});
		
		constraints.gridx = 3;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.ipadx = 75;
		constraints.ipady = 10;
		constraints.anchor = GridBagConstraints.CENTER;
		deleteButton = new JButton("Usuń poszukiwacza");
		add(deleteButton , constraints);
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DeletePoszukiwaczGUI deletePoszukiwaczGUI = new DeletePoszukiwaczGUI(rootGUI);
			}
		});
		
		
		constraints.gridx = 3;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.ipadx = 100;
		constraints.ipady = 10;
		constraints.anchor = GridBagConstraints.CENTER;
		odswiezButton = new JButton("Odśwież tabelę");
		add(odswiezButton , constraints);
		
		odswiezButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rootGUI.odswiezListePoszukiwaczy();
				((Tabelka)table.getModel()).odswiezTabele(rootGUI.poszukiwaczeArrayListToObject2D());
			}
		});
	}
	
}
