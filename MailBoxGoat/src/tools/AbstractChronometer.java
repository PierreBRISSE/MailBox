package tools;

public abstract class AbstractChronometer {
	protected int returnCode;
	protected long startTime, endTime, pausedTime;
	protected long passedTime, pauseTimeStart, pauseTimeEnd, resumeTime;

	// Getters & Setters :
	public long getPausedTime() {
		return pausedTime;
	}

	protected void setPausedTime(long pausedTime) {
		this.pausedTime = pausedTime;
	}

	public int getReturnCode() {
		return returnCode;
	}

	protected void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public long getStartTime() {
		return startTime;
	}

	protected void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	protected void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public long getPassedTime() {
		return passedTime;
	}

	protected void setPassedTime(long passedTime) {
		this.passedTime = passedTime;
	}

	public long getPauseTimeStart() {
		return pauseTimeStart;
	}

	protected void setPauseTimeStart(long pauseTimeStart) {
		this.pauseTimeStart = pauseTimeStart;
	}

	public long getPauseTimeEnd() {
		return pauseTimeEnd;
	}

	protected void setPauseTimeEnd(long pauseTimeEnd) {
		this.pauseTimeEnd = pauseTimeEnd;
	}

	public long getResumeTime() {
		return resumeTime;
	}

	protected void setResumeTime(long resumeTime) {
		this.resumeTime = resumeTime;
	}

}// END PRG
