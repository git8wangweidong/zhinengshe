package com.zhinengshe.exception;

/**
 * 参数异常
 * @author Administrator
 *
 */
public class ParameterException extends RuntimeException {

	
	private static final long serialVersionUID = -5268479341383996413L;
	
	public ParameterException() {
		super();
	}

	public ParameterException(String message) {
		super(message);
	}

	public ParameterException(Throwable cause) {
		super(cause);
	}

	public ParameterException(String message, Throwable cause) {
		super(message, cause);
	}

}
