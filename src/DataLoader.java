import java.util.ArrayList;

/*
 * Author: Ramsey
 * This class will load in an array of data based on the calling method
 * loadUsers will load in a file which is a list of users to be checked on login and pass them to the calling class as an array list
 * loadData will load in user sessions as objects and pass them back
 *
 */
public class DataLoader {

	public DataLoader() {
	}

	// string will be: Name, password, id
	public ArrayList<String> loadUsers() {
		// new arraylist
		ArrayList<String> userList = new ArrayList<String>();

		// read file

		// parse file

		// populate arraylist

		// return arraylist
		return userList;
	}

	// Returns an arraylist of session data for SimController to deal with
	public ArrayList<Session> loadUserData(int idNumber) {

		ArrayList<Session> sessionList = new ArrayList<Session>();

		// read file

		// parse file

		// populate arraylist

		// return arraylist

		return sessionList;
	}

	public ArrayList<Scenario> loadScenarios() {
		ArrayList<Scenario> scenarioList = new ArrayList<Scenario>();

		// read file

		// parse file

		// populate arraylist

		// return arraylist

		return scenarioList;

	}

	public boolean updateUserList() {
		try {

			return true;
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean updateSessionData() {
		try {

			return true;
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateScenarioList() {
		try {

			return true;
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}
}
