package com.springreact.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreact.demo.exception.EstudanteJaExisteException;
import com.springreact.demo.exception.EstudanteNaoEncontradoException;
import com.springreact.demo.model.Estudante;
import com.springreact.demo.repository.EstudanteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstudanteServiceImpl implements EstudanteService{
	
	@Autowired
	private final EstudanteRepository estudanteRepository;

	@Override
	public Estudante incluir(Estudante estudante) {
		
		if(estudanteJaExiste(estudante.getEmail())) {
			throw new EstudanteJaExisteException(estudante.getEmail() + " já existe!");
		}
		
		return estudanteRepository.save(estudante);
	}

	@Override
	public List<Estudante> listar() {
		return estudanteRepository.findAll();
	}

	@Override
	public Estudante editar(Estudante estudante, Long estudanteId) {
		
		return estudanteRepository.findById(estudanteId).map(e  -> {
			e.setPrimeiroNome(estudante.getPrimeiroNome());
			e.setUltimoNome(estudante.getUltimoNome());
			e.setEmail(estudante.getEmail());
			e.setDepartamento(estudante.getDepartamento());
			
			return estudanteRepository.save(e);
		}).orElseThrow(() -> new EstudanteNaoEncontradoException("Desculpe, esse estudante não foi encontrado"));
	}

	@Override
	public Estudante getEstudanteById(Long id) {
		return estudanteRepository.findById(id)
				.orElseThrow(() -> new EstudanteNaoEncontradoException("Desculpe, estudante com Id: "+ id + " não encontrado"));
	}

	@Override
	public void excluirEstudanteById(Long id) {
		if (!estudanteRepository.existsById(id)) {
			throw new EstudanteNaoEncontradoException("Desculpe, estudante com Id: "+ id + " não encontrado");
		}
		
		estudanteRepository.deleteById(id);
	}
	
	private boolean estudanteJaExiste(String email) {
		return estudanteRepository.findByEmail(email).isPresent();
	}

}
