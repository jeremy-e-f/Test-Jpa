package banque.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Réprésente le concept de Client d'une banque
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
	
	@Column(name="DATE_NAISSANCE")
	//@Temporal(TemporalType.DATE)
	private LocalDate dateNaissance;		/** Date de naissance du client */
	
	@Embedded
	private Adresse adresse;				/** Adresse du client */
	
	@ManyToMany
	@JoinTable(name="client_compte",
			joinColumns= @JoinColumn(name="ID_CLIENT", referencedColumnName="ID"),
			inverseJoinColumns= @JoinColumn(name="ID_COMPTE", referencedColumnName="ID"))
	private List<Compte> listeComptes;
	
	@ManyToOne
	@JoinColumn(name="ID_BANQUE")
	private Banque banque;					/** Banque à laquelle le client appartient */
	

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
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/** Setter
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/** Getter
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/** Setter
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/** Getter
	 * @return the listeComptes
	 */
	public List<Compte> getListeComptes() {
		return listeComptes;
	}

	/** Setter
	 * @param listeComptes the listeComptes to set
	 */
	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}

	/** Getter
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/** Setter
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", adresse=" + adresse + ", listeComptes=" + listeComptes + ", banque=" + banque + "]";
	}

}
