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
        private String routeOfMedication;

	public Medication(String medicationName, String dosage, String route,
			String medicationDueTimes) {
		this.medicationName = medicationName;
		this.dosage = dosage;
		this.medicationDueTimes = medicationDueTimes;
                routeOfMedication = route;
	}

	/**
	 * @return
	 */
	public String getMedicationName() {
		return medicationName;
	}

	/**
	 * @param medicationName
	 */
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

    public String getRouteOfMedication() {
        return routeOfMedication;
    }

    public void setRouteOfMedication(String routeOfMedication) {
        this.routeOfMedication = routeOfMedication;
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
	public String getMedicationDueTimes() {
		return medicationDueTimes;
	}

	/**
	 * @param medicationDueTimes
	 */
	public void setMedicationDueTimes(String medicationDueTimes) {
		this.medicationDueTimes = medicationDueTimes;
	}
}
