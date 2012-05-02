import java.util.ArrayList;

// @author Peter Collins
public class SimulationController {

	private DataLoader loader;

	private DataStorage writer;

	private ArrayList<User> users;

	private ArrayList<Scenario> scenarios;

	private ArrayList<Session> sessions;

	public SimulationController() {
		loader = new DataLoader();
		writer = new DataStorage();
		users = new ArrayList<User>();
		scenarios = new ArrayList<Scenario>();
		sessions = new ArrayList<Session>();

		populateUsers();
		populateScenarios();
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

	private void populateUsers() {
		loader.loadUsers();
	}

	private void populateScenarios() {
		scenarios = loader.loadScenarios();
	}

	private void populateSessions(int userID) {
		sessions = loader.loadUserData(userID);
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<Scenario> getScenarios() {
		return scenarios;
	}

	public ArrayList<Session> getSessions() {
		return sessions;
	}
}