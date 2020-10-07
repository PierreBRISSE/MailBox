package mailBoxGoat;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import control.MailControl;
import tools.Chronometer;
import tools.DateCreation;
import tools.InstantCreation;
import view.interfaceFX.WelcomePage;
import view.messages.CodeReturnMail;

public class Main {
	private static Logger log = LogManager.getLogger();
	private static String[] argsSave;
	private static MailControl control;
	private static List<Integer> returnCodes;

	public static void main(String[] args) {
		Chronometer chronometer;
		DateCreation date;
		InstantCreation instant;
		CodeReturnMail codeManagement;
		WelcomePage welcomePage;

		// Initialization
		returnCodes = new ArrayList<Integer>();
		instant = new InstantCreation();
		date = new DateCreation();
		chronometer = new Chronometer();
		welcomePage = new WelcomePage();
		argsSave = args;

		// Time & date management
		returnCodes.add(chronometer.startTime());
		returnCodes.add(instant.getReturnCode());
		returnCodes.add(date.getReturnCode());

		log.info("*******************************************************");
		log.info("MailGoat opened " + date.getDDMMAAAAToday() + " at " + instant.getDayTime());

		welcomePage.launchwindows(argsSave);

		// Results of the time passed
		returnCodes.add(chronometer.stopTime());
		log.info("MailGoat was open durring " + chronometer.getPassedTime() + " ms");

		// Return codes management
		codeManagement = new CodeReturnMail(returnCodes, log);
		codeManagement.codesTranslation();
	}

	/**
	 * 
	 * @param adressee
	 * @param object
	 * @param message
	 */
	public static void writeMessage(String addressee, String object, String message) {
		control = MailControl.instance(log, addressee, object, message);
		control.writingMail();
		control.sendMail();
	}

}// END PROGRAM
