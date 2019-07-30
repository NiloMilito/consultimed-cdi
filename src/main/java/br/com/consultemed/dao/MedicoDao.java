package br.com.consultemed.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import br.com.consultemed.model.Medico;
import br.com.consultemed.utils.JPAUtils;

public class MedicoDao implements IMedicoDao{
	
	private EntityManagerFactory factory = JPAUtils.getEntityManagerFactory();
	private EntityManager manager = null;

	@Override
	public void save(Medico medico) throws Exception {
		this.manager = factory.createEntityManager();
		this.manager.getTransaction().begin();
		this.manager.persist(medico);
		this.manager.getTransaction().commit();
		this.manager.close();		
	}

	@Override
	public Medico findById(Long id) throws Exception {	
		this.manager = factory.createEntityManager();
		return this.manager.find(Medico.class, id);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		this.manager = factory.createEntityManager();
		this.manager.getTransaction().begin();
		Medico medico = this.manager.find(Medico.class, id);
		this.manager.remove(medico);
		this.manager.getTransaction().commit();
		this.manager.close();	
	}

	@Override
	public void update(Medico medico) throws Exception {
		this.manager = factory.createEntityManager();
		this.manager.getTransaction().begin();
		this.manager.merge(medico);
		this.manager.getTransaction().commit();
		this.manager.close();
	}

	@Override
	public Collection<Medico> listAll() throws Exception {
		this.manager = factory.createEntityManager();
		List<Medico> medicos= new ArrayList<>();
		
		try {
			manager.getTransaction().begin();
			TypedQuery<Medico> query = manager.createNamedQuery("Medico.findAll", Medico.class);
			medicos = query.getResultList();
			manager.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

		return medicos;
	}

}
