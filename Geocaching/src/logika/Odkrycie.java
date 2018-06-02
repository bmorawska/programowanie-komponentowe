package logika;

import java.util.GregorianCalendar;

public class Odkrycie {
	
	private final int id;
	private Poszukiwacz poszukiwacz;
	private Skrzynka skrzynka;
	private GregorianCalendar dataZnalezienia;
	
	public Odkrycie(int id, Poszukiwacz poszukiwacz, Skrzynka skrzynka) {
		super();
		this.id = id;
		this.poszukiwacz = poszukiwacz; 
		this.skrzynka = skrzynka;
		this.dataZnalezienia = new GregorianCalendar();
	}
	
	public Odkrycie(int id, Poszukiwacz poszukiwacz, Skrzynka skrzynka, GregorianCalendar dataZnalezienia) {
		super();
		this.id = id;
		this.poszukiwacz = poszukiwacz;
		this.skrzynka = skrzynka;
		this.dataZnalezienia = dataZnalezienia;
	}
	
	
	public GregorianCalendar getDataZnalezienia() {
		return dataZnalezienia;
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
		return "Odkrycie: [id=" + id + ", poszukiwacz=" + poszukiwacz + ", skrzynka=" + skrzynka + ", dataZnalezienia="
				+ dataZnalezienia + "]";
	}
}
