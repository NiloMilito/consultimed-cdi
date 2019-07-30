package br.com.consultemed.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.consultemed.dao.ExameDao;
import br.com.consultemed.dao.IExameDao;
import br.com.consultemed.model.Exame;

public class ExameService implements IExameService {

	@Inject
	private IExameDao examedao;
	
	public ExameService() {
		this.examedao = new ExameDao();
	}

	@Override
	public Collection<Exame> listar() throws Exception {
		return this.examedao.listAll();
	}

	@Override
	public void salvar(Exame exame) throws Exception {
		this.examedao.save(exame);
	}

	@Override
	public void alterar(Exame exame) throws Exception {
		this.examedao.update(exame);
	}

	@Override
	public Exame buscar(Long id) throws Exception {
		return this.examedao.findById(id);
	}

	@Override
	public void remover(Long id) throws Exception {
		this.examedao.deleteById(id);
	}

	
}
