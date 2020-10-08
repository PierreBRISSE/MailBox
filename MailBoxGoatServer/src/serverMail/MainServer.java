package serverMail;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import control.ControlSocketServer;
import tools.Chronometer;
import tools.DateCreation;
import tools.InstantCreation;
import view.CodeReturn;

public class MainServer {
	private static Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		Chronometer chronometer;
		DateCreation date;
		InstantCreation instant;
		ControlSocketServer serveur;
		CodeReturn codeManagement;
		List<Integer> returnCodes;

		returnCodes = new ArrayList<Integer>();
		instant = new InstantCreation();
		date = new DateCreation();
		chronometer = new Chronometer();

		returnCodes.add(chronometer.startTime());
		returnCodes.add(instant.getReturnCode());
		returnCodes.add(date.getReturnCode());

		logger.info("*******************************************************");
		logger.info("Server is starting " + date.getDDMMAAAAToday() + " at " + instant.getDayTime());

		// The main stream of the program is launched
		serveur = ControlSocketServer.getInstanceContolServerSocket(logger);
		returnCodes.add(serveur.openServer());

		// Result of the time passed
		returnCodes.add(chronometer.stopTime());
		logger.info("The server runned durring " + chronometer.getPassedTime() + " ms");

		codeManagement = new CodeReturn(returnCodes, logger);
		codeManagement.codesTranslation();

	} // *

}// END PROGRAM
