package com.springreact.demo.service;

import java.util.List;

import com.springreact.demo.model.Estudante;

public interface EstudanteService {
	
	Estudante incluir(Estudante estudante);
	
	List<Estudante> listar();
	
	Estudante editar(Estudante estudante, Long estudanteId);
	
	Estudante getEstudanteById(Long id);
	
	void excluirEstudanteById(Long id);

}
