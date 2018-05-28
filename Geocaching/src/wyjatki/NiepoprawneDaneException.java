package wyjatki;

public class NiepoprawneDaneException extends Exception {
	private static final long serialVersionUID = 1L;

	public NiepoprawneDaneException(String wiadomosc) {
		super(wiadomosc);
	}

}
