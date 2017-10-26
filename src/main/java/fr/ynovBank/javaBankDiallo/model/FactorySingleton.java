package fr.ynovBank.javaBankDiallo.model;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactorySingleton {
	
	private static String PERSISTENCE_UNIT_NAME = "javaBankterrom";
	private static EntityManagerFactory factorySingleton = null;

	private FactorySingleton() 
	{
		
	}
	
public static EntityManagerFactory getInstance()
{
	if (factorySingleton == null)
	{
		factorySingleton = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	return factorySingleton;
}
	
}
