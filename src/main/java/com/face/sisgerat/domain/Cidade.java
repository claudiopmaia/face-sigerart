package com.face.sisgerat.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.face.sisgerat.domain.enums.UfEnum;

@SuppressWarnings("serial")
@Entity
@Table(name = "Cidade")
public class Cidade extends AbstractEntity{
	
//	@Id
//	@GeneratedValue(generator="SEQ_CIDADE", strategy = GenerationType.SEQUENCE)
//	@SequenceGenerator(name = "SEQ_CIDADE", sequenceName = "SEQ_CIDADE", allocationSize = 1)
//	@Column(name = "id_cidade", nullable = false)
//	private Long id;
//	@ManyToOne
//	@JoinColumn(name="id_Medico")
	
	public Cidade(Long id) {
	super.setId(id);
	}
	
	public Cidade() {
		super();
	}

	@Column(name = "nome_cidade", nullable = false)
	private String nome;
	
	@Column(name="status_cidade",nullable = false, columnDefinition = "TINYINT(1) default 1")
	private boolean status;
	
	@NotNull(message = "{NotNull.uf}")
	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private UfEnum uf;

	public UfEnum getUf() {
		return uf;
	}

	public void setUf(UfEnum uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
