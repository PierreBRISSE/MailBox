package view;

import org.apache.logging.log4j.Logger;

public class MessageError extends Message {
	private static final String abnormalEnd = "The programm terminated abnormaly !!!";

	public MessageError(int code, Logger logger) {
		super(code, logger);
		super.setCode(code);
		super.setLogger(logger);
	}

	public MessageError(Logger logger) {
		super(logger);
		super.setCode(100);
		super.setLogger(logger);
	}

	// ******************
	// PROBLEM MESSAGES
	// ------------------
	public void abnormalEnd() {
		super.logger.error(abnormalEnd);
	}

	// --------
	// SOCKET :
	public void problemOpenSocket() {
		super.logger.error(super.code + " - Problem with opening the socket !");
	}

	public void problemInputStreamSocket() {
		super.logger.error(super.code + " - Problem with the inputStream from the socket !");
	}

	public void problemClosingSocket() {
		super.logger.error(super.code + " - Problem with closing the socket !");
	}

	public void problemReadingFlux() {
		super.logger.error(super.code + " - Problem reading the flux of data !");
	}

	public void socketException() {
		super.logger.error(super.code + " - Socket exception !");
	}

	public void IOProblemWritingFlux() {
		super.logger.error(super.code + " - IO exception with the output flux !");
	}

	public void problemWritingFlux() {
		super.logger.error(super.code + " - Problem with the output flux !");
	}

	// ------
	// FILE :
	public void problemExistFileIn() {
		super.logger.error(super.code + " - The file In does not exist !");
	}

	public void contentEmpty() {
		super.logger.error(super.code + " - There is nothing to read !");
	}

	public void problemReadFileIn() {
		super.logger.error(super.code + " - Problem with the file In !");
	}

	public void nothingToWrite() {
		super.logger.error(super.code + " - There is nothing to write !");
	}

	public void problemCreateFileOut() {
		super.logger.error(super.code + " - It is not possible to create the file Out !");
	}

	public void problemWriting() {
		super.logger.error(super.code + " - Problem with writing in the file Out !");
	}

	// -----
	// URL :
	public void problemURL() {
		super.logger.error(super.code + " - Problem URL !");
	}

	public void blankURL() {
		super.logger.error(super.code + " - URL empty !");
	}

	public void unknowHost() {
		super.logger.error(super.code + " - Unknown host !");
	}

	public void problemHost() {
		super.logger.error(super.code + " - Problem with the host !");
	}

	// ----------
	// Encoding :
	public void unknownEncoding() {
		super.logger.error(super.code + " - The encoding system does not exist !");
	}

	public void problemEncoding() {
		super.logger.error(super.code + " - Problem with the encoding system !");
	}

	// ---------------------
	// Message preparation :
	public void problemWhenSplitingContent() {
		super.logger.error(super.code + " - Problem with spliting the content received !");
	}

	public void problemNumberOfSplitContent() {
		super.logger.error(super.code + " - Problem with the number of splits concerning the content received !");
	}

	public void NoSeparatorContent() {
		super.logger.error(super.code
				+ " - There is no separator to do the difference between the message, the object, and the addressee !");
	}

	// ---------
	// UNKNOWN :
	public void unknownCode() {
		super.logger.error(super.code + " - The code does not exist !");
	}

}// END PRG
