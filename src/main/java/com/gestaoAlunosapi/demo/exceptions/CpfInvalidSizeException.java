package com.gestaoAlunosapi.demo.exceptions;

public class CpfInvalidSizeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CpfInvalidSizeException() {
		super("The length of CPF is invalid!");
	}

}
