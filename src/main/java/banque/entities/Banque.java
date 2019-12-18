package banque.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Représente le concept de Banque
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name="banque")
public class Banque {
	
	/**
	 * Constructeur
	 */
	public Banque(){
	}
	
	@Id
	@Column(name="ID")
	private int id;						/** Id de la banque */
	
	@Column(name="NOM")
	private String nom;					/** Nom de la banque */
	
	@OneToMany(mappedBy="banque")
	private List<Client> listeClients;	/** Liste des clients de la banque */

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
	 * @return the listeClients
	 */
	public List<Client> getListeClients() {
		return listeClients;
	}

	/** Setter
	 * @param listeClients the listeClients to set
	 */
	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Banque [id=" + id + ", nom=" + nom + ", listeClients=" + listeClients + "]";
	}
}
