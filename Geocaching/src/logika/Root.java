package logika;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import dane.*;
import porownania.SortujPoDacieZalozeniaComparator;
import porownania.SortujPoLiczbieOdnalezienComparator;
import porownania.SortujPoNazwieComparator;
import wyjatki.ObiektOTejNazwiJestJuzNaLiscieException;
import wyjatki.ObiektOTejNazwieNieIstniejeException;

public class Root implements XMLable<Root> {

	private ArrayList<Poszukiwacz> poszukiwacze;
	private ArrayList<Skrzynka> skrzynki;
	private ArrayList<Odkrycie> odkrycia;
	
	private Map<String, Object> context = new HashMap <String, Object>();	

	public Root() {
		super();
		poszukiwacze = new ArrayList<>();
		skrzynki = new ArrayList<>();
		odkrycia = new ArrayList<>();
		
		mapujBazeDanych();
		
	}

	private void mapujBazeDanych() {	
		PoszukiwaczDane poszukiwaczDane = new PoszukiwaczDane();
		SkrzynkaDane skrzynkaDane = new SkrzynkaDane(poszukiwacze);
		OdkryciaDane odkryciaDane = new OdkryciaDane(poszukiwacze, skrzynki);
		
		poszukiwaczDane.wykonaj(context);
		poszukiwacze = (ArrayList<Poszukiwacz>) context.get("wynik");

		skrzynkaDane.wykonaj(context);
		skrzynki = (ArrayList<Skrzynka>) context.get("wynik");
		
		odkryciaDane.wykonaj(context);
		odkrycia = (ArrayList<Odkrycie>) context.get("wynik");
	}
	
	public void odswiezPoszukiwaczy() {
		PoszukiwaczDane poszukiwaczDane = new PoszukiwaczDane();
		poszukiwaczDane.wykonaj(context);
		poszukiwacze = (ArrayList<Poszukiwacz>) context.get("wynik");
	}
	
	public void odswiezOdkrycia() {
		OdkryciaDane odkryciaDane = new OdkryciaDane(poszukiwacze, skrzynki);
		odkryciaDane.wykonaj(context);
		odkrycia = (ArrayList<Odkrycie>) context.get("wynik");
	}

	public void zmienBazeDanych(String sql) {
		InsertUpdateDeleteDane iudd = new InsertUpdateDeleteDane(sql);
		iudd.zmien();	
	}

	public void usunZBazyDanych(String sql) {
		InsertUpdateDeleteDane iudd = new InsertUpdateDeleteDane(sql);
		iudd.zmien();
	}

