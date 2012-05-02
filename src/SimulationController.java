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

	// all write methods need to check the current data against the current
	// stored data as to not overwrite stored data accidentially.
	public void writeUsers() {
		if (dataIO.writeUserList(users)) {
			// data stored, do nothing
		} else {
			// data not stored
		}
	}

	public void writeSessions() {
		if (dataIO.writeSessionData(sessions)) {
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

	public void populateSessions(int userID) {
		if (dataIO.loadSessionList() != null) {
			sessions = dataIO.loadSessionList();
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
