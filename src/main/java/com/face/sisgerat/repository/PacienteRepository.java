	package com.face.sisgerat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.face.sisgerat.domain.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	@Query("select p from Paciente p where p.usuario.email like :email")
	Optional<Paciente> findByUsuarioEmail(String email);
}
