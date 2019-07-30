package br.com.consultemed.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultemed.model.Exame;
import br.com.consultemed.utils.JPAUtils;

public class ExameDao implements IExameDao {
	
	private EntityManagerFactory factory = JPAUtils.getEntityManagerFactory();
	private EntityManager manager = null;

	@Override
	public void save(Exame exame) {
		try {
			this.manager = factory.createEntityManager();
			this.manager.getTransaction().begin();
			this.manager.persist(exame);
			this.manager.getTransaction().commit();
			this.manager.close();			
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public Exame findById(Long id) {
		this.manager = factory.createEntityManager();
		return this.manager.find(Exame.class, id);
	}

	@Override
	public void deleteById(Long id) {
		try {
		this.manager = factory.createEntityManager();
		this.manager.getTransaction().begin();
		Exame exame = this.manager.find(Exame.class, id);
		this.manager.remove(exame);
		this.manager.getTransaction().commit();
		this.manager.close();	
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public void update(Exame exame) {
		try {
		this.manager = factory.createEntityManager();
		this.manager.getTransaction().begin();
		this.manager.merge(exame);
		this.manager.getTransaction().commit();
		this.manager.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Exame> listAll() throws Exception {
		this.manager = factory.createEntityManager();
		List<Exame> exames = new ArrayList<>();
		
		try {
			manager.getTransaction().begin();
			Query query = manager.createQuery("Select e From e");
			exames = query.getResultList();
			manager.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

		return exames;
	}

}
