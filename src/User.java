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

        /*
         * Name of the student
         */
	private String name;
        
        
	private String password;
        
        /*
         * Username
         */
	private String userID;
        
        
	

	public User(String name, String userID, String password ) {
		this.name = name;
		this.password = password;
		this.userID = userID;
		
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
	
    
    public boolean isProfessor() {
		return isProfessor;
	}
        
    public boolean validateLogin( String userID, String password ){
        if(userID.equals(this.userID)&&this.password.equals(password))
            return true;
        else
            return false;
        
    }
}
