package fr.diginamic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.entities.Client;
import fr.diginamic.entities.Emprunt;
import fr.diginamic.entities.Livre;

public class TestJpa {
	
	private static EntityManager em;

	public static void main(String[] args) {
		/** On cree l'entity manager */
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		em = entityManagerFactory.createEntityManager();
		
		/** On récupère le livre d'ID 1 */
		Livre livre= em.find(Livre.class, 1);
		System.out.println(livre+"\n");
		
		/** Récupère le livre de titre "Germinal" */
		Livre livre2 = findLivre("Germinal");
		System.out.println(livre2+"\n");
		
		/** On récupère le client d'ID 1 */
		Client client= em.find(Client.class, 1);
		System.out.println(client+"\n");
		
		/** On récupère l'emprunt d'ID 1 et ses livres associés */
		Emprunt emprunt= em.find(Emprunt.class, 1);
		System.out.println(emprunt+"\n");
		
		/** Liste d'emprunt du client Cheng YU */
		List<Emprunt> listeEmprunts= findEmpruntByClient("YU","Cheng");
		for(Emprunt emp : listeEmprunts){
			System.out.println(emp);
		}
		
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
	
	/**
	 * Permet de récupèrer une liste d'emprunts "managed" en fonction du nom et du prénom du client
	 * @param nom prenom
	 * @return
	 */
	public static List<Emprunt> findEmpruntByClient(String nom, String prenom){
		TypedQuery<Client> query = em.createQuery("select c from Client c where c.nom='"+nom+"' and  c.prenom='"+prenom+"'", Client.class);
		if(query.getResultList().isEmpty()){
			return new ArrayList<Emprunt>();
		}
		Client client= query.getResultList().get(0);
		return client.getListeEmprunts();
	}

}
