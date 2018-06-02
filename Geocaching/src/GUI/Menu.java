package GUI;

import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Menu extends JMenuBar{
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnZapiszodczytaj = new JMenu("Zapisz/Odczytaj");
	private final JMenu mnOdczytaj = new JMenu("Odczytaj");
	private RootGUI rootGUI;
	
	public Menu(RootGUI rootGUI) {
		
		this.rootGUI = rootGUI;
		menuBar.add(mnZapiszodczytaj);
		
		JMenu mnZapisz = new JMenu("Zapisz");
		mnZapisz.setMnemonic(KeyEvent.VK_S);
		mnZapiszodczytaj.add(mnZapisz);
		
		JMenuItem mnZapiszJakoXML = new JMenuItem("XML");
		mnZapiszJakoXML.setMnemonic(KeyEvent.VK_X);
		mnZapiszJakoXML.setAccelerator(KeyStroke.getKeyStroke(
                'X', ActionEvent.CTRL_MASK));
		mnZapisz.add(mnZapiszJakoXML);
		
		JMenuItem mnZapiszJakoOutlook = new JMenuItem("Outlook");
		mnZapisz.add(mnZapiszJakoOutlook);
		
		mnZapiszodczytaj.add(mnOdczytaj);
		
		JMenuItem mnOdczytajZXML = new JMenuItem("XML");
		mnOdczytaj.add(mnOdczytajZXML);
		
		JMenuItem mntmOdczytajZOutlook = new JMenuItem("Outlook");
		mnOdczytaj.add(mntmOdczytajZOutlook);
		
		JMenu mnPomoc = new JMenu("Pomoc");
		menuBar.add(mnPomoc);
		
		JMenuItem mnOProgramie = new JMenuItem("O programie");
		mnPomoc.add(mnOProgramie);
		mnOProgramie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OProgramieGUI oProgramieGUI = new OProgramieGUI();
			}
		});
		mnOProgramie.setAccelerator(KeyStroke.getKeyStroke('P', ActionEvent.CTRL_MASK));
		
		JMenuItem mnUstawieniaFiltrowania = new JMenuItem("Ustawienia filtrowania");
		mnPomoc.add(mnUstawieniaFiltrowania);
		mnUstawieniaFiltrowania.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UstawieniaFiltrowaniaGUI ustawieniaFiltrowaniaGUI = new UstawieniaFiltrowaniaGUI(rootGUI);
				
			}
		});
		
		JMenuItem mnWylaczProgram = new JMenuItem("Wyłącz program");
		mnPomoc.add(mnWylaczProgram);
		mnWylaczProgram.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		mnWylaczProgram.setAccelerator(KeyStroke.getKeyStroke('E', ActionEvent.CTRL_MASK));
		
		this.add(menuBar);
	}
}
