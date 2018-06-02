package dane;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JCalendar;

public class WyroznieniaDaty implements IDateEvaluator {

	private List<Date> list;
	
	

	public WyroznieniaDaty(List<Date> list) {
		super();
		this.list = list;
	}

	@Override
	public boolean isSpecial(Date date) {
		boolean jest = list.contains(date);   
		return jest;
	}

	@Override
	public Color getSpecialForegroundColor() {
		return Color.BLACK;
	}

	@Override
	public Color getSpecialBackroundColor() {
		return Color.GREEN;
	}

	@Override
	public String getSpecialTooltip() {
		return "Kliknij, aby dowiedzieć się więcej.";
	}

	@Override
	public boolean isInvalid(Date date) {
		return false;
	}

	@Override
	public Color getInvalidForegroundColor() {
		return null;
	}

	@Override
	public Color getInvalidBackroundColor() {
		return null;
	}

	@Override
	public String getInvalidTooltip() {
		return null;
	}

}
