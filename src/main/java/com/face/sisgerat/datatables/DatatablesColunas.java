package com.face.sisgerat.datatables;

public class DatatablesColunas {

	public static final String[] EspecialidadeS = {"id", "titulo"};

	public static final String[] MedicoS = {"id", "nome", "crm", "dtInscricao", "Especialidades"};
	
	public static final String[] AGENDAMENTOS = {"id", "Paciente.nome", "dataConsulta", "Medico.nome", "Especialidade.titulo"};

	public static final String[] USUARIOS = {"id", "email", "ativo", "perfis"};	
}
