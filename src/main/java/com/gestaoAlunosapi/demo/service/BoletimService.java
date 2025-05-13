package com.gestaoAlunosapi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaoAlunosapi.demo.entity.Boletim;
import com.gestaoAlunosapi.demo.exceptions.InvalidGradeException;
import com.gestaoAlunosapi.demo.exceptions.TestNotFoundException;
import com.gestaoAlunosapi.demo.repository.BoletimRepository;

@Service
public class BoletimService {
	@Autowired
	BoletimRepository repo;
	
	public void addBoletim(Boletim boletim) {
		repo.save(boletim);
	}
	
	public void deleteBoletim(Boletim boletim) {
		repo.delete(boletim);
	}
	
	public void changeGrade(Boletim boletim, int test, double grade) {
		if(grade>10 || grade<0) {
			throw new InvalidGradeException();
		}
		if(test == 1) {
			boletim.changeFirstTest(grade);
		}else if(test == 2) {
			boletim.changeSecondTest(grade);
		}else {
			throw new TestNotFoundException();
		}
		repo.save(boletim);
	}

}
