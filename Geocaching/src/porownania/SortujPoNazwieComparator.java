package porownania;

import java.util.Comparator;

import logika.*;

public class SortujPoNazwieComparator<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2)  {
		if (o1 instanceof Skrzynka && o2 instanceof Skrzynka) {
			return ((Skrzynka) o1).getNazwa().compareTo(((Skrzynka) o2).getNazwa());
		}
	    if (o1 instanceof Poszukiwacz && o2 instanceof Poszukiwacz) {
			return ((Poszukiwacz) o1).getPseudonim().compareTo(((Poszukiwacz) o2).getPseudonim());
		}
	    return 0;
	}
}
