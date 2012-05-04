import java.io.Serializable;

// User should be an abstract class in my opinion, extended by instructor and
// student. It will be easier to retrieve and store data of a generic type
// "user" because Ramsey has to serialize an array of users to write as well as read
// in a serialized array.
// It will also be easier to determine if the user is a professor by using a
// parent class.
// User should hold fields for name, password, IDNumber(for data storage), and a
// boolean to determine if the user is a professor, as well as getters and
// setters for these variables.
// User should also implement serializable.
// Peter C

public abstract class User implements Serializable {

	// User name
	private String name;

	// password
	private String password;

	// used to connect students with completed scenarios
	private int userID;

	// used to determine if the user is an instructor to provide the user with
	// the proper application interface.
	private boolean isInstructor;

	public User(String name, String password, int userID) {
		this.name = name;
		this.password = password;
		this.userID = userID;
		this.isInstructor = false;
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

	public boolean isInstructor() {
		return isInstructor;
	}

	public void setInstuctor(boolean isInstructor) {
		this.isInstructor = isInstructor;
	}

	// validate login already exists in the simulation controller and will be
	// called in the button listener for the login button. It will pass the two
	// strings the user entered and compare them with all current user objects.

	// public boolean validateLogin(String userID, String password) {
	// if (userID.equals(this.userID) && this.password.equals(password))
	// return true;
	// else
	// return false;
	//
	// }
}
