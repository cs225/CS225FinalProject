import java.util.ArrayList;
import java.util.HashMap;

// @author Peter Collins

/*
 *       //This is the structure of a singleton in java. I believe we should implement this for this class.
 * public class Singleton {
 *       // Private constructor prevents instantiation from other classes
 *       private Singleton() { }
 * 
 *       
 *       //SingletonHolder is loaded on the first execution of Singleton.getInstance() 
 *       //or the first access to SingletonHolder.INSTANCE, not before.
 *       
 *       private static class SingletonHolder { 
 *               public static final Singleton instance = new Singleton();
 *       }
 * 
 *       public static Singleton getInstance() {
 *               return SingletonHolder.instance;
 *       }
 * }
 * 
 */

public class SimulationController {

	private DataIO dataIO = new DataIO();
	private ArrayList<CompletedScenario> completedScenarios = new ArrayList<CompletedScenario>();
	private ArrayList<User> users = new ArrayList<User>();

	// Scenarios saved in individual files preferably for easy
	// reading/editing individual scenarios
	private ArrayList<Scenario> scenarios = new ArrayList<Scenario>();

	// private HashMap<Session, ArrayList<User>> userMap;
	// Sessions are going to be groups of students (like classes, Nursing 101
	// Section A for example)
	// So we can save the array list of users as a HashMap<Session,
	// ArrayList<Users> to easily get student
	// information by class. We can change the session class correspondingly and
	// maybe store users in session
	// It could probably be an internal class to this controller.

	public SimulationController() {
		loadAllData();
	}

	// method to be called when program is launched.
	public void loadAllData() {
		populateUsers();
		populateScenarios();
		populateCompletedScenarios();
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

	// take param session
	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<Scenario> getScenarios() {
		return scenarios;
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
}
