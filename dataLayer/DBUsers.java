//package prototype.Data;
//
//import dataLayer.DBconnect;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import logicLayer.User;
//
///*
//	Run with:
//	java -cp postgresql-42.2.1.jar:. DBTest
// */
//public class DBUsers extends DBconnect {
//
//    /*
//    Creates new row in the cases table with userNamem, userPassword and type as values. 
//    @param type refers to the user type.
//     */
//    public void createUser(String userName, String userPassword, String type) {
//
//        try {
//            dbConnect();
//            Connection db = connection;
//            Statement st = db.createStatement();
//            st.executeUpdate("Insert into users(username, password, usertype) Values(" + "'" + userName + "'" + "," + "'" + userPassword + "'" + "," + "'" + type + "'" + ");");
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//    }
//
//    /*
//    Initialize a User object with Strings whom gets their values from the SQL database in the users table.
//    returns a List stored with Users objects.
//     */
//    public List<User> displayUsers() {
//        String username = null;
//        String userEmail = null;
//        String companyEmail = null;
//        String userType = null;
//
//        User tempUser = null;
//        List users = new ArrayList<>();
//        try {
//            dbConnect();
//            Connection db = connection;
//
//            Statement st = db.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM users");
//            while (rs.next()) {
//
//                try {
//                    username = rs.getString(1);
//                    userEmail = rs.getString(2);
//                    companyEmail = rs.getString(3);
//                    userType = rs.getString(4);
//                    tempUser = new User(username, userEmail, companyEmail, userType);
//                    users.add(tempUser);
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
//            }
//            rs.close();
//            st.close();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            return users;
//        }
//    }
//
//    public User userRetrieve(String userName) {
//
//        User tempUser = null;
//        String userPassword = "";
//
//        try {
//
//            dbConnect();
//            Connection db = connection;
//
//            Statement st = db.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE username = " + "'" + userName + "'");
//            while (rs.next()) {
//                userName = rs.getString(1);
//                userPassword = rs.getString(2);
//                tempUser = new User(userName, userPassword, "");
//            }
//            rs.close();
//            st.close();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            return tempUser;
//        }
//    }
//
//    public void deleteUser(String userName) {
//
//        try {
//
//            dbConnect();
//            Connection db = connection;
//
//            Statement st = db.createStatement();
//            st.executeUpdate("DELETE FROM users WHERE username = '" + userName + "'");
//            st.close();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public void changePassword(String userName, String userPassword) {
//
//        try {
//
//            dbConnect();
//            Connection db = connection;
//
//            Statement st = db.createStatement();
//            st.executeUpdate("UPDATE users SET password = '" + userPassword + "' WHERE username = '" + userName + "';");
//
//        } catch (Exception e) {
//        }
//    }
//
//    public String getuserType(String userName) {
//
//        String userType = null;
//
//        try {
//
//            dbConnect();
//            Connection db = connection;
//
//            Statement st = db.createStatement();
//            ResultSet rs = st.executeQuery("SELECT usertype FROM users WHERE username = " + "'" + userName + "';");
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
//    }
//
//    public List<String> getUserNames() {
//        List<String> usernames = new ArrayList<>();
//        String username = null;
//        try {
//
//            dbConnect();
//            Connection db = connection;
//
//            Statement st = db.createStatement();
//            ResultSet rs = st.executeQuery("select username from users");
//            while (rs.next()) {
//                username = rs.getString(1);
//                usernames.add(username);
//            }
//            rs.close();
//            st.close();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return usernames;
//    }
//
//    public Boolean isUserExist(String username) {
//        Boolean userExist = true;
//        try {
//
//            dbConnect();
//            Connection db = connection;
//
//            Statement st = db.createStatement();
//            ResultSet rs = st.executeQuery("select username from users where username = '" + username + "';");
//            if (!rs.next()) {
//                return false;
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return userExist;
//    }
//}
