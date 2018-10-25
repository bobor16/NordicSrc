/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicLayer;
import iLogicLayer.iAuthenticate;

/**
 *
 * @author Martin Sorensen
 */
public class Authenticate implements iAuthenticate {

    private boolean loggedIn;
    private int loginAttempts;
    private String username;
    private String userPassword;
    //private boolean 
    
    public Authenticate(){
        
    }
    
    //User signes in.
    public void signIn(User user) {
        System.out.println("User signed in");
    }

    //User signes out.
    public void signOut(User user) {
        System.out.println("User signed out");
    }

    //returns true if user is logged in.
    public boolean isUserLoggedIn() {
        return false;
    }
    private void checkLoginCredentials(){
        
    }
    private void loginMethod(){
        
        if(loginAttempts<3 && !isUserLoggedIn()){
            User user = new User("morten@nordicsrc.com","123","nordicsrc");
        }
        
    }
}
