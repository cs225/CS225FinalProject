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

	
	public void writeUsers() {
		if (dataIO.writeUserList(users)) {
			// data stored
		} else {
			// data not stored
		}
	}

	public void writeSessions() {
		if (dataIO.writeSessionList(sessions)) {
			// data stored
		} else {
			// data not stored
		}
	}

	public void writeScenarios() {
		if (dataIO.writeScenarioList(scenarios)) {
			// data stored
		} else {
			// data not stored
		}
	}

	public void populateUsers() {
		if (dataIO.loadUsers() != null) {
			users = dataIO.loadUsers();
		} else {
			// prompt user via gui
		}
	}

	public void populateScenarios() {
		if (dataIO.loadScenarios() != null) {
			scenarios = dataIO.loadScenarios();
		} else {
			// prompt user via gui
		}
	}

	public void populateSessions(int userID) {
		if (dataIO.loadUserData() != null) {
			sessions = dataIO.loadUserData();
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