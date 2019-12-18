package fr.diginamic.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

/**
 * Représente le concept de livre
 * @author Diginamic
 *
 */
@Entity
@Table(name="livre")
public class Livre {
	
	/**
	 * Constructeur
	 */
	public Livre(){
	}
	
	@Id
	@Column(name="ID")
	private int id; 						/** Identifiant */
	
	@Column(name= "TITRE")
	private String titre;   				/** Titre  */
	
	@Column(name= "AUTEUR")
	private String auteur; 					/** Auteur */
	
	@ManyToMany
	@JoinTable(name="compo",
		joinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID"),
		inverseJoinColumns= @JoinColumn(name="ID_EMP", referencedColumnName= "ID"))
	private List<Emprunt> listeEmprunts; 	/** Liste des emprunts qui font référence au livre */
	
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
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/** Setter
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/** Getter
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/** Setter
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
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
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";
	}

}
