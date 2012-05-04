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

	private String summary;

	private String patientName;

	private int roomNumber;

	private String diagnosis;

	private String allergies;

	private String scenarioName;
	/**
	 * counter of how many narratives the scenario has
	 */
	private int startNumOfNarratives;

	private PatientRecord patientRecord;

	private String description;

	public Scenario() {
	}

	public Scenario(ArrayList<Medication> medicationList, String summary,
			String patientName, ArrayList<Narrative> narrativeList,
			int roomNumber, String diagnosis, String allergies,
			String scenarioName) {

		this.medicationList = medicationList;
		this.summary = summary;
		this.patientName = patientName;
		this.narrativeList = narrativeList;
		this.roomNumber = roomNumber;
		this.diagnosis = diagnosis;
		this.allergies = allergies;
		this.scenarioName = scenarioName;
		startNumOfNarratives = 0;
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

	/**
	 * @return
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * @param patientName
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * @return
	 */
	public ArrayList<Narrative> getNarrativeList() {
		return narrativeList;
	}

	/**
	 * @param narrativeList
	 */
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

}
