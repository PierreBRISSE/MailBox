package control;

import java.io.File;

import org.apache.logging.log4j.Logger;

import model.ModelSocketCreation;

public abstract class AbstractMailControl {
	protected ModelSocketCreation socketCreation;
	protected String adressee, object, message, content;
	protected File file;
	protected Logger log;
	protected int returnCode;

	// Getters & Setters
	protected ModelSocketCreation getSocketCreation() {
		return socketCreation;
	}

	protected void setSocketCreation(ModelSocketCreation socketCreation) {
		this.socketCreation = socketCreation;
	}

	public Logger getLog() {
		return log;
	}

	protected void setLog(Logger log) {
		this.log = log;
	}

	public int getReturnCode() {
		return returnCode;
	}

	protected void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public String getAdressee() {
		return adressee;
	}

	public void setAdressee(String adressee) {
		this.adressee = adressee;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		System.out.println("**" + this.content);// TODO
	}

	protected File getFile() {
		return file;
	}

	protected void setFile(File file) {
		this.file = file;
	}

}// END PRG
