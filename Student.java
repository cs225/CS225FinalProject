/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zack
 */
public class Student implements UserInterface{
    
    String name, password;
    
    public Student(String name, String password){
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
    public void displayComplete(){
    }
    
}
