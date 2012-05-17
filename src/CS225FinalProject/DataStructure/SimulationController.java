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

/**
 * @SUPRESSEDWARNINGS: ARRAY LIST CLONES MUST BE USED FOR REMOVAL METHODS TO
 *                     AVOID CONCURRENCY ISSUES!
 */

public class SimulationController implements Serializable {

	private DataIO dataIO = new DataIO();
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Scenario> scenarios = new ArrayList<Scenario>();
	private ArrayList<String> classNames = new ArrayList<String>();

	/**
	 * SimulationController implements the Singleton pattern. We will use one
	 * instance of it at any time, and it is accessible via the static method
	 * SimControl.getInstance(); Please use this method to access methods you
	 * need from the controller.
	 * 
	 * 
	 */
	private SimulationController() {
		loadAllData();

		// temporary objects for testing
		if (users.isEmpty()) {
			users.add(new Instructor("instructor", "password", generateNewID()));
			users.add(new Student("student", "James", "password",
					generateNewID(), "CS225"));
			users.add(new Student("student2", "Rick", "password",
					generateNewID(), "Nursing 101"));
		}

		if (classNames.isEmpty()) {
			classNames.add("CS225");
			classNames.add("Nursing 101");
		}
		if (scenarios.isEmpty()) {
			Narrative sample = new Narrative("Test", "5", "OMG", "no", "Lovely");
			ArrayList<Narrative> narratives = new ArrayList<Narrative>();
			narratives.add(sample);

			ArrayList<Medication> medications = new ArrayList<Medication>();
			medications.add(new Medication("Insulin", "10 units", "injection",
					"10AM"));

			scenarios.add(new Scenario("Test", "Test", new PatientRecord(
					"Eric", "Death due to OVER-PROGRAMMING :(", "none", 50, 20,
					medications, narratives), 20));

			scenarios.add(new Scenario("Test2", "Test2", new PatientRecord(
					"Eric2", "Death", "none", 50, 20,
					new ArrayList<Medication>(), narratives), 15));

			writeScenarios();
		}
		for (User u : users)
			System.out.println(u.getUserName() + "  /  " + u.getPassword());
		for (String cn : classNames)
			System.out.println(cn);
	}

	/** Implementing the Singleton pattern */
	private static class SimControl {
		public static SimulationController instance = new SimulationController();
	}

	public static SimulationController getInstance() {
		return SimControl.instance;
	}
        
        public boolean isUserNameAvailable(String username){
            for(User user:users){
                if(user.getUserName().equals(username))
                    return false;
            }
            return true;
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
		populateClassNames();
	}

	public int generateNewID() {
		int lastID = 0;
		if (!users.isEmpty()) {
			for (User u : users) {
				if (u.getUserID() > lastID) {
					lastID = u.getUserID();
				}
			}
		}
		return lastID + 1;
	}

	// methods for adding and removing classas
	@SuppressWarnings("unchecked")
	public boolean removeClass(String classesName) {
		boolean classRemoved = false;

		if (!classNames.isEmpty()) {
			for (String cn :  (ArrayList<String>) classNames.clone()) {
				if (cn.equalsIgnoreCase(classesName)) {
					classNames.remove(cn);
					classRemoved = true;
                                        
                                        for(User user: (ArrayList<User>)users.clone()){
                                            if(user instanceof Student){
                                                if(((Student)user).getClassName().equals(classesName))
                                                   users.remove(user);
                                            }
                                            
                                        }
				}
			}
                        
		}
                writeClassNames();
                writeUsers();
		return classRemoved;
	}

	public boolean addClass(String classesName) {
		boolean classExists = false;
		boolean classAdded = false;

		if (!classNames.isEmpty()) {
			for (String cn : classNames) {
				if (cn.equalsIgnoreCase(classesName)) {
					classExists = true;
				}
			}
		}
		if (!classExists) {
			classNames.add(classesName);
			classAdded = true;
		}
		return classAdded;
	}

	// methods for adding and removing students
	public boolean addStudent(String userName, String realName,
			String password, String className) {
		boolean studentExists = false;
		boolean studentAdded = false;

		if (!users.isEmpty()) {
			for (User u : users) {
				if (u.getUserName().equalsIgnoreCase(userName)
						&& u.getPassword().equals(password)) {
					studentExists = true;
				}
			}
		}

		if (!studentExists) {
			users.add(new Student(userName, realName, password,
					generateNewID(), className));
			studentAdded = true;
		}

		return studentAdded;
	}
        public void removeScenarioByName(String name){
            for(Scenario scenario: scenarios){
                if(scenario.getPatientName().equals(name)){
                    scenarios.remove(scenario);
                    writeScenarios();
                    break;
                }
            }
        }

