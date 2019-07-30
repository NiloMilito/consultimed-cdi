package br.com.consultemed.dao;

import br.com.consultemed.model.Paciente;

public interface IPacienteDao extends GenericDao<Paciente, Long> {	

	public Paciente buscarPorNome(String nome);
	
	public Paciente buscarPorCpf(String cpf);
}
