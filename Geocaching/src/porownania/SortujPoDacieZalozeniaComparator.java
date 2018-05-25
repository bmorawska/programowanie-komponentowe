package porownania;

import java.util.Calendar;
import java.util.Comparator;
import logika.Skrzynka;

public class SortujPoDacieZalozeniaComparator implements Comparator<Skrzynka> {
	
	@Override
	public int compare(Skrzynka o1, Skrzynka o2) {
		return ((logika.Skrzynka) o1).getDataZalozenia().get(Calendar.DATE) - 
			   ((logika.Skrzynka) o2).getDataZalozenia().get(Calendar.DATE);
	}

}
