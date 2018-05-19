package logika;

public class Wspolrzedne {
	
	private double dlugosc;
	private double szerokosc;
	
	public Wspolrzedne(double dlugosc, double szerokosc) {
		super();
		this.dlugosc = dlugosc;
		this.szerokosc = szerokosc;
	}

	public double getDlugosc() {
		return dlugosc;
	}
	
	public void setDlugosc(double dlugosc) {
		this.dlugosc = dlugosc;
	}
	
	public double getSzerokosc() {
		return szerokosc;
	}
	
	public void setSzerokosc(double szerokosc) {
		this.szerokosc = szerokosc;
	}

	@Override
	public String toString() {
		return "Wspolrzedne [dlugosc=" + dlugosc + ", szerokosc=" + szerokosc + "]";
	}
}
