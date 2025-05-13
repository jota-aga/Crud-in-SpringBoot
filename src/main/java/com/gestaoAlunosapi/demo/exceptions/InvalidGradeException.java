package com.gestaoAlunosapi.demo.exceptions;

public class InvalidGradeException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidGradeException() {
		super("The grade is invalid!");
	}

}
