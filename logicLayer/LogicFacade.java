/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicLayer;

import Interfaces.Idata.Idata;
import Interfaces.Ilogic.Ilogic;

/**
 *
 * @author mehgn
 */
public class LogicFacade implements Interfaces.Ilogic.Ilogic {

    private static Idata data;
    private static Ilogic logic;

    private PasswordValidation passwordChecker = new PasswordValidation();

    @Override
    public void injectData(Idata data) {
        this.data = data;
    }

    public LogicFacade() {
    }

    public static Ilogic getInstance() {
        return logic;
    }

    @Override
    public Boolean passwordCheck(String password) {
        return passwordChecker.checkPassword(password);
    }

    @Override
    public void signIn(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void signOut(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isUserLoggedIn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loginMethod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUserEnteredEmail(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getUserName(){
        
    }

}
