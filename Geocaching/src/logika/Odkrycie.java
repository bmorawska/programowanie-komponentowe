package logika;

import java.util.GregorianCalendar;

public class Odkrycie {
	
	private int id;
	private Poszukiwacz poszukiwacz;
	private Skrzynka skrzynka;
	private GregorianCalendar dataZnalezienia;
	
	public Odkrycie(Poszukiwacz poszukiwacz, Skrzynka skrzynka) {
		super();
		this.poszukiwacz = poszukiwacz; 
		this.skrzynka = skrzynka;
		this.dataZnalezienia = new GregorianCalendar();
	}
	
	public Odkrycie(Poszukiwacz poszukiwacz, Skrzynka skrzynka, GregorianCalendar dataZnalezienia) {
		super();
		this.poszukiwacz = poszukiwacz;
		this.skrzynka = skrzynka;
		this.dataZnalezienia = dataZnalezienia;
	}
	
	public int getId() {
		return id;
	}

	public Poszukiwacz getPoszukiwacz() {
		return poszukiwacz;
	}
	
	public Skrzynka getSkrzynka() {
		return skrzynka;
	}

	@Override
	public String toString() {
		return "Odkrycie [id=" + id + ", poszukiwacz=" + poszukiwacz + ", skrzynka=" + skrzynka + "]";
	}
}
