/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataLayer;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author mehgn
 */
public class DBconnect {
//    private final String url = "jdbc:mysql://" + "5.9.118.242" + ":" + "3306" + "/" + "hartmann?autoReconnect=true&useSSL=false";
    private final String url = "";
    public static final String DATABASE = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    public Connection connection = null;

    private static final String IP = "";
    private static final int PORT = 0000;

    
    /*
    Connects to the database with the specified url and gains acces with the USERNAME and PASSWORD variables.
    */
    public void dbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE + "?serverTimezone=UTC&useSSL=false";
            this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
