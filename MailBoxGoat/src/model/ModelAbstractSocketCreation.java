package model;

import java.net.Socket;

import org.apache.logging.log4j.Logger;

public abstract class ModelAbstractSocketCreation {
	protected String path, adress, in, out, content;
	protected Socket socket;
	protected Logger log;
	protected int port;
	protected int returnCode;

	// Getters & Setters :
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	protected Socket getSocket() {
		return socket;
	}

	protected void setSocket(Socket socket) {
		this.socket = socket;
	}

	public Logger getLog() {
		return log;
	}

	protected void setLog(Logger log) {
		this.log = log;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getIn() {
		return in;
	}

	public void setIn(String in) {
		this.in = in;
	}

	public String getOut() {
		return out;
	}

	public void setOut(String out) {
		this.out = out;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReturnCode() {
		return returnCode;
	}

	protected void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

}// END PRG
