package banque.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

/**
 * Représente le concept de Compte d'un Client
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name="compte")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
	
	/**
	 * Constructeur
	 */
	public Compte() {
	}
	
	public Compte(String numero, double solde, List<Client> proprietaires) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.proprietaires = proprietaires;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id; 						/** Identifiant */
	
	@Column(name="NUMERO")
	private String numero;					/** Numéro du compte */
	
	@Column(name="SOLDE")
	private double solde;					/** Solde du compte */
	
	@ManyToMany
	@JoinTable(name="client_compte",
			joinColumns= @JoinColumn(name="ID_COMPTE", referencedColumnName="ID"),
			inverseJoinColumns= @JoinColumn(name="ID_CLIENT", referencedColumnName="ID"))
	private List<Client> proprietaires;		/** Liste des clients propriétaires du compte */
	
	@OneToMany(mappedBy="compte")
	private List<Operation> listeOperations; /** Liste des opérations effectuées sur le compte */

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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/** Setter
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/** Getter
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/** Setter
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/** Getter
	 * @return the proprietaires
	 */
	public List<Client> getProprietaires() {
		return proprietaires;
	}

	/** Setter
	 * @param proprietaires the proprietaires to set
	 */
	public void setProprietaires(List<Client> proprietaires) {
		this.proprietaires = proprietaires;
	}

	/** Getter
	 * @return the listeOperations
	 */
	public List<Operation> getListeOperations() {
		return listeOperations;
	}

	/** Setter
	 * @param listeOperations the listeOperations to set
	 */
	public void setListeOperations(List<Operation> listeOperations) {
		this.listeOperations = listeOperations;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + ", listeOperations=" + listeOperations
				+ "]";
	}

}
