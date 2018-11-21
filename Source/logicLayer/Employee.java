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
public class Employee extends User{

    public Employee(String name, String password, String type, String email) {
        super(name, password, "Employee", email);
    }  
}
