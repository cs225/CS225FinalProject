
/**
 *
 * @author Kevin Mee
 */


public class Scenario {
    private String description, patientName, scenarioName;
    private PatientRecord patientRecord;
    private SimulationController controller;
    
    public Scenario(){
        scenarioName = "";
        description = "";
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
    
    public String getScenario(){
        return patientRecord.toString() + "\n" + description;
    }
    
    public void setRoom(int room){
        patientRecord.setRoom(room);
    }
    public int getRoom(){
        return patientRecord.getRoom();
    }
    public void setAge(int age){
        patientRecord.setAge(age);
    }
    public int getAge(){
        return patientRecord.getAge();
    }
    public void setDosage(int dose){
        patientRecord.setDosage(dose);
    }
    public int getDosage(){
        return patientRecord.getDosage();
    }
    public void setAllergies(String allergy){
        patientRecord.setAllergies(allergy);
    }
    public String getAllergies(){
        return patientRecord.getAllergies();
    }
    public void setDiagnosis(String diagnose){
        patientRecord.setDiagnosis(diagnose);
    }
    public String getDiagnosis(){
        return patientRecord.getDiagnosis();
    }
    public String recordToString(){
        return patientRecord.toString();
    }
    public void setScenarioName(String name){
        scenarioName = name;
    }
    public String getScenarioName(){
        return scenarioName;
    }
    
}
