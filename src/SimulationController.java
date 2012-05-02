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

	// everytime object array lists are serialized and written the current
	// version of those saved objects will be read in and compared with the
	// current version of the list to be written.
	public void writeUsers() {

	}

	public void writeSessions() {

	}

	public void writeScenarios() {

	}

	public void populateUsers() {
		if (loader.loadUsers() != null) {
			users = loader.loadUsers();
		} else {
			// prompt user via gui
		}
	}

	public void populateScenarios() {
		if (loader.loadScenarios() != null) {
			scenarios = loader.loadScenarios();
		} else {
			// prompt user via gui
		}
	}

	public void populateSessions(int userID) {
		if (loader.loadUserData() != null) {
			sessions = loader.loadUserData();
		} else {
			// prompt user via gui
		}
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<Scenario> getScenarios() {
		return scenarios;
	}

	// returns sessions that belong to a specific user
	public ArrayList<Session> getUserSessions(int userID) {
		ArrayList<Session> temp = new ArrayList<Session>();
		
		for (Session ses : sessions) {
			if (ses.getSessionID() == userID) {
				temp.add(ses);
			}
		}
		return temp;
	}

	// returns all sessions to the professor
	public ArrayList<Session> getAllSessions() {
		return sessions;
	}
}