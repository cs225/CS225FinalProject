import java.util.ArrayList;

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

public class SimulationController {

	private DataIO dataIO = new DataIO();

	private ArrayList<CompletedScenario> completedScenarios = new ArrayList<CompletedScenario>();
	private ArrayList<User> users = new ArrayList<User>();

	// Scenarios saved in individual files preferably for easy
	// reading/editing individual scenarios
	private ArrayList<Scenario> scenarios = new ArrayList<Scenario>();

	private SimulationController() {
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

	/** Implementing the Singleton pattern */
	private static class SimControl {
		public static final SimulationController instance = new SimulationController();
	}

	public static SimulationController getInstance() {
		return SimControl.instance;
	}
}
