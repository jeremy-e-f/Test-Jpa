package banque.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Représente le concept de Livret A
 * Un compte peut être un Livret A
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name="livret_a")
public class LivretA extends Compte{
	
	/**
	 * Constructeur 
	 */
	public LivretA() {
	}
	
	public LivretA(String numero, double solde, List<Client> proprietaires, double taux) {
		super(numero, solde, proprietaires);
		this.taux = taux;
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
