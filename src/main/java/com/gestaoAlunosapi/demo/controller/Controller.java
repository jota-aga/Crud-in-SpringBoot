package com.gestaoAlunosapi.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestaoAlunosapi.demo.entity.Student;
import com.gestaoAlunosapi.demo.exceptions.CpfIsEmptyException;
import com.gestaoAlunosapi.demo.exceptions.CpfNotFoundException;
import com.gestaoAlunosapi.demo.exceptions.IdNotFoundException;
import com.gestaoAlunosapi.demo.exceptions.InvalidGradeException;
import com.gestaoAlunosapi.demo.exceptions.NameIsEmptyException;
import com.gestaoAlunosapi.demo.exceptions.TestNotFoundException;
import com.gestaoAlunosapi.demo.repository.StudentRepository;

@RestController
public class Controller {
	@Autowired
	StudentRepository repo;
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> students;
		
		students = repo.findAll();
		
		return students;
	}
	
	
	@GetMapping("/students/cpf")
	public Student findByCpf(@RequestParam String cpf) {
		Student student = repo.findByCpf(cpf);
		if(student == null) {
			throw new CpfNotFoundException();
		}else {
			return student;
		}
	}
	
	@PostMapping("/students/add")
	public void createStudent(@RequestBody Student student) {
		if(student.getName().isEmpty()) {
			throw new NameIsEmptyException();
		}
		else if(student.getCpf().isEmpty()) {
			throw new CpfIsEmptyException();
		}
		student.calcularMedia();
		repo.save(student);
	}
	
	@PutMapping("/students/tests/{id}")
	public void changeTestValue(@PathVariable int id, @RequestParam int test, @RequestParam double nota) {
		Optional<Student> student = repo.findById(id);
		
		if(student.isEmpty()) {
			throw new IdNotFoundException();
		}
		
		Student s = student.get();
		
		
		if(nota>10 || nota<0) {
			throw new InvalidGradeException();
		}
		
		if(test == 1) {
			s.setFirstTest(nota);
			s.calcularMedia();
		}else if(test == 2) {
			s.setSecondTest(nota);
			s.calcularMedia();
		}else {
			throw new TestNotFoundException();
		}
		
		repo.save(s);
	}
	
	@DeleteMapping("/students/delete/{id}")
	public void deleteStudent(@PathVariable int id) {
		Optional<Student> student = repo.findById(id);
		if(student.isEmpty()) {
			throw new IdNotFoundException();
		}
		repo.deleteById(id);
	}
	
	@GetMapping("/students/{id}")
	public Optional<Student> findById(@PathVariable int id) {
		Optional<Student> student = repo.findById(id);
		if(student.isPresent()) {
			return student;
		}else {
			throw new IdNotFoundException();
		}
	}
}
