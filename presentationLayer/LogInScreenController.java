package presentationLayer;

import Interfaces.Ilogic.Ilogic;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.Parent;
import static sun.net.www.protocol.http.AuthCacheValue.Type.Server;

/**
 * FXML Controller class
 *
 * @author rasmu
 */
public class LogInScreenController extends SuperController implements Initializable {

    static Scene scene;
    private Parent root;

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField PasswordField;
    @FXML
    private Button LoginButton;
    @FXML
    private Button registerButton;
    @FXML
    private Label passwordMsgLabel;
    @FXML
    private Label ResetPasword;
    
    private Ilogic logic;
    
    ApplicationStateHandler stateHandler = new ApplicationStateHandler();

    public LogInScreenController(Ilogic logic) {
        super(logic);
    }

//    public Ilogic getLogic() { //Method that return logic variable value
//        return logic;
//    }

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void pressEnter(KeyEvent event) throws IOException {
    }

    @FXML
    private void LoginOnAction(ActionEvent event) {
        
        
        //Login as admin
            if(PasswordField.getText().equalsIgnoreCase("Admin") && emailField.getText().equalsIgnoreCase("Admin"))  stateHandler.setAdminPortalView(LoginButton);

        //Login as manufactorer
            if(PasswordField.getText().equalsIgnoreCase("manufactorer") && emailField.getText().equalsIgnoreCase("manufactorer"))stateHandler.setManufactorerPortalView(LoginButton);
            
        //Logic as Costumer
            if(PasswordField.getText().equalsIgnoreCase("customer") && emailField.getText().equalsIgnoreCase("customer"))stateHandler.customerPortalView(LoginButton);
    }

    @FXML
    private void registerOnAction(ActionEvent event) {
        //Registrer button
            stateHandler.setRegisterPortalView(registerButton);
    }

    private void setEmail() {
        System.out.println("Email used to login; " + emailField.getText());
        logic.setEmail(emailField.getText());
    }
}
