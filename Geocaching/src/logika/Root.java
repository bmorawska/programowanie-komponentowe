package logika;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

import dane.PolaczenieZBazaDanych;
import dane.XMLable;
import porownania.SortujPoDacieZalozeniaComparator;
import wyjatki.ObiektOTejNazwiJestJuzNaLiscieException;
import wyjatki.ObiektOTejNazwieNieIstniejeException;

public class Root implements XMLable<Root>{
	
	private ArrayList<Poszukiwacz> poszukiwacze;
	private ArrayList<Skrzynka> skrzynki;
	private ArrayList<Odkrycie> odkrycia;
	
	private PolaczenieZBazaDanych polaczenieZBazaDanych;
	
	public Root() {
		super();
		poszukiwacze = new ArrayList<>();
		skrzynki = new ArrayList<>();
		odkrycia = new ArrayList<>();
		
		
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
		
	public Poszukiwacz zalozycielSkrzynki (Skrzynka s) {
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
		}
		else {
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
		}
		else {
			throw new ObiektOTejNazwieNieIstniejeException("Nie ma takiej nazwy w bazie danych");
		}
	}
	
	public <T> void dodajObiekt(T obj, ArrayList<T> lista) throws ObiektOTejNazwiJestJuzNaLiscieException {
		
		if (lista.contains(obj)) {
			throw new ObiektOTejNazwiJestJuzNaLiscieException("Ten pseudonim jest juz zajety");
		}
		else {
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
