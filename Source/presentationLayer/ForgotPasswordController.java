/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import dataLayer.ClientController;
import dataLayer.Packet;
import interfaces.iLogic.Ilogic;
import interfaces.iPresentation.Ipresentation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logicLayer.User;

/**
 * FXML Controller class
 *
 * @author Borgar Bordoy
 */
public class ForgotPasswordController extends SuperController implements Initializable {

    @FXML
    private TextField emailField;
    @FXML
    private Label PasswordField;
    @FXML
    private Button showButton;
    @FXML
    private Label infoLabel;
    @FXML
    private Button backButton;
    @FXML
    private Label passwordMsgLabel;

    private Ilogic logic;
    private User user;
    private Ipresentation ip;

    ApplicationStateHandler stateHandler = new ApplicationStateHandler();

    public ForgotPasswordController(Ilogic logic) {
        super(logic);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void showButtonOnAction(ActionEvent event) {
        String password;
        String message = emailField.getText();
        ClientController cc = new ClientController();
        password = cc.getPassword(message);
        if (password.equals("invalid")) {

        } else {
            PasswordField.setText(password);
        }
    }

    @FXML
    public void backButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

}
