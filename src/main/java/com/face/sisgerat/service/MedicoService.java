package com.face.sisgerat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.face.sisgerat.domain.Medico;
import com.face.sisgerat.repository.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repository;
	
	@Transactional(readOnly = true)
	public Medico buscarPorUsuarioId(Long id) {
		
		return repository.findByUsuarioId(id).orElse(new Medico());
	}

	@Transactional(readOnly = false)
	public void salvar(Medico Medico) {
		
		repository.save(Medico);
	}

	@Transactional(readOnly = false)
	public void editar(Medico Medico) {
		Medico m2 = repository.findById(Medico.getId()).get();
		m2.setCrm(Medico.getCrm());
		m2.setDtInscricao(Medico.getDtInscricao());
		m2.setNome(Medico.getNome());
		if (!Medico.getEspecialidades().isEmpty()) {
			m2.getEspecialidades().addAll(Medico.getEspecialidades());
		}
	}

	@Transactional(readOnly = true)
	public Medico buscarPorEmail(String email) {
		
		return repository.findByUsuarioEmail(email).orElse(new Medico());
	}

	@Transactional(readOnly = false)
	public void excluirEspecialidadePorMedico(Long idMed, Long idEsp) {
		Medico Medico = repository.findById(idMed).get();
		Medico.getEspecialidades().removeIf(e -> e.getId().equals(idEsp));
	}

	@Transactional(readOnly = true)
	public List<Medico> buscarMedicosPorEspecialidade(String titulo) {
		
		return repository.findByMedicosPorEspecialidade(titulo);
	}

	@Transactional(readOnly = true)
	public boolean existeEspecialidadeAgendada(Long idMed, Long idEsp) {
		
		return repository.hasEspecialidadeAgendada(idMed, idEsp).isPresent();
	}
}
