package com.gestaoAlunosapi.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String cpf;
	@Column
	private String name;
	@Column
	private double firstTest;
	@Column
	private double secondTest;
	@Column
	private double media;
	@Column
	private String status;
	
	
	public Student(String cpf, String name) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.firstTest = 0;
		this.secondTest = 0;
	}


	public Student() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public double getFirstTest() {
		return firstTest;
	}


	public void setFirstTest(double firstTest) {
		this.firstTest = firstTest;
	}


	public double getSecondTest() {
		return secondTest;
	}


	public void setSecondTest(double secondTest) {
		this.secondTest = secondTest;
	}


	public double getMedia() {
		return media;
	}


	public void setMedia(double media ) {
		this.media = media;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	public void calcularMedia() {
		this.media = (this.firstTest + this.secondTest) / 2;
		
		if(media>=7) {
			status = "Aprovado";
		}else {
			status = "Reprovado";
		}
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", cpf=" + cpf + ", name=" + name + ", firstTest=" + firstTest + ", secondTest="
				+ secondTest + ", media=" + media + ", status=" + status + "]";
	}
	
	
}
