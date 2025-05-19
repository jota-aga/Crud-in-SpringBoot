package com.gestaoAlunosapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestaoAlunosapi.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	Student findByCpf(String cpf);
}
