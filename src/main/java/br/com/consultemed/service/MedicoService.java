package br.com.consultemed.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.consultemed.dao.DiasAtendimentoDao;
import br.com.consultemed.dao.IMedicoDao;
import br.com.consultemed.dao.MedicoDao;
import br.com.consultemed.model.Consulta;
import br.com.consultemed.model.Medico;

public class MedicoService implements IMedico{
	@Inject
	private IMedicoDao medicoDao;
	@Inject
	private DiasAtendimentoDao diasDao;
	@Inject
	private ConsultaService cservice;
	@Inject
	private AgendamentoService aservice;
		

	public MedicoService() {
		this.medicoDao = new MedicoDao();
		this.diasDao = new DiasAtendimentoDao();
		this.cservice = new ConsultaService();
		this.aservice = new AgendamentoService();
	}

	@Override
	public Object buscar(Long id) {
		try {
			return this.medicoDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void cancelarConsulta(Consulta consulta) {
		this.cservice.cancelarConsulta(consulta);
		this.aservice.reagendamentoConsulta(consulta, consulta);
	}

	public Collection<Medico> listar() {
		try {
			return this.medicoDao.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void salvar(Object object) {
		Medico medico = (Medico) object;		
		try {
			this.diasDao.save(medico.getDiasAtendimento());
			this.medicoDao.save(medico);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void alterar(Object object) {
		Medico medico = (Medico) object;		
		try {
			this.diasDao.update(medico.getDiasAtendimento());
			this.medicoDao.update(medico);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void remover(Long id) {
		try {
			this.medicoDao.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
