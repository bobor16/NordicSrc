
package presentationLayer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logicLayer.Authenticate; // Fix this when adding three layer architecture
import iLogicLayer.iAuthenticate;
import logicLayer.User;
/**
 * FXML Controller class
 *
 * @author rasmu
 */
public class LogInScreenController implements Initializable {

    @FXML
    private TextField EmailField;
    @FXML
    private PasswordField PasswordField;
    @FXML
    private Button LoginButton;
    @FXML
    private Button RegisterButton;
    @FXML
    private Label passwordMsgLabel;
    @FXML
    private Label ResetPasword;
    

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pressEnter(KeyEvent event) throws IOException {
    }

    @FXML
    private void LoginOnAction(ActionEvent event) { // not working atm
        
      
       //  iAuthenticate iauthenticate = new Authenticate(); // For when implementing interface?
       Authenticate authenticate = new Authenticate();
      
       User currentUser = new User("none","none","none","morten@nordicsrc.com");
       currentUser.setEmail(EmailField.getText());
       
       authenticate.setUserEnteredEmail(currentUser.getEmail());
       authenticate.loginMethod(); 
        
        
        
    }

    @FXML
    private void RegisterOnAction(ActionEvent event) {
    }
    
}
