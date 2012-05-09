package CS225FinalProject.DataStructure;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Kevin Mee
 * @authoer Eric
 */

public class Scenario implements Serializable {

	private String summary, scenarioName;

        /**
         * this is for calculation for later on for recording  the student's narratives.
         */
	private int  startNumOfNarratives, 
                
                time;

	private PatientRecord patientRecord;

	public Scenario() {
            summary= "";
            scenarioName=" Template";
            patientRecord= new PatientRecord();
	}
        /**
         * this should be the official Constructor of Scenario
         * @param scenarioName
         * @param summary
         * @param patientRecord 
         */
        public Scenario(String scenarioName, String summary, PatientRecord patientRecord,int time){
           this.summary = summary;
           this.patientRecord = patientRecord;
           this.time= time*60;
           startNumOfNarratives = patientRecord.getNarrativeList().size();
        }
        public Scenario( String patientName){
            this.patientRecord = new PatientRecord(patientName);
            summary = "";
            startNumOfNarratives = 0;
            time= 0;
        }
        

    public int getStartNumOfNarratives() {
        return startNumOfNarratives;
    }
        
        
        

    public PatientRecord getPatientRecord() {
        return patientRecord;
    }

    public void setPatientRecord(PatientRecord patientRecord) {
        this.patientRecord = patientRecord;
    }
        

    public String getPatientName(){
        return patientRecord.getName();
    }
    
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
        public void setMedicationList(ArrayList<Medication> medications){
            patientRecord.setMedication(medications);
        }
        public ArrayList<Medication> getMedicationList (){
            return patientRecord.getMedicationList();
        }


	public void setNarrativeList(ArrayList<Narrative> narrativeList) {
		patientRecord.setNarratives(narrativeList);
		startNumOfNarratives = narrativeList.size();
	}

	public void addNarrative(Narrative narrative) {
		patientRecord.getNarrativeList().add(narrative);
		startNumOfNarratives++;
	}

	public void removeNarrative(int i) {
		patientRecord.getNarrativeList().remove(i);
		startNumOfNarratives--;
	}

	public boolean removeNarrative(Narrative narrative) {
		return patientRecord.getNarrativeList().remove(narrative);
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
		patientRecord.addNarrative(new Narrative(date, time, narrative, followUp,
				initials));
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
         * time is in minutes
         */

        public void setTime(int time){
            this.time = time*60;
        }
        
        public int getTime(){
            return time/60;
        }

    public ArrayList<Narrative> getNarrativeList() {
       return patientRecord.getNarrativeList();
    }

}
