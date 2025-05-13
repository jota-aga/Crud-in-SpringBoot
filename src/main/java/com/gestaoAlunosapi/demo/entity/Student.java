package com.gestaoAlunosapi.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Boletim boletim;
	
	
	public Student(String cpf, String name) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.boletim = new Boletim();
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


	public Boletim getBoletim() {
		return boletim;
	}


	public void setBoletim(Boletim boletim) {
		this.boletim = boletim;
	}
	
	
	
}
