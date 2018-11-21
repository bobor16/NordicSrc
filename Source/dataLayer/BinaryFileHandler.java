/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.dataLayer;

import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author mehgn
 */
public class BinaryFileHandler {
    
    DBconnect dbconnect = new DBconnect();
    File file;
    FileInputStream fis;
    PreparedStatement ps;

    public BinaryFileHandler() {
        
        try {
            this.fis = new FileInputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectfilePath(String filePath){
        file  = new File(filePath);
    }
    
    
    
    public void uploadFile() {
        try {
            dbconnect.dbConnection().prepareStatement("INSERT INTO images VALUES (?, ?)");
            ps.setString(1, file.getName());
            ps.setBinaryStream(2, fis, file.length());
            ps.executeUpdate();
            ps.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void retrieveFile() {
        try{
        PreparedStatement ps = dbconnect.dbConnection().prepareStatement("SELECT img FROM images WHERE imgname = ?");
        ps.setString(1,"myimage.gif");
        ResultSet rs = ps.executeQuery();
        if (rs != null) {
            while (rs.next()) {
                byte[] imgBytes = rs.getBytes(1);
                // use the data in some way here
            }
            rs.close();
        }
        ps.close();
    } catch(Exception e){
        e.printStackTrace();
    }
    }

}
