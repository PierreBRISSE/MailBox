package tools;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateCreation extends AbstractDateCreation {

	public DateCreation() {
		super();
		setReturnCode(100);
		setDateToday(LocalDate.now());
		setDate(super.dateToday);
		dateStringConstruction();
	}

	public DateCreation(LocalDate date) {
		super();
		setReturnCode(100);
		setDate(date);
		setDateToday(LocalDate.now());
		dateStringConstruction();
	}

	public DateCreation(String date) {
		super();
		setReturnCode(100);
		setDateToday(LocalDate.now());
		creationOfDate(date);
	}

	/**
	 * 
	 * @param date (String)
	 */
	private void creationOfDate(String date) {
		String str;
		List<String> separator;
		boolean separatorPresent, end;
		int nbTab, nbMax;

		separator = new ArrayList<String>();
		separator.add("/");
		separator.add(".");
		separator.add("*");
		separator.add("+");
		separator.add("%");
		separator.add("#");

		separatorPresent = false;
		nbTab = 0;
		nbMax = separator.size() - 1;

		// Checking if there is a separator :
		do {
			end = false;
			str = separator.get(nbTab);

			if (date.contains(str)) {
				// Separator found
				separatorPresent = true;
			}

			if (nbTab >= nbMax) {
				// Separator not found
				end = true;
			} else if (separatorPresent == true) {
				end = true;
			} else {
				nbTab++;
			}

		} while (end == false);

		// The String date, is cut in a different manner if there is a separator or no
		if (separatorPresent == true) {
			separatorDateCreation(date);
			
		} else {
			separatorLessDateCreation(date);
			
		}

		dateStringConstruction();

	}// -

	/**
	 * 
	 * @param date (String) with no separator
	 */
	private void separatorLessDateCreation(String date) {
		LocalDate localDate;
		int day, month, year;

		if (date.length() == 6) { // ddmmyy
			day = Integer.valueOf(date.substring(0, 2));
			month = Integer.valueOf(date.substring(2, 4));
			year = Integer.valueOf(date.substring(4));

		} else if (date.length() == 8) { // ddmmyyyy
			day = Integer.valueOf(date.substring(0, 2));
			month = Integer.valueOf(date.substring(2, 4));
			year = Integer.valueOf(date.substring(4));

		} else {
			super.returnCode = 110;
			day = 1;
			month = 1;
			year = 1;

		}

		localDate = LocalDate.of(year, month, day);
		super.setDate(localDate);
	}// -

	/**
	 * 
	 * @param date (String) containing separator
	 */
	private void separatorDateCreation(String date) {
		int day, month, year;

		if (date.length() == 8) { // dd/mm/yy
			day = Integer.valueOf(date.substring(0, 2));
			month = Integer.valueOf(date.substring(3, 5));
			year = Integer.valueOf(date.substring(6));

		} else if (date.length() == 10) { // dd/mm/yyyy
			day = Integer.valueOf(date.substring(0, 2));
			month = Integer.valueOf(date.substring(3, 5));
			year = Integer.valueOf(date.substring(6));

		} else {
			super.returnCode = 110;
			day = 1;
			month = 1;
			year = 1;

		}

		super.setDate(LocalDate.of(year, month, day));
	}

	/**
	 * Create the string parameters concerning the date
	 */
	private void dateStringConstruction() {
		String[] infoDate;

		infoDate = dayConstructor(super.date);

		// Creation of String information about the date :
		setDay(infoDate[0]);
		setMonth(infoDate[1]);
		setYear4(infoDate[2]);
		setYear2(infoDate[3]);
		setDDMMAA(super.day + "/" + super.month + "/" + super.year2);
		setDDMMAAAA(super.day + "/" + super.month + "/" + super.year4);

		// Creation of String informations about the date of the day :
		creationStrindDateToday();

	}

	/**
	 * Creation of String informations concerning the current date
	 */
	private void creationStrindDateToday() {
		String[] infoDateToday;

		infoDateToday = dayConstructor(super.dateToday);

		setDayToday(infoDateToday[0]);
		setMonthToday(infoDateToday[1]);
		setYear4Today(infoDateToday[2]);
		setYear2Today(infoDateToday[3]);
		setDDMMAAToday(super.dayToday + "/" + super.monthToday + "/" + super.year2Today);
		setDDMMAAAAToday(super.dayToday + "/" + super.monthToday + "/" + super.year4Today);
	}

	/**
	 * 
	 * @param localDate
	 * @return elements of the date in String
	 */
	private String[] dayConstructor(LocalDate localDate) {
		String tabDate[];
		String dd, mm, aa, aaaa, str;
		int day, month, year;

		tabDate = new String[4];

		// Creation of the day :
		day = localDate.getDayOfMonth();
		str = String.valueOf(day);
		if (str.length() == 1) {
			dd = "0" + str;
		} else if (str.length() == 2) {
			dd = str;
		} else {
			super.returnCode = 111;
			dd = "01";
		}
		tabDate[0] = dd;

		// Creation of the month :
		month = localDate.getMonthValue();
		str = String.valueOf(month);
		if (str.length() == 1) {
			mm = "0" + str;
		} else if (str.length() == 2) {
			mm = str;
		} else {
			super.returnCode = 111;
			mm = "01";
		}
		tabDate[1] = mm;

		// Creation of the year :
		year = localDate.getYear();
		str = String.valueOf(year);
		switch (str.length()) {
		case 1:
			aa = "0" + str;
			aaaa = "200" + str;
			break;

		case 2:
			aa = str;
			aaaa = "20" + str;
			break;

		case 3:
			aaaa = "0" + str;
			aa = aaaa.substring(1, 3);
			break;

		case 4:
			aaaa = str;
			aa = aaaa.substring(2, 3);
			break;

		default:
			super.returnCode = 111;
			aa = "01";
			aaaa = "0001";
		}
		tabDate[2] = aaaa;
		tabDate[3] = aa;

		return tabDate;
	}

}// END PRG
