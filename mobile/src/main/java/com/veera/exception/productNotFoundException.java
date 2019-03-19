package com.veera.exception;

import java.io.Serializable;

public class productNotFoundException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String message;

	public productNotFoundException() {

		this("This product is not Availble");
	}

	public productNotFoundException(String message) {

		this.message = System.currentTimeMillis() + " : " + message;
	}

	public String getMessage() {
		return message;
	}

}
