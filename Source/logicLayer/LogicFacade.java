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
import Interfaces.Ilogic.Ilogic;
import Interfaces.Idata.Idata;
import dataLayer.DBCase;
import dataLayer.DBUsers;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
    public List<SystemLog> getSystemLog() {
        return data.getSystemLog();
    }

    @Override
    public void setSystemLog(String systemLogText) {
        data.setSystemLog(systemLogText);
    }

    @Override
    public void clearSystemLog() {
        data.clearSystemLog();
    }

    public Boolean passwordCheck(String password) {
        return passwordChecker.checkPassword(password);
    }

    @Override
    public void addCaseToList(Case aCase) {
    }

    @Override
    public ArrayList<Case> getCaseList() {
        return data.getCaseList();
    }
    
    public static void main(String[] args) {
        LogicFacade s = new LogicFacade();
        for(int i = 0; i < s.getCaseList().size(); i++){
            s.getCaseList().get(i).getCaseName();
        }
    }

    @Override
    public void addUserToDataBase(String firstName, String lastName, String password, String type, String email) {
        data.addUserToDataBase(firstName, lastName, password, type, email);
    }

    
}
