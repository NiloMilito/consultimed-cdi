package br.com.consultemed.service;

import br.com.consultemed.model.Agendamento;
import br.com.consultemed.model.Consulta;

public interface IAgendamento extends IGeneric<Agendamento, Long>{
	
	public void reagendamentoConsulta(Consulta consulta, Consulta nova);

}
