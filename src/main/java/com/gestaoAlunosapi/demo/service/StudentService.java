package com.gestaoAlunosapi.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestaoAlunosapi.demo.entity.Boletim;
import com.gestaoAlunosapi.demo.entity.Student;
import com.gestaoAlunosapi.demo.exceptions.CpfAlreadyExistsException;
import com.gestaoAlunosapi.demo.exceptions.CpfNotFoundException;
import com.gestaoAlunosapi.demo.exceptions.IdNotFoundException;
import com.gestaoAlunosapi.demo.exceptions.InvalidGradeException;
import com.gestaoAlunosapi.demo.exceptions.TestNotFoundException;
import com.gestaoAlunosapi.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository repo;
	
	public void addStudent(Student student) {
		
		Student studentRepeat = repo.findByCpf(student.getCpf());
		if(studentRepeat != null) {
			throw new CpfAlreadyExistsException();
		}
		repo.save(student);
	}
	
	public List<Student> getAllStudents(){
		List<Student> students = new ArrayList<>();
		
		students = repo.findAll();
		return students;
	}
	
	public Student findStudentByCpf(String cpf){
		Student student = repo.findByCpf(cpf);
		
		if(student == null) {
			throw new CpfNotFoundException();
		}
		
		return student;
	}
	
	public Optional<Student> findStudentById(int id) {
		Optional<Student> student = repo.findById(id);
		
		if(student.isEmpty()) {
			throw new IdNotFoundException();
		}
		
		return student;
		
	}
	
	public void changeGrade(double grade, int test, int id) {
		Optional<Student> studentOptional = findStudentById(id);
		Boletim boletim = studentOptional.get().getBoletim();
	
		if(test == 1) {
			boletim.changeFirstTest(grade);
		}
		else if(test == 2) {
			boletim.changeSecondTest(grade);
		}
		else {
			throw new TestNotFoundException();
		}
		
		if(grade >10 || grade < 0) {
			throw new InvalidGradeException();
		}
		
		Student student = studentOptional.get();
		repo.save(student);
	}
	
	public void deleteStudentById(int id) {
	
		repo.deleteById(id);
	}	
}
