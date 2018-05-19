package porownania;

import java.util.Comparator;

import logika.Odkrycie;

public class SortujPoIDOdkryciaComparator implements Comparator<Odkrycie>{

	@Override
	public int compare(Odkrycie o1, Odkrycie o2) {
		return ((Odkrycie) o1).getId() - ((Odkrycie) o2).getId();
	}

}
