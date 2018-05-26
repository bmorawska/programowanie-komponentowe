package dane;

import java.sql.*;
import java.util.Map;

import javax.swing.JOptionPane;

abstract public class BazaDanych {

	private static final String SQL_SERVER_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String CONNECTION_URL = "jdbc:sqlserver://localhost:1433;"
			+ "databaseName=GeocachingDB;integratedSecurity=true;";
	private Connection con;
	private Statement stmt;
	protected ResultSet resultSet;
	private String sql;

	public BazaDanych(String sql) {
		this.sql = sql;
	}

	public void wykonaj(Map <String, Object> context) {
		try {
			polaczZBazaDanych();
			wykonajKwerendeSQL();
			proces(context);
			zakonczPolaczenieZBaza();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nie udało się połączyć z bazą danych", "Błąd połączenia",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void zmien() {
		try {
			polaczZBazaDanych();
			zmienBaze();
			zakonczPolaczenieZBaza();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nie udało się wykonać operacji.", "Błąd operacji.",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void zmienBaze() throws SQLException {
		
		stmt = con.createStatement();
		stmt.executeUpdate(sql);
	}

	private void polaczZBazaDanych() throws ClassNotFoundException, SQLException {

		con = null;
		stmt = null;
		Class.forName(SQL_SERVER_DRIVER);
		con = DriverManager.getConnection(CONNECTION_URL);
	}

	abstract protected void proces(Map <String, Object> context) throws SQLException;

	private void wykonajKwerendeSQL() throws SQLException {
		stmt = con.createStatement();
		resultSet = stmt.executeQuery(sql);
	}

	private  void zakonczPolaczenieZBaza() throws SQLException {
		try {
		resultSet.close();
		}catch (Exception e) {
			//Specjalnie jest pusto
		}
		finally {
		stmt.close();
		con.close();
		}
	}
}
