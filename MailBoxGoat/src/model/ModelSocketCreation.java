package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import org.apache.logging.log4j.Logger;

public class ModelSocketCreation extends ModelAbstractSocketCreation {
	private static ModelSocketCreation instanceSocketCreation = null;

	private ModelSocketCreation(String path, int port, String adress, String content, Logger log) {
		super();
		setReturnCode(100);
		setLog(log);
		setPath(path);
		setAdress(adress);
		setPort(port);
		setContent(content);
	}

	/**
	 * 
	 * @param path
	 * @param port
	 * @param adress
	 * @param message
	 * @param logger
	 * @return SocketCreation or null
	 */
	public static ModelSocketCreation instanceSocketCreation(String path, int port, String adress, String content,
			Logger log) {
		if (instanceSocketCreation == null) {
			instanceSocketCreation = new ModelSocketCreation(path, port, adress, content, log);
		}

		return instanceSocketCreation;
	}

	/**
	 * 
	 * @return returnCode
	 */
	public int start() {

		try {
			super.log.trace("MailGoat -" + ModelSocketCreation.class + " starting the connection.");
			super.socket = new Socket(super.adress, super.port);

//			read();
			message();

			close();

		} catch (SocketException e) {
			super.returnCode = 15;
		} catch (Exception e) {
			super.returnCode = 11;
		}

		return super.returnCode;
	}

	private void close() {
		try {
			super.socket.close();

		} catch (IOException e) {
			super.returnCode = 13;
		}
	}// -

	private void read() {
		DataInputStream dataInputStream;
		String line;

		dataInputStream = null;
		line="";
		
		try {
			dataInputStream=new DataInputStream(super.socket.getInputStream());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Send a message
	 */
	private void message() {
		DataOutputStream dataOutputStream;

		dataOutputStream = null;

		try {
			super.log.trace("MailGoat -" + ModelSocketCreation.class + " writing the message");

			dataOutputStream = new DataOutputStream(super.socket.getOutputStream());
			System.out.println(super.content);// TODO
			dataOutputStream.writeUTF(super.content);

			dataOutputStream.close();

		} catch (IOException e) {
			super.returnCode = 17;
		} catch (Exception e) {
			super.returnCode = 18;
		}
	}

}// END PRG
