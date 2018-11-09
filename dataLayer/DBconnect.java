package dataLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.JOptionPane;

/**
 *
 * @author Borgar Bordoy
 */
public class DBconnect {

    static Connection connection;
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
            System.out.println("Successfully connected to the server!");

        } catch (SQLException ex) {
            Logger.getLogger(DBconnect.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(null, "Failed to connect");
            System.out.println("Failed to connect to server");
        }

        return connection;
    }

    public ArrayList<String> sendQuery(String query) {
        ArrayList<String> result = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }

        try (Connection db = DriverManager.getConnection(url, user, password);
                Statement st = db.createStatement();
                ResultSet rs = st.executeQuery(query);) {
            while (rs.next()) {
                int i = 1;
                while (i < rs.getMetaData().getColumnCount()) {
                    result.add(rs.getString(i));
                    i++;
                }
                result.add(rs.getString(i));
            }
            System.out.println(result);

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public void insertImage() {
        File img = new File("C:\\Users\\borga\\Documents\\NetBeansProjects\\NordicSrc/klarborg-nisser-Martin-80-cm-designet-af-etly-klarborg.jpg");
        String query = "INSERT INTO productspecification(psid, image) VALUES(?,?)";
        try (Connection con = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = con.prepareStatement(query)) {

            try (FileInputStream fin = new FileInputStream(img)) {
                pst.setInt(1, 1);
                pst.setBinaryStream(2, fin, (int) img.length());
                pst.executeUpdate();
            } catch (IOException ex) {
                Logger.getLogger(DBconnect.class.getName()).log(
                        Level.SEVERE, ex.getMessage(), ex);
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DBconnect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public static void main(String[] args) throws SQLException {
        DBconnect db = new DBconnect();
        db.sendQuery("SELECT * FROM users");
        db.insertImage();
    }
}
