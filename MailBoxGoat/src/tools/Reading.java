package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reading extends AbstractReading {
	static final Logger logger = LogManager.getLogger();

	public Reading() {
		super();
		setReturnCode(100);
		setContent("");
	}

	public Reading(InputStream inputStream) {
		super();
		setReturnCode(100);
		setInputStream(inputStream);
		setContent("");
	}

	public Reading(File file) {
		super();
		setReturnCode(100);
		setFile(file);
		setContent("");
	}

	//***************
	// Read methods :
	
	/**
	 * read a file content
	 */
	public String readFile() {
		String content;

		content = "";

		if (this.file.exists()) {

			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.file));) {
				content = readBuffer(bufferedReader);
				bufferedReader.close();

			} catch (Exception e) {
				this.returnCode = 22;
			}

		} else {
			this.returnCode = 20;
		}

		return content;
	}// -

	/**
	 * Read the stream
	 */
	public String readStream() {
		String content;

		content = "";

		if (this.file.exists()) {

			try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.inputStream));) {
				content = readBuffer(bufferedReader);
				bufferedReader.close();

			} catch (Exception e) {
				this.returnCode = 22;
			}

		} else {
			this.returnCode = 20;
		}

		return content;
	}// -

	/**
	 * Read a stream
	 */
	public String readStream(InputStream inputStream) {
		this.inputStream = inputStream;

		return readStream();
	}// -

	/**
	 * 
	 * @param bufferedReader
	 * @throws IOException
	 */
	private String readBuffer(BufferedReader bufferedReader) throws IOException {
		String content, line;

		content = "";

		while ((line = bufferedReader.readLine()) != null) {
			content += line;
			content += "\n";
		}

		if (content.isBlank() == false) {

			this.convertionUTF8.setContentUTF8(content);
			this.content = this.convertionUTF8.getContentUTF8();
			this.returnCode = this.convertionUTF8.getReturnCode();

		} else {
			this.returnCode = 21;
		}
		
		bufferedReader.close();

		return content;
	}

}// END PRG
