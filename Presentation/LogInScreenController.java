/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

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
    private void LoginOnAction(ActionEvent event) {
    }

    @FXML
    private void RegisterOnAction(ActionEvent event) {
    }
    
}