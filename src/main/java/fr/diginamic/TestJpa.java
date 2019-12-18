package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.entities.Livre;

public class TestJpa {
	
	private static EntityManager em;

	public static void main(String[] args) {
		/** On cree l'entity manager */
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		em = entityManagerFactory.createEntityManager();
		
		/** On récupère le livre d'ID 1 */
		Livre livre= em.find(Livre.class, 1);
		System.out.println(livre);
		
		/** Récupère le livre de titre "Germinal" */
		Livre livre2 = findLivre("Germinal");
		System.out.println(livre2);
		
		em.close();

	}
	
	/**
	 * Permet de récupèrer un livre "managed" en fonction de son titre
	 * @param titre
	 * @return
	 */
	public static Livre findLivre(String titre){
		TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.titre='"+titre+"'", Livre.class);
		Livre livre= query.getResultList().get(0);
		return livre;
	}

}
