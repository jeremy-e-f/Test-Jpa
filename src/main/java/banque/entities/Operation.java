package banque.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

/**
 * Représente le concept d'une Opération bancaire
 * @author DIGINAMIC
 *
 */

@Entity
@Table(name="operation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {
	
	/**
	 * Constructeur
	 */
	public Operation() {
	}
	
	@Id
	@Column(name="ID")
	private int id;					/** Identifiant */
	
	@Column(name="DATE")
	//@Temporal(TemporalType.DATE)
	private LocalDate date;			/** Date de réalisation de l'opération */
	
	@Column(name="MONTANT")
	private double montant;			/** Montant de l'opération */
	
	@Column(name="MOTIF")
	private String motif;			/** Motif de l'opération */
	
	@ManyToOne
	@JoinColumn(name="ID_COMPTE")
	private Compte compte; 			/** Compte sur lequel l'opération a été effectuée */

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
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/** Setter
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/** Getter
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}

	/** Setter
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/** Getter
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/** Setter
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/** Getter
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/** Setter
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Operation [id=" + id + ", date=" + date + ", montant=" + montant + ", motif=" + motif + "]";
	}

}
