/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import interfaces.iLogic.Ilogic;
import logicLayer.Case;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;

/**
 * FXML Controller class
 *
 * @author Bruger
 */
public class ManufactorerPortalViewController extends SuperController implements Initializable {

    @FXML
    private MenuBar menubar;
    @FXML
    private PasswordField SearchField;
    @FXML
    private Button SearchButton;
    @FXML
    private ListView<?> AcceptedCasesListView;
    @FXML
    private Button ShowCaseButton;
    @FXML
    private Button loadScene1;
    @FXML
    private Tab NewCasesListView;
    @FXML
    private ListView<Case> CaseListView;
    @FXML
    private Button AttachedFilesButton;
    @FXML
    private Button PlaceBidButton;
    @FXML
    private Button logOutButton;

    public ManufactorerPortalViewController(Ilogic logic) {
        super(logic);
    }

    ApplicationStateHandler applicationStateHandler = new ApplicationStateHandler();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateObservableCaseListView();
    }

    @FXML
    private void searchOnAction(ActionEvent event) {
    }

    @FXML
    private void showCaseOnAction(ActionEvent event) {
    }

    @FXML
    private void loadSceneOnAction(ActionEvent event) {
    }

    @FXML
    private void SearchOnAction(ActionEvent event) {
    }

    @FXML
    private void OpenAttachedFilesOnAction(ActionEvent event) {
        applicationStateHandler.setPickAFile(AttachedFilesButton);
    }

    @FXML
    private void PlaceBidOnAction(ActionEvent event) {
        applicationStateHandler.setPlaceBidView(PlaceBidButton);
    }

    @FXML
    private void logOutButtonMethod(ActionEvent event) {
        applicationStateHandler.setLogInScreen(logOutButton);
    }

    private void showCases() {
    }

    public void populateObservableCaseListView() {
//        ObservableList<Case> oberservableCaseList = FXCollections.observableArrayList(logic.getCaseList());
//        CaseListView.setItems(oberservableCaseList);
//        CaseListView.setCellFactory(ComboBoxListCell.forListView(oberservableCaseList));
    }
}
