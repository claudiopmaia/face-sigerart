package com.face.sisgerat.domain.enums;

public enum SituacaoProfissionalEnum {
	ESTUDANTE(1, "ESTUDANTE"), 
	DESEMPREGADO(2, "DESEMPREGADO"), 
	APOSENTADO(3, "APOSENTADO"), 
	FREELANCER(4, "FREELANCER"), 
	EMPREGADO(5, "EMPREGADO"),
	AUTONOMO(6, "AUTÔNOMO");
	
	private long cod;
	private String desc;

	private SituacaoProfissionalEnum(long cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public long getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}
}
