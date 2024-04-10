package com.springreact.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.demo.model.Estudante;
import com.springreact.demo.service.EstudanteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/estudantes")
@RequiredArgsConstructor
public class EstudanteController {
	
	@Autowired
	private final EstudanteService estudanteService;
	
	@GetMapping
	public ResponseEntity<List<Estudante>> listar(){
		return new ResponseEntity<>(estudanteService.listar(), HttpStatus.FOUND);
	}
	
	@PostMapping
	public Estudante incluir(@RequestBody Estudante estudante) {
		return estudanteService.incluir(estudante);
	}
	
	@PutMapping("/editar/{id}")
	public Estudante editar(@RequestBody Estudante estudante, @PathVariable Long id) {
		return estudanteService.editar(estudante, id);
	}
	
	@DeleteMapping("/excluir/{id}")
	public void excluir(@PathVariable Long id) {
		estudanteService.excluirEstudanteById(id);
	}
	
	@GetMapping("/estudante/{id}")
	public Estudante getEstudanteById(@PathVariable Long id) {
		return estudanteService.getEstudanteById(id);
	}
	

}
