package com.face.sisgerat.repository.projection;

import com.face.sisgerat.domain.Especialidade;
import com.face.sisgerat.domain.Medico;
import com.face.sisgerat.domain.Paciente;

public interface HistoricoPaciente {

	Long getId();
	
	Paciente getPaciente();
	
	String getDataConsulta();
	
	Medico getMedico();
	
	Especialidade getEspecialidade();
}
