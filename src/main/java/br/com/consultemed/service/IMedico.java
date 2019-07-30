package br.com.consultemed.service;

import br.com.consultemed.model.Consulta;

@SuppressWarnings("rawtypes")
public interface IMedico extends IGeneric{
	
	public void cancelarConsulta(Consulta consulta);

}
