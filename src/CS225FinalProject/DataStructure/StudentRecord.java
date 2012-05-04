package CS225FinalProject.DataStructure;

import java.io.Serializable;
import java.lang.*;
import java.util.HashMap;

/**
 */
public class StudentRecord implements Serializable {
    
    /**
     */
    private String sessionName;
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

    public StudentRecord(String sessionName,  String studentName, String userName, String password) {
        this.sessionName = sessionName;
        this.userName = userName;
        this.password = password;
        this.studentName = studentName;
        this.simulationResultList = new HashMap<String, ScenarioResult>();
    }

    public StudentRecord(String name) {
    }
    
    
    
    
    
    

    public String getSessionName() {
        return sessionName;
    }
    
    public boolean validateStudentLogin(String userName,String password){
        return true;
    }
    
    
    

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
        return simulationResultList.get(scenarioName);
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
        return (ScenarioResult[])simulationResultList.values().toArray();
    }

    /**
     * @param scenarioResult 
     * @param scenarioNameKey
     */
    public void addScenarioResult( String scenarioNameKey, ScenarioResult scenarioResult) {
    }
}

