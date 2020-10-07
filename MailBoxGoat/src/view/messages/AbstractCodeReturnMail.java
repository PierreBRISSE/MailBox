package view.messages;

import java.util.List;

import org.apache.logging.log4j.Logger;

public abstract class AbstractCodeReturnMail {
	protected MessageMail message;
	protected MessageErrorMail messageError;
	protected List<Integer> codes;
	protected Logger logger;
	protected boolean Unknown;;

	// Getters & setters :
	protected boolean isUnknown() {
		return Unknown;
	}

	protected void setUnknown(boolean unknown) {
		Unknown = unknown;
	}

	protected Logger getLogger() {
		return logger;
	}

	protected void setLogger(Logger logger) {
		this.logger = logger;
	}

	public List<Integer> getCodes() {
		return this.codes;
	}

	public void setCodes(List<Integer> code) {
		this.codes = code;
	}

	protected MessageMail getMessage() {
		return message;
	}

	protected void setMessage(MessageMail message) {
		this.message = message;
	}

	protected MessageErrorMail getMessageError() {
		return messageError;
	}

	protected void setMessageError(MessageErrorMail messageError) {
		this.messageError = messageError;
	}

}// END PRG
