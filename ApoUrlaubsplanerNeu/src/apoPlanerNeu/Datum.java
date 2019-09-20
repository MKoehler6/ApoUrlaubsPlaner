package apoPlanerNeu;

import java.time.*;
import java.time.temporal.IsoFields;

public class Datum {
	
	int year = 2019;
	int week;
	
	public String gibMontagVonWocheX (int week)
	{
		LocalDate date = LocalDate.of(year, Month.JANUARY, 10);
		LocalDate dayInWeek = date.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, week);
		LocalDate dateMonday = dayInWeek.with(DayOfWeek.MONDAY);
		String dateStringEnglish = dateMonday.toString();
		String dateStringGerman = dateStringEnglish.split("-")[2] + "."
				+ dateStringEnglish.split("-")[1] + "."
				+ dateStringEnglish.split("-")[0];
		return dateStringGerman;
	}
	
	public String gibFreitagVonWocheX (int week)
	{
		LocalDate date = LocalDate.of(year, Month.JANUARY, 10);
		LocalDate dayInWeek = date.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, week);
		LocalDate dateMonday = dayInWeek.with(DayOfWeek.FRIDAY);
		String dateStringEnglish = dateMonday.toString();
		String dateStringGerman = dateStringEnglish.split("-")[2] + "."
				+ dateStringEnglish.split("-")[1] + "."
				+ dateStringEnglish.split("-")[0];
		return dateStringGerman;
	}

}
