package com.springreact.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springreact.demo.model.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long>{

	Optional<Estudante> findByEmail(String email);

}
