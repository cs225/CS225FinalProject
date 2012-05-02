import java.util.ArrayList;

// @author Peter Collins
public class SimulationController {

	private DataIO dataIO;

	private ArrayList<User> users;

	private ArrayList<Scenario> scenarios;

	private ArrayList<Session> sessions;

	public SimulationController() {
		dataIO = new DataIO();
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
		// dataIO.writeUsers(users);
	}

	public void writeSessions() {
		// dataIO.writeSessions(sessions);

	}

	public void writeScenarios() {
		// dataIO.writeScenarios(scenarios);
	}

	public void populateUsers() {
		if (dataIO.loadUserList() != null) {
			users = dataIO.loadUserList();
		} else {
			// prompt user via gui
		}
	}

	public void populateScenarios() {
		if (dataIO.loadScenarioList() != null) {
			scenarios = dataIO.loadScenarioList();
		} else {
			// prompt user via gui
		}
	}

	public void populateSessions(int userID) {
		if (dataIO.loadSessionList() != null) {
			sessions = dataIO.loadSessionList();
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