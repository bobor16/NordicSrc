/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicLayer;

/**
 *
 * @author Martin Sorensen
 */
public class Authenticate {

    private boolean loggedIn;

    //User signes in.
    public void signIn(User user) {
        System.out.println("User signed in");
    }

    //User signes out.
    public void signOut(User user) {
        System.out.println("User signed out");
    }

    //returns true if user is logged in.
    public boolean isUserLoggedIn(User user) {
        return true;
    }

}
