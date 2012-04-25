package CS225FinalProject.DataStructure;

import java.io.Serializable;
import java.lang.*;
import java.util.HashMap;

/**
 */
public class StudentRecord implements Serializable {
    /**
     */
    private String userName;

    /**
     */
    private String password;

    /**
     */
    private String studentName;

    /**
     */
    private HashMap<String, ScenarioResult> simulationResultList;

    /**
     * @return 
     */
    public String getUserName() {
        return null;
    }

    /**
     * @param userName 
     */
    public void setUserName(String userName) {
    }

    /**
     * @return 
     */
    public String getPassword() {
        return null;
    }

    /**
     * @param password 
     */
    public void setPassword(String password) {
    }

    /**
     * @return 
     */
    public String getStudentName() {
        return null;
    }

    /**
     * @param studentName 
     */
    public void setStudentName(String studentName) {
    }

    /**
     * @param scenarioName 
     * @return 
     */
    public ScenarioResult getScenarioResult(String scenarioName) {
        return null;
    }

    /**
     * @param scenarioResult 
     * @param keyScenarioName 
     */
    public void setScenarioResult(String keyScenarioName, ScenarioResult scenarioResult) {
    }

    /**
     * @return 
     */
    public ScenarioResult[] getScenarioResultList() {
        return null;
    }

    /**
     * @param scenarioResult 
     * @param scenarioNameKey
     */
    public void addScenarioResult( String scenarioNameKey, ScenarioResult scenarioResult) {
    }
}

