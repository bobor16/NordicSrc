/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import Interfaces.Ilogic.Ilogic;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mehgn
 */
public class RegisterViewController extends SuperController implements Initializable {

    @FXML
    private Button cancelButton;

    public RegisterViewController(Ilogic logic) {
        super(logic);
    }

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label passwordLabel;
    @FXML
    private TextField emailField;
    @FXML
    private Label emailLabel;
    @FXML
    private TextField verifyEmailField;
    @FXML
    private Label verifyEmailLabel;
    @FXML
    private TextField companyNameField;
    @FXML
    private TextField CVRField;
    @FXML
    private RadioButton manufacturerRadioButton;
    @FXML
    private RadioButton customerRadioButton;
    @FXML
    private RadioButton employeeRadioButton;
    @FXML
    private Label verifyPasswordLabel;
    @FXML
    private PasswordField verifyPasswordField;
    
    ApplicationStateHandler applicationStateHandler = new ApplicationStateHandler();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cancelButtonMethod(ActionEvent event) {
        applicationStateHandler.setLogInScreen(cancelButton);
    }

    
    @FXML
    private void registerMethod(ActionEvent event) {
    }

    
    
    
}
