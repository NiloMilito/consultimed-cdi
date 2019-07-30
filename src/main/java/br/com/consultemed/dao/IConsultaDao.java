package br.com.consultemed.dao;

import java.util.Date;

import br.com.consultemed.model.Consulta;

public interface IConsultaDao extends GenericDao<Consulta, Long> {
	
	public Consulta buscarPorId(Long id);
	
	public Consulta buscarPorPeriodo(Date inicio, Date fim);

}
