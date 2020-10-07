package model;

import java.net.InetAddress;
import java.net.Socket;

import org.apache.logging.log4j.Logger;

public abstract class AbstractModelSocketServer {
	protected InetAddress url;
	protected String in, out, path;
	protected Socket socket;
	protected int returnCode;
	protected int port, time;
	protected Logger logger;

	// Getters & Setters :
	public String getPath() {
		return path;
	}

	public Logger getLogger() {
		return logger;
	}

	protected void setLogger(Logger logger) {
		this.logger = logger;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Socket getSocket() {
		return socket;
	}

	public String getOut() {
		return out;
	}

	public String getIn() {
		return in;
	}

	public InetAddress getUrl() {
		return url;
	}

	protected void setUrl(InetAddress url) {
		this.url = url;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getReturnCode() {
		return returnCode;
	}

	protected void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public int getTime() {
		return time;
	}

	protected void setTime(int time) {
		this.time = time;
	}

}// END PRG
