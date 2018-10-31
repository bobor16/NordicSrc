/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataLayer;

import Interfaces.Idata.Idata;
import Interfaces.Ilogic.Ilogic;

/**
 *
 * @author mehgn
 */
public class DataFacade implements Interfaces.Idata.Idata{
    
    private static Idata data;
    private static Ilogic logic;
    DBUsers DBUsers;
    public DataFacade() {
         DBUsers = new DBUsers();
    }

    public static Idata getInstance() {
        return data;
    }

    @Override
    public void injectLogic(Ilogic logic) {
        this.logic = logic;
    }

    @Override
    public String getUserEmail(String userEmail) {
        System.out.println("userEmail in datafacade" + userEmail);
        return DBUsers.getUserEmail(userEmail);
    }

}
