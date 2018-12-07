/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import interfaces.iLogic.Ilogic;
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
 * @author mehgn
 */
public class AdminPortalViewController extends SuperController implements Initializable {

    @FXML
    private PasswordField SearchField;
    @FXML
    private Button SearchButton;
    @FXML
    private ListView<?> AcceptedCasesListView;
    @FXML
    private Button ShowCaseButton;
    @FXML
    private Tab NewCasesListView;
    @FXML
    private ListView<?> CaseListView11;
    @FXML
    private Button AttachedFilesButton;
    @FXML
    private Tab NewCasesListView1;
    @FXML
    private PasswordField SearchField1;
    @FXML
    private Button SearchButton1;
    @FXML
    private ListView<?> CaseListView111;
    @FXML
    private Button logOutButton;
    @FXML
    private Button adminProfileButton;
    @FXML
    private Button adminSettingsButton;
    @FXML
    private Button showUserButton;
    @FXML
    private Button createUserButton;
    @FXML
    private Button editUserButton;
    @FXML
    private Button deleteUserButton;

    public AdminPortalViewController(Ilogic logic) {
        super(logic);
    }

    ApplicationStateHandler appliCationStateHandler = new ApplicationStateHandler();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void showCaseOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    public void searchOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    public void adminSettingsOnAction(ActionEvent event) throws IOException {

    }

    public void loadSceneOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    public void adminProfileOnAction(ActionEvent event) throws IOException {

    }

    public void OpenAttachedFilesOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    public void SearchOnAction(ActionEvent event) throws IOException {

    }

    public void logout(ActionEvent event) throws IOException {

    }

    @FXML
    private void logOutButtonMethod(ActionEvent event) {
        appliCationStateHandler.setLogInScreen(logOutButton);
    }

    @FXML
    private void showUserOnAction(ActionEvent event) {
    }

}
