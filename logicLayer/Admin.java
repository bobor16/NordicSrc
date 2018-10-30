
package logicLayer;

public class Admin extends User{
    
    private String FAQ;

    public Admin(String name, String password, String type, String email) {
        super(name, password, type, email);
    }
    
    public void verifyManufacturerProfile(User user){
        
    }
    
    public void verifyCustomerProfile(User user){
        
    }
        
    public void searchProfile(User user){
        
    }
        // Next 3 methods need case parameter
    public void searchCase(){
        
    }
        
    public void acceptOrder(){
        
    }
        
    public void declineOrder(){
        
    }

    public String getFAQ() {
        return FAQ;
    }

    public void setFAQ(String FAQ) {
        this.FAQ = FAQ;
    }
    
}