	@SuppressWarnings("unchecked")
	public boolean removeStudent(String userName, String password) {

		boolean userRemoved = false;

		if (!users.isEmpty()) {
			for (User u : (ArrayList<User>) users.clone()) {
				if (u.getUserName().equalsIgnoreCase(userName)
						&& u.getPassword().equals(password)
						&& !u.isInstructor()) {
					users.remove(u);
					userRemoved = true;
				}
			}
		}
		return userRemoved;
	}
        /**
         * remove student by real name
         * @param realName
         * @return 
         */
        public boolean removeStudentByNameAndClassroom(String realName, String classroom){
            boolean userRemoved = false;

		if (!users.isEmpty()) {
			for (User u : (ArrayList<User>) users.clone()) {
                               if(u != null && u instanceof Student){
				if (u.getRealName().equals(realName) && u.getClassName().equals(classroom)){
					users.remove(u);
					userRemoved = true;
				}
                               }
			}
		}
		return userRemoved;
            
        }
        public Student getStudentByNameAndClassroom(String realName, String classroom){
            Student user=null;
            if (!users.isEmpty()) {
			for (User u : (ArrayList<User>) users.clone()) {
                               if(u != null && u instanceof Student){
				if (u.getRealName().equals(realName) && u.getClassName().equals(classroom)){
				
					user = (Student)u;
                                        return user;
				}
                               }
			}
		}
		return user;
            
        }
	@SuppressWarnings("unchecked")
	public void removeStudentsFromClass(String className) {
		if (!users.isEmpty()) {
			for (User u : (ArrayList<User>) users.clone()) {
				if (u.getClassName().equalsIgnoreCase(className)) {
					users.remove(u);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void removeAllStudents() {
		if (!users.isEmpty()) {
			for (User u : (ArrayList<User>) users.clone()) {
				if (!u.isInstructor()) {
					users.remove(u);
				}
			}
		}
	}

	public boolean validateStudentLogin(String userName, String pw) {

		boolean isValidStudent = false;

		if (!users.isEmpty()) {
			for (User user : users) {
				if (userName.equalsIgnoreCase(user.getUserName())
						&& pw.equals(user.getPassword())
						&& !user.isInstructor()) {
					isValidStudent = true;
				}
			}
		}
		return isValidStudent;
	}

	public boolean validateInstructorLogin(String name, String pw) {

		boolean isValidInstructor = false;

		if (!users.isEmpty()) {
			for (User user : users) {
				if (name.equalsIgnoreCase(user.getUserName())
						&& pw.equals(user.getPassword()) && user.isInstructor()) {
					isValidInstructor = true;
				}
			}
		}
		return isValidInstructor;
	}

	public Scenario getScenarioByName(String scenarioName) {
		Scenario temp = new Scenario();
		if (!scenarios.isEmpty()) {
			for (Scenario s : scenarios) {
				if (s.getPatientName().equals(scenarioName)) {
					temp = s;
				}
			}
		}
		return temp;
	}

	// returns a list of students that belong to a specific class
	public ArrayList<User> getStudentsInClass(String className) {

		ArrayList<User> tempUsers = new ArrayList<User>();

		if (!users.isEmpty()) {
			for (User student : users) {
                            if(!student.isInstructor()){
				if ((student).getClassName().equals(className)) {
					tempUsers.add(student);
				}
                            }
			}
		}
		return tempUsers;
	}

	public boolean isInstructorAvailable() {
		if (!users.isEmpty()) {
			for (User u : getUsers()) {
				if (u.isInstructor())
					return true;
			}
		}
		return false;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public User getUser(String username, String password) {
		for (User user : users) {
			if (user.getUserName().equals(username)
					&& user.getPassword().equals(password))
				return user;
		}
		return null;
	}

	public ArrayList<Scenario> getScenarios() {
		return scenarios;
	}

	public ArrayList<String> getClassNames() {
		return classNames;
	}

	// all write methods need to check the current data against the current
	// stored data as to not overwrite stored data accidentally.
	public void writeUsers() {

		if (dataIO.writeUserList(users)) {
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

	public void writeClassNames() {

		if (dataIO.writeClassNameList(classNames)) {
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

	public void populateClassNames() {

		if (dataIO.loadClassNameList() != null) {
			classNames = dataIO.loadClassNameList();

		} else {
			// loading data failure, file not found
		}
	}

        /**
         * Usefull for importing Scenarios.
         * @param scenarios 
         */
    public void setScenarios(ArrayList<Scenario> scenarios) {
        this.scenarios = scenarios;
    }
        
}
