package CS225FinalProject.DataStructure;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTable;

//This will hold user session data
public class CompletedScenario {

	private Date dateTaken;
	private int score;
	private JTable studentInput;
	private String evaluationSuggestion;
	private Scenario scenarioTaken;
	private DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy at HH:mm:ss");

	// finish constructor, getters and setters have been generated.
	// storing data propely is not implemented.

	public CompletedScenario() {
		// creating a new date object immediately stores the current time
		dateTaken = Calendar.getInstance().getTime();
	}

	//Overloaded constructor to create a new object already populated with relevant information
	public CompletedScenario(JTable studentInput, String evaluationSuggestion, Scenario scenarioTaken){
		this.dateTaken = Calendar.getInstance().getTime();
		this.studentInput = studentInput;
		this.evaluationSuggestion = evaluationSuggestion;
		this.scenarioTaken = scenarioTaken;
	}
	public String getDateTaken() {
		// returns a formatted string representing the exact date and time the
		// scenario was completed.
		return dateFormat.format(dateTaken);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public JTable getStudentInput() {
		return studentInput;
	}

	public void setStudentInput(JTable studentInput) {
		this.studentInput = studentInput;
	}

	public String getEvaluationSuggestion() {
		return evaluationSuggestion;
	}

	public void setEvaluationSuggestion(String evaluationSuggestion) {
		this.evaluationSuggestion = evaluationSuggestion;
	}

	public Scenario getScenarioTaken() {
		return scenarioTaken;
	}

	public void setScenarioTaken(Scenario scenarioTaken) {
		this.scenarioTaken = scenarioTaken;
	}
}
