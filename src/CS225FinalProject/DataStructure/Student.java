package CS225FinalProject.DataStructure;
/**
 * 
 * @author Zack
 */

// should extend user rather than implementing the user interface
// See comment in instructor.
// Please also add in an ID number so we can link completed scenarios with users
// easily.
// also please add a string that denotes what "Session" the user is in, to make
// it easy to group the users later.
// most of this is handled in the class User at this time but use it as a base
// for your two other classes
// PJ makes a good point that User should be abstract, and the two types should
// extend it.
// We can then make an array of just Users which can be of either type.--RH

/*
 * Msg from Eric:
 * 
 * Both Student and Proffesor should extend the abstract class User, as
 * suggested/Provided by Peter&Ramsey. Then refer to my
 * CS225FinalProject.DataStructure.StudentRecord class as a sort of template for
 * getting the the results. The booleans method setDone and getDone should not
 * be implemented because we dont know how many test they will give and also we
 * want to make this program flexible for the proffesors.
 * 
 * 
 * the adding/removing/editing the scenarios is managed by the Controller.
 */

public class Student extends User {

	private String className;

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

	// public void displayComplete() {
	// }
}
