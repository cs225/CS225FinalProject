
/**
 *
 * @author Kevin Mee
 */

//Kevin, overload the constructor so we can make scenario objects when we load data

public class Scenario {
    private String description, patientName;
    private PatientRecord patientRecord;
    private SimulationController controller;
    
    public Scenario(){
        description = controller.getDescription();
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
