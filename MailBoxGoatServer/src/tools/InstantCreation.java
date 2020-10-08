package tools;

import java.time.Instant;

public class InstantCreation {
	private Instant instantNow;
	private String dayTime;
	private int returnCode;

	public InstantCreation() {
		setReturnCode(100);
		setInstantNow(Instant.now());
		timeOfTheDay();
	}

	// Getters & Setters :
	public Instant getInstantNow() {
		return instantNow;
	}

	private void setInstantNow(Instant instantNow) {
		this.instantNow = instantNow;
	}

	public String getDayTime() {
		return dayTime;
	}

	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	/**
	 * The method remove the date of instance
	 */
	private void timeOfTheDay() {
		String instantStr, str;
		boolean end, trouve;
		int numLetterT, max;

		instantStr = this.instantNow.toString();

		if (instantStr.isBlank()) {
			this.returnCode = 115;

		} else {
			max = instantStr.length() - 1;
			numLetterT = 0;
			trouve = false;

			// Looking for the letter T, that separates the date from the time of the day
			do {
				end = false;
				str = instantStr.substring(numLetterT, numLetterT + 1);

				if (str.equalsIgnoreCase("T")) {
					end = true;
					trouve = true;
				} else if (numLetterT >= max) {
					end = true;
				} else {
					numLetterT++;
				}

			} while (end == false);

			// Filling the field dayTime if it has been found
			if (trouve == true) {
				this.dayTime = instantStr.substring(numLetterT + 1);

			} else {
				this.returnCode = 116;
			}
		}

	}// -

}// END PRG
