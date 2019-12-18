package banque.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Représente le concept de virement
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name="virement")
public class Virement extends Operation{
	
	/**
	 * Constructeur
	 */
	public Virement() {
	}
	
	public Virement(LocalDate date, double montant, String motif, Compte compte, String beneficiaire) {
		super(date, montant, motif, compte);
		this.beneficiaire = beneficiaire;
	}
	
	@Column(name="beneficiaire")
	private String beneficiaire; /** Bénéficiaire du virement */

	/** Getter
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/** Setter
	 * @param beneficiaire the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Virement [beneficiaire=" + beneficiaire + "]";
	}

}
