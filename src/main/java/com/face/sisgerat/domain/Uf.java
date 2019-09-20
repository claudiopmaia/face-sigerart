package com.face.sisgerat.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "UF")
public class Uf extends AbstractEntity {
	
//	@Id
//	@GeneratedValue(generator="SEQ_UF", strategy = GenerationType.SEQUENCE)
//	@SequenceGenerator(name = "SEQ_UF", sequenceName = "SEQ_UF", allocationSize = 1)
//	@Column(name = "id_uf", nullable = false)
//	private Long id;
	
	@Column(name="nome_uf", nullable = false)
	private String nome;
	
	@Column(name="sigla_uf", nullable = false)
	private String sigla;
	
	@Column(name="status_uf",nullable = false,columnDefinition = "TINYINT(1) default 0")
	private boolean status;
	
	

	public Uf(Long id) {
		super.setId(id);
	}
	public Uf() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
