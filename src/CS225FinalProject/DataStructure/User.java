package CS225FinalProject.DataStructure;

import java.io.Serializable;

public abstract class User implements Serializable {

	// Login name
	private String userName;

	// password
	private String password;

	// used to connect students with completed scenarios
	private int userID;

	// used to determine if the user is an instructor to provide the user with
	// the proper application interface.
	private boolean isInstructor;

	public User(String userName, String password, int userID) {
		this.userName = userName;
		this.password = password;
		this.userID = userID;
		this.isInstructor = false;
	}

	public User() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = name;
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

	public abstract String getClassName();

	public abstract void setClassName(String className);

	public abstract String getRealName();

	public abstract void setRealName(String realName);
}
