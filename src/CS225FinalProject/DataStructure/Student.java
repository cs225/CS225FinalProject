package CS225FinalProject.DataStructure;

import java.util.ArrayList;

//Added Completed Scenarios to the user object, so that they can be more easily organized.
public class Student extends User {

	private String className, realName;
	private ArrayList<CompletedScenario> completedScenarios = new ArrayList<CompletedScenario>();

	/*
	 * student constructor takes in the name that is displayed when the user
	 * logs in, the password the user needs to log in the username so that the
	 * teach can tell who the name belongs to and the user ID
	 */
	public Student(String userName, String realName, String password,
			int userID, String className) {
		super(userName, password, userID);
		this.realName = realName;
		this.className = className;
	}

	/* the getUsername method simply returns the username */
	public String getRealName() {
		return realName;
	}

	/* the setUsername method sets the assigned username to the user */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/* getClassName returns the section the user is in */

	public String getClassName() {
		return className;
	}

	/* setClassName assigned the section to the user */
	public void setClassName(String className) {
		this.className = className;
	}

	/* addComletedScenarios adds to the list of completed scanarios */
	public void addCompletedScenario(CompletedScenario cs) {
		completedScenarios.add(cs);
	}

	/* ArrayList returns the list of complete scenarios */
	public ArrayList<CompletedScenario> getCompletedScenarios() {
		return completedScenarios;
	}

	/* setCompletedScenarios sets what is completed */
	public void setCompletedScenarios(
			ArrayList<CompletedScenario> completedScenarios) {
		this.completedScenarios = completedScenarios;
	}
}
