package com.face.sisgerat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.face.sisgerat.domain.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

	@Query("select m from Medico m where m.usuario.id = :id")
	Optional<Medico> findByUsuarioId(Long id);

	@Query("select m from Medico m where m.usuario.email like :email")
	Optional<Medico> findByUsuarioEmail(String email);

	@Query("select distinct m from Medico m "
			+ "join m.Especialidades e "
			+ "where e.titulo like :titulo "
			+ "and m.usuario.ativo = true")
	List<Medico> findByMedicosPorEspecialidade(String titulo);

	@Query("select m.id "
			+ "from Medico m "
			+ "join m.Especialidades e "
			+ "join m.agendamentos a "
			+ "where "
			+ "a.Especialidade.id = :idEsp AND a.Medico.id = :idMed")
	Optional<Long> hasEspecialidadeAgendada(Long idMed, Long idEsp);
}
