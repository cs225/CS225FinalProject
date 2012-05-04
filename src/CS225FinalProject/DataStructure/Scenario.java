package CS225FinalProject.DataStructure;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Kevin Mee
 * @authoer Eric
 */

public class Scenario implements Serializable {

	private ArrayList<Medication> medicationList;

	private ArrayList<Narrative> narrativeList;

	private String summary, patientName, diagnosis, 
                allergies, scenarioName, description;

	private int roomNumber, startNumOfNarratives, time;

	private PatientRecord patientRecord;

	public Scenario() {
	}

	public Scenario(ArrayList<Medication> medicationList, String summary,
			String patientName, ArrayList<Narrative> narrativeList,
			int roomNumber, String diagnosis, String allergies,
			String scenarioName, int time) {

		this.medicationList = medicationList;
		this.summary = summary;
		this.patientName = patientName;
		this.narrativeList = narrativeList;
		this.roomNumber = roomNumber;
		this.diagnosis = diagnosis;
		this.allergies = allergies;
		this.scenarioName = scenarioName;
		startNumOfNarratives = 0;
                this.time = time;
	}

    public PatientRecord getPatientRecord() {
        return patientRecord;
    }

    public void setPatientRecord(PatientRecord patientRecord) {
        this.patientRecord = patientRecord;
    }
        
        

	public Scenario(String descript) {
		description = descript;
		patientRecord = new PatientRecord();
		patientName = patientRecord.getName();
	}

	public ArrayList<Medication> getMedicationList() {
		return medicationList;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}


	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public ArrayList<Narrative> getNarrativeList() {
		return narrativeList;
	}

	public void setNarrativeList(ArrayList<Narrative> narrativeList) {
		this.narrativeList = narrativeList;
		startNumOfNarratives = narrativeList.size();
	}

	public void addNarrative(Narrative narrative) {
		narrativeList.add(narrative);
		startNumOfNarratives++;
	}

	public void removeNarrative(int i) {
		narrativeList.remove(i);
		startNumOfNarratives--;
	}

	public boolean removeNarrative(Narrative narrative) {
		return narrativeList.remove(narrative);
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getDiagnosis() {
		return patientRecord.getDiagnosis();
	}

	public void setDiagnosis(String diagnosis) {
		patientRecord.setDiagnosis(diagnosis);
	}

	public String getAllergies() {
		return patientRecord.getAllergies();
	}

	public void setAllergies(String allergy) {

		patientRecord.setAllergies(allergy);
	}

	public void addNarrative(String date, String time, String narrative,
			String followUp, String initials) {
		narrativeList.add(new Narrative(date, time, narrative, followUp,
				initials));
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descript) {
		description = descript;
	}

	public String getScenario() {
		return patientRecord.toString() + "\n" + description;
	}

	public void setRoom(int room) {
		patientRecord.setRoom(room);
	}

	public int getRoom() {
		return patientRecord.getRoom();
	}

	public void setAge(int age) {
		patientRecord.setAge(age);
	}

	public int getAge() {
		return patientRecord.getAge();
	}

	public String recordToString() {
		return patientRecord.toString();
	}

	public void setScenarioName(String name) {
		scenarioName = name;
	}

	public String getScenarioName() {
		return scenarioName;
	}
        /**
         * 
         * @param time 
         * 
         * time is in seconds
         */

        public void setTime(int time){
            this.time = time;
        }
        
        public int getTime(){
            return time;
        }

}
