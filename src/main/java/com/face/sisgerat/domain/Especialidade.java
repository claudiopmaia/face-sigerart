package com.face.sisgerat.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Especialidades", indexes = {@Index(name = "idx_Especialidade_titulo", columnList = "titulo")})
public class Especialidade extends AbstractEntity {
	
	@Column(name = "titulo", unique = true, nullable = false)
	private String titulo;
	
	@Column(name = "descricao", columnDefinition = "TEXT")
	private String descricao;
	
	@ManyToMany
	@JoinTable(
			name = "Medicos_tem_Especialidades",
			joinColumns = @JoinColumn(name = "id_Especialidade", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "id_Medico", referencedColumnName = "id")
    )
	private List<Medico> Medicos;	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Medico> getMedicos() {
		return Medicos;
	}

	public void setMedico(List<Medico> Medicos) {
		this.Medicos = Medicos;
	}
}
