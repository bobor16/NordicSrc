/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicLayer;

/**
 *
 * @author mehgn
 */
public class Costumer extends User{

    public Costumer(String name, String password, String type, String email) {
        super(name, password, "Customer", email);
    }
    
    
}
