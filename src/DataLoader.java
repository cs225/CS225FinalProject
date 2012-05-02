import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/*
 * Author: Ramsey
 * This class will load in an array of data based on the calling method
 * loadUsers will load in a file which is a list of users to be checked on login and pass them to the calling class as an array list
 * loadData will load in user sessions as objects and pass them back
 *
 */

public class DataLoader {

	private File userFile;
	private File sessionFile;
	private File scenarioFile;

	public DataLoader() {
		// Defile files here
		userFile = new File("users.lst");
		sessionFile = new File("sessions.lst");
		scenarioFile = new File("scenarios.lst");

	}

	// load the files (indvidually!) in their methods
	// arraylist of user objects
	public ArrayList<User> loadUsers() {
		
		// new arraylist
		ArrayList<User> userList = new ArrayList<User>();

		// read file and deserialize
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					userFile));

			// cast the object as an arrayList of users and set it
			userList = (ArrayList<User>) in.readObject();
		} catch (IOException e) {
			System.out.println("Error Finding File:"
					+ userFile.getAbsolutePath());

			// can allow user to select file if file not found?
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		// return arraylist
		return userList;
	}

	// Returns an arraylist of session data for SimController to deal with
	public ArrayList<Session> loadUserData(int idNumber) {

		ArrayList<Session> sessionList = new ArrayList<Session>();

		// read file and deserialize
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					sessionFile));

			// cast the object as an arrayList of users and set it
			sessionList = (ArrayList<Session>) in.readObject();
		} catch (IOException e) {
			System.out.println("Error Finding File:"
					+ sessionFile.getAbsolutePath());

			// can allow user to select file if file not found?
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return sessionList;
	}

	public ArrayList<Scenario> loadScenarios() {
		ArrayList<Scenario> scenarioList = new ArrayList<Scenario>();

		// read file and deserialize
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					sessionFile));

			// cast the object as an arrayList of users and set it
			scenarioList = (ArrayList<Scenario>) in.readObject();
		} catch (IOException e) {
			System.out.println("Error Finding File:"
					+ sessionFile.getAbsolutePath());

			// can allow user to select file if file not found?
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

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
