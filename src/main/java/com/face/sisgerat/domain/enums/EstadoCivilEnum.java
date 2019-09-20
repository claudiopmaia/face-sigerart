package com.face.sisgerat.domain.enums;

public enum EstadoCivilEnum {
	SOLTEIRO(1, "SOLTEIRO"),
	CASADO(2, "CASADO"),
	DIVORCIADO(3, "DIVORCIADO"),
	VIUVO(4, "VIÚVO"),
	SEPARADO(5, "SEPARADO"),
	UNIAOESTAVEL(6, "UNIÃO ESTAVEL"),
	;
	
	private long cod;
	private String desc;

	private EstadoCivilEnum(long cod, String desc) {
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
