package com.face.sisgerat.domain.enums;

public enum SexoEnum {
	MASCULINO(1, "MASCULINO"), FEMININO(2, "FEMININO");
	
	private long cod;
	private String desc;

	private SexoEnum(long cod, String desc) {
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
