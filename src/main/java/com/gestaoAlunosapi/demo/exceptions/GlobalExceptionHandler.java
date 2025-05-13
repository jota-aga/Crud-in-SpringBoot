package com.gestaoAlunosapi.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> handleIdNotFound(IdNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(CpfNotFoundException.class)
	public ResponseEntity<String> handleCpfNotFound(CpfNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(NameIsEmptyException.class)
	public ResponseEntity<String> handleNameIsEmpty(NameIsEmptyException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(CpfIsEmptyException.class)
	public ResponseEntity<String> handleCpfIsEmpty(CpfIsEmptyException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidGradeException.class)
	public ResponseEntity<String> handleInvalidGrade(InvalidGradeException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(CpfInvalidSizeException.class)
	public ResponseEntity<String> handleCpfInvalidSize(CpfInvalidSizeException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(TestNotFoundException.class)
	public ResponseEntity<String> handleTestNotFound(TestNotFoundException e){
		return ResponseEntity.status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE).body(e.getMessage());
	}
	
	
	
	
}
