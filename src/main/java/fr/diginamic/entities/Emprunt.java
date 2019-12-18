package fr.diginamic.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Représente le concept d'emprunt
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name="emprunt")
public class Emprunt {
	
	/**
	 * Constructeur
	 */
	public Emprunt() {
	}
	
	@Id
	@Column(name="ID")
	private int id;						 /** Identifiant */
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_DEBUT")
	private Date dateDebut;			 	/** Date de début de l'emprunt */
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_FIN")
	private Date dateFin;				 /** Date de fin de l'emprunt */
	
	@Column(name="DELAI")
	private int delai; 					/** Délai d'emprunt */
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client; 				/** Client auquel l'emprunt appartient */
	
	@ManyToMany
	@JoinTable(name="compo",
		joinColumns= @JoinColumn(name="ID_EMP", referencedColumnName= "ID"),
		inverseJoinColumns= @JoinColumn(name="ID_LIV", referencedColumnName="ID"))
	private List<Livre> listeLivres; 	/** Liste des livres concernés par l'emprunt */

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
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/** Setter
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/** Getter
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/** Getter
	 * @return the delai
	 */
	public int getDelai() {
		return delai;
	}

	/** Setter
	 * @param delai the delai to set
	 */
	public void setDelai(int delai) {
		this.delai = delai;
	}

	/** Getter
	 * @return the client
	 */
	public Client getClient() {
		return this.client;
	}

	/** Setter
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/** Getter
	 * @return the listeLivres
	 */
	public List<Livre> getListeLivres() {
		return listeLivres;
	}

	/** Setter
	 * @param listeLivres the listeLivres to set
	 */
	public void setListeLivres(List<Livre> listeLivres) {
		this.listeLivres = listeLivres;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", delai=" + delai
				+ ", client=" + client + ", listeLivres=" + listeLivres + "]";
	}


}
