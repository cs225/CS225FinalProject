/**
 *
 * @author kevinmee
 */
public class PatientRecord {
    private String patientName, medication;
    private int dosage, room, age;
    
    
    public PatientRecord(){
        patientName = "";
        medication = "";
        dosage = 0;
        room = 0;
        age = 0;
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
    
    @Override
    public String toString(){
        return "Patient name: "+patientName + "\nRoom: "+ room 
                +"\nMedication: "+ medication;
    }
}
