import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * Author: Ramsey
 * This class will load in an array of data based on the calling method
 * loadUsers will load in a file which is a list of users to be checked on login and pass them to the calling class as an array list
 * loadData will load in user sessions as objects and pass them back
 *
 */

public class DataIO {

	private File userFile;
	private File scenarioFile;
	private File completedScenarioFile;

	public DataIO() {
		// Define files here
		userFile = new File("users.lst");
		scenarioFile = new File("scenarios.lst");
		completedScenarioFile = new File("completed.lst");

	}

	// load the files (individually!) in their methods
	// array list of user objects
	public ArrayList<User> loadUserList() {
		// new array list
		ArrayList<User> userList = new ArrayList<User>();

		// read file and de-serialize
		try {

			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					userFile));

			// cast the object as an arrayList of users and set it
			userList = (ArrayList<User>) in.readObject();

			in.close();

		} catch (IOException e) {

			System.out.println("Error Finding File:"
					+ userFile.getAbsolutePath());

			// returning null if file not found
			return null;
			// can allow user to select file if file not found?
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		// return array list
		return userList;
	}

	// Returns an array list of session data for SimController to deal with
	public ArrayList<CompletedScenario> loadCompletedScenarioList() {
		ArrayList<CompletedScenario> sessionList = new ArrayList<CompletedScenario>();

		try {

			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					completedScenarioFile));

			sessionList = (ArrayList<CompletedScenario>) in.readObject();

			in.close();

		} catch (IOException e) {

			System.out.println("Error Finding File:"
					+ completedScenarioFile.getAbsolutePath());

			return null;

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return sessionList;
	}

	public ArrayList<Scenario> loadScenarioList() {
		ArrayList<Scenario> scenarioList = new ArrayList<Scenario>();

		try {

			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					completedScenarioFile));
			scenarioList = (ArrayList<Scenario>) in.readObject();

			in.close();

		} catch (IOException e) {

			System.out.println("Error Finding File:"
					+ completedScenarioFile.getAbsolutePath());

			return null;

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return scenarioList;

	}

	public boolean writeUserList(ArrayList<User> userList) {
		try {

			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(userFile));
			out.writeObject(userList);
			out.close();
			return true;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean writeCompletedScenarioList(
			ArrayList<CompletedScenario> sessionList) {
		try {

			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(completedScenarioFile));
			out.writeObject(sessionList);
			out.close();
			return true;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean writeScenarioList(ArrayList<Scenario> scenarioList) {
		try {

			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(scenarioFile));
			out.writeObject(scenarioList);
			out.close();
			return true;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}
}
