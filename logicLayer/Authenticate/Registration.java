/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicLayer.Authenticate;

/**
 *
 * @author Group 4.
 */
public class Registration extends User {

    public Registration(String name, String password, String type) {
        super(name, password, type);
    }

    //Registrates users
    public void registerUser(User user) {
        System.out.println("User registrated!");
    }
    
    //Returns true if user is already createt.
    public boolean checkUsername(String username) {
        return true;
    }

}
