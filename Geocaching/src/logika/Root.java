package logika;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import dane.*;
import porownania.SortujPoDacieZalozeniaComparator;
import wyjatki.ObiektOTejNazwiJestJuzNaLiscieException;
import wyjatki.ObiektOTejNazwieNieIstniejeException;

public class Root implements XMLable<Root> {

	private ArrayList<Poszukiwacz> poszukiwacze;
	private ArrayList<Skrzynka> skrzynki;
	private ArrayList<Odkrycie> odkrycia;

	public Root() {
		super();
		poszukiwacze = new ArrayList<>();
		skrzynki = new ArrayList<>();
		odkrycia = new ArrayList<>();
		
		mapujBazeDanych();
		
	}

	private void mapujBazeDanych() {
		Map<String, Object> context = new HashMap <String, Object>();	
		PoszukiwaczDane poszukiwaczDane = new PoszukiwaczDane();
		SkrzynkaDane skrzynkaDane = new SkrzynkaDane(poszukiwacze);
		OdkryciaDane odkryciaDane = new OdkryciaDane(poszukiwacze, skrzynki);
		
		poszukiwaczDane.wykonaj(context);
		poszukiwacze = (ArrayList<Poszukiwacz>) context.get("wynik");

		skrzynkaDane.wykonaj(context);
		skrzynki = (ArrayList<Skrzynka>) context.get("wynik");
		
		odkryciaDane.wykonaj(context);
		odkrycia = (ArrayList<Odkrycie>) context.get("wynik");
		
		/*Test metod do dodawania. Jak będzie interfejs graficzny to można wywalić
		dodajDoBazyDanych("INSERT INTO poszukiwacz VALUES ('Basia', 'basia@gmail.com', 'MISTRZ')");
		usunZBazyDanych("DELETE FROM poszukiwacz WHERE pseudonim = 'Basia'");
		zmienBazeDanych("UPDATE poszukiwacz SET email = 'Baldus97@gmail.com' WHERE pseudonim = 'Baldus'");
		*/
	}

	private void zmienBazeDanych(String sql) {
		InsertUpdateDeleteDane iudd = new InsertUpdateDeleteDane(sql);
		iudd.zmien();	
	}

	private void usunZBazyDanych(String sql) {
		InsertUpdateDeleteDane iudd = new InsertUpdateDeleteDane(sql);
		iudd.zmien();
	}

	private void dodajDoBazyDanych(String sql) {
		InsertUpdateDeleteDane iudd = new InsertUpdateDeleteDane(sql);
		iudd.zmien();
	}

	public ArrayList<Poszukiwacz> getPoszukiwacze() {
		return poszukiwacze;
	}

	public ArrayList<Skrzynka> getSkrzynki() {
		return skrzynki;
	}

	public ArrayList<Odkrycie> getOdkrycia() {
		return odkrycia;
	}

	public ArrayList<Poszukiwacz> poszukiwaczeNaTymSamymPoziomie(Poziom poziom) {
		ArrayList<Poszukiwacz> poszukiwaczePoziom = new ArrayList<>();

		for (Poszukiwacz p : poszukiwacze) {
			if (p.getPoziom().equals(poziom)) {
				poszukiwaczePoziom.add(p);
			}
		}

		return poszukiwaczePoziom;
	}

	public ArrayList<Skrzynka> skrzynkiTegoSamegoTypu(TypSkrzynki typSkrzynki) {
		ArrayList<Skrzynka> skrzynkiTyp = new ArrayList<>();

		for (Skrzynka s : skrzynki) {
			if (s.getTypSkrzynki().equals(typSkrzynki)) {
				skrzynkiTyp.add(s);
			}
		}

		return skrzynkiTyp;
	}

	public ArrayList<Skrzynka> skrzynkiTegoSamegoRozmiaru(Rozmiar rozmiar) {
		ArrayList<Skrzynka> skrzynkiRozmiar = new ArrayList<>();

		for (Skrzynka s : skrzynki) {
			if (s.getRozmiar().equals(rozmiar)) {
				skrzynkiRozmiar.add(s);
			}
		}

		return skrzynkiRozmiar;
	}

	public Poszukiwacz zalozycielSkrzynki(Skrzynka s) {
		return (s.getZalozyciel());
	}

	public ArrayList<Skrzynka> skrzynkiZalozonePrzezPoszukiwacza(Poszukiwacz p) {

		ArrayList<Skrzynka> skrzynkiPoszukiwacza = new ArrayList<>();

		for (Skrzynka s : skrzynki) {
			if (s.getZalozyciel().equals(p)) {
				skrzynkiPoszukiwacza.add(s);
			}
		}

		return skrzynkiPoszukiwacza;
	}

	public ArrayList<Skrzynka> dostepneSkrzynki(boolean zwrocicDostepne) {

		ArrayList<Skrzynka> dostepneSkrzynki = new ArrayList<>();

		if (zwrocicDostepne) {
			for (Skrzynka s : skrzynki) {
				if (s.getCzyDostepna()) {
					dostepneSkrzynki.add(s);
				}
			}
		} else {
			for (Skrzynka s : skrzynki) {
				if (!s.getCzyDostepna()) {
					dostepneSkrzynki.add(s);
				}
			}
		}

		return dostepneSkrzynki;

	}

	public ArrayList<Skrzynka> skrzynkiZnalezionePomiedzyDatami(GregorianCalendar data1, GregorianCalendar data2) {

		ArrayList<Skrzynka> skrzynkiMiedzyDatami = new ArrayList<>();

		for (Skrzynka s : skrzynki) {
			if (s.getDataZalozenia().before(data2) && s.getDataZalozenia().after(data1)) {
				skrzynkiMiedzyDatami.add(s);
			}
		}

		Collections.sort(skrzynkiMiedzyDatami, new SortujPoDacieZalozeniaComparator());
		return skrzynkiMiedzyDatami;
	}

	public <T> void usunObiekt(T obj, ArrayList<T> lista) throws ObiektOTejNazwieNieIstniejeException {

		if (lista.contains(obj)) {
			lista.remove(obj);
		} else {
			throw new ObiektOTejNazwieNieIstniejeException("Nie ma takiej nazwy w bazie danych");
		}
	}

	public <T> void dodajObiekt(T obj, ArrayList<T> lista) throws ObiektOTejNazwiJestJuzNaLiscieException {

		if (lista.contains(obj)) {
			throw new ObiektOTejNazwiJestJuzNaLiscieException("Ten pseudonim jest juz zajety");
		} else {
			lista.add(obj);
		}
	}

	@Override
	public void zapiszJakoXML(XMLEncoder e) {

		e.writeObject(this);
	}

	@Override
	public Root odczytajZXML(XMLDecoder d) {

		Root root = (Root) d.readObject();
		return root;
	}

}
