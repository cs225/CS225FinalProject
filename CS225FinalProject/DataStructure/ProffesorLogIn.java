package CS225FinalProject.DataStructure;

import java.io.Serializable;

/**
 *
 * @author Eric
 */
public class ProffesorLogIn implements Serializable{
    private String userName;
    private String passWord;

    public ProffesorLogIn(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public ProffesorLogIn() {
        userName = "default";
        passWord = "default";
    }
    
    
    public boolean validateLogin(String username,String password){
        if(username.equals(userName)&&
           password.equals(passWord))
            return true;
        else 
            return false;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
}
