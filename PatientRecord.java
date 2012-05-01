/**
 *
 * @author kevinmee
 */
public class PatientRecord {
    private String patientName, medication;
    private int dosage, room;
    
    
    public PatientRecord(){
        patientName = "";
        medication = "";
        dosage = 0;
        room = 0;
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
    
    public String getMedication(){
        return medication;
    }
    
    public void setMedication(String meds){
        medication = meds;
    }
    
    public int getRoom(){
        return room;
    }
    
    public void setRoom(int num){
        room = num;
    }
    
    public String toString(){
        return "Patient name: "+patientName + "\nRoom: "+ room 
                +"\nMedication: "+ medication;
    }
}
