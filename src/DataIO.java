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
	private File sessionFile;
	private File scenarioFile;

	public DataIO() {
		// Define files here
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

		// return arraylist
		return userList;
	}

	// Returns an arraylist of session data for SimController to deal with
	public ArrayList<Session> loadUserData() {
		ArrayList<Session> sessionList = new ArrayList<Session>();

		try {

			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					sessionFile));

			sessionList = (ArrayList<Session>) in.readObject();
			
			in.close();

		} catch (IOException e) {

			System.out.println("Error Finding File:"
					+ sessionFile.getAbsolutePath());

			return null;

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return sessionList;
	}

	public ArrayList<Scenario> loadScenarios() {
		ArrayList<Scenario> scenarioList = new ArrayList<Scenario>();

		try {
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					sessionFile));
			scenarioList = (ArrayList<Scenario>) in.readObject();
			
			in.close();

		} catch (IOException e) {

			System.out.println("Error Finding File:"
					+ sessionFile.getAbsolutePath());

			return null;

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return scenarioList;

	}

	public boolean writeUserList() {
		try {

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(userFile));
            out.writeObject(repo);
            out.close();
			return true;
			
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean writeSessionData() {
		try {

			return true;
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean writeScenarioList() {
		try {

			return true;
		} catch (Exception e) {

			System.out.println(e.getMessage());
			return false;
		}
	}
}
