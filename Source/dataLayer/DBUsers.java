package dataLayer;

import Interfaces.All.IUser;
import LogicLayer.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
	Run with:
	java -cp postgresql-42.2.1.jar:. DBTest
 */
public class DBUsers extends DBconnect implements IUser {

    String firstName;
    String lastName;
    String password;
    String type;
    String email;
    User tempUser;

   

    public void deleteUser(String email) {
        sendQuery("DELETE FROM Users WHERE Email = " + email);
    }

    public List<User> showUsers() {
        firstName = null;
        lastName = null;
        password = null;
        type = null;
        email = null;
        tempUser = null;

        List users = new ArrayList();

        try {
            dbConnection();
            Connection db = connection;
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Users");

            while (rs.next()) {
                try {
                    firstName = rs.getString(1);
                    lastName = rs.getString(2);
                    password = rs.getString(3);
                    type = rs.getString(4);
                    email = rs.getString(5);
                    tempUser = new User(firstName, lastName, password, type, email);
                    users.add(tempUser);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            rs.close();
            st.close();

            sendQuery("DELETE FROM Users WHERE Email = ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return users;
        }
    }

    public User getUserPassword(String email) {

        password = "";
        User tempUser = null;

        try {
            dbConnection();
            Connection db = connection;

            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Users WHERE Email = " + "'" + email + "'");
            while (rs.next()) {
                email = rs.getString(5);
                password = rs.getString(3);
                tempUser = new User(null, null, password, null, email);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return tempUser;
        }
    }

    public void changePassword(String email, String userPassword) {

        try {

            dbConnection();
            Connection db = connection;

            Statement st = db.createStatement();
            st.executeUpdate("UPDATE Users SET password = '" + userPassword + "' WHERE username = '" + email + "';");

        } catch (Exception e) {
        }
    }

    public User getuserType(String email) {

        String type = null;
        User tempUser = null;
        try {

            dbConnection();
            Connection db = connection;

            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("SELECT Type FROM Users WHERE email = " + "'" + email + "';");
            while (rs.next()) {
                type = rs.getString(4);
                tempUser = new User(null, null, null, type, null);
            }
            rs.close();
            st.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return tempUser;
    }
    
    public Boolean isUserExist(String email) {
        Boolean userExist = true;
        try {

            dbConnection();
            Connection db = connection;

            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery("select Email from Users where email = '" + email + "';");
            if(!rs.next()){
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return userExist;
    }

//   

    @Override
    public void addUserToDataBase(String firstName, String lastName, String password, String type, String email) {
        sendQuery("Insert into Users (FirstName, LastName, Password, Type, Email) VALUES (" + firstName + "," + lastName + "," + password + "," + type + "," + email + ")");
    }

}
