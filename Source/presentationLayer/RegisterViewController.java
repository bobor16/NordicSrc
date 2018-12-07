/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import interfaces.iLogic.Ilogic;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import dataLayer.ClientController;
import dataLayer.Packet;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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

    private final ToggleGroup group = new ToggleGroup();
    
    private ApplicationStateHandler applicationStateHandler = new ApplicationStateHandler();

    private HashMap<String, String> registerForm = new HashMap<>();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        manufacturerRadioButton.setToggleGroup(group);
        customerRadioButton.setToggleGroup(group);
        employeeRadioButton.setToggleGroup(group);
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
                if (group.getSelectedToggle() != null) {
                    registerForm.put("type", group.getSelectedToggle().getUserData().toString());
                }
            }
        });
    }

    @FXML
    private void cancelButtonMethod(ActionEvent event) {
        applicationStateHandler.setLogInScreen(cancelButton);
    }

    @FXML
    private void registerMethod(ActionEvent event) {
        registerForm.put("name", firstNameField.getText() + " " + lastNameField.getText());
        registerForm.put("email", emailField.getText());
        registerForm.put("password", passwordField.getText());
        registerForm.put("cname", companyNameField.getText());
        registerForm.put("cvr", CVRField.getText());
        ClientController cc = new ClientController();
        switch (cc.register(registerForm)){
            case "success":
                applicationStateHandler.setLogInScreen(cancelButton/*???*/);
                break;
            case "user exists":
                System.out.println("email exists already");
                break;
            default:
                System.out.println("Registration failed");
                break;
            }
    }

}
