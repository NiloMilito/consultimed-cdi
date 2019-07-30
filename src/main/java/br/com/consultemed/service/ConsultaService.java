package br.com.consultemed.service;

import java.util.Collection;
import java.util.Date;

import br.com.consultemed.dao.ConsultaDao;
import br.com.consultemed.dao.IConsultaDao;
import br.com.consultemed.model.Consulta;

public class ConsultaService implements IConsulta{
	
	private IConsultaDao consultaDao;
	
	public ConsultaService() {
		this.consultaDao = new ConsultaDao();
	}
	
	public Consulta buscarPorPeriodo(Date inicio, Date fim) {
		return this.consultaDao.buscarPorPeriodo(inicio, fim);
	}

	@Override
	public void cancelarConsulta(Consulta consulta) {
		try {
			this.remover(consulta.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void remover(Long id) throws Exception {
		this.consultaDao.deleteById(id);
	}

	@Override
	public Collection<Consulta> listar() throws Exception {
		return this.consultaDao.listAll();
	}

	@Override
	public void salvar(Consulta consulta) throws Exception {
		this.consultaDao.save(consulta);		
	}

	@Override
	public void alterar(Consulta consulta) throws Exception {
		this.consultaDao.update(consulta);		
	}

	@Override
	public Consulta buscar(Long id) throws Exception {
		return this.consultaDao.buscarPorId(id);
	}

	
}
