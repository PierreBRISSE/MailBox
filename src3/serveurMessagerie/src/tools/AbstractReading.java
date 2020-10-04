package tools;

import java.io.File;
import java.io.InputStream;

public abstract class AbstractReading {
	protected String content;
	protected File file;
	protected UTF8convertion convertionUTF8;
	protected InputStream inputStream;
	protected int returnCode;

	// Getters & setters :
	public String getContent() {
		return content;
	}

	protected void setContent(String content) {
		this.convertionUTF8 = new UTF8convertion(content);
		this.content = this.convertionUTF8.getContentUTF8();
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

}// END PRG
