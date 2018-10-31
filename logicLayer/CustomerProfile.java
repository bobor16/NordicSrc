/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicLayer;

/**
 *
 * @author Bruger
 */
public class CustomerProfile extends User {
    
    private String eMail;
    private String companyName;
    private String CVRnumber;
    private Boolean verified;

    public CustomerProfile(String name, String password, String type, String email) {
        super(name, password, type, email);
    }
    
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCVRnumber() {
        return CVRnumber;
    }

    public void setCVRnumber(String CVRnumber) {
        this.CVRnumber = CVRnumber;
    }
    
    public Boolean isVerified(){
        return verified == true;
    }
    
    public void placeOrder(){
        
    }
    
    
}
