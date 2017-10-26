package fr.ynovBank.javaBankDiallo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import javax.persistence.TypedQuery;

//import java.sql.Statement;

import fr.ynovBank.javaBankDiallo.model.Client;
import fr.ynovBank.javaBankDiallo.model.Compte;
import fr.ynovBank.javaBankDiallo.model.FactorySingleton;
import fr.ynovBank.javaBankDiallo.model.Transaction;

public class ClientManager {

	
	public static List<Client> loadClients() {
		EntityManager em = FactorySingleton.getInstance().createEntityManager();
		
		//em.persist(client);
		em.getTransaction().begin();
		
		TypedQuery<Client> tQuery = em.createQuery("from Client", Client.class);
		List<Client> listeClients = tQuery.getResultList();
		
		for (Client c : listeClients)
		{
			System.out.println (c);
		}

		em.close();
	
		return listeClients;
	}
	
	public static Client connexionClient(String login, String pwd) {
		EntityManager em = FactorySingleton.getInstance().createEntityManager();
		
		//em.persist(client);
		em.getTransaction().begin();
		
		TypedQuery<Client> tQuery = em.createQuery("from Client", Client.class);
		List<Client> listeClients = tQuery.getResultList();
	
		for (Client c : listeClients)
		{
			if(login.equals(c.getLogin()) &&	pwd.equals(c.getPasswd()))
			{
				em.close();
				return c;
			}
		}

		em.close();
		return null;
	}
}
