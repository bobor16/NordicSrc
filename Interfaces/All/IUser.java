/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.All;

/**
 *
 * @author mehgn
 */
public interface IUser {

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);

    public String getPassword();

    public void setPassword(String password);

    public String getType();

    public void setType(String type);

    public String getEmail();

    public void setEmail(String email);
}
