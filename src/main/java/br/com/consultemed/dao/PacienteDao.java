package br.com.consultemed.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.consultemed.model.Paciente;
import br.com.consultemed.utils.JPAUtils;

public class PacienteDao implements IPacienteDao{
	
	private EntityManagerFactory factory = JPAUtils.getEntityManagerFactory();
	private EntityManager manager = null;

	@Override
	public Paciente buscarPorNome(String nome) {
		this.manager = factory.createEntityManager();
		Query query = this.manager.createQuery("SELECT a FROM Paciente a Where a.nome LIKE :nome ");
		query.setParameter("nome", nome);	
		return (Paciente) query.getSingleResult();
	}

	@Override
	public Paciente buscarPorCpf(String cpf) {
		this.manager = factory.createEntityManager();
		Query query = this.manager.createQuery("SELECT a FROM Paciente a Where a.cpf LIKE :cpf ");
		query.setParameter("cpf", cpf);	
		return (Paciente) query.getSingleResult();
	}

	@Override
	public void save(Paciente paciente) throws Exception {
		this.manager = factory.createEntityManager();
		this.manager.getTransaction().begin();
		this.manager.persist(paciente);
		this.manager.getTransaction().commit();
		this.manager.close();
	}

	@Override
	public Paciente findById(Long id) throws Exception {
		this.manager = factory.createEntityManager();
		return this.manager.find(Paciente.class, id);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		this.manager = factory.createEntityManager();
		this.manager.getTransaction().begin();
		Paciente paciente = this.findById(id);
		this.manager.remove(paciente);
		this.manager.getTransaction().commit();
		this.manager.close();				
	}

	@Override
	public void update(Paciente paciente) throws Exception {
		this.manager = factory.createEntityManager();
		this.manager.getTransaction().begin();
		this.manager.merge(paciente);
		this.manager.getTransaction().commit();
		this.manager.close();
	}

	@Override
	public Collection<Paciente> listAll() throws Exception {
		this.manager = factory.createEntityManager();
		List<Paciente> pacientes = new ArrayList<>();
		
		try {
			manager.getTransaction().begin();
			TypedQuery<Paciente> query = manager.createNamedQuery("Paciente.findAll", Paciente.class);
			pacientes = query.getResultList();
			manager.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return pacientes;
	}	

}
