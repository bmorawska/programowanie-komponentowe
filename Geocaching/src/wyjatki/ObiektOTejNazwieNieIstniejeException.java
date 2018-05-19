package wyjatki;

public class ObiektOTejNazwieNieIstniejeException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ObiektOTejNazwieNieIstniejeException(String wiadomosc) {
		super(wiadomosc);
	}
}
