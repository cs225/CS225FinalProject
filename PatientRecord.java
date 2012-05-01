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
    
    public void setMedicatio(String meds){
        medication = meds;
    }
}
