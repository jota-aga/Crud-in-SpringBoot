package com.gestaoAlunosapi.demo.exceptions;

public class CpfIsEmptyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CpfIsEmptyException() {
		super("The cpf is empty!");
	}

}
