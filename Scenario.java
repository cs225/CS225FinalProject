
/**
 *
 * @author Kevin Mee
 */
public class Scenario {
    private String description, patientName;
    private PatientRecord patientRecord;
    
    public Scenario(){
        description = "";
        patientRecord = new PatientRecord();
        patientName = patientRecord.getName();
    }
    
}
