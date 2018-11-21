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
import java.io.File;
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

    @Override
    public String getEmail() {
        return data.getEmail();
    }

    @Override
    public String getFirstName() {
        return data.getFirstName();
    }
    @Override
    public void setFirstName(String firstName) {
        data.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return data.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        data.setLastName(lastName);
    }

    @Override
    public String getPassword() {
        return data.getPassword();
    }

    @Override
    public void setPassword(String password) {
        data.setPassword(password);
    }

    @Override
    public String getType() {
        return data.getType();
    }

    @Override
    public void setType(String type) {
        data.setType(type);
    }

    @Override
    public void setEmail(String email) {
        data.setEmail(email);
    }

    public Boolean passwordCheck(String password) {
        return passwordChecker.checkPassword(password);
    }
}
