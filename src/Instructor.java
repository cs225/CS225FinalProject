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


public class Instructor implements UserInterface{
    String name, password;
    
    public Instructor(String name, String password){
        this.name = name;
        this.password = password;
    }
    public boolean login(String name, String password){
        String login = "name"+"password";
        if (login.equals(DataStorage.getLogin()){
            return true;
        }
        else
            return false;
        }
    }
    public void addSection(){
    }
    public void addStudent(){
    }
    public void removeSection(){
    }
    public void removeStudent(){
    }
    public void displayScores(){
    }
}
