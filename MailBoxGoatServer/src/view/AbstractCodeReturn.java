package view;

import java.util.List;

import org.apache.logging.log4j.Logger;

import view.Message;
import view.MessageError;

public abstract class AbstractCodeReturn {
	protected Message message;
	protected MessageError messageError;
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

	protected Message getMessage() {
		return message;
	}

	protected void setMessage(Message message) {
		this.message = message;
	}

	protected MessageError getMessageError() {
		return messageError;
	}

	protected void setMessageError(MessageError messageError) {
		this.messageError = messageError;
	}

}// END PRG
