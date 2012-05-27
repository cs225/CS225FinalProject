package CS225FinalProject.DataStructure;

import CS225FinalProject.SimulationManager;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.JTextArea;

//This will hold user session data
public class CompletedScenario implements Serializable, Printable{

	private Date dateTaken;
	private Integer score;
	private String evaluationSuggestion;
	private Scenario scenarioTaken;
	private DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        private  ArrayList<Narrative> studentinput;
        
        /**
         * The student who took the test, only useful for the printing implementation.
         */
        private Student student;

	// finish constructor, getters and setters have been generated.
	// storing data propely is not implemented.

	public CompletedScenario() {
		// creating a new date object immediately stores the current time
		dateTaken = Calendar.getInstance().getTime();
	}

	//Overloaded constructor to create a new object already populated with relevant information
	public CompletedScenario( ArrayList<Narrative> studentinput , String evaluationSuggestion, Scenario scenarioTaken){
		this.dateTaken = Calendar.getInstance().getTime();
		//this.studentInput = studentInput;
		this.evaluationSuggestion = evaluationSuggestion;
		this.scenarioTaken = scenarioTaken;
                this.studentinput = studentinput;
                score=null;
                student = (Student)SimulationManager.CURRENT_USER;
                
	}
	public String getDateTaken() {
		// returns a formatted string representing the exact date and time the
		// scenario was completed.
		return dateFormat.format(dateTaken);
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ArrayList<Narrative> getStudentInput() {
		return studentinput;
	}

	public void setStudentInput(ArrayList<Narrative> studentInput) {
		this.studentinput = studentInput;
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

        
        /**
         * Evan, implement the report here. it should print the details like the suggestion and score and student info.
         * I made a instance of the Student that took the simulation so you can display their info.
         * @throws PrinterException 
         */
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
       // throw new UnsupportedOperationException("Not supported yet.");
        //student.getRealName(); sample of getting the name of the student . it is functional :).
        //JTextArea jTextArea = new JTextArea();
        //jTextArea.getp
        
        return 1;
    }
}
