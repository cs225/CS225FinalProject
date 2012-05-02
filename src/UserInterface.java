/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Zack
 */

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

public interface UserInterface {
	boolean login(String name, String password);

}
