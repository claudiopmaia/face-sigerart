package com.face.sisgerat.domain.enums;

public enum PerfilTipoEnum {
	ADMIN(1, "ADMIN"), MEDICO(2, "MEDICO"), PACIENTE(3, "PACIENTE");
	
	private long cod;
	private String desc;

	private PerfilTipoEnum(long cod, String desc) {
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
