import java.util.ArrayList;

// @author Peter Collins
public class SimulationController {

	private DataIO dataIO;

	private ArrayList<User> users;

	private ArrayList<Scenario> scenarios;
//Sessions are going to be groups of students (like classes, Nursing 101 Section A for example)
//So we can save the arraylist of users as a HashMap<Session, ArrayList<Users> to easily get student
//information by class.  We can change the session class correspondingly and maybe store users in session
//It could probably be an internal class to this controller.
	private ArrayList<Session> sessions;

	public SimulationController() {
		dataIO = new DataIO();
		users = new ArrayList<User>();
		scenarios = new ArrayList<Scenario>();
		//Scenarios saved in individual files preferably for easy reading/editing individual scenarios
		sessions = new ArrayList<Session>(); 

		populateUsers();
		populateScenarios();
	}

//Will need session information
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

//will change to reflect session change
	public void writeSessions() {
		if (dataIO.writeSessionList(sessions)) {
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

//Will change to reflect session change
	public void populateSessions(int userID) {
		if (dataIO.loadSessionList() != null) {
			sessions = dataIO.loadSessionList();
		} else {
			// loading data failure, file not found
		}
	}

//take param session
	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<Scenario> getScenarios() {
		return scenarios;
	}

	// returns sessions that belong to a specific user - we'll change this to reflect change to session
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
