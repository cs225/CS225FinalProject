package CS225FinalProject.DataStructure;

import java.io.Serializable;
import java.lang.*;

/**
 */
public class Medication implements Serializable{
    /**
     */
    private String medicationName;

    /**
     */
    private String dosage;

    /**
     */
    private String medicationDueTimes;

    public Medication(String medicationName, String dosage, String medicationDueTimes) {
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.medicationDueTimes = medicationDueTimes;
    }
    /**
     * @return 
     */
    public String getMedicationName() {
        return null;
    }

    /**
     * @param medicationName 
     */
    public void setMedicationName(String medicationName) {
    }

    /**
     * @return 
     */
    public String getDosage() {
        return null;
    }

    /**
     * @param dosage 
     */
    public void setDosage(String dosage) {
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
    }
}

