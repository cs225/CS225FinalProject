package CS225FinalProject.DataStructure;

import java.io.Serializable;
import java.lang.*;
import java.util.ArrayList;

/**
 */
public class Scenario implements Serializable{
    /**
     */
    private ArrayList<Medication> medicationList;

    /**
     */
    private String summary;

    /**
     */
    private String patientName;

    /**
     */
    private ArrayList<Narrative> narrativeList;

    /**
     */
    private int roomNumber;

    /**
     */
    private String diagnosis;

    /**
     */
    private String allergies;

    /**
     */
    private String scenarioName;
    /**
     * counter of how many narratives the scenario has
     */
    private int startNumOfNarratives;

    public Scenario() {
    }

    public Scenario(ArrayList<Medication> medicationList, String summary, String patientName, ArrayList<Narrative> narrativeList, int roomNumber, String diagnosis, String allergies, String scenarioName) {
        this.medicationList = medicationList;
        this.summary = summary;
        this.patientName = patientName;
        this.narrativeList = narrativeList;
        this.roomNumber = roomNumber;
        this.diagnosis = diagnosis;
        this.allergies = allergies;
        this.scenarioName = scenarioName;
        startNumOfNarratives=0;
    }
    

    /**
     * @return 
     */
    public ArrayList<Medication> getMedicationList() {
        return null;
    }
    

    /**
     * @return 
     */
    public String getSummary() {
        return null;
    }

    /**
     * @param summary 
     */
    public void setSummary(String summary) {
    }

    /**
     * @return 
     */
    public String getPatientName() {
        return null;
    }

    /**
     * @param patientName 
     */
    public void setPatientName(String patientName) {
    }

    /**
     * @return 
     */
    public ArrayList<Narrative> getNarrativeList() {
        return null;
    }

    /**
     * @param narrativeList 
     */
    public void setNarrativeList(ArrayList<Narrative> narrativeList) {
        this.narrativeList=narrativeList;
        startNumOfNarratives=narrativeList.size();
    }
    public void addNarrative(Narrative narrative){
        narrativeList.add(narrative);
        startNumOfNarratives++;
    }
    public void removeNarrative(int i){
        narrativeList.remove(i);
        startNumOfNarratives--;
    }
    public boolean removeNarrative(Narrative narrative){
        return narrativeList.remove(narrative);
    }

    /**
     * @return 
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * @param roomNumber 
     */
    public void setRoomNumber(int roomNumber) {
    }

    /**
     * @return 
     */
    public String getDiagnosis() {
        return null;
    }

    /**
     * @param diagnosis 
     */
    public void setDiagnosis(String diagnosis) {
    }

    /**
     * @return 
     */
    public String getAllergies() {
        return null;
    }

    /**
     * @param allergies 
     */
    public void setAllergies(String allergies) {
    }
    
    public void addNarrative(String date,String time, String narrative, String followUp, String initials){
        narrativeList.add(new Narrative(date, time, narrative, followUp, initials));
    }

	public Object getScenarioName() {
		// TODO Auto-generated method stub
		return null;
	}
}

