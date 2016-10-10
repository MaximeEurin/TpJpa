package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.adaming.entities.Agent;


public class AgentDaoImpl implements IAgentDao{
	
	@Override
	public int isExistDao(String login, String mdp) {

	/**
	 * Créer une EMF
	 */
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("PU");
	
	/**
	 * Créer une EM
	 */
	
	EntityManager em=emf.createEntityManager();
	
	Query queryAgentIsExist=em.createNamedQuery("getAgent");
	
	queryAgentIsExist.setParameter(1, login);
	queryAgentIsExist.setParameter(2, mdp);
	
	@SuppressWarnings("unchecked")
	List<Agent> listeAgent= queryAgentIsExist.getResultList();
	System.out.println(listeAgent.size());
	return listeAgent.size();
	
	}
}