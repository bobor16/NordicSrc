/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicLayer;

import java.io.File;

/**
 *
 * @author Bruger
 */
public class ProductSpecification {
    
    private String productionPrice;
    private String numberOfItems;
    private String deliveryDeadline;
    private File detailedSpecification;

    public ProductSpecification(String productionPrice, String numberOfItems, String deliveryDeadline, File detailedSpecification){
        this.productionPrice = productionPrice;
        this.numberOfItems = numberOfItems;
        this.deliveryDeadline = deliveryDeadline;
        this.detailedSpecification = detailedSpecification;
    }
    
    public String getProductionPrice() {
        return productionPrice;
    }

    public void setProductionPrice(String productionPrice) {
        this.productionPrice = productionPrice;
    }

    public String getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(String numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public String getDeliveryDeadline() {
        return deliveryDeadline;
    }

    public void setDeliveryDeadline(String deliveryDeadline) {
        this.deliveryDeadline = deliveryDeadline;
    }
    
    
    
}
