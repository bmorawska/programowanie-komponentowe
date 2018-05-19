package logika;

public class Odkrycie {
	
	private int id;
	private Poszukiwacz poszukiwacz;
	private Skrzynka skrzynka;
	
	public Odkrycie(Poszukiwacz poszukiwacz, Skrzynka skrzynka) {
		super();
		this.poszukiwacz = poszukiwacz;
		this.skrzynka = skrzynka;
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
