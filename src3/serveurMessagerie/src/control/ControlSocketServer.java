package control;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.logging.log4j.Logger;

import model.ModelServerSocket;

public class ControlSocketServer implements Repertory {
	private static ControlSocketServer instanceContolServerSocket = null;
	private InetAddress url;
	private ModelServerSocket modelServerSocket;
	private Logger log;
	private int returnCode;

	private ControlSocketServer(Logger logger) {
		setReturnCode(100);
		setLogger(logger);
	}

	// Getters & Setters :
	private void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public Logger getLogger() {
		return log;
	}

	private void setLogger(Logger logger) {
		this.log = logger;
	}

	/**
	 * 
	 * @param logger
	 * @return new ContolServerSocket or null
	 */
	public static ControlSocketServer getInstanceContolServerSocket(Logger logger) {
		if (instanceContolServerSocket == null) {
			instanceContolServerSocket = new ControlSocketServer(logger);
		}

		return instanceContolServerSocket;
	}

	/**
	 * Opening the server
	 * 
	 * @param logger
	 * 
	 * @return returnCode
	 */
	public int openServer() {
		log.trace(ControlSocketServer.class);

		try {

			this.url = InetAddress.getLocalHost();
			this.modelServerSocket = ModelServerSocket.getInstanceModelServerSocket(port, this.url, path, log, timeout);

			if (this.url.toString().isBlank() == false) {
				this.returnCode = this.modelServerSocket.start();

			} else {
				this.returnCode = 31;
			}

		} catch (UnknownHostException e) {
			this.returnCode = 35;
		} catch (Exception e) {
			this.returnCode = 36;
		}

		return this.returnCode;
	}// -

}// END PRG
