package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJpaBanque {
	
	private static EntityManager em;

	public static void main(String[] args) {
		/** On cree l'entity manager */
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_banque");
		em = entityManagerFactory.createEntityManager();
		
		
		
		em.close();
	}
}
