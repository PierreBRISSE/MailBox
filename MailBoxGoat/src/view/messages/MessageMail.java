package view.messages;

import org.apache.logging.log4j.Logger;

public class MessageMail {
	protected Logger logger;
	private static final String normalEnd = "The programm terminated normaly.";
	protected int code;

	public MessageMail(int code, Logger logger) {
		setCode(code);
		setLogger(logger);
	}

	public MessageMail(Logger logger) {
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