	public void dodajDoBazyDanych(String sql) {
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

	public String getEmailFromPseudonim(String pseudonim) {
		
		for (Poszukiwacz p : poszukiwacze) {
			if (p.getPseudonim().equals(pseudonim)) {
				return p.getEmail();
			}
		}
		return "";
		
	}
	
	public String getPoziomFromPseudonim(String pseudonim) {
		
		for (Poszukiwacz p : poszukiwacze) {
			if (p.getPseudonim().equals(pseudonim)) {
				return p.getPoziom().toString();
			}
		}
		return "";
		
	}

	public Object[][] getTablicaPoszukiwaczy() {
		
		Object obj[][] = new Object[poszukiwacze.size()][3];
		
		for (int i = 0; i < poszukiwacze.size(); i++) {
			obj[i][0] = poszukiwacze.get(i).getPseudonim();
			obj[i][1] = poszukiwacze.get(i).getEmail();
			obj[i][2] = poszukiwacze.get(i).getPoziom();
		}
		
		return (obj);
		
	}

	public void sortujPoszukiwaczyPoNazwieComparator() {
		Collections.sort(poszukiwacze, new SortujPoNazwieComparator<>());
	}

	public void sortujSkrzynkiPoNazwieComparator() {
		Collections.sort(skrzynki, new SortujPoNazwieComparator<>());	
	}

	public void sortujSkrzynkiPoLiczbieOdnalezienComparator() {
		Collections.sort(skrzynki, new SortujPoLiczbieOdnalezienComparator());
		
	}

	public void sortujSkrzynkiPoDacieZalozeniaComparator() {
		Collections.sort(skrzynki, new SortujPoDacieZalozeniaComparator());
		
	}

	public void shuffleSkrzynki() {
		Collections.shuffle(skrzynki);
		
	}
	
	public void shufflePoszukiwacze() {
		Collections.shuffle(poszukiwacze);
	}
	

	public void aktualizujPoszukiwaczaUpdate(String pseudonim, String email, String poziom) {
		String sql = "UPDATE poszukiwacz SET email = '" + email + "', poziom = '" + poziom + "' WHERE pseudonim = '" + pseudonim + "'"; 
		zmienBazeDanych(sql);
		
		Poziom poz;
		switch (poziom) {
		case "NOWICJUSZ":
			poz = Poziom.NOWICJUSZ;
			break;
		case "UCZEN":
			poz = Poziom.UCZEN;
			break;
		case "CZELADNIK":
			poz = Poziom.CZELADNIK;
			break;
		case "EKSPERT":
			poz = Poziom.EKSPERT;
			break;
		case "MISTRZ":
			poz = Poziom.MISTRZ;
			break;
		default:
			poz = Poziom.NOWICJUSZ;
			break;
		}
		
		Poszukiwacz p = null;
		for (Poszukiwacz posz : poszukiwacze) {
			if (posz.getPseudonim().equals(pseudonim)) {
				p = posz;
				p.setEmail(email);
				p.setPoziom(poz);
				
			}
		}
	}
	
	public void usunPoszukiwaczaDelete(String pseudonim) {
		String sql = "DELETE FROM poszukiwacz WHERE pseudonim = '" + pseudonim + "'";
		usunZBazyDanych(sql);
		
		Poszukiwacz p = null;
		for (Poszukiwacz posz : poszukiwacze) {
			if (posz.getPseudonim().equals(pseudonim)) {
				p = posz;
			}
		}
		getPoszukiwacze().remove(p);
	}
	

	public void dodajPoszukiwaczaInsert(String pseudonim, String email) {
		String sql = "INSERT INTO poszukiwacz VALUES ('" + pseudonim + "', '" + email + "', 'NOWICJUSZ')";
		dodajDoBazyDanych(sql);
		odswiezPoszukiwaczy();
	}

	public void dodajOdkrycieInsert(String pseudonim, String nazwa, java.sql.Date  data) {
		String sql = "INSERT INTO odkrycie (poszukiwacz, skrzynka, dataZnalezienia) VALUES ('" + pseudonim + "', '" + nazwa + "', '" + data + "')";
		dodajDoBazyDanych(sql);
		odswiezOdkrycia();
		
	}

	public ArrayList<Date> pokazDatyOdkryc() {
		ArrayList<Date> daty = new ArrayList<>();
		for (Odkrycie o : odkrycia) {
			GregorianCalendar gc = o.getDataZnalezienia();
			Date czas = (Date) gc.getTime();
			daty.add(czas);
		}
		
		return daty;
	}

	public String infoOOdkryciuZDnia(Date time) {
		String info = "";
		StringBuilder builder = new StringBuilder(info);
		for (Odkrycie o : odkrycia) {
			GregorianCalendar gc = o.getDataZnalezienia();
			Date czas = (Date) gc.getTime();
			if (time.after(czas) && !time.before(czas)) {
				builder.append("Odkrycie " + o.getId());
				builder.append("Poszukiwacz: " + o.getPoszukiwacz().getPseudonim().toString());
				builder.append("Skrzynka   : " + o.getSkrzynka().getNazwa().toString());
				builder.append("\n");
			}
		}
		info = builder.toString();
		return info;
	}

}
