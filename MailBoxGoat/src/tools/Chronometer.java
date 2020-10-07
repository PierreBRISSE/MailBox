package tools;

public class Chronometer extends AbstractChronometer {

	public Chronometer() {
		super();
		init();
	}

	/**
	 * Initialization
	 */
	private void init() {
		super.setReturnCode(100);
		super.setEndTime(0);
		super.setPassedTime(0);
		super.setPauseTimeStart(0);
		super.setPauseTimeEnd(0);
		super.setPausedTime(0);
		super.setStartTime(0);
	}

	/**
	 * Starting the clock
	 * 
	 * @return returnCode
	 */
	public int startTime() {
		if (super.startTime > 0) {
			// Restarting the chronometer
			init();
			super.startTime = System.currentTimeMillis();

		} else if (super.startTime == 0) {
			// Start a new chronometer
			super.startTime = System.currentTimeMillis();

		} else {
			super.returnCode = 118;
		}

		return this.returnCode;
	}

	/**
	 * pausing the clock
	 * 
	 * @return returnCode
	 */
	public int pauseTime() {
		super.pauseTimeStart = System.currentTimeMillis();

		if (super.startTime > super.pauseTimeStart) {
			super.returnCode = 118;
			stopTime();
		}

		return this.returnCode;
	}

	/**
	 * resuming the clock
	 * 
	 * @return returnCode
	 */
	public int resumeTime() {
		long pauseTime;

		super.pauseTimeEnd = System.currentTimeMillis();

		pauseTime = super.pauseTimeEnd - super.pauseTimeStart;

		if (pauseTime >= 0) {
			// Calculating the new time passed in pause
			super.pausedTime += pauseTime;

		} else {
			super.returnCode = 118;
			stopTime();
		}

		return this.returnCode;
	}

	/**
	 * Stop the clock
	 * 
	 * @return returnCode
	 */
	public int stopTime() {
		long passedTimeWiyhoutPause;

		super.endTime = System.currentTimeMillis();
		passedTimeWiyhoutPause = super.endTime - super.startTime;

		if (passedTimeWiyhoutPause >= 0) {
			if (super.pausedTime > passedTimeWiyhoutPause) {
				super.returnCode = 118;

			} else {
				// Calculation of the time passed without pauses
				super.passedTime = passedTimeWiyhoutPause - super.pausedTime;

			}

		} else {
			super.returnCode = 118;
		}

		return this.returnCode;
	}

}// END PRG
