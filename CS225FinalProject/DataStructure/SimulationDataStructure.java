package CS225FinalProject.DataStructure;


import java.io.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


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

    
    /**
     * loads data from files, if professor file is not found, 
     * it creates a default one, the same thing applies to the 
     * SimulationDataStructure class file.
     */
    public SimulationDataStructure() {
        loadResources();
        
        
        /*
         * if proffesor file is not found, it makes a new one and records it 
         * to file
         */
        if(proffesorLogIn ==null)
            proffesorLogIn = new ProffesorLogIn();
        try {
            recordSimulationDataStructure();
        } catch (IOException ex) {
            Logger.getLogger(SimulationDataStructure.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        
        
        /*
         * Example for loading the teacher file login 
         */
        //////////////////////////////////////////////
        try {
            ObjectInputStream profesorLogin = new ObjectInputStream(new FileInputStream("login.pli"));
        } catch (IOException ex) {
           // Logger.getLogger(SimulationDataStructure.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("no proffesor login file found, so default login is made and recorded to file");
        }
        /////////////////////////////////////////////
        
        /*
         * Loading Scenarios and the SimulationDataStructure files should be here below
         */
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
        return proffesorLogIn.validateLogin(userName, passWord);
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
        validateStudentLogIn(sessionName, userName, password);
        return sessionMap.get(sessionName).getStudentRecord(userName);
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

    
    /**
     * 
     * @throws IOException 
     */
    private void recordSimulationDataStructure() throws IOException  {
        
        //Profesor file saved.
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("login.pli"));
        out.writeObject(proffesorLogIn);
        out.close();
        //Data Structure saved must go here.
        
        
 
    }
    
    
    
    /**
     * when adding a student or changing an username, this should be called
     * for multiple copies of userNames prevention.
     * @param userName
     * @return 
     */
    public boolean isUserNameAvailable(String userName){
        return true;
    }
}

