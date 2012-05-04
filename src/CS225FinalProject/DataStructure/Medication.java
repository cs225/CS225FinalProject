package CS225FinalProject.DataStructure;

/**
 * @author Keith
 * @author Eric
 * 
 */

import java.io.Serializable;
import java.lang.*;

public class Medication implements Serializable {

	private String medicationName;
	private String dosage;
	private String medicationDueTimes;

	public Medication(String medicationName, String dosage,
			String medicationDueTimes) {
		this.medicationName = medicationName;
		this.dosage = dosage;
		this.medicationDueTimes = medicationDueTimes;
	}

	/**
	 * @return
	 */
	public String getMedicationName() {
		return medicationDueTimes;
	}

	/**
	 * @param medicationName
	 */
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	/**
	 * @return
	 */
	public String getDosage() {
		return dosage;
	}

	/**
	 * @param dosage
	 */
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	/**
	 * @return
	 */
	public int[] getMedicationDueTimes() {
		return null;
	}

	/**
	 * @param medicationDueTimes
	 */
	public void setMedicationDueTimes(String medicationDueTimes) {
		this.medicationDueTimes = medicationDueTimes;
	}
}
