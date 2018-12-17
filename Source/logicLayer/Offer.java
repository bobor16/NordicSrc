/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicLayer;

import java.io.Serializable;

/**
 *
 * @author mehgn
 */
public class Offer implements Serializable{

    private int offerID;
    private int orderID;
    private int amount;
    private String manfemail;
    private String psName;

    public String getManfemail() {
        return manfemail;
    }

    public void setManfemail(String manfemail) {
        this.manfemail = manfemail;
    }
    private double priceper;
    private double pricetotal;
    private String completionDate;
    private String deliveryDate;
    private String briefDescription;
    private byte[] psBytes;
    

    public int getOfferID() {
        return offerID;
    }

    public void setOfferID(int offerID) {
        this.offerID = offerID;
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

    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public byte[] getPsBytes() {
        return psBytes;
    }

    public void setPsBytes(byte[] psBytes) {
        this.psBytes = psBytes;
    }

    public Offer(int orderID, int amount, double priceper, double pricetotal, String completionDate, String deliveryDate, String briefDescription, String psName, byte[] psBytes) {
        this.orderID = orderID;
        this.amount = amount;
        this.priceper = priceper;
        this.pricetotal = pricetotal;
        this.completionDate = completionDate;
        this.deliveryDate = deliveryDate;
        this.briefDescription = briefDescription;
        this.psName = psName;
        this.psBytes = psBytes;
        
    }

    public int getOrderID() {
        return orderID;
    }

    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    

}
