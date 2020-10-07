package view.messages;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.Logger;

public class CodeReturnMail extends AbstractCodeReturnMail {

	public CodeReturnMail(List<Integer> codes, Logger logger) {
		super();
		setCodes(codes);
		setLogger(logger);
		setUnknown(false);
		setMessage(new MessageMail(logger));
		setMessageError(new MessageErrorMail(logger));
	}

	/**
	 * @param logger
	 * 
	 */
	public void codesTranslation() {
		Iterator<Integer> it;
		boolean error;
		int code;

		error = false;
		it = this.codes.iterator();

		// Translation of the return codes into messages
		while (it.hasNext()) {
			code = it.next();

			if (code < 100) {
				// Error during the process detected
				messageError.setCode(code);
				error = true;
			} else {
				message.setCode(code);
			}

			codeTranslation(code);
		}

		if (error == true) {
			// The program terminated abnormally
			super.messageError.abnormalEnd();
		} else {
			// The program terminated normally
			normalTerminatedMessage();
		}

	}

	/**
	 * Code between 100 and 109 correspond to normal end if there is no error before
	 */
	private void normalTerminatedMessage() {
		int nb;
		boolean end;

		if (super.Unknown == false) { // An unknown code detected does not do a normal ending

			nb = 109;

			do {
				end = false;

				if (super.codes.contains(nb)) {
					end = true;
					super.message.noProblem();
				} else if (nb < 100) {
					end = true;
				} else {
					nb--;
				}

			} while (end == false);

		}

	}// -

	/**
	 * Translate the code
	 * 
	 * @param code
	 */
	private void codeTranslation(int code) {

		switch (code) {
		// **************
		// NORMAL CODES
		// -------------
		case 100:
			break;

		// **********
		// WARNINGS
		// ----------
		// DATE & TIME :
		case 110:
			message.problemFormatDate();
			break;

		case 111:
			message.problemCreationDate();
			break;

		case 115:
			message.instantEmpty();
			break;

		case 116:
			message.timeZoneNotFound();
			break;

		case 118:
			message.ProblemTimeChronometer();
			break;

		// ********
		// ERRORS
		// --------
		// SOCKET :
		case 11:
			messageError.problemOpenSocket();
			break;

		case 12:
			messageError.problemInputStreamSocket();
			break;

		case 13:
			messageError.problemClosingSocket();
			break;

		case 14:
			messageError.problemReadingFlux();
			break;

		case 15:
			messageError.socketException();
			break;
			
		case 17:
			messageError.IOProblemWritingFlux();
			break;

		case 18:
			messageError.problemWritingFlux();
			break;

		// FILE :
		case 20:
			messageError.problemExistFileIn();
			break;

		case 21:
			messageError.contentEmpty();
			break;

		case 22:
			messageError.problemReadFileIn();
			break;

		case 25:
			messageError.nothingToWrite();
			break;

		case 26:
			messageError.problemCreateFileOut();
			break;

		case 27:
			messageError.problemWriting();
			break;

		// URL :
		case 30:
			messageError.problemURL();
			break;

		case 31:
			messageError.blankURL();
			break;

		case 35:
			messageError.unknowHost();
			break;

		case 36:
			messageError.problemHost();
			break;

		// UTF8 :
		case 50:
			messageError.unknownEncoding();
			break;

		case 51:
			messageError.problemEncoding();
			break;

		// UNKNOWN CODE :
		default:
			super.Unknown = true;
			messageError.unknownCode();
		}

	}

}// END PRG
