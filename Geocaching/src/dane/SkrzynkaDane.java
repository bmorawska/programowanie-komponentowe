package dane;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import logika.Poszukiwacz;
import logika.Rozmiar;
import logika.Skrzynka;
import logika.TypSkrzynki;
import logika.Wspolrzedne;
import wyjatki.NieudaneMapowanieException;

public class SkrzynkaDane extends BazaDanych {

	ArrayList<Poszukiwacz> poszukiwacze;

	public SkrzynkaDane(ArrayList<Poszukiwacz> poszukiwacze) {
		super("SELECT * FROM skrzynka");

		this.poszukiwacze = poszukiwacze;
	}

	@Override
	protected void proces(Map<String, Object> context) throws SQLException {

		List<Skrzynka> skrzynki = new ArrayList<>();

		try {
			while (resultSet.next()) {

				String nazwa = resultSet.getString("nazwa");
				String opis = resultSet.getString("opis");
				int liczbaOdnalezien = resultSet.getInt("liczba_odnalezien");
				boolean czyDostepna = resultSet.getBoolean("czyDostepna");
				Date dataZalozeniaDate = resultSet.getDate("dataZalozenia");
				GregorianCalendar dataZalozenia = new GregorianCalendar();
				dataZalozenia.setTime(dataZalozeniaDate);
				String wspolrzedneDlugoscString = resultSet.getString("wspolrzedne_dlugosc");
				double wspolrzedneDlugosc = Double.parseDouble(wspolrzedneDlugoscString);
				String wspolrzedneSzerokoscString = resultSet.getString("wspolrzedne_szerokosc");
				double wspolrzedneSzerokosc = Double.parseDouble(wspolrzedneSzerokoscString);
				Wspolrzedne wspolrzedne = new Wspolrzedne(wspolrzedneDlugosc, wspolrzedneSzerokosc);
				String rozmiarString = resultSet.getString("rozmiar");
				Rozmiar rozmiar = stringToRozmiar(rozmiarString);
				String typSkrzynkiString = resultSet.getString("typSkrzynki");
				TypSkrzynki typSkrzynki = stringToTypSkrzynki(typSkrzynkiString);
				String zalozycielString = resultSet.getString("zalozyciel");
				Poszukiwacz zalozyciel = null;
				for (Poszukiwacz p : poszukiwacze) {
					if (p.getPseudonim().equals(zalozycielString)) {
						zalozyciel = p;
					}
				}

				Skrzynka s = new Skrzynka(nazwa, wspolrzedne, typSkrzynki, rozmiar, zalozyciel, opis, dataZalozenia,
						czyDostepna, liczbaOdnalezien);
				skrzynki.add(s);
			}
		} catch (NieudaneMapowanieException e) {
			System.err.println("Nie udało się zmapować obiektów typu Poszukiwacz.");
			e.printStackTrace();
		}

		context.put("wynik", skrzynki);

	}

	private Rozmiar stringToRozmiar(String rozmiarString) throws NieudaneMapowanieException {

		Rozmiar rozmiar = Rozmiar.NORMALNY;

		switch (rozmiarString) {
		case "NORMALNY":
			rozmiar = Rozmiar.NORMALNY;
			break;
		case "MALY":
			rozmiar = Rozmiar.MALY;
			break;
		case "MIKRO":
			rozmiar = Rozmiar.MIKRO;
			break;
		case "DUZY":
			rozmiar = Rozmiar.DUZY;
			break;
		default:
			throw new NieudaneMapowanieException("Nie udało się zmapować obiektów z bazy danych");
		}

		return (rozmiar);
	}

	private TypSkrzynki stringToTypSkrzynki(String typSkrzynkiString) throws NieudaneMapowanieException {

		TypSkrzynki typSkrzynki = TypSkrzynki.EARTHCACHE;

		switch (typSkrzynkiString) {
		case "EARTHCACHE":
			typSkrzynki = TypSkrzynki.EARTHCACHE;
			break;
		case "ZDJECIE":
			typSkrzynki = TypSkrzynki.ZDJECIE;
			break;
		case "ZAGADKOWA":
			typSkrzynki = TypSkrzynki.ZAGADKOWA;
			break;
		case "WYDARZENIE":
			typSkrzynki = TypSkrzynki.WYDARZENIE;
			break;
		case "TRADYCYJNA":
			typSkrzynki = TypSkrzynki.TRADYCYJNA;
			break;
		default:
			throw new NieudaneMapowanieException("Nie udało się zmapować obiektów z bazy danych");
		}

		return (typSkrzynki);
	}

}
