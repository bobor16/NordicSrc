/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import Interfaces.Ilogic.Ilogic;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;

/**
 * FXML Controller class
 *
 * @author rasmu
 */
public class EmployeeController extends SuperController implements Initializable {

    @FXML
    private Button adminProfileButton;
    @FXML
    private Button adminSettingsButton;
    @FXML
    private Button logOutButton;
    @FXML
    private PasswordField SearchField;
    @FXML
    private Button SearchButton;
    @FXML
    private ListView<?> CaseListView11;
    @FXML
    private Button approveCaseButton;
    @FXML
    private Button delcineCaseButton;

    public EmployeeController(Ilogic logic) {
        super(logic);
    }
    
    ApplicationStateHandler appliCationStateHandler = new ApplicationStateHandler();

    

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void adminProfileOnAction(ActionEvent event) {
    }

    @FXML
    private void adminSettingsOnAction(ActionEvent event) {
    }

    @FXML
    private void logOutButtonMethod(ActionEvent event) {
    }

    @FXML
    private void SearchOnAction(ActionEvent event) {
    }

    @FXML
    private void approveOnAction(ActionEvent event) {
    }

    @FXML
    private void declineOnAction(ActionEvent event) {
    }
    
}
