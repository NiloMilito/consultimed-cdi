package br.com.consultemed.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultemed.model.Agendamento;
import br.com.consultemed.utils.JPAUtils;

public class AgendamentoDao implements IAgendamentoDao{
	
	private EntityManagerFactory factory = JPAUtils.getEntityManagerFactory();
	private EntityManager manager = factory.createEntityManager();

	@Override
	public void salvar(Agendamento agendamento) {
		this.manager.getTransaction().begin();
		this.manager.persist(agendamento);
		this.manager.getTransaction().commit();
		this.manager.close();
	}

	@Override
	public void alterar(Agendamento agendamento) {
		this.manager.getTransaction().begin();
		this.manager.merge(agendamento);
		this.manager.getTransaction().commit();
		this.manager.close();	
	}

	@Override
	public void remover(Agendamento agendamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Agendamento buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agendamento buscarPorPeriodo(Date inicio, Date fim) {
		Query query = this.manager.createQuery("SELECT a FROM Agendamento a Where a.dataAgendamento BETWEEN :inicio AND :fim ");
		query.setParameter("inicio", inicio);
		query.setParameter("fim", fim);
		return (Agendamento) query.getSingleResult();
	}

}
