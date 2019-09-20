package com.face.sisgerat.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.face.sisgerat.domain.enums.EstadoCivilEnum;
import com.face.sisgerat.domain.enums.SexoEnum;
import com.face.sisgerat.domain.enums.SituacaoProfissionalEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "Pacientes")
public class Paciente extends AbstractEntity {

	@Column(name = "nome", unique = true, nullable = false)
	private String nome;
	
	@Column(name = "cpf_paciente", unique = true, nullable = false)
	private String cpf;
	
	@Column(name = "rg_paciente", unique = true, nullable = false)
	private String rg;
	
	@NotNull(message = "{NotNull.endereco.cidade.uf}")
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private SexoEnum sexo;

	
	@NotNull(message = "{NotNull.estadoCivil}")
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private EstadoCivilEnum estadoCivil;

	@NotNull(message = "{NotNull.situacaoProfissional}")
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private SituacaoProfissionalEnum situacaoProfissional;

	
	@Column(name = "naturalidade_paciente")
	private String naturalidade;
	
	@Column(name = "nis_paciente")
	private String nis;

	@Column(name = "data_nascimento", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dtNascimento;
	
	
//	@Column(name = "ativo", nullable = false, columnDefinition = "TINYINT(1)")
//	private boolean ativo;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@JsonIgnore
	@OneToMany(mappedBy = "Paciente")
	private List<Agendamento> agendamentos;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public SexoEnum getSexo() {
		return sexo;
	}
	
	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Agendamento> getAgendamentos() {
		return agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EstadoCivilEnum getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public SituacaoProfissionalEnum getSituacaoProfissional() {
		return situacaoProfissional;
	}

	public void setSituacaoProfissional(SituacaoProfissionalEnum situacaoProfissional) {
		this.situacaoProfissional = situacaoProfissional;
	}
	
	
	

//	public boolean isAtivo() {
//		return ativo;
//	}
//
//	public void setAtivo(boolean ativo) {
//		this.ativo = ativo;
//	}	

}
