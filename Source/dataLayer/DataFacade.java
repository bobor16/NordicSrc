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
import Server.LogicLayer.SystemLog;
import Interfaces.Idata.Idata;
import java.util.List;

/**
 *
 * @author mehgn
 */
public class DataFacade implements Idata {

    private static Idata data;
    private static Ilogic logic;
    DBUsers DBUsers;
    DBSystemLog DBSystemlog;

    public DataFacade() {
        DBUsers = new DBUsers();
        DBSystemlog = new DBSystemLog();
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
    public String getEmail() {
        return DBUsers.getEmail();
    }

    @Override
    public String getFirstName() {
        return DBUsers.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        DBUsers.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return DBUsers.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        DBUsers.setLastName(lastName);
    }

    @Override
    public String getPassword() {
        return DBUsers.getPassword();
    }

    @Override
    public void setPassword(String password) {
        DBUsers.setPassword(password);
    }

    @Override
    public String getType() {
        return DBUsers.getType();
    }

    @Override
    public void setType(String type) {
        DBUsers.setType(type);
    }

    @Override
    public void setEmail(String email) {
        DBUsers.setEmail(email);
    }
}

