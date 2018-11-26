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

public class CustomerPortalViewController extends SuperController implements Initializable {

    @FXML
    private Button searchButton;
    @FXML
    private ListView<?> CaseListView1;
    @FXML
    private Button showCaseButton;
    @FXML
    private Button createNewOrderButton;
    @FXML
    private Button logOutButton;

    ApplicationStateHandler stateHandler = new ApplicationStateHandler();

    public CustomerPortalViewController(Ilogic logic) {
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
    public void loadSceneOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    private void searchMethod(ActionEvent event) {
    }

    @FXML
    private void showCaseMethod(ActionEvent event) {
    }

    @FXML
    private void createNewOrderMethod(ActionEvent event) {
    }

    @FXML

    private void customerSettingsOnAction(ActionEvent event) {
    }

    @FXML
    private void customerProfileOnAction(ActionEvent event) {
    }

    @FXML
    private void logOutButtonMethod(ActionEvent event) {
        stateHandler.setLogInScreen(logOutButton);
    }

}
