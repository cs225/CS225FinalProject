package CS225FinalProject.DataStructure;


import java.io.Serializable;
import java.util.HashMap;


/**
 */
public class SimulationDataStructure implements Serializable{
    /**
     */
    private static HashMap<String, Scenario> scenarioMap;

    /**
     */
    private static HashMap<String, Session> sessionMap;

    /**
     */
    private static ProffesorLogIn proffesorLogIn;

    public SimulationDataStructure() {
        loadResources();
    }

    /**
     * This method loads all the resourses from file.
     * if some are not found, generate them and are with empty contents.
     
  *The SimulationDataStructure class file is store in the ROOT Working Directory
   with the file extention .sds

  *The Scenario file/s are stored in ROOT/scenarios directory 
   with the file extention .sco

  *The ProffesorLogIn class is stored the root working directory
   with the file extention .pli
     */
    public static void loadResources() {
    }

    /**
     * @param sessionName
     * @param userName 
     * @param password 
     * @return 
     */
    public  boolean validateStudentLogIn(String sessionName,String userName, String password) {
        return false;
    }

    /**
     * @param userName 
     * @param passWord 
     */
    public boolean validateProffesorLogIn(String userName, String passWord) {
        return true;
    }

    /**
     * @return 
     */
    public Scenario[] getScenarioList() {
        return null;
    }

    /**
     * @return 
     */
    public Session[] getSessionList() {
        return null;
    }

    /**
     * @param sessionName 
     * @return 
     */
    public  Session getSession(String sessionName) {
        return null;
    }

    /**
     * @param scenarioName 
     * @return 
     */
    public Scenario getScenario(String scenarioName) {
        return null;
    }
    public StudentRecord getStudentRecord(String sessionName, String userName,String password){
        return null;
    }
    /**
     */
    public void recordSessionsToFile() {
    }

    /**
     * @param scenario 
     */
    public void recordScenarioToFile(Scenario scenario) {
    }

    /**
     * @param scenarioName 
     */
    public void removeScenarioFile(String scenarioName) {
    }
}

