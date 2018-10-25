/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicLayer;
// import iLogicLayer.iAuthenticate;


/**
 *
 * @author Martin Sorensen
 */
public class Authenticate {

    private boolean loggedIn;
    private String username;
    private String userPassword;
    private String userEnteredEmail;
    private boolean stillHasLoginAttempts;
 
    
    public Authenticate(){
        
    }
    
    //User signs in.
    public void signIn(User user) {
        System.out.println(user.getName()+" signed in");
    }

    //User signs out.
    public void signOut(User user) {
        System.out.println(user.getName()+" signed out");
    }

    //returns true if user is logged in.
    public boolean isUserLoggedIn() {
        return false;
    }
    private void checkLoginCredentials(){
        // need a method for checking characters / numbers input from user
    }
    public void setUserEnteredEmail(String userEnteredEmail) {
        this.userEnteredEmail = userEnteredEmail; 
    }
    
      
     public String getUserEnteredEmail() {
        return userEnteredEmail;
    }
     
    public void loginMethod(){ // Not working atm
       
      //  if(stillHasLoginAttempts && !isUserLoggedIn()){ add later
          if(true && true){
            System.out.println("User still has login attempts");
            User user = new User("morten","123","nordicsrc","morten@nordicsrc.com");
            
            if(userEnteredEmail.equals(user.getEmail())){
                signIn(user);
                System.out.println("Correct email and password");
            }
            else{
               // login attempt--
                System.out.println("Wrong email/password");
            }
            
        } else {
            
            System.out.println("No more login attempts");
        }
        
    }
    
    private boolean loginCredentialsValidation(User user){
        return true;
    }
    
    
    
    
}
