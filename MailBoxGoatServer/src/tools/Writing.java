package tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class Writing extends AbstractWriting {

	public Writing(String content) {
		super();
		setReturnCode(100);
		setContent(content);
		setAdresse("");
		setFile(new File(super.adresse));
	}

	public Writing(String content, File file) {
		super();
		setReturnCode(100);
		setContent(content);
		setAdresse(file.getAbsolutePath());
		setFile(file);
	}

	public Writing(String content, String adresse) {
		super();
		setReturnCode(100);
		setContent(content);
		setAdresse(adresse);
		setFile(new File(super.adresse));
	}

	// *****************
	// Writing methods

	/**
	 * 
	 * @return returnCode
	 */
	public int writingFile() {
		if (super.file.exists()) {

			if (super.content.isBlank() == false) {
				writing();

			} else {
				super.returnCode = 25;
			}

		} else {
			try {
				super.file.createNewFile();
			} catch (Exception e) {
				super.returnCode = 26;
			}
		}

		return super.returnCode;
	}

	/**
	 * Separates the name from the content
	 * 
	 * @param path
	 */
	public int writingMail(String separatorSigne, String path) {
		String[] strs;
		int numberOfDivision;

		// Are there any separator ?
		if (super.content.contains(separatorSigne)) {
			strs = super.content.split(separatorSigne);

			if (strs == null) {
				super.returnCode = 60;

			} else {
				// Calculating the number of blocks
				numberOfDivision = 0;
				for (int i = 0; i < strs.length; i++) {
					numberOfDivision++;
				}

				// The mail is composed of 3 blocks, addressee, object, and message
				if (numberOfDivision == 3) {
					// All the verifications passed
					writingMailNext(strs, path);

				} else {
					super.returnCode = 61;
				}
			}

		} else {
			super.returnCode = 63;
		}

		return super.returnCode;
	}

	/**
	 * 
	 * @param strs
	 * @param path
	 */
	private void writingMailNext(String[] strs, String path) {
		String addresseePara, objectPara;

		addresseePara = "";
		objectPara = "";

		// Recovering the addressee
		if (strs[0].substring(0, 4).equalsIgnoreCase("null")) {
			addresseePara = strs[0];
			addresseePara = addresseePara.replace("null", "");
		} else {
			addresseePara = strs[0];
		}
		// Recovering the object
		objectPara = strs[1];

		// Core message
		super.content = strs[2];

		// Creating the file
		super.adresse = path + addresseePara + "-" + objectPara + ".txt"; // Title of the message saved
		super.file = new File(super.adresse);
		writing();
	}

	/**
	 * common method for writing
	 */
	private void writing() {
		BufferedWriter bufferedWriter;

		try (FileOutputStream fileOutStream = new FileOutputStream(super.file);) {
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutStream));
			bufferedWriter.write(super.content);
			bufferedWriter.flush();

			bufferedWriter.close();

		} catch (Exception e) {
			super.returnCode = 27;
		}

	}// -

}// END PRG
