/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicLayer;

import java.io.File;

/**
 *
 * @author mehgn
 */
public class Order implements java.io.Serializable {

    private static final long serialVersionUID = -7279684461532176262L;


    private int id;
    private String title;
    private String customer;
    private String manufactorer;
    private boolean archived;
    private int amount;
    private double priceper;
    private double pricetotal;
    private String completionDate;
    private String deliveryDate;
    private String deadline;
    private File ps;
    private Boolean status;
    private String briefdescription;
    private String psname;
    private byte[] psBytes;

    public Order(int id, String title, String customer, String manufactorer, boolean archived, int amount, double priceper, double pricetotal, String completionDate, String deliveryDate, String deadline, String briefdescription) {
        this.id = id;
        this.title = title;
        this.customer = customer;
        this.manufactorer = manufactorer;
        this.archived = archived;
        this.amount = amount;
        this.priceper = priceper;
        this.pricetotal = pricetotal;
        this.completionDate = completionDate;
        this.deliveryDate = deliveryDate;
        this.deadline = deadline;
        this.briefdescription = briefdescription;
    }

    public Order(int id, String title, int psid, String customer, String manufactorer, boolean archived, int amount, double priceper, double pricetotal, String completionDate, String deliviryDate, String deadline, String briefdescription, Boolean status) {
        this.id = id;
        this.title = title;
        this.customer = customer;
        this.manufactorer = manufactorer;
        this.archived = archived;
        this.amount = amount;
        this.priceper = priceper;
        this.pricetotal = pricetotal;
        this.completionDate = completionDate;
        this.deliveryDate = deliveryDate;
        this.deadline = deadline;
        this.briefdescription = briefdescription;
        this.status = status;
    }

    public Order(String title, int amount, double priceper, double pricetotal, String completionDate, String deliveryDate, String deadline, String briefdescription, String psname) {
        this.title = title;
        this.archived = false;
        this.amount = amount;
        this.priceper = priceper;
        this.pricetotal = pricetotal;
        this.completionDate = completionDate;
        this.deliveryDate = deliveryDate;
        this.deadline = deadline;
        this.briefdescription = briefdescription;
        this.psname = psname;
    }

    public Order(String title, int amount){
        this.title = title;
        this.amount = amount;
    }


    public String getTitle() {
        return this.title;
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

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getBriefdescription() {
        return briefdescription;
    }

    public void setBriefdescription(String briefdescription) {
        this.briefdescription = briefdescription;
    }

    public String getPsname() {
        return psname;
    }

    public void setPsname(String psname) {
        this.psname = psname;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getManufactorer() {
        return manufactorer;
    }

    public void setManufactorer(String manufactorer) {
        this.manufactorer = manufactorer;
    }

    
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public byte[] getPsBytes() { return psBytes; }

    public void setPsBytes(byte[] psBytes) { this.psBytes = psBytes; }
}
