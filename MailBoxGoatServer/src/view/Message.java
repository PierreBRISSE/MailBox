package view;

import org.apache.logging.log4j.Logger;

public class Message {
	protected Logger logger;
	private static final String normalEnd = "The programm sever terminated normaly.";
	protected int code;

	public Message(int code, Logger logger) {
		setCode(code);
		setLogger(logger);
	}

	public Message(Logger logger) {
		setCode(100);
		setLogger(logger);
	}

	// Getters & Setters :
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Logger getLogger() {
		return logger;
	}

	protected void setLogger(Logger logger) {
		this.logger = logger;
	}

	// ************
	// MESSAGES :
	public void noProblem() {
		this.logger.info(normalEnd);
	}

	public void timeOutServer() {
		this.logger.info("The server closed due to a timeOut.");
	}

	// -------------
	// DATE & TIME :
	public void problemFormatDate() {
		this.logger.warn("Format problem when reading the date.");
	}

	public void problemCreationDate() {
		this.logger.error("Problem when creating the date.");
	}

	public void instantEmpty() {
		this.logger.error("Time zone is empty.");
	}

	public void timeZoneNotFound() {
		this.logger.error("Time of the day not found.");
	}

	public void ProblemTimeChronometer() {
		this.logger.error("Problem with the chronometer.");
	}

}// END PRG
