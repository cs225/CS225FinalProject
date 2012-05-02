import java.io.Serializable;

//This will hold user session data
public class Session implements Serializable {

	private int sessionID;

	public Session(int userID) {
		this.sessionID = userID;
	}

	public Session() {

	}

	// session ID will equal the userID who submitted the session
	public int getSessionID() {
		return sessionID;
	}
}
