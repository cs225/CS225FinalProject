// @author Peter Collins
public class SimulationController {

	private LoadData loader;

	private StoreData writer;

	private ArrayList<Student> students;

	private ArrayList<Instructor> instructors;

	private ArrayList<Scenario> scenarios;

	public SimulationController() {
		loader = new LoadData();
		writer = new StoreData();

		populateUsers();
		populateScenarios();
	}

	private void populateUsers() {
		// loader.loadUsers();
	}

	private void populateScenarios() {
		//loader.loadScenarios();
	}

	public boolean validateLogin(String name, String pw) {
		boolean isValidUser = false;

		if (!isInstructor) {
			for (Student s : students) {
				if (name == s.getName() && pw == s.getPassword()) {
					isValidUser = true;
				}
			}
		}

		else if (isInstructor) {
			for (Instructor i : instructors) {
				if (name == i.getName() && pw == i.getPassword()) {
					isValidUser = true;
				}
			}
		}
		return isValidUser;
	}

	public ArrayList<Scenario> getScenarios() {
		return scenarios;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public ArrayList<Instructor> getInstructors() {
		return instructors;
	}
}
