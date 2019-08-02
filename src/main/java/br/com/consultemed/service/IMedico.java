package br.com.consultemed.service;

import br.com.consultemed.model.Consulta;
import br.com.consultemed.model.Medico;


public interface IMedico extends IGeneric<Medico, Long>{
	
	public void cancelarConsulta(Consulta consulta);

}
