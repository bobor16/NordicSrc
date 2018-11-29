/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataLayer;

/**
 *
 * @author mehgn
 */
import Interfaces.Ilogic.Ilogic;
import Interfaces.Idata.Idata;
import LogicLayer.Case;
import LogicLayer.LogicFacade;
import LogicLayer.SystemLog;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mehgn
 */
public class DataFacade implements Idata {

    private static Idata data;
    private static Ilogic logic;
    private DBUsers DBUsers;
    private DBSystemLog DBSystemlog;
    private DBCase DBCase;

    public DataFacade() {
        DBUsers = new DBUsers();
        DBSystemlog = new DBSystemLog();
        DBCase = new DBCase();
    }

    public static Idata getInstance() {
        return data;
    }

    @Override
    public void injectLogic(Ilogic logic) {
        this.logic = logic;
    }

    @Override
    public List<SystemLog> getSystemLog() {
        return DBSystemlog.getSystemLog();
    }

    @Override
    public void setSystemLog(String systemLogText) {
        DBSystemlog.setSystemLog(systemLogText);
    }

    @Override
    public void clearSystemLog() {
        DBSystemlog.clearSystemLog();
    }

    @Override
    public ArrayList<Case> getCaseList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUserToDataBase(String firstName, String lastName, String password, String type, String email) {
        DBUsers.addUserToDataBase(firstName, lastName, password, type, email);
    }
}

