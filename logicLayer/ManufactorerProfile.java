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
public class ManufactorerProfile {
    
    private String eMail;
    private String companyName;
    private String CVRnumber;

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCVRnumber(String CVRnumber) {
        this.CVRnumber = CVRnumber;
    }

    public String geteMail() {
        return eMail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCVRnumber() {
        return CVRnumber;
    }
    
    public void placeOffer(){
        
    }
}
