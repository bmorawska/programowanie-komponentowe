package dane;

import java.sql.SQLException;
import java.util.Map;


public class InsertUpdateDeleteDane extends BazaDanych {

	public InsertUpdateDeleteDane(String sql) {
		super(sql);
	}

	@Override
	protected void proces(Map<String, Object> context) throws SQLException { }
}
