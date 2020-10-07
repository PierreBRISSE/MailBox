package tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import org.apache.logging.log4j.Logger;

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

	public Writing(Logger logger, File file, String contentMail) {
		super();
		setReturnCode(100);
		setContent(contentMail);
		setAdresse(file.getAbsolutePath());
		setFile(file);
	}

	// *****************
	// Writing methods
	/**
	 * 
	 * @return returnCode
	 */
	public int writingFile() {

		if (super.file.exists() == true) {

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

	}

}// END PRG
