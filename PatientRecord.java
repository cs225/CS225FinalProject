/**
 *
 * @author kevinmee
 */
public class PatientRecord {
    private String patientName, medication;
    private int dosage;
    
    
    public PatientRecord(){
        patientName = "";
        medication = "";
        dosage = 0;
    }
    
    
    public String getName(){
        return patientName;
    }
}
