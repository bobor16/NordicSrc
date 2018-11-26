package dataLayer;

import Interfaces.All.IUser;

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

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public void setFirstName(String firstName) {
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void setLastName(String lastName) {
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String password) {
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void setType(String type) {
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public void setEmail(String email) {
    }
}
