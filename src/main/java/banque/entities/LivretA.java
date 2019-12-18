package banque.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Représente le concept de Livret A
 * Un compte peut être un Livret A
 * @author DIGINAMIC
 *
 */
@Entity
public class LivretA extends Compte{
	
	/**
	 * Constructeur 
	 */
	public LivretA() {
	}
	
	@Column(name="TAUX")
	private double taux;

	/** Getter
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/** Setter
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LivretA [taux=" + taux + "]";
	}
	
}
