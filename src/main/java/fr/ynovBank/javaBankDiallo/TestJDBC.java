package fr.ynovBank.javaBankDiallo;

import fr.ynovBank.javaBankDiallo.dao.TransactionManager;


public class TestJDBC {

	public static void main(String[] args) {
		TransactionManager.loadTransactionByCompte(1);
	}
}
