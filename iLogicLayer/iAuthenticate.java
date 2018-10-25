
package iLogicLayer;
import logicLayer.User;
public interface iAuthenticate {
    
    void signIn(User user);
    void signOut(User user); 
    boolean isUserLoggedIn();

        
    }

  

   
