package fr.ynovBank.javaBankDiallo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ynovBank.javaBankDiallo.model.Client;
import fr.ynovBank.javaBankDiallo.model.Compte;
import fr.ynovBank.javaBankDiallo.model.Transaction;

public class TestJPA {

	//private static final 
	private static String PERSISTENCE_UNIT_NAME = "javaBankDiallo";
	private static EntityManagerFactory factory;
	private static Logger logger = LogManager.getLogger(TestJPA.class);

	public static void main(String[] args) {
		EntityManager em = null;
		try {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			em = factory.createEntityManager();
			
			em.getTransaction().begin();
			Client client = new Client();
			client.setLogin("cTest");
			client.setPasswd("1234");
			client.setNom("Test");
			client.setPrenom("Charles");
			Client client2 = new Client();
			client2.setLogin("login");
			client2.setPasswd("pass");
			client2.setNom("Terrom");
			client2.setPrenom("Killian");
			Compte compte = new Compte();
			compte.setLibelle("Compte courant");
			compte.setClient(client);
			Compte compte2 = new Compte();
			compte2.setLibelle("Compte cheque");
			compte2.setClient(client);
			
			List<Compte> listeComptes = new ArrayList<Compte>();
			listeComptes.add(compte);
			listeComptes.add(compte2);
			client.setComptes(listeComptes);
			client2.setComptes(listeComptes);
			Transaction transaction = new Transaction();
			transaction.setCompte(compte);
			transaction.setLibelle("Salaire");
			transaction.setDate(new Date());
			transaction.setMontant(10000);
			Transaction transaction2 = new Transaction();
			transaction2.setCompte(compte2);
			transaction2.setLibelle("APL");
			transaction2.setDate(new Date());
			transaction2.setMontant(100);
			compte.setTransactions(new ArrayList<Transaction>());
			compte2.setTransactions(new ArrayList<Transaction>());
			compte.getTransactions().add(transaction);
			compte.getTransactions().add(transaction2);
			compte2.getTransactions().add(transaction2);
			
			em.persist(client);
			em.persist(client2);
			em.getTransaction().commit();
			
			TypedQuery<Client> tQuery = em.createQuery("from Client", Client.class);
			List<Client> listeClients = tQuery.getResultList();
			TypedQuery<Compte> tQueryC = em.createQuery("from Compte", Compte.class);
			List<Compte> listeCompte = tQueryC.getResultList();
			TypedQuery<Transaction> tQueryT = em.createQuery("from Transaction", Transaction.class);
			List<Transaction> listeTransaction = tQueryT.getResultList();
	
			PersistenceUtil util = Persistence.getPersistenceUtil();
			for (Client c : listeClients)
			{
				logger.info(c.toString());
				logger.debug("is client loaded ? "+util.isLoaded(c));
				logger.debug("is client loaded ? "+util.isLoaded(c.getClientID()));
				Compte co = c.getComptes().get(0);
				logger.debug("are translations loaded ? "+util.isLoaded(co, "transactions"));
				co.getTransactions();
				logger.debug("are translations loaded now ? "+util.isLoaded(co, "transactions"));
				for(Transaction tran : co.getTransactions()) {
					logger.info(tran.toString());
				}
			}
			logger.info("Size: "+ listeClients.size());		
			
		} finally {
			em.close();
			factory.close();
		}
		
	}
}
