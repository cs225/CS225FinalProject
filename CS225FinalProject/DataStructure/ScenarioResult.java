package CS225FinalProject.DataStructure;

import java.io.Serializable;
import java.util.*;
import java.lang.*;
import javax.swing.JTable;

/**
 */
public class ScenarioResult implements Serializable{
    /**
     */
    private Date dateTaken;

    /**
     */
    private JTable studentInput;

    /**
     */
    private String evaluationSuggestion;

    /**
     */
    private Integer score;

    /**
     */
    private Scenario scenarioTaken;

    /**
     * @return 
     */
    public Date getDateTaken() {
        return null;
    }

    /**
     * @return 
     */
    public JTable getStudentInput() {
        return null;
    }

    /**
     * @return 
     */
    public String getEvaluationSuggestion() {
        return null;
    }

    /**
     * @param scenarioTaken 
     * @param dateTaken 
     * @param evaluationSuggestion 
     * @param studentInput 
     */
    public ScenarioResult(
            Date dateTaken,
            javax.swing.JTable studentInput,
            String evaluationSuggestion,
            Scenario scenarioTaken) 
    {
        
    }

    /**
     * @return 
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score 
     */
    public void setScore(Integer score) {
    }

    /**
     */
    public void displayGUI() {
    }
}

