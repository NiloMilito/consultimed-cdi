package br.com.consultemed.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.consultemed.model.DiasAtendimento;
import br.com.consultemed.model.Medico;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
		EntityManager manager = emf.createEntityManager();
	
		Medico medico = new Medico();		
		DiasAtendimento dia = new  DiasAtendimento();
		
		manager.getTransaction().begin();
		manager.persist(medico);
		manager.persist(dia);
		manager.getTransaction().commit();
	}

}
