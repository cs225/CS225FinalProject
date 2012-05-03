
import java.util.ArrayList;
// finish up the narratives get/set/add/remove
//------Suggestion by Eric


/**
 *
 * @author kevinmee
 */
public class PatientRecord {
    private String patientName, allergies, diagnosis;
    private ArrayList<MedicationInterface> medication;
    private int dosage, room, age;
    //private ArrayList<Narrative> narratives;
    
    
    public PatientRecord(){
        patientName = "";
        medication = new ArrayList<MedicationInterface>();
        allergies = "";
        diagnosis = "";
        dosage = 0;
        room = 0;
        age = 0;
        //narratives = new ArrayList<Narrative>();
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
    
    public MedicationInterface getMedication(int i){
        return medication.get(i);
    }
    
    public void setMedication(MedicationInterface meds){
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
    
    @Override
    public String toString(){
        return "Patient name: "+patientName + "\nRoom: "+ room 
                +"\nMedication: "+ medication;
    }
}
