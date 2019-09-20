package com.face.sisgerat.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.face.sisgerat.domain.Agendamento;
import com.face.sisgerat.domain.Horario;
import com.face.sisgerat.repository.projection.HistoricoPaciente;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

	@Query("select h "
			+ "from Horario h "
			+ "where not exists("
				+ "select a.horario.id "
					+ "from Agendamento a "
					+ "where "
						+ "a.Medico.id = :id and "
						+ "a.dataConsulta = :data and "
						+ "a.horario.id = h.id "
			+ ") "
			+ "order by h.horaMinuto asc")
	List<Horario> findByMedicoIdAndDataNotHorarioAgendado(Long id, LocalDate data);

	@Query("select a.id as id,"
				+ "a.Paciente as Paciente,"
				+ "CONCAT(a.dataConsulta, ' ', a.horario.horaMinuto) as dataConsulta,"
				+ "a.Medico as Medico,"
				+ "a.Especialidade as Especialidade "
			+ "from Agendamento a "
			+ "where a.Paciente.usuario.email like :email")
	Page<HistoricoPaciente> findHistoricoByPacienteEmail(String email, Pageable pageable);

	@Query("select a.id as id,"
			+ "a.Paciente as Paciente,"
			+ "CONCAT(a.dataConsulta, ' ', a.horario.horaMinuto) as dataConsulta,"
			+ "a.Medico as Medico,"
			+ "a.Especialidade as Especialidade "
		+ "from Agendamento a "
		+ "where a.Medico.usuario.email like :email")	
	Page<HistoricoPaciente> findHistoricoByMedicoEmail(String email, Pageable pageable);

	@Query("select a from Agendamento a "
			+ "where "
			+ "	(a.id = :id AND a.Paciente.usuario.email like :email) "
			+ " OR "
			+ " (a.id = :id AND a.Medico.usuario.email like :email)")
	Optional<Agendamento> findByIdAndPacienteOrMedicoEmail(Long id, String email);

}
