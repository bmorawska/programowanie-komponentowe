package dane;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

public interface XMLable<T> {

	public void zapiszJakoXML (XMLEncoder e);
	public T odczytajZXML(XMLDecoder d);
	
}
