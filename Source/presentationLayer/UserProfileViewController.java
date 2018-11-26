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
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Bruger
 */
public class UserProfileViewController extends SuperController implements Initializable {

    @FXML
    private Label CompanyNameLabel;
    @FXML
    private Label EmailLabel;
    @FXML
    private Label PhoneNumberLabel;
    @FXML
    private Label CVRNumberLabel;
    @FXML
    private Button EditButton;
    @FXML
    private Button SaveButton;
    @FXML
    private Pane VerifiedColorPane;
    @FXML
    private Label VerifiedLabel;

    ApplicationStateHandler applicationHandler = new ApplicationStateHandler();
    @FXML
    private Button CancelProfileView;

    UserProfileViewController(Ilogic logic) {
        super(logic);
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CancelProfileViewMethod(ActionEvent event) {
    }
    
}
