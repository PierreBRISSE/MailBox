package tools;

import java.time.LocalDate;

public abstract class AbstractDateCreation {
	protected LocalDate date, dateToday;
	protected String DDMMAA, DDMMAAAA, DDMMAAToday, DDMMAAAAToday;
	protected String day, month, year2, year4;
	protected String dayToday, monthToday, year2Today, year4Today;
	protected int returnCode;

	// Getters & setters :
	public int getReturnCode() {
		return returnCode;
	}

	protected void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public LocalDate getDate() {
		return date;
	}

	protected void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getDateToday() {
		return dateToday;
	}

	protected void setDateToday(LocalDate dateToday) {
		this.dateToday = dateToday;
	}

	public String getDDMMAA() {
		return DDMMAA;
	}

	protected void setDDMMAA(String dDMMAA) {
		DDMMAA = dDMMAA;
	}

	public String getDDMMAAAA() {
		return DDMMAAAA;
	}

	protected void setDDMMAAAA(String dDMMAAAA) {
		DDMMAAAA = dDMMAAAA;
	}

	public String getDDMMAAToday() {
		return DDMMAAToday;
	}

	protected void setDDMMAAToday(String dDMMAAToday) {
		DDMMAAToday = dDMMAAToday;
	}

	public String getDDMMAAAAToday() {
		return DDMMAAAAToday;
	}

	protected void setDDMMAAAAToday(String dDMMAAAAToday) {
		DDMMAAAAToday = dDMMAAAAToday;
	}

	public String getDay() {
		return day;
	}

	protected void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	protected void setMonth(String month) {
		this.month = month;
	}

	public String getYear2() {
		return year2;
	}

	protected void setYear2(String year2) {
		this.year2 = year2;
	}

	public String getYear4() {
		return year4;
	}

	protected void setYear4(String year4) {
		this.year4 = year4;
	}

	public String getDayToday() {
		return dayToday;
	}

	protected void setDayToday(String dayToday) {
		this.dayToday = dayToday;
	}

	public String getMonthToday() {
		return monthToday;
	}

	protected void setMonthToday(String monthToday) {
		this.monthToday = monthToday;
	}

	public String getYear2Today() {
		return year2Today;
	}

	protected void setYear2Today(String year2Today) {
		this.year2Today = year2Today;
	}

	public String getYear4Today() {
		return year4Today;
	}

	protected void setYear4Today(String year4Today) {
		this.year4Today = year4Today;
	}

}// END PRG
