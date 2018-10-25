
package logicLayer;
import java.util.Date;

public class Bids {
    private int productPrice;
    private int shippingPrice;
    private int totalPrice;
    private String comment;

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(int shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public void cancelOrder(){
        
    }
    
    public void makeBid(){
        
    }
    
    public void changeBid(){
        
    }
    
    
}
