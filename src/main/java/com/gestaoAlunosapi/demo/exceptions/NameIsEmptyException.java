package com.gestaoAlunosapi.demo.exceptions;

public class NameIsEmptyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NameIsEmptyException() {
		super("The name is empty!");
	}

}
