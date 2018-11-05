package dataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.JOptionPane;

/**
 *
 * @author Borgar Bordoy
 */
public class DBconnect {

    Connection connection;
    String url = "jdbc:postgresql://tek-mmmi-db0a.tek.c.sdu.dk:5432/si3_2018_group_4_db";
    String user = "si3_2018_group_4";
    String password = "auto92-modal";

    public Connection dbConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
        try {
            DriverManager.getConnection(url, user, password);
//                JOptionPane.showMessageDialog(null, "Connected");
            System.out.println("Connected");
            
        } catch (SQLException ex) {
            Logger.getLogger(DBconnect.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(null, "Failed to connect");
            System.out.println("Failed to connect");
        }

        return connection;
    }
}
