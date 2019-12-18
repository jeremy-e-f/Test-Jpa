package fr.diginamic.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * Réprésente le concept de Client
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name="client")
public class Client {
	
	/**
	 * Constructeur
	 */
	public Client() {
	}

	@Id
	@Column(name="ID")
	private int id; 						/** Identifiant */
	
	@Column(name="NOM")
	private String nom; 					/** Nom du client */
	
	@Column(name="PRENOM")
	private String prenom; 					/** Prénom du client */
	
	@OneToMany(mappedBy="client")
	private List<Emprunt> listeEmprunts; 	/** Liste des emprunts qu'a réalisés le client */

	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/** Setter
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/** Getter
	 * @return the listeEmprunts
	 */
	public List<Emprunt> getListeEmprunts() {
		return listeEmprunts;
	}

	/** Setter
	 * @param listeEmprunts the listeEmprunts to set
	 */
	public void setListeEmprunts(List<Emprunt> listeEmprunts) {
		this.listeEmprunts = listeEmprunts;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}


}
