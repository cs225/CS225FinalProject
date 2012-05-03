/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Zack
 */


// should extend user rather than implementing the user interface
// See comment in instructor.
// Please also add in an ID number so we can link completed scenarios with users easily.
// also please add a string that denotes what "Session" the user is in, to make it easy to group the users later. 
// most of this is handled in the class User at this time but use it as a base for your two other classes 
// PJ makes a good point that User should be abstract, and the two types should extend it. 
// We can then make an array of just Users which can be of either type.--RH

public class Student implements UserInterface {

	private String name, password;

	public Student(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public boolean login(String name, String password) {
		String login = "name" + "password";
		if (login.equals(DataStorage.getLogin())) { //Login should be handled in the controller.
			return true;
		} else
			return false;
	}

	public void displayComplete() {
	}
}
