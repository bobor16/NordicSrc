/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataLayer;

import Interfaces.All.ISystemLog;
import LogicLayer.SystemLog;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mehgn
 */
public class DBSystemLog extends DBconnect implements ISystemLog {
    
      /*
    Initialize a SystemLog object with Strings whom gets their values from the SQL database in the SystemLog table
    returns a List with a SystemLog.
     */
    @Override
    public List<SystemLog> getSystemLog() {
         List systemLog = new ArrayList<>();
        SystemLog tempSystemLog = null;
        String log;
        try {

            dbConnection();
            Connection db = connection;

            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM SystemLog");
            while (rs.next()) {

                try {
                    log = rs.getString(1);
                    tempSystemLog = new SystemLog();
                    tempSystemLog.setSystemLog(log);
                    systemLog.add(tempSystemLog);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return systemLog;
        }
    }

    @Override
    public void setSystemLog(String systemLogText) {
         Date date = new Date();
        try {
            dbConnection();
            Connection db = connection;

            Statement st = db.createStatement();
            st.executeUpdate("insert into SystemLog(SystemLog) Values('" + date.toString() + " - " + systemLogText + "');");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void clearSystemLog() {
        
    }
    
    
    
}
