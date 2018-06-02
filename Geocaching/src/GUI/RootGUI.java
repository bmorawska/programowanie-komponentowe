package GUI;

import java.sql.Date;
import java.util.ArrayList;

import logika.Poszukiwacz;
import logika.Poziom;
import logika.Root;
import logika.Skrzynka;


public class RootGUI<Odkrycie>  {

	private Root root; 
	
	public Root getRoot() {
		return root;
	}

	public RootGUI() {
		root = new Root();
		
	}
	
	public void dodajPoszukiwaczaDoBazy(String pseudonim, String email) {
		
		root.dodajPoszukiwaczaInsert(pseudonim, email);	
	}
	
	public void dodajOdkrycieDoBazy(String pseudonim, String nazwa, java.sql.Date  data) {
		
		root.dodajOdkrycieInsert(pseudonim, nazwa, data);
	}
	
	public void usunPoszkiwaczaZBazy(String pseudonim) {
		
		root.usunPoszukiwaczaDelete(pseudonim);	
	}
	
	public void aktualizujPoszukiwaczaWBazie(String pseudonim, String email, String poziom) {
		
		root.aktualizujPoszukiwaczaUpdate(pseudonim, email, poziom);	
	}
	

	public boolean sprawdzCzyIstniejePoszukiwacz(String pseudonim) {
		
		for (Poszukiwacz p : root.getPoszukiwacze()) {
			if (p.getPseudonim().equals(pseudonim)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean sprawdzCzyIstniejeSkrzynka(String skrzynkaNazwa) {
		
		for (Skrzynka p : root.getSkrzynki()) {
			if (p.getNazwa().equals(skrzynkaNazwa)) {
				return true;
			}
		}
		return false;
	}

	public Object[][] poszukiwaczeArrayListToObject2D() {
		Object obj [][] = root.getTablicaPoszukiwaczy();
		return (obj);
	}
	
	public void odswiezListePoszukiwaczy() {
		root.odswiezPoszukiwaczy();
	}

	public void posortujPoszukiwaczyAlfabetycznie() {
		root.sortujPoszukiwaczyPoNazwieComparator();
		
	}

	public void posortujSkrzynkiAlfabetycznie() {
		root.sortujSkrzynkiPoNazwieComparator();
		
	}

	public void sortujSkrzynkiPoLiczbieOdnalezien() {
		root.sortujSkrzynkiPoLiczbieOdnalezienComparator();
		
	}

	public void sortujSkrzynkiPoDacieZalozenia() {
		root.sortujSkrzynkiPoDacieZalozeniaComparator();
		
	}

	public void pomieszajSkrzynki() {
		root.shuffleSkrzynki();
		
	}
	
	public void pomieszajPoszukiwaczy() {
		root.shuffleSkrzynki();
		
	}

	public ArrayList<java.util.Date> dajDatyOdkryc() {
		return root.pokazDatyOdkryc();
	}

	public String pobierzInformacjeOOdkryciu(java.util.Date time) {
		return root.infoOOdkryciuZDnia(time);
	}

}
