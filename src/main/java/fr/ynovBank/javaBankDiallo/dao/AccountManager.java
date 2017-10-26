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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import java.sql.Statement;

import fr.ynovBank.javaBankDiallo.model.Client;
import fr.ynovBank.javaBankDiallo.model.Compte;
import fr.ynovBank.javaBankDiallo.model.FactorySingleton;
import fr.ynovBank.javaBankDiallo.model.Transaction;
import fr.ynovBank.javaBankDiallo.servlet.AccountServlet;

public class AccountManager {
	
	private static Logger logger = LogManager.getLogger(AccountServlet.class);
	
	public static List<Compte> loadComptes() {
		EntityManager em = FactorySingleton.getInstance().createEntityManager();

		em.getTransaction().begin();
		
		TypedQuery<Compte> tQuery = em.createQuery("from Compte", Compte.class);
		List<Compte> listeComptes = tQuery.getResultList();

		em.close();
		
		return listeComptes;
	}
	
	public static List<Compte> loadComptesClient(int idClient) {
		EntityManager em = FactorySingleton.getInstance().createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Compte> tQuery = em.createQuery("from Compte where clientID = :idClient", Compte.class);
		tQuery.setParameter("idClient", idClient);
		List<Compte> listeComptes = tQuery.getResultList();

		em.close();

		return listeComptes;
	}
	
	
}
