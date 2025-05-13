package com.gestaoAlunosapi.demo.exceptions;

public class TestNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TestNotFoundException() {
		super("Test does exist!");
	}

}
