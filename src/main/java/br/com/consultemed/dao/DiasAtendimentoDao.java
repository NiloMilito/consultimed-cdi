package br.com.consultemed.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.consultemed.model.DiasAtendimento;
import br.com.consultemed.utils.JPAUtils;

public class DiasAtendimentoDao implements IDiasAtendimentoDao{
	
	private EntityManagerFactory factory = JPAUtils.getEntityManagerFactory();
	private EntityManager manager = factory.createEntityManager();


	@Override
	public void save(DiasAtendimento diasAtendimento) throws Exception {
		this.manager.getTransaction().begin();
		this.manager.persist(diasAtendimento);
		this.manager.getTransaction().commit();
		this.manager.close();	
	}

	@Override
	public DiasAtendimento findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DiasAtendimento diasAtendimento) throws Exception {
		this.manager.getTransaction().begin();
		this.manager.merge(diasAtendimento);
		this.manager.getTransaction().commit();
		this.manager.close();
	}

	@Override
	public Collection<DiasAtendimento> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
