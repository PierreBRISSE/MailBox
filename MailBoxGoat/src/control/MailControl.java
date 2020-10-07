package control;

import java.io.File;

import org.apache.logging.log4j.Logger;

import model.ModelSocketCreation;
import tools.Writing;

public class MailControl extends AbstractMailControl implements Repertory {
	private static MailControl instanceControl = null;

	private MailControl(Logger log, String addressee, String object, String message) {
		super();
		super.setReturnCode(100);
		super.setLog(log);
		super.setAdressee(addressee);
		super.setObject(object);
		super.setMessage(message);
		super.setContent(super.adressee + "###" + super.object + "###" + super.message);
		super.setFile(new File(pathDraft));
	}

	/**
	 * 
	 * @param log
	 * @param adressee
	 * @param object
	 * @param message
	 * @return instance Control
	 */
	public static MailControl instance(Logger log, String addressee, String object, String message) {
		if (instanceControl == null) {
			instanceControl = new MailControl(log, addressee, object, message);
		}

		return instanceControl;
	}

	/**
	 * Write the content of the mail in a file to save it temporally
	 * 
	 * @return returnCode
	 */
	public int writingMail() {
		Writing writing;

		super.log.trace("MailGoat -" + MailControl.class + " writing the mail into draft.");

		writing = new Writing(super.log, super.file, super.content);
		writing.writingFile();
		super.returnCode = writing.writingFile();

		return super.returnCode;
	}

	public int sendMail() {
		super.log.trace("MailGoat -" + MailControl.class + " send mail.");

		super.socketCreation = ModelSocketCreation.instanceSocketCreation(pathDraft, port, adress, super.content, log);
		super.returnCode = super.socketCreation.getReturnCode();

		if (super.returnCode > 99) {
			super.socketCreation.start();
			super.returnCode = super.socketCreation.getReturnCode();
		}
		
		return super.returnCode;
	}

}// END PRG
