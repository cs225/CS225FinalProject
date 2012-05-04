package CS225FinalProject.DataStructure;

//Added Completed Scenarios to the user object, so that they can be more easily organized.
import java.util.ArrayList;

public class Student extends User {

	private String className;
	private ArrayList<CompletedScenario> completedScenarios = new ArrayList<CompletedScenario>();

	// private ArrayList<CompletedScenarios> studentData;

	public Student(String name, String password, int userID) {
		super(name, password, userID);
	}

	public Student(String name, String password, int userID, String className) {
		super(name, password, userID);
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void addCompletedScenario(CompletedScenario cs) {

		completedScenarios.add(cs);

	}

	public ArrayList<CompletedScenario> getCompletedScenarios() {
		return completedScenarios;
	}

	public void setCompletedScenarios(
			ArrayList<CompletedScenario> completedScenarios) {
		this.completedScenarios = completedScenarios;
	}

}
