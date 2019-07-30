package br.com.consultemed.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.consultemed.dao.IPacienteDao;
import br.com.consultemed.dao.PacienteDao;
import br.com.consultemed.model.Paciente;

public class PacienteService implements IPaciente{
	
	@Inject
	private IPacienteDao pacienteDao;
	
	
	public PacienteService() {
		this.pacienteDao =  new PacienteDao();
	}

	@Override
	public void salvar(Paciente object) throws Exception {
		this.pacienteDao.save(object);		
	}

	@Override
	public void alterar(Paciente object) throws Exception {		
		this.pacienteDao.update(object);
	}

	@Override
	public void remover(Long id) throws Exception {
		this.pacienteDao.deleteById(id);
	}

	@Override
	public Paciente buscar(Long id) throws Exception {
		return this.pacienteDao.findById(id);
	}

	@Override
	public Paciente buscarPorNome(String nome) {		
		return this.pacienteDao.buscarPorNome(nome);
	}

	@Override
	public Paciente buscarPorCpf(String cpf) {		
		return this.pacienteDao.buscarPorCpf(cpf);
	}

	@Override
	public Collection<Paciente> listar() throws Exception {
		return this.pacienteDao.listAll();
	}

}
