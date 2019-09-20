package com.face.sisgerat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.face.sisgerat.domain.Paciente;
import com.face.sisgerat.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repository;
	
	@Transactional(readOnly = true)
	public Paciente buscarPorUsuarioEmail(String email) {
		
		return repository.findByUsuarioEmail(email).orElse(new Paciente());
	}
	
	@Transactional(readOnly = true)
	public Paciente buscarPorPacienteEmailAndAtivo(String email) {
		
		return repository.findByPacienteEmailAndAtivo(email).orElse(new Paciente());
	}

	@Transactional(readOnly = false)
	public void salvar(Paciente Paciente) {
		
		repository.save(Paciente);		
	}

	@Transactional(readOnly = false)
	public void editar(Paciente Paciente) {
		Paciente p2 = repository.findById(Paciente.getId()).get();
		p2.setNome(Paciente.getNome());
		p2.setDtNascimento(Paciente.getDtNascimento());		
	}
}
