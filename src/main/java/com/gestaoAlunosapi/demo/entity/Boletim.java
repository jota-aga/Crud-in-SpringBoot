package com.gestaoAlunosapi.demo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Boletim {	
	private double firstTest;
	private double secondTest;
	private double media;
	private String status;
	
	public Boletim() {
		this.firstTest = 0;
		this.secondTest = 0;
		this.media = 0;
	}

	public void calculateAverage() {
		this.media = (firstTest + secondTest) / 2;
		
		if(media>=7) {
			status = "Aprovado";
		}else {
			status = "Reprovado";
		}
	}
	
	public void changeFirstTest(double grade) {
		firstTest = grade;
		calculateAverage();
		
	}
	
	public void changeSecondTest(double grade) {
		secondTest = grade;
		calculateAverage();
		
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

	public void setMedia(double media) {
		this.media = media;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
