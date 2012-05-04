/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Zack
 */

// should extend user rather than implementing the user interface
// Zack! you write public class Instructor implements UserInterface
// UserInterface is not a class; instead User is an interface.
// So this should say Instructor implements User (which is an interface) --RH

public class Instructor extends User {

	public Instructor(String name, String password, int userID) {
		super(name, password, userID);
		this.setInstuctor(true);
	}

	// all of these methods will be handled in the GUI classes and simulation
	// controller

	// public boolean login(String name, String password){
	// String login = "name"+"password";
	// if (login.equals(DataStorage.getLogin()){
	// return true;
	// }
	// else
	// return false;
	// }
	// }
	// public void addSection(){
	// }
	// public void addStudent(){
	// }
	// public void removeSection(){
	// }
	// public void removeStudent(){
	// }
	// public void displayScores(){
	// }
}
