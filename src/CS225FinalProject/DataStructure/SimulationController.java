package CS225FinalProject.DataStructure;



import java.io.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

//import CS225FinalProject.DataStructure.SimulationController.SimControl;

/**
 * SimulationController This class has 3 responsibilities: -receive and resolve
 * requests from the GUI -receive and resolve requests for data access
 * -coordinate usage of other classes.
 * 
 * @author Peter Collins
 * @author epanahi
 * 
 */

/*
 * ++++++++Note to others working on different modules+++++++++++++++++++++++
 * Whenever a SimulationController object needs to be accessed anywhere in the
 * code, you should create a SimulationController object to use as a reference,
 * and set it equal to SimulationController.getInstance();
 * 
 * Your code should look like this:
 * 
 * SimulationController controller = SimulationController.getInstance();
 * 
 * You can then use the object named "controller" to call SimulationController
 * methods such as setting and getting data, verifying login, reading and
 * writing, etc. This way we will always be modifying and accessing one instance
 * of all our data.
 */

public class SimulationController implements Serializable {
	private static HashMap<String, Scenario> scenarioMap;
	private static HashMap<String, Session> sessionMap;
	private static ProffesorLogIn proffesorLogIn;
	// Begin new data
	private DataIO dataIO = new DataIO();
	private ArrayList<CompletedScenario> completedScenarios = new ArrayList<CompletedScenario>();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Scenario> scenarios = new ArrayList<Scenario>();

	// Private Constructor and Singleton Holder
	/**
	 * SimulationController implements the Singleton pattern. We will use one
	 * instance of it at any time, and it is accessible via the static method
	 * SimControl.getInstance(); Please use this method to access methods you
	 * need from the controller.
	 */
	private SimulationController() {
		loadAllData();
	}

	/** Implementing the Singleton pattern */
	private static class SimControl {
		public static final SimulationController instance = new SimulationController();
	}

	public static SimulationController getInstance() {
		return SimControl.instance;
	}

	// Methods
	/**
	 * This method is called when the SimulationController is created to
	 * initialize all information from the files, and load up the data
	 * structures
	 */
	private void loadAllData() {
		populateUsers();
		populateScenarios();
		populateCompletedScenarios();
	}

	public int generateNewID() {
		int lastID = 0;
		for (User u : users) {
			if (u.getUserID() > lastID) {
				lastID = u.getUserID();
			}
		}

		return lastID + 1;
	}

	public boolean validateLogin(String name, String pw) {

		boolean isValidUser = false;

		for (User user : users) {
			if (name == user.getName() && pw == user.getPassword()) {
				isValidUser = true;
			}
		}
		return isValidUser;
	}

	// all write methods need to check the current data against the current
	// stored data as to not overwrite stored data accidentally.
	public void writeUsers() {

		if (dataIO.writeUserList(users)) {
			// data stored, do nothing

		} else {
			// data not stored
		}
	}

	public void writeCompletedScenarios() {

		if (dataIO.writeCompletedScenarioList(completedScenarios)) {
			// data stored, do nothing

		} else {
			// data not stored
		}
	}

	public void writeScenarios() {

		if (dataIO.writeScenarioList(scenarios)) {
			// data stored, do nothing

		} else {
			// data not stored
		}
	}

	public void populateUsers() {

		if (dataIO.loadUserList() != null) {
			users = dataIO.loadUserList();

		} else {
			// loading data failure, file not found
		}
	}

	public void populateScenarios() {

		if (dataIO.loadScenarioList() != null) {
			scenarios = dataIO.loadScenarioList();

		} else {
			// loading data failure, file not found
		}
	}

	public void populateCompletedScenarios() {

		if (dataIO.loadCompletedScenarioList() != null) {
			completedScenarios = dataIO.loadCompletedScenarioList();

		} else {
			// loading data failure, file not found
		}
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<Scenario> getScenarios() {
		return scenarios;
	}

	// need to fix getScenarioName in scenario by merging the two scenario
	// clases
	public Scenario getScenarioByName(String scenarioName) {
		Scenario temp = null;
		for (Scenario s : scenarios) {
			if (s.getScenarioName().equals(scenarioName)) {
				temp = s;
			}
		}
		return temp;
	}

	// returns a list of students that belong to a specific class
	public ArrayList<User> getStudentsInClass(String className) {

		ArrayList<User> tempUsers = new ArrayList<User>();

		for (User student : users) {
			if (student.getClassName().equals(className)) {
				tempUsers.add(student);
			}
		}
		return tempUsers;
	}

	// returns completed scenarios that belong to a specific user
	public ArrayList<CompletedScenario> getUserSessions(int userID) {

		ArrayList<CompletedScenario> temp = new ArrayList<CompletedScenario>();

		for (CompletedScenario ses : completedScenarios) {
			if (ses.getScenarioID() == userID) {
				temp.add(ses);
			}
		}
		return temp;
	}

	// returns all completed scenarios to the professor
	public ArrayList<CompletedScenario> getAllSessions() {
		return completedScenarios;
	}

	// End new data
	/**
	 * loads data from files, if professor file is not found, it creates a
	 * default one, the same thing applies to the SimulationDataStructure class
	 * file.
	 */
	// public SimulationController() {
	// loadResources();
	//
	//
	// /*
	// * if proffesor file is not found, it makes a new one and records it
	// * to file
	// */
	// if(proffesorLogIn ==null)
	// proffesorLogIn = new ProffesorLogIn();
	// try {
	// recordSimulationDataStructure();
	// } catch (IOException ex) {
	// Logger.getLogger(SimulationController.class.getName()).log(Level.SEVERE,
	// null, ex);
	// }
	// }

	/**
	 * This method loads all the resourses from file. if some are not found,
	 * generate them and are with empty contents.
	 * 
	 * The SimulationDataStructure class file is store in the ROOT Working
	 * Directory with the file extention .sds
	 * 
	 * The Scenario file/s are stored in ROOT/scenarios directory with the file
	 * extention .sco
	 * 
	 * The ProffesorLogIn class is stored the root working directory with the
	 * file extention .pli
	 */
	public static void loadResources() {

		/*
		 * Example for loading the teacher file login
		 */
		// ////////////////////////////////////////////
		try {
			ObjectInputStream profesorLogin = new ObjectInputStream(
					new FileInputStream("login.pli"));
		} catch (IOException ex) {
			// Logger.getLogger(SimulationDataStructure.class.getName()).log(Level.SEVERE,
			// null, ex);
			System.out
					.println("no proffesor login file found, so default login is made and recorded to file");
		}
		// ///////////////////////////////////////////

		/*
		 * Loading Scenarios and the SimulationDataStructure files should be
		 * here below
		 */
	}

	/**
	 * @param sessionName
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean validateStudentLogIn(String sessionName, String userName,
			String password) {
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
	public Session getSession(String sessionName) {
		return null;
	}

	/**
	 * @param scenarioName
	 * @return
	 */
	public Scenario getScenario(String scenarioName) {
		return null;
	}

	public StudentRecord getStudentRecord(String sessionName, String userName,
			String password) {
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
	private void recordSimulationDataStructure() throws IOException {

		// Profesor file saved.
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				"login.pli"));
		out.writeObject(proffesorLogIn);
		out.close();
		// Data Structure saved must go here.

	}

	/**
	 * when adding a student or changing an username, this should be called for
	 * multiple copies of userNames prevention.
	 * 
	 * @param userName
	 * @return
	 */
	public boolean isUserNameAvailable(String userName) {
		return true;
	}
}
