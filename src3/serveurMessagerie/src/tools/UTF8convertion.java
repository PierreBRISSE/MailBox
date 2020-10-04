package tools;

import java.io.UnsupportedEncodingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UTF8convertion {
	static final Logger logger = LogManager.getLogger("Suivi");
	private int returnCode;
	private String contentUTF8;

	public UTF8convertion() {
		setContentUTF8("");
		setReturnCode(100);
	}

	public UTF8convertion(String content) {
		super();
		setContentUTF8(convert(content));
		setReturnCode(0);
	}

	// Getters & Setters :
	public int getReturnCode() {
		return returnCode;
	}

	private void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public String getContentUTF8() {
		return contentUTF8;
	}

	public void setContentUTF8(String content) {
		this.contentUTF8 = convert(content);
	}

	/**
	 * 
	 * @param content
	 * @return contentUTF8
	 */
	private String convert(String content) {
		byte[] binary;

		if (content.isEmpty()) {
			contentUTF8 = "";

		} else {

			binary = content.getBytes();
			try {
				this.contentUTF8 = new String(binary, "UTF-8");

			} catch (UnsupportedEncodingException e) {
				setReturnCode(50);
			} catch (Exception e) {
				setReturnCode(51);
			}

		}

		return this.contentUTF8;
	}

} // END PRG
