package com.springreact.demo.model;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estudante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long estudanteId;
	
	private String primeiroNome;
	
	private String ultimoNome;
	
	@NaturalId(mutable = true)
	private String email;
	
	private String departamento;

}
