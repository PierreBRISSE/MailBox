package model;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import org.apache.logging.log4j.Logger;

import tools.Writing;

public class ModelServerSocket extends AbstractModelSocketServer {
	private static ModelServerSocket instanceModelServerSocket = null;

	private ModelServerSocket(int port, InetAddress url, String path, Logger logger, int timeout) {
		super();
		super.setReturnCode(100);
		super.setPort(port);
		super.setUrl(url);
		super.setPath(path);
		super.setTime(timeout);
		super.setLogger(logger);
	}

	/**
	 * 
	 * @param port
	 * @param url
	 * @param path
	 * @param logger
	 * @param timeout
	 * @return
	 */
	public static ModelServerSocket getInstanceModelServerSocket(int p, InetAddress url, String path, Logger l, int t) {
		if (instanceModelServerSocket == null) {
			instanceModelServerSocket = new ModelServerSocket(p, url, path, l, t);
		}

		return instanceModelServerSocket;
	}

	/**
	 * Close the socket
	 * 
	 * @return returnCode
	 */
	private void close() {
		super.logger.trace("Sever - " + ModelServerSocket.class + " close");

		try {
			super.socket.close();

		} catch (Exception e) {
			super.returnCode = 13;
		}

	}

	/**
	 * Start the connection
	 * 
	 * @param logger
	 * 
	 * @return returnCode;
	 */
	public int start() {

		try (ServerSocket serverSocket = new ServerSocket(super.port);) {
			super.logger.trace("Sever - " + ModelServerSocket.class + " start at port : " + super.port);
			super.logger.trace(" for a duration of " + super.time / 1000 + " s");

			serverSocket.setSoTimeout(super.time);
			super.socket = serverSocket.accept();

			read(); // Entrance flux
			if (super.returnCode > 99) {
				super.logger.trace("Sever - Starting to save the mail in a file ");
				messageSave();
			}

			close();
			serverSocket.close();

		} catch (SocketTimeoutException e) {
			super.returnCode = 101;
		} catch (SocketException e) {
			super.returnCode = 15;
		} catch (Exception e) {
			super.returnCode = 11;
		}

		return super.returnCode;
	}

	/**
	 * Writing the content of the mail in a file
	 */
	private void messageSave() {
		Writing writer;

		writer = new Writing(super.in);
		super.returnCode = writer.writingMail("###", super.path);
	}

	/**
	 * Collect the stream
	 */
	private void read() {
		DataInputStream reading;

		try {
			super.logger.trace("Sever - " + ModelServerSocket.class + " reading a stream");

			reading = new DataInputStream(super.socket.getInputStream());

			while (reading.available() > 0) {
				super.in += reading.readUTF();
			}

			reading.close();

		} catch (IOException e) {
			super.returnCode = 12;
		} catch (Exception e) {
			super.returnCode = 14;
		}

	}// -

	/**
	 * Method to use if you want to find a port
	 */
	public void portAction() {
		ServerSocket serverSocketPort;

		for (int portTest = 1; portTest <= 65535; portTest++) {
			try {
				serverSocketPort = new ServerSocket(portTest);
			} catch (IOException e) {
				System.err.println("Le port " + portTest + " est déjà utilisé ! ");
			}
		}
	} // -

}// END PRG