package porownania;

import java.util.Comparator;
import logika.Wspolrzedne;
import logika.Skrzynka;

public class SortujPoOdleglosciComparator<Skrzynka> implements Comparator<Skrzynka> {
	
	Wspolrzedne wspolrzedne;

	public SortujPoOdleglosciComparator(Wspolrzedne wsporzedne) {
		super();
		this.wspolrzedne = wsporzedne;
	}
	
	private double sqr(double x) {
		return x * x;
	}
	
	private Double odlegloscSferyczna(Wspolrzedne w) {
		return (111.3 * Math.sqrt((sqr(w.getSzerokosc() - wspolrzedne.getSzerokosc()) + 
			   (sqr(w.getDlugosc() - wspolrzedne.getDlugosc())) * (Math.cos((wspolrzedne.getSzerokosc() * Math.PI)/180)))));
	}
	
	@Override
	public int compare(Skrzynka o1, Skrzynka o2) {
		return odlegloscSferyczna(((logika.Skrzynka) o1).getWspolrzedne()).compareTo
			  (odlegloscSferyczna(((logika.Skrzynka) o2).getWspolrzedne()));
	}
}
