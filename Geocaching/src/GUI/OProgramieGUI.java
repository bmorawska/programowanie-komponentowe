package GUI;


import java.awt.GridLayout;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class OProgramieGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private GridLayout gl = new GridLayout(1, 1);

	public OProgramieGUI() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 200, 800, 600);
		setTitle("O Programie");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(gl);

		JEditorPane jep = new JEditorPane();
		jep.setEditable(false);

		jep.setContentType("text/html");
		jep.setText("<html>"
				+ "<b> Geocaching </b> - gra terenowa użytkowników odbiorników GPS, polegająca na poszukiwaniu tzw. skrytek uprzednio ukrytych przez innych uczestników "
				+ "		zabawy. Ukrywane przeważnie w interesujących miejscach skrytki zawierają dziennik odwiedzin (logbook), do którego wpisują się kolejni znalazcy, a także "
				+ "		drobne upominki na wymianę. Lokalizacja miejsca ukrycia skrytki przekazywana jest przez jej założyciela innym uczestnikom gry poprzez wprowadzenie"
				+ "		współrzędnych geograficznych w jednej ze specjalnych internetowych baz danych, tzw. serwisów geocachingowych.\r\n\n\n"
				+ " Skrzynki geocachingowe dzielimy na różne rodzaje w zależności od ich rozmiaru i sposobu znalezienia. </br>\r"
				+ "	Poniższa tebela prezentuje występujące w programie rodzaje skrzynek." + "	</br>" + "\n"
				+ "	<table border=\"1\" cellspacing=\"2\">\r\n" + "	<tr>\r\n"
				+ "		<td><b>Typ</b></td>	<td><b>Idea skrzynki</b></td>	<td><b>Współrzędne wskazują</b></td>	<td><b>Logbook</b></td>\r\n"
				+ "	</tr>\r\n" + "	<tr>\r\n"
				+ "		<td>Tradycyjna</td>	<td>fizyczna skrzynka </br> ukryta na współrzędnych</td>	<td>fizyczne miejsce ukrycia skrzynki</td>	<td>papierowy - w skrzynce</td>\r\n"
				+ "	</tr>\r\n" + "	<tr>\r\n"
				+ "		<td>Wydarzenie</td>	<td>spotkanie keszerów, </br> brak fizycznego pojemnika</td>	<td>miejsce spotkania</td>	<td>brak</td>\r\n"
				+ "	</tr>\r\n" + "	<tr>\r\n"
				+ "		<td>Earthcache</td>	<td>brak fizycznego pojemnika,</br>  pokazanie znajdującym miejsca </br> unikalnego z punktu </br> widzenia geologii</td>	<td>miejsce ciekawego zjawiska</td>	<td>brak</td>\r\n"
				+ "	</tr>\r\n" + "	<tr>\r\n"
				+ "		td>Zagadkowa</td>		<td>wymaga rozwiązania </br> zagadki w celu poznania </br> miejsca ukrycia fizycznego</br>  pojemnika</td>		<td>dowolne miejsce	papierowy</td>	 <td> w skrzynce</td>	\r\n"
				+ "	</tr>\r\n" + "	<tr>\r\n"
				+ "		<td>Zdjęcie</td>	<td>do jej zaliczenia wymagane </br> jest zdjęcie</td>	<td>miejsce w którym wykonywane jest zdjęcie</td>	<td>brak</td>\r\n"
				+ "	</tr>\r\n" + "	</table>"
				+ "<b> Program </b> symuluje środowisko, w którym w bazie danych przechowywane są informacje o poszukiwaczach, skrzynkach i ich znalezieniach.\""
				+ "			\"	Logbook przedstawiony jest w formie kalendarza, w którym można zapisywać, który poszukiwacz znalazł, którą skrzynkę i datę tego wydarzenia. Możliwe\" + \r\n"
				+ "			\"	jest również planowanie wydarzeń przyszłych, które aby nie zostały zapomniane, są sygnalizowane alarmem. Można także filtrować dane, usuwać, dodawać obiektyy\" + \r\n"
				+ "			\"	oraz je modyfikować.\" " + "</html>");
		
		JScrollPane scrollPane = new JScrollPane(jep);

		setContentPane(contentPane);
		contentPane.add(scrollPane);

		setVisible(true);
	}

}
