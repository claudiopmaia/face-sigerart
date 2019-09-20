package com.face.sisgerat.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Endereco")
public class Endereco extends AbstractEntity {
	
//	@Id
//	@SequenceGenerator(sequenceName = "SEQ_ENDERECO", name = "SEQ_ENDERECO", allocationSize = 1)
//	@GeneratedValue(generator="SEQ_ENDERECO", strategy = GenerationType.SEQUENCE)
//	@Column(name = "id_endereco", nullable = false)
//	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;
	
	@Column(name = "logradouro_endereco")
	private String logradouro;
	
	@Column(name = "bairro_endereco" )
	private String bairro;
	
	@Column(name = "numero_endereco")
	private String numero;
	
	@Column(name = "cep_endereco")
	private String cep;
	
	@Column(name = "contato_cel_endereco")
	private String celular;
	
	@Column(name = "contato_fixo_endereco")
	private String telefone;
	
	@Column(name = "ddd_endereco")
	private String ddd;
	
	@Column(name = "complemento_endereco")
	private String complemento;

	@Column(name="status_endereco",nullable = false,columnDefinition = "TINYINT(1) default 1")
	private boolean status;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
