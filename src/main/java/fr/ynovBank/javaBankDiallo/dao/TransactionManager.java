package fr.ynovBank.javaBankDiallo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

//import java.sql.Statement;

import fr.ynovBank.javaBankDiallo.model.Client;
import fr.ynovBank.javaBankDiallo.model.Compte;
import fr.ynovBank.javaBankDiallo.model.FactorySingleton;
import fr.ynovBank.javaBankDiallo.model.Transaction;

public class TransactionManager {


	public static List<Transaction> loadTransactions() {
		EntityManager em = FactorySingleton.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		
		TypedQuery<Transaction> tQuery = em.createQuery("from Transaction", Transaction.class);
		List<Transaction> listeTransactions = tQuery.getResultList();
		
		for (Transaction transac : listeTransactions)
		{
			System.out.println ("iooiuoiu"+transac);
		}

		em.close();
		return listeTransactions;
	}
	
	public static List<Transaction> loadTransactionByCompte(int numeroCompte) {
		EntityManager em = FactorySingleton.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		
		TypedQuery<Transaction> tQuery = em.createQuery("from Transaction where leCompte.numero = :numeroCompte", Transaction.class);
		tQuery.setParameter("numeroCompte", numeroCompte);
		List<Transaction> listeTransactions = tQuery.getResultList();
		em.close();
		return listeTransactions;
	}
	
	
	public static void creerTransactions(Compte compte, String libelle, int montant) {
		EntityManager em = FactorySingleton.getInstance().createEntityManager();
		
		em.getTransaction().begin();
		//valorisé a date du jour
		Date date = new Date();
		Transaction transaction = new Transaction();
		transaction.setCompte(compte);
		transaction.setDate(date);
		transaction.setLibelle(libelle);
		transaction.setMontant(montant);
		
		em.persist(transaction);
		em.getTransaction().commit();
	}

}
