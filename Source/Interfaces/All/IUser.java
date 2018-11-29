/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.All;

import LogicLayer.User;

/**
 *
 * @author mehgn
 */
public interface IUser {

   public void addUserToDataBase(String firstName, String lastName, String password, String type, String email);
}
