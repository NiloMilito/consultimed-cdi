package br.com.consultemed.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.consultemed.model.Consulta;
import br.com.consultemed.utils.JPAUtils;

public class ConsultaDao implements IConsultaDao{
	
	private EntityManagerFactory factory = JPAUtils.getEntityManagerFactory();
	private EntityManager manager = factory.createEntityManager();
	
	
	@Override
	public Consulta buscarPorId(Long id) {		
		return manager.find(Consulta.class, id);
	}

	@Override
	public Consulta buscarPorPeriodo(Date inicio, Date fim) {
		Query query = this.manager.createQuery("SELECT a FROM Consulta a Where a.dataConsulta BETWEEN :inicio AND :fim ");
		query.setParameter("inicio", inicio);
		query.setParameter("fim", fim);
		return (Consulta) query.getSingleResult();
	}

	@Override
	public void save(Consulta consulta) throws Exception {
		this.manager.getTransaction().begin();
		this.manager.persist(consulta);
		this.manager.getTransaction().commit();
		this.manager.close();
	}

	@Override
	public Consulta findById(Long id) throws Exception {
		return this.manager.find(Consulta.class, id);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		this.manager.getTransaction().begin();
		Consulta consulta = this.manager.find(Consulta.class, id);
		this.manager.remove(consulta);
		this.manager.getTransaction().commit();
		this.manager.close();	
	}

	@Override
	public void update(Consulta consulta) throws Exception {
		this.manager.getTransaction().begin();
		this.manager.merge(consulta);
		this.manager.getTransaction().commit();
		this.manager.close();
	}

	@Override
	public Collection<Consulta> listAll() throws Exception {
		this.manager = factory.createEntityManager();
		List<Consulta> consultas = new ArrayList<>();
		
		try {
			manager.getTransaction().begin();
			TypedQuery<Consulta> query = manager.createNamedQuery("Consulta.findAll",Consulta.class);
			consultas = query.getResultList();
			manager.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

		return consultas;
	}

}
