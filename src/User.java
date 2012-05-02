import java.io.Serializable;

// User should be an abstract class in my opinion, extended by instructor and
// student. It will be easier to retrieve and store data of a generic type
// "user" because I have to serialize an array of users to write as well as read
// in a serialized array.
// It will also be easier to determine if the user is a professor by using a
// parent class.
// User should hold fields for name, password, IDNumber(for data storage), and a
// boolean to determine if the user is a professor, as well as getters and
// setters for these variables.
// User should also implement serializable.
// Peter C

public abstract class User implements Serializable {

	private String name;
	private String password;
	private int userID;
	private boolean isProfessor;

	public User(String name, String password, int userID, boolean isProfessor) {
		this.name = name;
		this.password = password;
		this.userID = userID;
		this.isProfessor = isProfessor;
	}

	public User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public boolean isProfessor() {
		return isProfessor;
	}

	public void setProfessor(boolean isProfessor) {
		this.isProfessor = isProfessor;
	}
}
