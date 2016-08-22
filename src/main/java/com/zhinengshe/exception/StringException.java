package com.zhinengshe.exception;

public class StringException extends Exception {

	private static final long serialVersionUID = 5007273418567642718L;
	
	private String code;

	public StringException() {
		super();
	}

	public StringException(String message) {
		super(message);
	}

	public StringException(String code, String message) {
		super(message);
		this.code = code;
	}

	public StringException(Throwable cause) {
		super(cause);
	}

	public StringException(String message, Throwable cause) {
		super(message, cause);
	}

	public StringException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


}
