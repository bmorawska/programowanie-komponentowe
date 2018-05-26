package dane;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import logika.Poszukiwacz;
import logika.Poziom;
import wyjatki.NieudaneMapowanieException;

public class PoszukiwaczDane extends BazaDanych {
	
	public PoszukiwaczDane() {
		super("SELECT * FROM poszukiwacz");
	}

	@Override
	protected void proces(Map<String, Object> context) throws SQLException {
		
		List<Poszukiwacz> poszukiwacze = new ArrayList<>();
		
		try {
		while(resultSet.next()) {
			
			String pseudonim = resultSet.getString("pseudonim");
			String email = resultSet.getString("email");
			String poziomString = resultSet.getString("poziom");
			Poziom poziom;

			poziom = stringToPoziom(poziomString);	
					
			Poszukiwacz p = new Poszukiwacz(pseudonim, email, poziom);
			poszukiwacze.add(p);
		}
		} catch (NieudaneMapowanieException e) {
			System.err.println("Nie udało się zmapować obiektów typu Poszukiwacz.");
			e.printStackTrace();
		}
		
		
		context.put("wynik", poszukiwacze);
	}
	
	private Poziom stringToPoziom (String poziomString) throws NieudaneMapowanieException {
		
		Poziom poziom = Poziom.NOWICJUSZ;
		
		switch (poziomString) {
		case "NOWICJUSZ":
			poziom = Poziom.NOWICJUSZ;
			break;
		case "UCZEN":
			poziom = Poziom.UCZEN;
			break;
		case "CZELADNIK":
			poziom = Poziom.CZELADNIK;
			break;
		case "EKSPERT":
			poziom = Poziom.EKSPERT;
			break;
		case "MISTRZ":
			poziom = Poziom.MISTRZ;
			break;
		default:
			throw new NieudaneMapowanieException("Nie udało się zmapować obiektów z bazy danych");
		}
		
		return (poziom);
	}

}
