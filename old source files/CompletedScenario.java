import java.io.Serializable;

//This will hold user session data
public class CompletedScenario implements Serializable {

	private int scenarioID;

	public CompletedScenario(int userID) {
		this.scenarioID = userID;
	}

	public CompletedScenario() {
	}

	// scenario ID will match the userID who submitted the completed scenario
	public int getScenarioID() {
		return scenarioID;
	}
}
