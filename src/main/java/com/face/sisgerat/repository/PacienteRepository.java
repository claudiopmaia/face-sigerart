	package com.face.sisgerat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.face.sisgerat.domain.Paciente;
import com.face.sisgerat.domain.Usuario;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	@Query("select p from Paciente p where p.usuario.email like :email")
	Optional<Paciente> findByUsuarioEmail(String email);
	
	
	
	@Query("select p from Paciente p where p.usuario.email like :email AND p.usuario.ativo = true")
	Optional<Paciente> findByPacienteEmailAndAtivo(String email);
}
