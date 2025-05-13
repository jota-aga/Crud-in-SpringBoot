package com.gestaoAlunosapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoAlunosapi.demo.entity.Boletim;

public interface BoletimRepository extends JpaRepository<Boletim, Integer> {

}
