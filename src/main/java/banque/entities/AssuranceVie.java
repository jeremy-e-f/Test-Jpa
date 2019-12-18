package banque.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Représente le concept d'Assurence Vie
 * Un compte peut être une Assurance Vie
 * @author DIGINAMIC
 *
 */
@Entity
@Table(name="assurance_vie")
public class AssuranceVie extends Compte{
	
	/**
	 * Constructeur
	 */
	public AssuranceVie() {
	}
	
	@Column(name="DATE_FIN")
	//@Temporal(TemporalType.DATE)
	private LocalDate dateFin;
	
	@Column(name="TAUX")
	private double taux;

	/** Getter
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/** Setter
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

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
		return "AssuranceVie [dateFin=" + dateFin + ", taux=" + taux + "]";
	}
	
}
