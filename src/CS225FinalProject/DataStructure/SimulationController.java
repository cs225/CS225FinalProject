package CS225FinalProject.DataStructure;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * SimulationController This class has 3 responsibilities: -receive and resolve
 * requests from the GUI -receive and resolve requests for data access
 * -coordinate usage of other classes.
 * 
 * @author Peter Collins
 * @author epanahi
 * 
 */

/*
 * ++++++++Note to others working on different modules+++++++++++++++++++++++
 * Whenever a SimulationController object needs to be accessed anywhere in the
 * code, you should create a SimulationController object to use as a reference,
 * and set it equal to SimulationController.getInstance();
 * 
 * Your code should look like this:
 * 
 * SimulationController controller = SimulationController.getInstance();
 * 
 * You can then use the object named "controller" to call SimulationController
 * methods such as setting and getting data, verifying login, reading and
 * writing, etc. This way we will always be modifying and accessing one instance
 * of all our data.
 */

public class SimulationController implements Serializable {
	// Begin new data
	private DataIO dataIO = new DataIO();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Scenario> scenarios = new ArrayList<Scenario>();
	private ArrayList<String> classNames = new ArrayList<String>();

	// Private Constructor and Singleton Holder
	/**
	 * SimulationController implements the Singleton pattern. We will use one
	 * instance of it at any time, and it is accessible via the static method
	 * SimControl.getInstance(); Please use this method to access methods you
	 * need from the controller.
	 */
	private SimulationController() {
		loadAllData();

		for (User u : users)
			System.out.println(u.getName());

		// temporary user objects for testing
		if (users.isEmpty()) {
			users.add(new Instructor("instructor", "password", 0));
			users.add(new Student("student", "password", 1, "CS225"));
		}
	}

	/** Implementing the Singleton pattern */
	private static class SimControl {
		public static final SimulationController instance = new SimulationController();
	}

	public static SimulationController getInstance() {
		return SimControl.instance;
	}

	// Methods
	/**
	 * This method is called when the SimulationController is created to
	 * initialize all information from the files, and load up the data
	 * structures
	 */
	private void loadAllData() {
		populateUsers();
		populateScenarios();
		setClassNames();
	}

	/**
	 * all iterations through array lists should first check if the list is
	 * empty or not
	 */
	private void setClassNames() {
		for (User u : users) {

			if (classNames.isEmpty() && !u.isInstructor()) {
				classNames.add(u.getClassName());

			} else if (!classNames.isEmpty() && !u.isInstructor()) {
				for (String cn : classNames) {

					if (!cn.equalsIgnoreCase(u.getClassName())) {
						classNames.add(u.getClassName());
					}
				}
			}
		}
	}

	private ArrayList<String> getClassNames() {
		return classNames;
	}

	public int generateNewID() {
		int lastID = 0;
		for (User u : users) {
			if (u.getUserID() > lastID) {
				lastID = u.getUserID();
			}
		}
		return lastID + 1;
	}

	// methods for adding and removing students / classes
	public boolean addStudent(String name, String password, String className) {
		boolean studentAdded = false;

		for (User u : users) {
			if (u.getName().equalsIgnoreCase(name)
					&& u.getPassword().equals(password)) {
				studentAdded = false; // user name + pw rejected
			} else {
				users.add(new Student(name, password, generateNewID(),
						className));
				studentAdded = true; // user name + pw accepted
			}
		}
		setClassNames();
		return studentAdded;
	}

	public void removeStudent(String name, String password, String className) {
		for (User u : users) {
			if (u.getName().equalsIgnoreCase(name)
					&& u.getPassword().equals(password)
					&& u.getClassName().equalsIgnoreCase(className)) {
				users.remove(u);
				setClassNames();
			}
		}
	}

	public void removeStudentsFromClass(String className) {
		for (User u : users) {
			if (u.getClassName().equalsIgnoreCase(className)) {
				users.remove(u);
				setClassNames();
			}
		}
	}

	public void removeAllStudents() {
		for (User u : users) {
			if (!u.isInstructor()) {
				users.remove(u);
				setClassNames();
			}
		}
	}

	public boolean validateStudentLogin(String name, String pw) {

		boolean isValidStudent = false;

		for (User user : users) {
			if (name.equalsIgnoreCase(user.getName())
					&& pw.equals(user.getPassword()) && !user.isInstructor()) {
				isValidStudent = true;
			}
		}
		return isValidStudent;
	}

	public boolean validateInstructorLogin(String name, String pw) {

		boolean isValidInstructor = false;

		for (User user : users) {
			if (name.equalsIgnoreCase(user.getName())
					&& pw.equals(user.getPassword()) && user.isInstructor()) {
				isValidInstructor = true;
			}
		}
		return isValidInstructor;
	}

	// all write methods need to check the current data against the current
	// stored data as to not overwrite stored data accidentally.
	public void writeUsers() {

		if (dataIO.writeUserList(users)) {
			// data stored, do nothing

		} else {
			// data not stored
			System.out.println("no data");
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

	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<Scenario> getScenarios() {
		return scenarios;
	}

	public Scenario getScenarioByName(String scenarioName) {
		Scenario temp = new Scenario();
		for (Scenario s : scenarios) {
			if (s.getScenarioName().equals(scenarioName)) {
				temp = s;
			}
		}
		return temp;
	}

	// returns a list of students that belong to a specific class
	public ArrayList<User> getStudentsInClass(String className) {

		ArrayList<User> tempUsers = new ArrayList<User>();

		for (User student : users) {
			if (student.getClassName().equals(className)) {
				tempUsers.add(student);
			}
		}
		return tempUsers;
	}

	private boolean isInstructorAvailable() {
		for (User u : getUsers()) {
			if (u.isInstructor())
				return true;
		}
		return false;
	}
}
