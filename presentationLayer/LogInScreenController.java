package presentationLayer;

import Interfaces.Ilogic.Ilogic;
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
import Interfaces.All.iAuthenticate;
import javafx.scene.Parent;
import logicLayer.User;

/**
 * FXML Controller class
 *
 * @author rasmu
 */
public class LogInScreenController implements Initializable {

    private Ilogic logic;
    static Scene scene;
    private Parent root;

    @FXML
    private TextField emailField;
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

    public LogInScreenController(Ilogic logic) {
        this.logic = logic;
    }

    public Ilogic getLogic() { //Method that return logic variable value
        return logic;
    }

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
        getUserEmail();
    }

    @FXML
    private void RegisterOnAction(ActionEvent event) {
    }

    
    private String getUserEmail(){
        System.out.println("Email used to login; " + emailField.getText());
        return logic.getUserEmail(emailField.getText());
    }
}
