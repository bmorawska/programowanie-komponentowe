package logika;

import java.util.GregorianCalendar;

public class Skrzynka {
	
	private String nazwa;
	private Wspolrzedne wspolrzedne;
	private TypSkrzynki typSkrzynki;
	private Rozmiar rozmiar;
	private String opis;
	private int liczbaOdnalezien;
	private Poszukiwacz zalozyciel;
	private GregorianCalendar dataZalozenia;
	private boolean czyDostepna;
	
	
	//Minimalne dane pozwalające na utworzenie obiektu mającego sens
	public Skrzynka(String nazwa, 
					Wspolrzedne wspolrzedne, 
					TypSkrzynki typSkrzynki, 
					Rozmiar rozmiar, 
					Poszukiwacz zalozyciel) {
		super();
		this.nazwa = nazwa;
		this.wspolrzedne = wspolrzedne;
		this.typSkrzynki = typSkrzynki;
		this.rozmiar = rozmiar;
		this.zalozyciel = zalozyciel;
		this.opis = "Brak opisu";
		this.czyDostepna = true;
		this.liczbaOdnalezien = 0;
		this.dataZalozenia = new GregorianCalendar();		//dzisiejsza data
	}
	
	//Pełne dane identyfikujące skrzynkę
	public Skrzynka(String nazwa, 
			Wspolrzedne wspolrzedne, 
			TypSkrzynki typSkrzynki, 
			Rozmiar rozmiar, 
			Poszukiwacz zalozyciel,
			String opis,
			GregorianCalendar dataZalozenia) 
	{
			super();
			this.nazwa = nazwa;
			this.wspolrzedne = wspolrzedne;
			this.typSkrzynki = typSkrzynki;
			this.rozmiar = rozmiar;
			this.zalozyciel = zalozyciel;
			this.opis = opis;
			this.czyDostepna = true; 
			this.liczbaOdnalezien = 0;
			this.dataZalozenia = dataZalozenia;		//dzisiejsza data
	}
	
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public int getLiczbaOdnalezien() {
		return liczbaOdnalezien;
	}
	public void setLiczbaOdnalezien(int liczbaOdnalezien) {
		this.liczbaOdnalezien = liczbaOdnalezien;
	}
	public boolean isCzyDostepna() {
		return czyDostepna;
	}
	public void setCzyDostepna(boolean czyDostepna) {
		this.czyDostepna = czyDostepna;
	}
	public String getNazwa() {
		return nazwa;
	}
	public Wspolrzedne getWspolrzedne() {
		return wspolrzedne;
	}
	public TypSkrzynki getTypSkrzynki() {
		return typSkrzynki;
	}
	public Rozmiar getRozmiar() {
		return rozmiar;
	}
	public Poszukiwacz getZalozyciel() {
		return zalozyciel;
	}
	public GregorianCalendar getDataZalozenia() {
		return dataZalozenia;
	}
	
	public boolean getCzyDostepna() {
		return czyDostepna;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skrzynka other = (Skrzynka) obj;
		if (nazwa == null) {
			if (other.nazwa != null)
				return false;
		} else if (!nazwa.equals(other.nazwa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Skrzynka [nazwa=" + nazwa + ", \n" + 
					 	 "wspolrzedne=" + wspolrzedne + ", \n" +
					 	 "typSkrzynki=" + typSkrzynki + ", \n" +
					 	 "rozmiar=" + rozmiar + ", \n" + 
					 	 "opis=" + opis + ", \n" + 
					 	 "liczbaOdnalezien=" + liczbaOdnalezien + ", \n" + 
					 	 "zalozyciel=" + zalozyciel + ", /n" + 
					 	 "dataZalozenia=" + dataZalozenia + ", /n" + 
					 	 "czyDostepna=" + czyDostepna + "]";
	}
}
