/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicLayer;

/**
 *
 * @author mehgn
 */
public class order {
    private String title;
    private int id;
    private int psid;
    private String customer;
    private boolean archived;
    private int amount;
    private double priceper;
    private double pricetotal;
    private String completionDate;
    private String deliviryDate;
    private String briefdescription;

    public order(String title, int id, int psid, String customer, boolean archived, int amount, double priceper, double pricetotal, String completionDate, String deliviryDate, String briefdescription) {
        this.title = title;
        this.id = id;
        this.psid = psid;
        this.customer = customer;
        this.archived = archived;
        this.amount = amount;
        this.priceper = priceper;
        this.pricetotal = pricetotal;
        this.completionDate = completionDate;
        this.deliviryDate = deliviryDate;
        this.briefdescription = briefdescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPsid() {
        return psid;
    }

    public void setPsid(int psid) {
        this.psid = psid;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPriceper() {
        return priceper;
    }

    public void setPriceper(double priceper) {
        this.priceper = priceper;
    }

    public double getPricetotal() {
        return pricetotal;
    }

    public void setPricetotal(double pricetotal) {
        this.pricetotal = pricetotal;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    public String getDeliviryDate() {
        return deliviryDate;
    }

    public void setDeliviryDate(String deliviryDate) {
        this.deliviryDate = deliviryDate;
    }

    public String getBriefdescription() {
        return briefdescription;
    }

    public void setBriefdescription(String briefdescription) {
        this.briefdescription = briefdescription;
    }
    
            
}
