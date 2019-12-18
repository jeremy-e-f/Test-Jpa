package fr.diginamic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import banque.entities.Adresse;
import banque.entities.AssuranceVie;
import banque.entities.Banque;
import banque.entities.Client;
import banque.entities.Compte;
import banque.entities.LivretA;
import banque.entities.Operation;
import banque.entities.Virement;

public class TestJpaBanque {
	
	/** Logger */
	private static final Logger LOG = LoggerFactory.getLogger("");
	
	/** Entity Manager */
	private static EntityManager em;

	public static void main(String[] args) {
		long debut= System.currentTimeMillis();
		
		/** On cree l'entity manager */
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_banque");
		em = entityManagerFactory.createEntityManager();
		
		/** Création d'une banque */
		Banque banque= new Banque();
		banque.setNom("Banque");
		
		/** Adresse */
		Adresse adresseA= new Adresse();
		adresseA.setNumero(12);
		adresseA.setCodePostal(34010);
		adresseA.setRue("Triller");
		adresseA.setVille("Montpellier");
		
		Adresse adresseB= new Adresse();
		adresseB.setNumero(1);
		adresseB.setCodePostal(84135);
		adresseB.setRue("Banior");
		adresseB.setVille("Toulouse");
		
		/** Création de clients */
		Client clientA= new Client();
		clientA.setNom("PERAUT");
		clientA.setPrenom("Maurice");
		clientA.setDateNaissance(LocalDate.of(1965, 12, 1));
		clientA.setAdresse(adresseA);
		clientA.setBanque(banque);
		
		Client clientB= new Client();
		clientB.setNom("PERAUT");
		clientB.setPrenom("Chantal");
		clientB.setDateNaissance(LocalDate.of(1970, 4, 25));
		clientB.setAdresse(adresseA);
		clientB.setBanque(banque);
		
		Client clientC= new Client();
		clientC.setNom("PERRIER");
		clientC.setPrenom("Didier");
		clientC.setDateNaissance(LocalDate.of(1985, 7, 4));
		clientC.setAdresse(adresseB);
		clientC.setBanque(banque);
		
		/** Création d'un compte */
		List<Client> proprioComptA= new ArrayList<Client>();
		proprioComptA.add(clientA);
		proprioComptA.add(clientB);
		
		Compte cpteA= new Compte();
		cpteA.setNumero("FGG594E6E1458");
		cpteA.setSolde(4586.2);
		cpteA.setProprietaires(proprioComptA);
		
		List<Client> proprioComptB= new ArrayList<Client>();
		proprioComptB.add(clientC);
		
		AssuranceVie cpteB= new AssuranceVie();
		cpteB.setNumero("14GF4GBFG8G000");
		cpteB.setSolde(10586.2);
		cpteB.setProprietaires(proprioComptB);
		cpteB.setTaux(1.5);
		cpteB.setDateFin(LocalDate.parse("2030-12-31"));
		
		LivretA cpteC= new LivretA();
		cpteC.setNumero("R3509C4BYGC4000");
		cpteC.setSolde(2586.85);
		cpteC.setProprietaires(proprioComptB);
		cpteC.setTaux(0.5);
		
		/** Création des opérations */
		List<Virement> listeVirements= new ArrayList<Virement>();
		listeVirements.add(new Virement(LocalDate.parse("2019-12-01"), 100, "Remboursement", cpteA, "Collègue"));
		listeVirements.add(new Virement(LocalDate.parse("2019-12-11"), 10, "Don", cpteA, "Don association"));
		listeVirements.add(new Virement(LocalDate.parse("2019-12-10"), 55.5, "Depot", cpteC, ""));
		
		List<Operation> listeOperations= new ArrayList<Operation>();
		listeOperations.add(new Operation(LocalDate.parse("2019-10-20"), 39.8, "Super U", cpteA));
		listeOperations.add(new Operation(LocalDate.parse("2019-12-14"), 14.5, "MarchéBONI", cpteA));
		
		/** Enregistrement des données */
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try{
			em.persist(banque);
			em.persist(clientA);
			em.persist(clientB);
			System.out.println(clientB.getId());
			em.persist(clientC);
			em.persist(cpteA);
			em.persist(cpteB);
			em.persist(cpteC);
			
			for(Operation op: listeOperations){
				em.persist(op);
			}
			for(Virement vir: listeVirements){
				em.persist(vir);
			}
			
			et.commit();
		}catch(Exception e){
			LOG.error(e.getMessage());
			et.rollback();
		}finally{
			em.close();
			long fin= System.currentTimeMillis();
			System.out.println("Everything went fine! ("+(fin-debut)+" ms)");
		}
		
	}
}
