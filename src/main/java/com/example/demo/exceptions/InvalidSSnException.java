package com.example.demo.exceptions;

public class InvalidSSnException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidSSnException() {

	}
	public InvalidSSnException(String msg) {
		super(msg);

	}
}
