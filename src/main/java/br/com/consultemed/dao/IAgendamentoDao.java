package br.com.consultemed.dao;

import java.util.Date;

import br.com.consultemed.model.Agendamento;

	public interface IAgendamentoDao {
		
	public void salvar(Agendamento agendamento);
	
	public void alterar(Agendamento agendamento);
	
	public void remover(Agendamento agendamento);
	
	public Agendamento buscarPorId(Long id);
	
	public Agendamento buscarPorPeriodo(Date inicio, Date fim);
}
