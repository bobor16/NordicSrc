/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author marti
 */
public class CreateOrderViewController implements Initializable { // Todo: extends SuperController

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField verifyEmailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button placeOrderButton;
    @FXML
    private Button cancelButton;
    @FXML
    private PasswordField passwordField1;
    
     ApplicationStateHandler applicationStateHandler = new ApplicationStateHandler();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void PlaceOrderMethod(ActionEvent event) {
    }

    @FXML
    private void cancelButtonMethod(ActionEvent event) {
        applicationStateHandler.customerPortalView(cancelButton);
    }
    
}
