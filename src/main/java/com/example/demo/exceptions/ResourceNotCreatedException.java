package com.example.demo.exceptions;

public class ResourceNotCreatedException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ResourceNotCreatedException(){

	}
	public ResourceNotCreatedException(String msg){
		super(msg);

	}

}
