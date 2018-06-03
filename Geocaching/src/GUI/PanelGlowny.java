package GUI;


import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PanelGlowny extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private RootGUI rootGUI = new RootGUI();
	JFrame frame = new JFrame("Geocaching");
	JPanel glownyPanel = new JPanel();
	JPanel logbookPanel = new LogbookGUI(rootGUI);
	JPanel poszukiwaczPanel = new PoszukiwaczGUI(rootGUI);
	JPanel skrzynkaPanel = new JPanel();
	GridLayout gl = new GridLayout(1, 2);
	JTabbedPane tabbedPane = new JTabbedPane();
	private JMenuBar menuBar;

	public static void main(String[] args) {
		try {
			PanelGlowny frame = new PanelGlowny();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PanelGlowny() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(glownyPanel);
		glownyPanel.setLayout(gl);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		glownyPanel.add(tabbedPane);
		tabbedPane.addTab("Poszukiwacze", null, poszukiwaczPanel, null);
		tabbedPane.addTab("Skrzynki", null, skrzynkaPanel, null);
		tabbedPane.addTab("Logbook", null, logbookPanel, null);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1000, 800);
		
		menuBar = new Menu(rootGUI);
		frame.setJMenuBar(menuBar);	
		
		frame.setVisible(true);
		
	}
}
