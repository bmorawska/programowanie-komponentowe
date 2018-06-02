package GUI;

import javax.swing.table.AbstractTableModel;

public class Tabelka extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	private String[] nazwyKolumn = { "Pseudonim", "Email", "Poziom" }; 	
 	private Object[][] dane;	
	
	public Tabelka(Object[][] dane) {
		this.dane = dane;	
	}

	@Override
	public int getColumnCount() {
		return nazwyKolumn.length;
	}

	@Override
	public int getRowCount() {
		return dane.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return dane[row][col];
	}
	
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
	@Override
	public String getColumnName(int col) {
		return nazwyKolumn[col];
	}
	
	public void ustawNoweDane(Object[][] dane) {
		this.dane = dane;
	}
	
	public void odswiezTabele(Object[][] dane) {
		ustawNoweDane(dane);
		fireTableDataChanged();
	}

}
