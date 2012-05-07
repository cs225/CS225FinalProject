package CS225FinalProject.DataStructure;
import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author kevinmee
 */
public class PatientRecord implements Serializable{
    private String patientName, allergies, diagnosis;
    private ArrayList<Medication> medication;
    private int age,room;
    private ArrayList<Narrative> narratives;
    
    //From Eric:
    //I changed MedicationInterface to Medication
    //Awsome Job Kevin!!! :)

    public PatientRecord(
            String patientName, 
            String diagnosis,
            String allergies,  
            int room, 
            int age, 
            ArrayList<Medication> medication,
            ArrayList<Narrative> narratives) {
        this.patientName = patientName;
        this.allergies = allergies;
        this.diagnosis = diagnosis;
        this.medication = medication;
        this.age = age;
        this.narratives = narratives;
        this.room = room;
    }
    
    
    
    public PatientRecord(){
        patientName = "";
        medication = new ArrayList<Medication>();
        allergies = "";
        diagnosis = "";
        age = 0;
        narratives = new ArrayList<Narrative>();
    }
    public PatientRecord(String patientName){
        this.patientName = patientName;
        medication = new ArrayList<Medication>();
        allergies = "";
        diagnosis = "";
        age = 0;
        narratives = new ArrayList<Narrative>();
    }
    
    public  int getAge(){
        return age;
    }
    public void setAge(int a){
        age = a;
    }
    
    public String getName(){
        return patientName;
    }
    
    public void setName(String name){
        patientName = name;
    }
    

    public Medication getMedication(int i){
        return medication.get(i);
    }

    public ArrayList<Medication> getMedicationList() {
        return medication;
    }
    
    
    public void addMedication(Medication meds){
        medication.add(meds);
    }
    
    public String getAllergies(){
        return allergies;
    }
    
    public void setAllergies(String allergy){
        allergies = allergy;
    }
    
    public String getDiagnosis(){
        return diagnosis;
    }
    
    public void setDiagnosis(String diagnose){
        diagnosis = diagnose;
    }
    
    public int getRoom(){
        return room;
    }
    
    public void setRoom(int num){
        room = num;
    }
    
    public void addNarrative(Narrative nar){
        narratives.add(nar);
    }
    public void removeNarrative(Narrative nar){
        narratives.remove(nar);
    }
    public ArrayList<Narrative> getNarrativeList(){
        return narratives;
    }

    public void setNarratives(ArrayList<Narrative> narratives) {
        this.narratives = narratives;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setMedication(ArrayList<Medication> medication) {
        this.medication = medication;
    }

 
    
    @Override
    public String toString(){
        return "Patient name: "+patientName + "\nRoom: "+ room 
                +"\nMedication: "+ medication;
    }
}
