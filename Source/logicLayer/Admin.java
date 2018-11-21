/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicLayer;

/**
 *
 * @author mehgn
 */
public class Admin extends User{
    
    public Admin(String name, String password, String type, String email) {
        super(name, password, "Admin", email);
    }
}
