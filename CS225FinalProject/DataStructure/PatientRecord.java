
import java.util.ArrayList;


/**
 *
 * @author kevinmee
 */
public class PatientRecord {
    private String patientName, allergies, diagnosis;
    private ArrayList<Medication> medication;
    private int dosage, room, age;
    private ArrayList<Narrative> narratives;
    
    //From Eric:
    //I changed MedicationInterface to Medication
    //Awsome Job Kevin!!! :)
    
    public PatientRecord(){
        patientName = "";
        medication = new ArrayList<Medication>();
        allergies = "";
        diagnosis = "";
        room = 0;
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
    
    public int getDosage(){
        return dosage;
    }
    
    public void setDosage(int number){
        dosage = number;
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
    
    @Override
    public String toString(){
        return "Patient name: "+patientName + "\nRoom: "+ room 
                +"\nMedication: "+ medication;
    }
}
