package tools;

import java.io.File;

public abstract class AbstractWriting {
	protected UTF8conversion convertionUTF8;
	protected String content, adresse;
	protected File file;
	protected int returnCode;

	// Getters & setters :
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getReturnCode() {
		return returnCode;
	}

	protected void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		// UTF8 conversion
		convertionUTF8 = new UTF8conversion(content);
		this.content = convertionUTF8.getContentUTF8();
		this.returnCode = convertionUTF8.getReturnCode();
	}

}// END PRG
