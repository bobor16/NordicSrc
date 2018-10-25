/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicLayer;

public class User {
   
    private String name;
    private String password;
    private String type;
    private String email;
    private String userEnteredEmail;
    private int loginAttempts;
    
    
    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserEnteredEmail() {
        return userEnteredEmail;
    }

    public void setUserEnteredEmail(String userEnteredEmail) {
        this.userEnteredEmail = userEnteredEmail;
    }
    
    public User(String name, String password, String type, String email){
        this.name = name;
        this.password = password;
        this.type = type;
    }
    
    
    
}
