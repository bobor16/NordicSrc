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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author rasmu
 */
public class LogInScreenController implements Initializable {

    @FXML
    private TextField UsernameBox;
    @FXML
    private PasswordField PasswordBox;
    @FXML
    private Button LogOnButton;
    @FXML
    private Button ResetPasswordButton;
    @FXML
    private Label passwordMsgLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pressEnter(KeyEvent event) {
    }

    @FXML
    private void LogOnButtonAction(ActionEvent event) {
    }

    @FXML
    private void ResetPasswordAction(ActionEvent event) {
    }
    
}
