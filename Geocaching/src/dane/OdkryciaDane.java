package dane;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import logika.*;

public class OdkryciaDane extends BazaDanych {

	ArrayList<Poszukiwacz> poszukiwacze;
	ArrayList<Skrzynka> skrzynki;

	public OdkryciaDane(ArrayList<Poszukiwacz> poszukiwacze, ArrayList<Skrzynka> skrzynki) {
		super("SELECT * FROM odkrycie");
		this.poszukiwacze = poszukiwacze;
		this.skrzynki = skrzynki;
	}

	@Override
	protected void proces(Map<String, Object> context) throws SQLException {

		List<Odkrycie> odkrycia = new ArrayList<>();

		while (resultSet.next()) {

			int idOdkrycia = resultSet.getInt("id_odkrycia");
			Date dataZnalezieniaDate = resultSet.getDate("dataZnalezienia");
			GregorianCalendar dataZnalezienia = new GregorianCalendar();
			dataZnalezienia.setTime(dataZnalezieniaDate);
			String pseudonim = resultSet.getString("poszukiwacz");
			String skrzynkaNazwa = resultSet.getString("skrzynka");
			Poszukiwacz poszukiwacz = null;
			for (Poszukiwacz p : poszukiwacze) {
				if (p.getPseudonim().equals(pseudonim)) {
					poszukiwacz = p;
				}
			}
			Skrzynka skrzynka = null;
			for (Skrzynka s : skrzynki) {
				if (s.getNazwa().equals(skrzynkaNazwa)) {
					skrzynka = s;
				}
			}

			Odkrycie o = new Odkrycie(idOdkrycia, poszukiwacz, skrzynka, dataZnalezienia);
			odkrycia.add(o);

		}

		context.put("wynik", odkrycia);
	}
}
