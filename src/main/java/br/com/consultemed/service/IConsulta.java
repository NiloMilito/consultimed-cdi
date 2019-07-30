package br.com.consultemed.service;

import br.com.consultemed.model.Consulta;

public interface IConsulta extends IGeneric<Consulta, Long>{
	
	public void cancelarConsulta(Consulta consulta);

}
