package dataLayer;

import Interfaces.All.IUser;
import dataLayer.DBconnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import logicLayer.User;

/*
	Run with:
	java -cp postgresql-42.2.1.jar:. DBTest
 */
public class DBUsers extends DBconnect implements IUser {

 
    public String getUserEmail(String userEmail) {

//        String userType = null; 
//        try {
//            Connection db = connection;
//
//            Statement st = db.createStatement();
//            ResultSet rs = st.executeQuery("SELECT usertype FROM users WHERE username = " + "'" + username + "';");
//            while (rs.next()) {
//                userType = rs.getString(1);
//            }
//            rs.close();
//            st.close();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return userType;
        System.out.println("userEmail in dataUser" + userEmail);
        return userEmail;
    }

//   
}
