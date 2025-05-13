package com.gestaoAlunosapi.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestaoAlunosapi.demo.dto.StudentDto;
import com.gestaoAlunosapi.demo.entity.Boletim;
import com.gestaoAlunosapi.demo.entity.Student;
import com.gestaoAlunosapi.demo.exceptions.CpfIsEmptyException;
import com.gestaoAlunosapi.demo.exceptions.CpfNotFoundException;
import com.gestaoAlunosapi.demo.exceptions.IdNotFoundException;
import com.gestaoAlunosapi.demo.exceptions.InvalidGradeException;
import com.gestaoAlunosapi.demo.exceptions.NameIsEmptyException;
import com.gestaoAlunosapi.demo.exceptions.TestNotFoundException;
import com.gestaoAlunosapi.demo.repository.StudentRepository;
import com.gestaoAlunosapi.demo.service.BoletimService;
import com.gestaoAlunosapi.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class Controller {
	@Autowired
	StudentService StudentService;
	
	@Autowired 
	BoletimService BoletimService;
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return StudentService.getAllStudents();
	}
	
	
	@GetMapping("/students/cpf")
	public Student findByCpf(@RequestParam String cpf) {
		return StudentService.findStudentByCpf(cpf);
	}
	
	@PostMapping("/students/add")
	public ResponseEntity<String> createStudent(@Valid @RequestBody StudentDto studentDto) {
		Student student = studentDto.cast();
		StudentService.addStudent(student);
		BoletimService.addBoletim(student.getBoletim());
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	@PutMapping("/students/tests/{id}")
	public ResponseEntity<String> changeTestValue(@PathVariable int id, @RequestParam int test, @RequestParam double grade) {
		Optional<Student> s = StudentService.findStudentById(id);
		Student student = s.get();
		Boletim boletim = student.getBoletim();
		BoletimService.changeGrade(boletim, test, grade);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
	}
	
	@DeleteMapping("/students/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id) {
		
		StudentService.deleteStudentById(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}
	
	@GetMapping("/students/{id}")
	public Optional<Student> findById(@PathVariable int id) {
		return StudentService.findStudentById(id);
	}
}
