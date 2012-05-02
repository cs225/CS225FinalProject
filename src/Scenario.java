
/**
 *
 * @author Kevin Mee
 */


public class Scenario {
    private String description, patientName;
    private PatientRecord patientRecord;
    private SimulationController controller;
    
    public Scenario(){
        description = controller.getDescription();
        patientRecord = new PatientRecord();
        patientName = patientRecord.getName();
    }
    
    public Scenario(String descript){
        description = descript;
        patientRecord = new PatientRecord();
        patientName = patientRecord.getName();
    }
    
    public String getDescription(){
        return description;
    }
    public void setDescription(String descript){
        description = descript;
    }
    
    
}
