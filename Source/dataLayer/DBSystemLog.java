/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataLayer;

import Interfaces.All.ISystemLog;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mehgn
 */
public class DBSystemLog implements ISystemLog {
    
    @Override
    public List getSystemLog() {
        List systemLog = new ArrayList();
        try {
//            dbConnect();
//            Connection db = connection;
//
//            Statement st = db.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM SystemLog");
//            while (rs.next()) {
//
//                try {
//                    tempSystemLog.setSystemLog(rs.getString(1));
//                    tempSystemLog = new SystemLog(log);
//                    systemLog.add(tempSystemLog);
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
//            }
//            rs.close();
//            st.close();
    
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return systemLog;
        }
    }

    @Override
    public void setSystemLog(String systemLogText) {
//        SystemLog tempSystemLog = new SystemLog();
        System.out.println("SystemLog has been set to " + systemLogText);
    }

    @Override
    public void clearSystemLog() {
    }
    
    
    
}
