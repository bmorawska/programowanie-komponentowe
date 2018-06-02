package GUI;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import javafx.scene.control.RadioButton;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class MapaGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon mapka;
	private JLabel mapkaJL;
	private JTextField textField;
	private JButton przycisk;
	
	public MapaGUI() {
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.gridheight = 3;
		constraints.ipadx = 50;
		constraints.ipady = 50;
		constraints.anchor = GridBagConstraints.CENTER;
		mapka = new ImageIcon(MapaGUI.class.getResource("/obrazki/mapaPabianic2.PNG"));
		mapkaJL = new JLabel(mapka);
		Border border = BorderFactory.createEtchedBorder();
		mapkaJL.setBorder(border);
		add(mapkaJL, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 2;
		constraints.ipadx = 250;
		constraints.ipady = 300;
		constraints.weightx = 0.2;
		constraints.anchor = GridBagConstraints.CENTER;
		textField = new JTextField(20);
		textField.setText("Hello");
		add(textField, constraints);
		
		constraints.gridx = 2;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.ipadx = 180;
		constraints.ipady = 25;
		constraints.weightx = 0.2;
		constraints.anchor = GridBagConstraints.CENTER;
		przycisk = new JButton("Pokaż");
		add(przycisk, constraints);
		
	}

}
