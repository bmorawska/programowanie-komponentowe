package porownania;

import java.util.Comparator;

import logika.Skrzynka;

public class SortujPoLiczbieOdnalezienComparator implements Comparator<Skrzynka>{

	@Override
	public int compare(Skrzynka o1, Skrzynka o2) {
		return o1.getLiczbaOdnalezien() - o2.getLiczbaOdnalezien();
	} 
}
