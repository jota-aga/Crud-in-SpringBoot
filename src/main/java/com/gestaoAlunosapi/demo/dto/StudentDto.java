package com.gestaoAlunosapi.demo.dto;

import com.gestaoAlunosapi.demo.entity.Student;

import jakarta.validation.constraints.NotBlank;


public class StudentDto {
	
	@NotBlank
	private String cpf;
	@NotBlank
	private String name;


	public StudentDto(@NotBlank String cpf, @NotBlank String name) {
		
		this.cpf = cpf;
		this.name = name;
	}
	
	public Student cast() {
		Student student = new Student(cpf, name);
		return student;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
