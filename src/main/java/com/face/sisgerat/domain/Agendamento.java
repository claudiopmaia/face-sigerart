package com.face.sisgerat.domain;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.*;
import java.time.LocalDate;

@SuppressWarnings("serial")
@Entity
@Table(name = "agendamentos") 
public class Agendamento extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name="id_Especialidade")
	private Especialidade Especialidade;
	
	@ManyToOne
	@JoinColumn(name="id_Medico")
	private Medico Medico;
	
	@ManyToOne
	@JoinColumn(name="id_Paciente")
	private Paciente Paciente;
	
	@ManyToOne
	@JoinColumn(name="id_horario")
	private Horario horario; 

	@Column(name="data_consulta")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataConsulta;
	
	public Especialidade getEspecialidade() {
		return Especialidade;
	}

	public void setEspecialidade(Especialidade Especialidade) {
		this.Especialidade = Especialidade;
	}

	public Medico getMedico() {
		return Medico;
	}

	public void setMedico(Medico Medico) {
		this.Medico = Medico;
	}

	public Paciente getPaciente() {
		return Paciente;
	}

	public void setPaciente(Paciente Paciente) {
		this.Paciente = Paciente;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}
}
